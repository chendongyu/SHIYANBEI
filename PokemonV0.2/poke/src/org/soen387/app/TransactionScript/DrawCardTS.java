package org.soen387.app.TransactionScript;




import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;


public class DrawCardTS {

	public static boolean exceute(String deckId,String gameId) {
		
		
		if(CommonUtil.isEmpty(gameId)) {
			return false;
		}
		
		ChallengeRDG challenge = ChallengeRDG.getChallengeByGameId(gameId);
		if(!deckId.equals(challenge.getChallengee()) && !deckId.equals(challenge.getChallenger())) {
			return false;
		}
		DeckRDG.updateCardStatus(deckId);
		
		
		
	
		return true;
		
		
		
	}
	
}
