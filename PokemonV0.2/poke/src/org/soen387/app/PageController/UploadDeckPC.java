package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.UploadDeckTS;
import org.soen387.app.common.Constants;

/**
 * Servlet implementation class UploadDeck
 */
@WebServlet("/Poke/Deck")
public class UploadDeckPC extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDeckPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
