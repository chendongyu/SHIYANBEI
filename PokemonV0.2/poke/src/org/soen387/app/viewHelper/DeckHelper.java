package org.soen387.app.viewHelper;

import java.util.List;

import org.soen387.app.common.CommonUtil;

public class DeckHelper implements ViewHelper {

	private String id;
	
	private List<ViewHelper> cards;
	
	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		playJson.append("{\"deck\":");
		playJson.append("{\"id\":");
		playJson.append(id);
		playJson.append(",");
		playJson.append(CommonUtil.changeListToJsonPre("cards", cards));
		playJson.append("}}");
		return playJson.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ViewHelper> getCards() {
		return cards;
	}

	public void setCards(List<ViewHelper> cards) {
		this.cards = cards;
	}
}
