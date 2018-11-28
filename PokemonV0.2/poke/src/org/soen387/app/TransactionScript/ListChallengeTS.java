package org.soen387.app.TransactionScript;

import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.viewHelper.ChallengeHelper;
import org.soen387.app.viewHelper.ViewHelper;

public class ListChallengeTS {

	
	public static boolean exceute(List<ViewHelper> challengeHelper) {
		
		if(challengeHelper == null) {
			return false;
		}
		
		List<ChallengeRDG> challengeRDGs = ChallengeRDG.findAllChallenge();
		
		for(int index=0; index<challengeRDGs.size(); index++) {
			ViewHelper ch = new ChallengeHelper();
			CommonUtil.setPropToVH(challengeRDGs.get(index), ch);
			challengeHelper.add(ch);
		}
		
		return true;
	}
	
	public static boolean exceute(List<ViewHelper> challengeHelper, String userId) {
		
		if(challengeHelper == null) {
			return false;
		}
		
		List<ChallengeRDG> challengeRDGs = ChallengeRDG.findAllById(userId);
		
		for(int index=0; index<challengeRDGs.size(); index++) {
			ViewHelper ch = new ChallengeHelper();
			CommonUtil.setPropToVH(challengeRDGs.get(index), ch);
			challengeHelper.add(ch);
		}
		
		return true;
	}
	
	
}
