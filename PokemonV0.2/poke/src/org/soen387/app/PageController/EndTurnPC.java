package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.DrawCardTS;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;

@WebServlet("/EndTurn")
public class EndTurnPC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String endTurnLastPlayer = null;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String gameId = (String)request.getParameter("game");
		String loginId = (String)request.getSession(true).getAttribute("loginId");	
	
	
	
		if(loginId == null) {
			String jsonStr = Constants.FAILUREJSON;
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.close();
		}
		else if(endTurnLastPlayer == null) {
			endTurnLastPlayer = loginId;
			if(DrawCardTS.exceute(ChallengeRDG.findPlayers(gameId).getChallengee(),gameId)) {
				
				String jsonStr =Constants.SUCCESSJSON; // convert to json
				
				PrintWriter writer = response.getWriter();
				writer.write(jsonStr);
				writer.close();
			}else {
				
				String jsonStr = Constants.FAILUREJSON;
				PrintWriter writer = response.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
		}
		
		else if(endTurnLastPlayer != loginId) {
			endTurnLastPlayer= loginId;
			if(DrawCardTS.exceute(ChallengeRDG.findPlayers(gameId).getChallengee(),gameId)) {
				
				String jsonStr =Constants.SUCCESSJSON; // convert to json
				
				PrintWriter writer = response.getWriter();
				writer.write(jsonStr);
				writer.close();
			}else {
				
				String jsonStr = Constants.FAILUREJSON;
				PrintWriter writer = response.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
		}
		else {
			
			String jsonStr = Constants.FAILUREJSON;
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.close();
		}
		

	}
		
		
		


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}