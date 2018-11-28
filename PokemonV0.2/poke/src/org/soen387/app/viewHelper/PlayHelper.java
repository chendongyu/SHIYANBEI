package org.soen387.app.viewHelper;

import java.util.List;

import org.soen387.app.rdg.BenchRDG;

public class PlayHelper implements ViewHelper{

	private String userId;
	
	private String handSize;

	private String deckSize;
	
	private String status;
	
	private String discardSize;
	
	private List<BenchRDG> benchRDG;
	
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		playJson.append("\"");
		playJson.append(userId);
		playJson.append("\":{");
		playJson.append("\"status\": \"playing\",\"handsize\":");
		playJson.append(handSize);
		playJson.append(",");
		playJson.append("\"decksize\":");
		playJson.append(deckSize);
		playJson.append(",");
		playJson.append("\"discardsize\":");
		playJson.append(discardSize);
		playJson.append(",");
		playJson.append("\"bench\":[");
		for(BenchRDG s: benchRDG) {
			playJson.append(s.getCardId());
			playJson.append(",");
		}
		playJson.deleteCharAt(playJson.length()-1);
		playJson.append("]}");
		return playJson.toString();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHandSize() {
		return handSize;
	}

	public String getDiscardSize() {
		return discardSize;
	}

	public void setDiscardSize(String discardSize) {
		this.discardSize = discardSize;
	}

	public void setHandSize(String handSize) {
		this.handSize = handSize;
	}

	public String getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(String deckSize) {
		this.deckSize = deckSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BenchRDG> getBenchRDG() {
		return benchRDG;
	}

	public void setBenchRDG(List<BenchRDG> benchRDG) {
		this.benchRDG = benchRDG;
	}

	public void changeBenchToJSON() {
		
	}
}
