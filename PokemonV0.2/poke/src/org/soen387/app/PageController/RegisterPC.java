package org.soen387.app.PageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soen387.app.TransactionScript.RegisterUserTS;
import org.soen387.app.TransactionScript.ViewUserTS;
import org.soen387.app.TransactionScript.updateUserStatusTS;
import org.soen387.app.common.CommonUtil;
import org.soen387.app.common.Constants;
import org.soen387.app.viewHelper.UserHelper;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static Map<String, String>registeredMap = new HashMap<String, String>(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		UserHelper viewHelper = new UserHelper();
		if(CommonUtil.isEmpty(user) || CommonUtil.isEmpty(pass)) {

			String jsonStr =Constants.FAILUREJSON_RIGESTER; // convert to json
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else if(ViewUserTS.exceute(viewHelper, user)) {
			
			
			
			String jsonStr =Constants.FAILUREJSON_RIGESTER; // convert to json
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.close();
		} else {
			
			RegisterUserTS.exceute(user, pass);
			viewHelper = new UserHelper();
			ViewUserTS.exceute(viewHelper, user);
			request.getSession(true).setAttribute("loginId", viewHelper.getUserId());
			updateUserStatusTS.exceute(viewHelper.getUserId(), "1");		
			String jsonStr =Constants.SUCCESSJSON_RIGESTER; // convert to json
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
