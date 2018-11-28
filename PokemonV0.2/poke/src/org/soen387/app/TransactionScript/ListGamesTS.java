package org.soen387.app.TransactionScript;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.ViewHelper;

public class ListGamesTS {

	public static boolean exceute(ViewHelper viewHelper,String userId) {

		ChallengeRDG challengeAccept = ChallengeRDG.getChallengeAccept(userId);
		
		if(challengeAccept == null) {
			return false;
		}
		
		CommonUtil.setPropToVH(challengeAccept, viewHelper);
		return true;
	}
}
