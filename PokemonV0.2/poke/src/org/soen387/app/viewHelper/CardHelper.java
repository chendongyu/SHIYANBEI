package org.soen387.app.viewHelper;

import org.soen387.app.common.CommonUtil;

public class CardHelper implements ViewHelper {

	private String name;
	
	private String type;
	
	@Override
	public String toJson() {
		
		StringBuffer playJson = new StringBuffer();
		playJson.append("{\"t\":\"");
		playJson.append(type);
		playJson.append("\",\"n\":\"");
		if(!CommonUtil.isEmpty(name)) {
			String[] split = name.split(" ");
			if(split.length>1) {
				playJson.append(split[0]+",\"b\":"+split[1]);
			}else {
				playJson.append(name);
			}
		}else {
			playJson.append(name);
		}
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
