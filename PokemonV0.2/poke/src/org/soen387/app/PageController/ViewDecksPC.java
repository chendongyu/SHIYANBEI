package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.UploadDeckTS;
import org.soen387.app.common.Constants;
import org.soen387.app.rdg.DeckRDG;
import org.soen387.app.viewHelper.DecksHelper;
import org.soen387.app.viewHelper.ViewHelper;

@WebServlet("/Poke/Deck")
public class ViewDecksPC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private List<ViewHelper> viewHelper;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDecksPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//viewHelper = new ArrayList<ViewHelper>();
		
		 String loginId = (String)request.getSession(true).getAttribute("loginId");
			if(loginId == null) {
				String jsonStr = Constants.FAILUREJSON;
				PrintWriter writer = response.getWriter();
				writer.write(jsonStr);
				writer.close();
			}
			List<DeckRDG> allDeck = DeckRDG.findDecks();
		DecksHelper decksHelper = new DecksHelper();
		decksHelper.setDeckRDGs(allDeck);
		String jsonStr = decksHelper.toJson();
		PrintWriter writer = response.getWriter();
		writer.write(jsonStr);
		writer.close();
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//doGet(request, response);
		String deck = request.getParameter("deck");
		String loginId = (String)request.getSession(true).getAttribute("loginId");
		if(loginId == null) {
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
		
		if(UploadDeckTS.exceute(loginId, deck)) {
			
			PrintWriter writer = response.getWriter();
			writer.write(Constants.SUCCESSJSON);
			writer.close();
		}else {
			
			PrintWriter writer = response.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
	}
}
