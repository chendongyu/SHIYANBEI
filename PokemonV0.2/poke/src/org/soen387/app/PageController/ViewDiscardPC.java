package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.ViewDiscardTS;
import org.soen387.app.TransactionScript.ViewHandTS;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.DeckHelper;
import org.soen387.app.viewHelper.HandHelper;

@WebServlet("/ViewDiscard")
public class ViewDiscardPC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDiscardPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String loginId = (String)request.getParameter("player");
		String gameId = (String)request.getParameter("game");

		ChallengeRDG challenge = ChallengeRDG.findPlayers(gameId);
		
		String challengerId = challenge.getChallenger();
		String challengeeId = challenge.getChallengee();
		
		if(loginId == null) {
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
		if(gameId== null) {
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
		
		if(!loginId.equals(challengerId) && !loginId.equals(challengeeId)) {
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
		HandHelper handHelper = new HandHelper();
		
		if(ViewDiscardTS.exceute(handHelper, gameId, loginId)) {
			
			PrintWriter writer = response.getWriter();
			writer.write(handHelper.toJson());
			writer.close();
		}else {
			
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
