package org.soen387.app.viewHelper;

public class CardHelper implements ViewHelper {

	private String name;
	
	private String type;
	
	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		playJson.append("{\"t\":\"");
		playJson.append(type);
		playJson.append("\",\"n\":\"");
		playJson.append(name);
		playJson.append("\"}");
		return playJson.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
