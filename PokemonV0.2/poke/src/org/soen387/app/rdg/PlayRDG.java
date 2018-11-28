package org.soen387.app.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;

public class PlayRDG extends BaseRDG {

	private String userId;
	
	private String handSize;
	
	private String discardSize;

	private String deckSize;
	
	private String status;
	
	private List<BenchRDG> benchRDG;

	public PlayRDG() {
		super();
	}
	


	public PlayRDG( String status,String userId, String handSize, String deckSize, String discardSize) {
		super();
		this.userId = userId;
		this.handSize = handSize;
		this.deckSize = deckSize;
		this.discardSize = discardSize;
		this.status = status;
	}


	public static PlayRDG findAll(String userId)
	{
		PlayRDG PlayRDG = null;
		String pHandSize = "0";
		String pDeckSize = "0";
		String pDiscardSize = "0";
		String pStatus = null;
		
		try {
			ResultSet resultSet = excuteSelSql("SELECT USER.STATUS, "
					+ "DECK.STATUS, "
					+ "COUNT(DECK.CARD_ID) AS HANDSIZE "
					+ "FROM  USER "
					+ "INNER JOIN DECK "
					+ "ON USER.USER_ID = DECK.DECK_ID "
					+ "WHERE USER.USER_ID = ? "
					+ "GROUP BY DECK.STATUS", 
					userId);

			while (resultSet.next()) {
				if("0".equals(resultSet.getString(2))) {
					pStatus = resultSet.getString(1);
					pDeckSize = resultSet.getString(3);
				}
				
				if("1".equals(resultSet.getString(2))) {
					pStatus = resultSet.getString(1);
					pHandSize = resultSet.getString(3);
				}
				
				if("2".equals(resultSet.getString(2))) {
					pStatus = resultSet.getString(1);
					pDiscardSize = resultSet.getString(3);
				}
				
				if(!CommonUtil.isEmpty(pStatus)) {
					PlayRDG = new PlayRDG(pStatus,userId,pHandSize,pDeckSize,pDiscardSize);
					BenchRDG BenchRDG = new BenchRDG();
					BenchRDG.setCardId("1");
					List benchRDGs = new ArrayList<BenchRDG>();
					benchRDGs.add(BenchRDG);
					BenchRDG BenchRDG2 = new BenchRDG();
					BenchRDG2.setCardId("2");
					benchRDGs.add(BenchRDG);
					PlayRDG.setBenchRDG(benchRDGs);
				}
				
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			}
		return PlayRDG;
		
	
		
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



	public void setHandSize(String handSize) {
		this.handSize = handSize;
	}



	public String getDiscardSize() {
		return discardSize;
	}



	public void setDiscardSize(String discardSize) {
		this.discardSize = discardSize;
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
}
