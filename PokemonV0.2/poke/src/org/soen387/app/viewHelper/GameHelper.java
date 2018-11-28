package org.soen387.app.viewHelper;

import org.soen387.app.common.CommonUtil;

public class GameHelper implements ViewHelper {

	private String id;
	
	private String challenger;
	
	private String challengee;
	
	
	

	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		
		playJson.append("{\"games\":[");
		if(!CommonUtil.isEmpty(id)) {
			playJson.append("{\"id\":");
			playJson.append(id);
			playJson.append(",\"players\":[\"");
			playJson.append(challenger);
			playJson.append("\",\"");
			playJson.append(challengee);
			playJson.append("\"]}");
		}
		playJson.append("]}");
		return playJson.toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
	}

	public String getChallengee() {
		return challengee;
	}

	public void setChallengee(String challengee) {
		this.challengee = challengee;
	}
	
	

}
