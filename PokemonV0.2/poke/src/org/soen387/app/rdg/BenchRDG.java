package org.soen387.app.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;

public class BenchRDG extends BaseRDG {

	private String userId;
	
	private String cardId;
	
	private String energys;
	
	private String bPrement;

	private String benchId;
	
	
	
	
	public BenchRDG() {
		super();
	}
	

	


	public BenchRDG(String userId, String cardId, String benchId) {
		super();
		this.userId = userId;
		this.cardId = cardId;
		this.benchId = benchId;
	}






	public static List<BenchRDG> findAll(String userId)
	{
		List<BenchRDG> benchList =  new ArrayList<BenchRDG>();
		
		try {
			ResultSet resultSet = excuteSelSql("SELECT DK.DECK_ID,DK.CARD_ID FROM DECK DK WHERE DK.STATUS = 3 AND DK.DECK_ID = ?", 
					userId);
			while(resultSet.next()) {
				BenchRDG benchRDG= new BenchRDG(resultSet.getString(1),resultSet.getString(2),"");
				benchList.add(benchRDG);
				
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			}
		return benchList;
		
	
		
	}
	
	
	
	
	public static int insert(BenchRDG benchRDG) {
		
		if(benchRDG== null) {
			return 0;
		}
		
		int num = excuteInsertSql("INSERT INTO BENCH(BENCH.USER_ID,BENCH.CARD_ID)"
					+ " VALUES(?, ?)",benchRDG.getUserId(),benchRDG.getCardId());
		
		return num;
	}
	

	
	public static int delete(BenchRDG benchRDG) {
	
		if(benchRDG == null) {
			return 0;
		}
		
		int num = excuteInsertSql("DELETE FROM BENCH WHERE "
					+ "BENCH.BENCH_ID = ?",benchRDG.getBenchId());
		
		return num;
	}
	

	
	
	
	
	
	
	public String getUserId() {
		return userId;
	}






	public void setUserId(String userId) {
		this.userId = userId;
	}






	public String getCardId() {
		return cardId;
	}






	public void setCardId(String cardId) {
		this.cardId = cardId;
	}






	public String getBenchId() {
		return benchId;
	}






	public void setBenchId(String benchId) {
		this.benchId = benchId;
	}





	public String getEnergys() {
		return energys;
	}





	public void setEnergys(String energys) {
		this.energys = energys;
	}





	public String getbPrement() {
		return bPrement;
	}





	public void setbPrement(String bPrement) {
		this.bPrement = bPrement;
	}
	
	
	
	


}
