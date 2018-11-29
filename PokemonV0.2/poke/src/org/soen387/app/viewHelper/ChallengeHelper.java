package org.soen387.app.viewHelper;

public class ChallengeHelper implements ViewHelper{

	private String id;
	
	private String challenger;
	
	private String version = "1";
	

	private String challengee;
	
	private String status;
	
	@Override
	public String toJson() {

		StringBuffer userJson = new StringBuffer();
		userJson.append("{\"id\":");
		userJson.append(id);
		userJson.append("{\"version\":");
		userJson.append(version);
		userJson.append(",\"challenger\":\"");
		userJson.append(challenger);
		userJson.append("\",\"challengee\":\"");
		userJson.append(challengee);
		userJson.append("\",\"status\":\"");
		userJson.append(status);
		userJson.append("\"}");
		return userJson.toString();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
