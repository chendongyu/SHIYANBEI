package org.soen387.app.TransactionScript;

import org.soen387.app.rdg.DeckRDG;

public class UploadDeckTS {

	public static boolean exceute(String deckId,String deck) {
		
		String[] cards = deck.split("\n");
		
		if(cards.length!=40){
			return false;
		}
		
		DeckRDG.delete(deckId);
		
		
		
		for(int i = 0; i < cards.length; i++) {
			String line = cards[i];
			String type = line.substring(0,1);
			String name = line.substring(3,line.length()-1);
			
			DeckRDG deckRDG = new DeckRDG();
			deckRDG.setName(name);
			deckRDG.setType(type);
			deckRDG.setOrder(i+"");
			deckRDG.setDeckId(deckId);
			DeckRDG.insert(deckRDG);
		}
		return true;
	}
}
