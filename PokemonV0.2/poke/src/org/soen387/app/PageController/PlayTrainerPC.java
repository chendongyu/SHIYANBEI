package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.PlayCardTS;
import org.soen387.app.common.Constants;

@WebServlet("/PlayTrainer")
public class PlayTrainerPC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cardId = req.getParameter("card");
		String gameId = req.getParameter("game");
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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}