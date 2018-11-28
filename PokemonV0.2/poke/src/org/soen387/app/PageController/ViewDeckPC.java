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

import org.soen387.app.TransactionScript.UploadDeckTS;
import org.soen387.app.TransactionScript.ViewDeckTS;
import org.soen387.app.common.Constants;
import org.soen387.app.viewHelper.DeckHelper;
import org.soen387.app.viewHelper.ViewHelper;

@WebServlet("/ViewDeck")
public class ViewDeckPC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private List<ViewHelper> viewHelper;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDeckPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String loginId = (String)request.getSession(true).getAttribute("loginId");

		if(loginId == null) {
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
		
		viewHelper = new ArrayList<ViewHelper>();
		
		if(ViewDeckTS.exceute(viewHelper, loginId)) {
			
			DeckHelper deckHelper = new DeckHelper();
			deckHelper.setId(loginId);
			deckHelper.setCards(viewHelper);
			PrintWriter writer = response.getWriter();
			writer.write(deckHelper.toJson());
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
