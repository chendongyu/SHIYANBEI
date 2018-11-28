package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.updateUserStatusTS;
import org.soen387.app.common.Constants;

@WebServlet("/Poke/Player/Logout")
public class LogOutPC extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId = (String)req.getSession(true).getAttribute("loginId");
		req.getSession(true).removeAttribute("loginId");
		req.getSession(true).removeAttribute("challengeFlag");
		
		if(updateUserStatusTS.exceute(loginId, "0")) {
			
			String jsonStr =Constants.SUCCESSJSON_LOGOUT; // convert to json
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}else {
			
			String jsonStr =Constants.FAILUREJSON; // convert to json
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
