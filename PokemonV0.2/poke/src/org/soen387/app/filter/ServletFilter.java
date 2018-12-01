package org.soen387.app.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="ServletFilter",urlPatterns="/*")
public class ServletFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String requestURI = httpServletRequest.getRequestURI();
		
		// TODO Auto-generated method stub
		String Testpattern = "/poke/Poke/Game/.*?/Hand/.*?/Play/.*?/Challenge";
		
		if(Pattern.matches(Testpattern, requestURI)) {
			
			String[] split = requestURI.split("/");
			
			System.out.println(split[0]);
			
//			if() {
//				request.getRequestDispatcher("/poke/src/org/soen387/app/PageController/AcceptChallengePC.java").forward(request, response);
//			}
//			else if() {
//				request.getRequestDispatcher("/poke/src/org/soen387/app/PageController/RefuseChallengePC.java").forward(request, response);
//			}
//			else if() {
//				request.getRequestDispatcher("/poke/src/org/soen387/app/PageController/ChallengePlayerPC.java").forward(request, response);
//			}
//			
//			else if() {
//				request.getRequestDispatcher("/poke/src/org/soen387/app/PageController/ViewBoardPC.java").forward(request, response);
//			}
//			else if() {
//				request.getRequestDispatcher("/poke/src/org/soen387/app/PageController/ViewHandPC.java").forward(request, response);
//			}
//			
//		
		
			
		}else {
			
			filter.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
