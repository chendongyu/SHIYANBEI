package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.playerChallengeTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.UserRDG;

@WebServlet("/ChallengePlayer")
public class challengePlayerPC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//String player1_id = req.getParameter("challengerID");
		String player1_id = (String)req.getSession(true).getAttribute("loginId");		
		String player2_id = req.getParameter("player");
		String status = "0";
		String deckId = req.getParameter("deck");
		UserRDG userRDG = UserRDG.findById(player2_id);
		
		if(Integer.parseInt(deckId)<0) {
			String jsonStr =Constants.FAILUREJSON_CHALLENGEPLAYER; // convert to json
			PrintWriter writer = resp.getWriter();
			//test
			writer.write(jsonStr);
			writer.close();
		}
	
		if(userRDG == null ||CommonUtil.isEmpty(player1_id)|| CommonUtil.isEmpty(player2_id) || player1_id.equals(player2_id)
				||Integer.parseInt(player1_id) < 0||Integer.parseInt(player2_id) < 0) {
			String jsonStr = Constants.FAILUREJSON_CHALLENGEPLAYER;
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else if(playerChallengeTS.exceute(player1_id, player2_id, status)){
			
			req.getSession(true).setAttribute("challengeFlag", Constants.CHALLENGEON);
			String jsonStr =Constants.SUCCESSJSON_CHALLENGEPLAYER; // convert to json
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else {
			String jsonStr =Constants.FAILUREJSON_CHALLENGEPLAYER; // convert to json
			PrintWriter writer = resp.getWriter();
			//test
			writer.write(jsonStr);
			writer.close();
		}
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
