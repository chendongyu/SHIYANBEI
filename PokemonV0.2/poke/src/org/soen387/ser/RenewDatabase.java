package org.soen387.ser;

import java.util.List;

import org.soen387.app.common.CommonUtil;
import org.soen387.app.rdg.BaseRDG;

public class RenewDatabase {

	public static void main(String[] args) {
		
		BaseRDG.excuteInsertSql("truncate table USER;");
		BaseRDG.excuteInsertSql("truncate table DECK;");
		BaseRDG.excuteInsertSql("truncate table CHALLENGE;");
	}

}

