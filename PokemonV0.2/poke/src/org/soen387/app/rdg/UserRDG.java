package org.soen387.app.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.soen387.app.common.CommonUtil;

public class UserRDG extends BaseRDG {

	private String userId;
	
	private String userName;

	private String passWord;
	
	private String status;
	
	public UserRDG() {
		super();
	}
	
	public UserRDG( String userName, String passWord) {
		
		this.userName = userName;
		this.passWord = passWord;
	}

	public UserRDG(String userId, String userName, String passWord) {
		
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public static List<UserRDG> findAllLogin() {
		
		List<UserRDG> userList = new ArrayList<UserRDG>();
		try {
			ResultSet resultSet = excuteSelSql("SELECT USER.USER_ID, USER.USER_NAME,USER.USER_PASSWORD FROM USER WHERE STATUS <> 0");
			while (resultSet.next()) {
				userList.add(new UserRDG(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public static UserRDG findById(String userId) {
		
		//check if there is an already used user name(in case of duplicate)
		UserRDG userRDG = null;
		try {
			ResultSet resultSet = excuteSelSql("SELECT USER.USER_ID,USER.USER_NAME,"
					+ "USER.USER_PASSWORD FROM USER WHERE USER.USER_ID = ?",userId);
			if (resultSet.next()) {
				userRDG = new UserRDG(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRDG;
	}
	
	public static UserRDG find(String userName) {
		//check if there is an already used user name(in case of duplicate)
		UserRDG userRDG = null;
		try {
			ResultSet resultSet = excuteSelSql("SELECT USER.USER_ID,USER.USER_NAME,"
					+ "USER.USER_PASSWORD FROM USER WHERE USER.USER_NAME = ?",userName);
			if (resultSet.next()) {
				userRDG = new UserRDG(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRDG;
	}
	
	public static UserRDG find(String userName, String passWord) {
		
		UserRDG userRDG = null;
		try {
			ResultSet resultSet = excuteSelSql("SELECT USER.USER_ID, USER.USER_ID, USER.USER_NAME,"    //using base class method
					+ "USER.USER_PASSWORD FROM USER WHERE USER.USER_NAME = ? AND USER.USER_PASSWORD = ?",userName,passWord);
			if (resultSet.next()) {          //check if is end of file
				userRDG = new UserRDG(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRDG;
	}
	
	public static int insert(UserRDG userRDG) {
		
		if(userRDG == null) {
			return 0;
		}
		
		int num = excuteInsertSql("INSERT INTO USER(USER.USER_NAME,"
				+ "USER.USER_PASSWORD) VALUES( ?, ?)",userRDG.getUserName(),userRDG.getPassWord());
		return num;
	}
	
	public static int update(UserRDG userRDG) {
		if(userRDG == null) {
			return 0;
		}
		
		int num = excuteInsertSql("UPDATE USER SET USER.STATUS = ?"
				+ "WHERE USER.USER_ID = ?",userRDG.getStatus(),userRDG.getUserId());
		
		return num;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
