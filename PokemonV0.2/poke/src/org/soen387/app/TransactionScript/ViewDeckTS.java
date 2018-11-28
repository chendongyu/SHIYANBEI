package org.soen387.app.TransactionScript;

import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.DeckRDG;
import org.soen387.app.viewHelper.CardHelper;
import org.soen387.app.viewHelper.ViewHelper;

public class ViewDeckTS {

	public static boolean exceute(List<ViewHelper> list,String userId) {
		
		List<DeckRDG> allDeck = DeckRDG.findAll(userId);
		
		if(allDeck.size() == 0) {
			return false;
		}else {
			
			for(int index=0; index<allDeck.size(); index++) {
				CardHelper cardHelper = new CardHelper();
				CommonUtil.setPropToVH(allDeck.get(index), cardHelper);
				list.add(cardHelper);
			}
			return true;
		}
		
	}
}
