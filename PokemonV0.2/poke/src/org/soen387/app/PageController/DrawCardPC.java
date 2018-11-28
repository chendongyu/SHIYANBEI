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
import org.soen387.app.TransactionScript.ListGamesTS;
import org.soen387.app.TransactionScript.UploadDeckTS;
import org.soen387.app.TransactionScript.updateUserStatusTS;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.GameHelper;
import org.soen387.app.viewHelper.ViewHelper;


@WebServlet("/DrawCard")
public class DrawCardPC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawCardPC() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String gameId = (String)request.getParameter("game");
		String loginId = (String)request.getSession(true).getAttribute("loginId");	
		String deckId = loginId;
		

	
		
	
		
		if(loginId == null) {
			String jsonStr = Constants.FAILUREJSON;
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.close();
		}
		

		
		else if(DrawCardTS.exceute(deckId,gameId)) {
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
