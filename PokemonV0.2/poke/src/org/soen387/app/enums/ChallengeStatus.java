package org.soen387.app.enums;

public enum ChallengeStatus {
	OPEN(0),REFUSED(1),WITHDRAWN(2),ACCEPTED(3);
	
	private int value;
	
	ChallengeStatus(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
