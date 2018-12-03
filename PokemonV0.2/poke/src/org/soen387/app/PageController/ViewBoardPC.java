package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.ListGamesTS;
import org.soen387.app.TransactionScript.ViewBoardTS;
import org.soen387.app.common.Constants;
import org.soen387.app.viewHelper.BoardHelper;
import org.soen387.app.viewHelper.GameHelper;
import org.soen387.app.viewHelper.ViewHelper;

@WebServlet("/ViewBoard")
public class ViewBoardPC extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private BoardHelper viewHelper;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gameId = (String) req.getParameter("game");
		String loginId = (String)req.getSession(true).getAttribute("loginId");
		viewHelper = new BoardHelper();
		if(ViewBoardTS.exceute(viewHelper, gameId,loginId,req)) {
			PrintWriter writer = resp.getWriter();
			writer.write(viewHelper.toJson());
			writer.close();
		}else {
			PrintWriter writer = resp.getWriter();
			writer.write(Constants.FAILUREJSON);
			writer.close();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}	
}
