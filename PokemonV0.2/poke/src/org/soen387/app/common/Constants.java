package org.soen387.app.common;

public class Constants {

	public static final String SUCCESSJSON ="{\"status\":\"success\",\"message\":"
			+ "\"Things went okay! We should probably say specifically what.\"}";
	
	public static final String FAILUREJSON ="{\"status\":\"fail\",\"message\":"
			+ "\"Something went horribly wrong, but make your message more helpful!\"}";
	
	public static final String SUCCESSJSON_LOGIN ="{\"status\":\"success\",\"message\":"
			+ "\"You have logged in successfully! \"}";
	
	public static final String FAILUREJSON_LOGIN ="{\"status\":\"fail\",\"message\":"
			+ "\"Opps! Your Log in was unsuccessful!\"}";
	
	public static final String SUCCESSJSON_RIGESTER ="{\"status\":\"success\",\"message\":"
			+ "\"You have registered in successfully!\"}";
	
	public static final String FAILUREJSON_RIGESTER ="{\"status\":\"fail\",\"message\":"
			+ "\"Opps! the register was unsuccessful!\"}";
	
	public static final String SUCCESSJSON_ACCEPTCHALLENGE ="{\"status\":\"success\",\"message\":"
			+ "\"The challenge has been accepted successfully!\"}";
	
	public static final String FAILUREJSON_ACCEPTCHALLENGE ="{\"status\":\"fail\",\"message\":"
			+ "\"Opps! an error has occured when accepting challenge!\"}";
	
	public static final String SUCCESSJSON_CHALLENGEPLAYER ="{\"status\":\"success\",\"message\":"
			+ "\"The challenge request has been send successfully!\"}";
	
	public static final String FAILUREJSON_CHALLENGEPLAYER ="{\"status\":\"fail\",\"message\":"
			+ "\"Opps! an error has occured while issuing a challenge!\"}";
	
	public static final String SUCCESSJSON_REFUSE ="{\"status\":\"success\",\"message\":"
			+ "\"The challenge request has been REFUSED !\"}";
	
	public static final String FAILUREJSON_REFUSE ="{\"status\":\"fail\",\"message\":"
			+ "\"Opps! an error has occured while refusing a challenge!\"}";
	
	
	public static final String SUCCESSJSON_LOGOUT ="{\"status\":\"success\",\"message\":"
			+ "\"You have logged out successfully!\"}";
	
	public static final String CHALLENGEON = "1";
	
	public static final String CHALLENGEOFF = "0";
}
