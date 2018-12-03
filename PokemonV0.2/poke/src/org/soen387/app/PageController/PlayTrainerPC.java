package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.PlayCardTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;

@WebServlet("/PlayTrainer")
public class PlayTrainerPC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String endTurnLastPlayer = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cardId = req.getParameter("card");
		String gameId = req.getParameter("game");
		String loginId = (String) req.getSession(true).getAttribute("loginId");
		String pokemon = req.getParameter("pokemon");
		String version = req.getParameter("version");
		ChallengeRDG players = ChallengeRDG.findPlayers(gameId);
		String challenger = players.getChallenger();
		String challengee = players.getChallengee();
/*		ChallengeRDG players = ChallengeRDG.findPlayers(gameId);
		
		String challenger = players.getChallenger();
		String challengee = players.getChallengee();*/

		DeckRDG card = DeckRDG.findCardByGameIdAndCardId(cardId);
		
		if(card==null || !loginId.equals(card.getDeckId())) {
			
			String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}else if(card.getType().equals("p")){
			
			String name = card.getName();
			String[] split = name.split(" ");
			
			if(split.length>1) {
				String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}else if(DeckRDG.playCardToBench(cardId)) {
				String jsonStr =Constants.SUCCESSJSON; // convert to json
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}else {
				String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
		}else if(card.getType().equals("e")){
			
			boolean firstTurn = false;
			if(endTurnLastPlayer == null || (!endTurnLastPlayer.equals(challenger+""+version) && !endTurnLastPlayer.equals(challengee+""+version))) {
				endTurnLastPlayer = loginId+""+version;
				firstTurn = true;
			}
			
			if(CommonUtil.isEmpty(pokemon)) {
				String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();			
			}else if(!firstTurn && endTurnLastPlayer.equals(loginId+""+version)) {
				String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}else {
				
				Map<String,String> pokemonsEnergyMap = new HashMap<String,String>();
				String energyValue = null;
				Object attribute = req.getSession(true).getAttribute("benchEnergy");
				if(attribute!=null) {
					Map<String,String> pokemonsEnergyMapOld =  (HashMap<String,String>)attribute;
					String energy = pokemonsEnergyMapOld.get(pokemon);
					if(CommonUtil.isEmpty(energy)) {
						energyValue = "["+cardId+"]";
					}else {
						energy = energy.substring(0,energy.length()-1);
						energy += ","+cardId+"]";
						energyValue = energy;
					}
				}else {
					energyValue = "["+cardId+"]";
				}
				pokemonsEnergyMap.put(pokemon, energyValue);
				req.getSession(true).setAttribute("benchEnergy", pokemonsEnergyMap);
			}
			
			DeckRDG.dropCardByCardId(cardId);
		}else {
			
			if(PlayCardTS.exceute(gameId, cardId)) {
				String jsonStr =Constants.SUCCESSJSON; // convert to json
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
			else {
				String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
		}		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}