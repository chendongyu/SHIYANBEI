package org.soen387.app.viewHelper;

public class HandHelper implements ViewHelper{

	private String json;
	
	@Override
	public String toJson() {
		
		return getJson();
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
