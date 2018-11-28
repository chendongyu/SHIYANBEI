package org.soen387.app.TransactionScript;

import org.soen387.app.rdg.UserRDG;

public class updateUserStatusTS {

	public static boolean exceute(String userId,String status) {
		
		UserRDG userRDG = new UserRDG();
		userRDG.setUserId(userId);
		userRDG.setStatus(status);
		int rol = UserRDG.update(userRDG);
		
		if(rol>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
