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

import org.soen387.app.TransactionScript.ListChallengeTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.viewHelper.ViewHelper;

/**
 * Servlet implementation class ListPlayer
 */
@WebServlet("/Poke/Challenge")
public class ListChallengesPC extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private List<ViewHelper> viewHelper;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = (String)req.getSession(true).getAttribute("loginId");
		
		if(CommonUtil.isEmpty(loginId)) {
			String jsonStr =Constants.FAILUREJSON; // convert to json
			PrintWriter writer = resp.getWriter();
			writer.write(jsonStr);
			writer.close();
		}

		viewHelper = new ArrayList<ViewHelper>();
		
		//ListChallengeTS.exceute(viewHelper, loginId);
		ListChallengeTS.exceute(viewHelper);
		String playersJson = CommonUtil.changeListToJson("challenges", viewHelper);
		
		PrintWriter writer = resp.getWriter();
		writer.write(playersJson);
		writer.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}	
}
