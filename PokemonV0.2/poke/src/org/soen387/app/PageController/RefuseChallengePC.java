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
import org.soen387.app.TransactionScript.RefuseChallengeTS;
import org.soen387.app.TransactionScript.playerChallengeTS;
import org.soen387.app.TransactionScript.updateChallengeStatusTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.UserHelper;
import org.soen387.app.viewHelper.ViewHelper;

@WebServlet("/RefuseChallenge")
public class RefuseChallengePC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String refuseStatus = "1";
		String widthDrawStatus = "2";
		String challengeID = req.getParameter("challenge");
		
		
		
		
		
		if(challengeID == null) {
			String jsonStr = Constants.FAILUREJSON_REFUSE;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
			
		}
		else if(ChallengeRDG.findPlayers(challengeID).getChallengee().equals((String)req.getSession(true).getAttribute("loginId"))) 
		{
			if(updateChallengeStatusTS.exceute(challengeID, refuseStatus)){
				//RefuseChallengeTS.exceute(challengeID);
				String jsonStr =Constants.SUCCESSJSON_REFUSE; // convert to json
				
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			} else {
				String jsonStr =Constants.FAILUREJSON_REFUSE; // convert to json
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
		}
		else if(ChallengeRDG.findPlayers(challengeID).getChallenger().equals((String)req.getSession(true).getAttribute("loginId")))
		{
			if(updateChallengeStatusTS.exceute(challengeID, widthDrawStatus)){
				//RefuseChallengeTS.exceute(challengeID);
				String jsonStr =Constants.SUCCESSJSON_REFUSE; // convert to json
				
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			} else {
				String jsonStr =Constants.FAILUREJSON_REFUSE; // convert to json
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
			
			
		}
		else {
			String jsonStr =Constants.FAILUREJSON_REFUSE; // convert to json
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
