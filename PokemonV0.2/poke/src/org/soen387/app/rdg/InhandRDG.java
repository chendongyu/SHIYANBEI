package org.soen387.app.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;

public class InhandRDG extends BaseRDG {

	private String userId;
	
	private String cardId;
	
	private String playId;

	private String inhandId;
	
	
	
	
	public InhandRDG() {
		super();
	}
	

	


	public InhandRDG( String inhandId,String userId, String playId, String cardId ) {
		super();
		this.userId = userId;
		this.cardId = cardId;
		this.inhandId = inhandId;
		this.playId = playId;
	}






	public static List<InhandRDG> findAll(String userId)
	{
		List<InhandRDG> inhandList =  new ArrayList<InhandRDG>();
		
		try {
			ResultSet resultSet = excuteSelSql("SELECT INHAND.INHAND_ID, INHAND.USER_ID, INHAND.PLAY_ID, INHAND.CARD_ID FROM INHAND WHERE USER_ID = ? ", 
					userId);
			while(resultSet.next()) {
				InhandRDG inhandRDG= new InhandRDG(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
				inhandList.add(inhandRDG);
				
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			}
		return inhandList;
		
	
	}
	
	
	
	
	
	public static int insert(InhandRDG inhandRDG) {
		
		if(inhandRDG== null) {
			return 0;
		}
		
		int num = excuteInsertSql("INSERT INTO INHAND(INHAND.USER_ID,INHAND.CARD_ID)"
					+ " VALUES(?, ?)",inhandRDG.getUserId(),inhandRDG.getCardId());
		
		return num;
	}
	

	// draw card 
//	public static int update(InhandRDG inhandRDG) {
//		
//	}




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





	public String getPlayId() {
		return playId;
	}





	public void setPlayId(String playId) {
		this.playId = playId;
	}





	public String getInhandId() {
		return inhandId;
	}





	public void setInhandId(String inhandId) {
		this.inhandId = inhandId;
	}
	

	
	
	
	
	
	
	
	
	
	


}
