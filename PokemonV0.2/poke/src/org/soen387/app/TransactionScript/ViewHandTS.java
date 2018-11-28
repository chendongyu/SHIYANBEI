package org.soen387.app.TransactionScript;

import java.util.List;

import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;
import org.soen387.app.viewHelper.HandHelper;

public class ViewHandTS {

	public static boolean exceute(HandHelper handHelper,String gameId,String userId) {
		
		ChallengeRDG challenge = ChallengeRDG.getChallengeByGameId(gameId);
		if(!userId.equals(challenge.getChallengee()) && !userId.equals(challenge.getChallenger())) {
			return false;
		}
		
		List<DeckRDG> handCards = DeckRDG.findHandCard(userId);
		
		StringBuffer handBuffer = new StringBuffer();
		handBuffer.append("{\"hand\":[");
		for(int index=0;index<handCards.size(); index++) {
			handBuffer.append("{\"id\":");
			handBuffer.append(handCards.get(index).getCardId());
			handBuffer.append("},");
		}
		if(handCards.size() > 0) {
			handBuffer.deleteCharAt(handBuffer.length()-1);
		}
		handBuffer.append("]}");
		
		handHelper.setJson(handBuffer.toString());
		return true;
	}
}
