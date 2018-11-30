package org.soen387.app.viewHelper;

import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.DeckRDG;

public class DecksHelper implements ViewHelper {

	private List<DeckRDG> deckRDGs;
	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		playJson.append("{\"decks\":[");
		for(int i=0; i<deckRDGs.size(); i++) {
			playJson.append(deckRDGs.get(i).getDeckId());
			playJson.append(",");
		}
		if(deckRDGs.size()!=0) {
			playJson.deleteCharAt(playJson.length()-1);
		}
		playJson.append("]}");
		return playJson.toString();
	}
	public List<DeckRDG> getDeckRDGs() {
		return deckRDGs;
	}
	public void setDeckRDGs(List<DeckRDG> deckRDGs) {
		this.deckRDGs = deckRDGs;
	}

}
