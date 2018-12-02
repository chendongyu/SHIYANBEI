package org.soen387.app.filter;

import java.io 

.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
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
		final String challengePlayerPattern = "/poke/Poke/Player/.*?/Challenge";
		final String acceptPlayerPattern =  "/poke/Poke/Challenge/.*?/Accept";
		final String viewBoardPattern = "/poke/Poke/Game/.*";
		final String viewHandPattern = "/poke/Poke/Game/.*?/Hand";
		final String endTurnPattern = "/poke/Poke/Game/.*?/EndTurn";
		final String refuseChallengePattern = "/poke/Poke/Challenge/.*?/Refuse";
		final String widthDrawChallengePattern = "/poke/Poke/Challenge/.*?/Withdraw";
		
		
		
		if(Pattern.matches(challengePlayerPattern, requestURI)) {
			
			String[] split = requestURI.split("/");
			RequestDispatcher rd = request.getRequestDispatcher("/ChallengePlayer?player="+split[4]);
			rd.forward(request, response);		
		}else if(Pattern.matches(acceptPlayerPattern, requestURI)){
			
			String[] split = requestURI.split("/");
			RequestDispatcher rd = request.getRequestDispatcher("/AcceptChallenge?challenge="+split[4]);
			rd.forward(request, response);
		}else if(Pattern.matches(viewBoardPattern, requestURI)){
			
			if(Pattern.matches(viewHandPattern, requestURI)) {
				
				String[] split = requestURI.split("/");
				RequestDispatcher rd = request.getRequestDispatcher("/ViewHand?game="+split[4]);
				rd.forward(request, response);
			}else if(Pattern.matches(endTurnPattern, requestURI)) {
				
				String[] split = requestURI.split("/");
				RequestDispatcher rd = request.getRequestDispatcher("/EndTurn?game="+split[4]);
				rd.forward(request, response);
			}else {
				
				String[] split = requestURI.split("/");
				RequestDispatcher rd = request.getRequestDispatcher("/ViewBoard?game="+split[4]);
				rd.forward(request, response);
			}
		}else if(Pattern.matches(refuseChallengePattern, requestURI)){
			
			String[] split = requestURI.split("/");
			RequestDispatcher rd = request.getRequestDispatcher("/RefuseChallenge?challenge="+split[4]);
			rd.forward(request, response);
		}else if(Pattern.matches(widthDrawChallengePattern, requestURI)){
			
			String[] split = requestURI.split("/");
			RequestDispatcher rd = request.getRequestDispatcher("/WithdrawChallenge?challenge="+split[4]);
			rd.forward(request, response);
		}
		
		else {
			
			filter.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}