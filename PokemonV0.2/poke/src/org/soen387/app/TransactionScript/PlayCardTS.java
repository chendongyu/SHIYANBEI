package org.soen387.app.TransactionScript;

import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.ChallengeRDG;
import org.soen387.app.rdg.DeckRDG;
import org.soen387.app.rdg.PlayRDG;
import org.soen387.app.viewHelper.BoardHelper;
import org.soen387.app.viewHelper.PlayHelper;

public class PlayCardTS {

	public static boolean exceute(String gameId,String cardId) {
		
		if(CommonUtil.isEmpty(gameId)) {
			return false;
		}
		
		//ChallengeRDG challenge = ChallengeRDG.getChallengeByGameId(gameId);
		
		DeckRDG.playCardToDiscardStatus(cardId);
		
		
		
		
//		viewHelper.setId(challenge.getId());
//		String[] players = {challenge.getChallenger(),challenge.getChallengee()};
//		viewHelper.setPlayers(players);
//		String[] decks = {challenge.getChallenger(),challenge.getChallengee()};
//		viewHelper.setDecks(decks);
//		
//		
//		
//		List<PlayHelper> list = new ArrayList<PlayHelper>();
//		PlayRDG play1 = PlayRDG.findAll(challenge.getChallenger());
//		PlayHelper playHelper = new PlayHelper();
//		
//		CommonUtil.setPropToVH(play1, playHelper);
//		list.add(playHelper);
//		PlayRDG play2 = PlayRDG.findAll(challenge.getChallengee());
//		PlayHelper playHelper2 = new PlayHelper();
//		CommonUtil.setPropToVH(play2, playHelper2);
//		list.add(playHelper2);
//		viewHelper.setPlayHelpers(list);
		
		return true;
	}
		
		
}
