package org.soen387.app.viewHelper;

import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.DeckRDG;

public class BoardHelper implements ViewHelper {
	
	private String id;
	private String version = "1";
	private String current;
	


	private String[] players;
	
	private String[] decks;
	
	private List<PlayHelper> playHelpers;
	

	
	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		
		playJson.append("{\"game\":{\"");
		playJson.append("id");
		playJson.append("\":");
		playJson.append(id);
		playJson.append(",\"");
		
		playJson.append("version");
		playJson.append("\":");
		playJson.append(version);
		playJson.append(",\"");
		
		playJson.append("players\":[");
		for(String s : players) {
			playJson.append(s);
			playJson.append(",");
		}
		playJson.deleteCharAt(playJson.length()-1);
		
		playJson.append("],\"current\":");
		playJson.append(current);
		
		playJson.append(",\"decks\":[");
		for(String s : decks) {
			playJson.append(s);
			playJson.append(",");
		}
		playJson.deleteCharAt(playJson.length()-1);
		playJson.append("],\"play\": {");
		for(int index=0; index<playHelpers.size(); index++) {
		playJson.append(playHelpers.get(index).toJson());
		playJson.append(",");
		}
		
//		playJson.append("\"");
//		playJson.append(playHelpers.get(0).getUserId());
//		playJson.append("\":{");
//		playJson.append("\"status\": \"playing\",\"handsize\":");
//		playJson.append(playHelpers.get(0).getHandSize());
//		playJson.append(",");
//		playJson.append("\"decksize\":");
//		playJson.append(playHelpers.get(0).getDeckSize());
//		playJson.append("},");
//		
//		playJson.append("\"");
//		playJson.append(playHelpers.get(1).getUserId());
//		playJson.append("\":{");
//		playJson.append("\"status\": \"playing\",\"handsize\":");
//		playJson.append(playHelpers.get(1).getHandSize());
//		playJson.append(",");
//		playJson.append("\"decksize\":");
//		playJson.append(playHelpers.get(1).getDeckSize());
//		playJson.append("}");
		
		
		playJson.deleteCharAt(playJson.length()-1);
		playJson.append("}}}");
		return playJson.toString();
	}


	public String[] getPlayers() {
		return players;
	}

	public void setPlayers(String[] players) {
		this.players = players;
	}

	public String[] getDecks() {
		return decks;
	}

	public void setDecks(String[] decks) {
		this.decks = decks;
	}

	public List<PlayHelper> getPlayHelpers() {
		return playHelpers;
	}

	public void setPlayHelpers(List<PlayHelper> playHelpers) {
		this.playHelpers = playHelpers;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getCurrent() {
		return current;
	}


	public void setCurrent(String current) {
		this.current = current;
	}

}
