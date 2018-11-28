package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.ListPlayerTS;
import org.soen387.app.TransactionScript.playerChallengeTS;
import org.soen387.app.TransactionScript.updateChallengeStatusTS;
import org.soen387.app.TransactionScript.updateUserStatusTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;
import org.soen387.app.viewHelper.UserHelper;
import org.soen387.app.viewHelper.ViewHelper;


@WebServlet("/AcceptChallenge")
public class AcceptChallengePC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//private List<ViewHelper> viewHelper;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String status = "3";
		String userStatus = "2";
		String challengerId = (String) req.getSession(true).getAttribute("loginId");
		String challengeId = req.getParameter("challenge");
		//String challengeIdInSession = (String) req.getSession(true).getAttribute("challenge");
		Object challengeFlag = req.getSession(true).getAttribute("challengeFlag");

		
		
		List<DeckRDG> deckList = DeckRDG.findAll(challengerId);
		
		
		List<ChallengeRDG> challengeRDGs = ChallengeRDG.findAllById(challengerId);
		
		if(challengeRDGs.size()==0) {
			String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}
		
		else if(Constants.CHALLENGEON.equals(challengeFlag) || deckList.size()==0) {
			String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}else if(challengeId == null||challengerId == null ) {
			String jsonStr = Constants.FAILUREJSON_ACCEPTCHALLENGE;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else if(updateChallengeStatusTS.exceute(challengeId, status)){
			
			String jsonStr =Constants.SUCCESSJSON_ACCEPTCHALLENGE; // convert to json
			updateUserStatusTS.exceute(	
					ChallengeRDG.findPlayers(challengeId).getChallenger(), userStatus);
			updateUserStatusTS.exceute(	
					ChallengeRDG.findPlayers(challengeId).getChallengee(), userStatus);
			
			req.getSession(true).setAttribute("gameId", (challengeId + challengerId));
			
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else {
			
			String jsonStr =Constants.FAILUREJSON_ACCEPTCHALLENGE; // convert to json
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
