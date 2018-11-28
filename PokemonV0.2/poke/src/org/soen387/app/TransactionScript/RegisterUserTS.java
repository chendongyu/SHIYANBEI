package org.soen387.app.TransactionScript;

import org.soen387.app.rdg.UserRDG;

public class RegisterUserTS {
	
	public static boolean exceute(String userName,String password) {
		
		UserRDG userRDG = new UserRDG(userName, password);
		//insert will return how many roles you inserted(in our case there will be only one)
		int rol = UserRDG.insert(userRDG);
		
		if(rol > 0) {
			return true;
		}else {
			return false;
		}
	}
}
