package org.soen387.app.TransactionScript;

import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.UserRDG;
import org.soen387.app.viewHelper.UserHelper;
import org.soen387.app.viewHelper.ViewHelper;



public class ListPlayerTS {

	public static boolean exceute(List<ViewHelper> viewHelper) {

		List<UserRDG> allUser = UserRDG.findAllLogin();
		
		if(allUser.size()>0) {
			
			for(int index=0; index<allUser.size();index++) {
				UserHelper userHelper = new UserHelper();
				CommonUtil.setPropToVH(allUser.get(index), userHelper);
				viewHelper.add(userHelper);
			}
			return true;
		}else {
			
			return false;
		}
	}
}
