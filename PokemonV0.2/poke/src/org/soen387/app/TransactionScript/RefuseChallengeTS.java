package org.soen387.app.TransactionScript;



import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.ChallengeHelper;
import org.soen387.app.viewHelper.ViewHelper;

public class RefuseChallengeTS {

	public static boolean exceute(String challengeId) {
		
		if(challengeId == null) {
			return false;
		}
		ChallengeRDG.delete(challengeId);
		
		
		return true;
	}
}
