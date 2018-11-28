package org.soen387.app.TransactionScript;

import java.util.List;

import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;

public class playerChallengeTS {

	public static boolean exceute(String challenger, String challengee, String status) {
		
		List<DeckRDG> deckList = DeckRDG.findAll(challenger);
		if(deckList.size()==0) {
			return false;
		}
		
		ChallengeRDG challengeRDG = new ChallengeRDG();
		challengeRDG.setChallenger(challenger);
		challengeRDG.setChallengee(challengee);
		challengeRDG.setStatus(status);
		
		
		int rol = ChallengeRDG.insert(challengeRDG); 
		
		
		
		
		if(rol>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
