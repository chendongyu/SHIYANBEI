package org.soen387.app.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *  Connect to Jdbc
 */
public class MySqlConnectJdbc {

	//Connector Class
	private static MySqlConnectJdbc mySqlConnectJdbc;
	
	//Connector
	private Connection connect;
	
	/**
	 * TODO
	 */
	private MySqlConnectJdbc() {
		super();
		loadConnectorFromProper();
	}

	/**
	 * @return mysql connector
	 */
	public static MySqlConnectJdbc getConnectMysqlJdbc() {
		
		if(mySqlConnectJdbc == null) {
			mySqlConnectJdbc = new MySqlConnectJdbc();
			return new MySqlConnectJdbc();
		}
			return mySqlConnectJdbc;
	}
	
	private void loadConnectorFromProper() {
		// get the corresponding txt file, namely "Database"
		ResourceBundle resource = ResourceBundle.getBundle("DataBase");
		
		String driver = resource.getString("driver"); 
		String dbHost = resource.getString("dbHost");
		String dbPort = resource.getString("dbPort");
		String dbName = resource.getString("dbName");
		String useUnicode = resource.getString("useUnicode");
		String characterEncoding = resource.getString("characterEncoding");
		String serverTimezone = resource.getString("serverTimezone");
		String useSSL = resource.getString("useSSL");
	    String dbUserName = resource.getString("dbUserName");
	    String dbUserPassword = resource.getString("dbUserPassword");
	    
	    StringBuffer urlStrBuf = new StringBuffer();
	    urlStrBuf.append("jdbc:mysql://");
	    urlStrBuf.append(dbHost);
	    urlStrBuf.append(":");
	    urlStrBuf.append(dbPort);
	    urlStrBuf.append("/");
	    urlStrBuf.append(dbName);
	    urlStrBuf.append("?useUnicode=");
	    urlStrBuf.append(useUnicode);
	    urlStrBuf.append("&characterEncoding=");
	    urlStrBuf.append(characterEncoding);
	    urlStrBuf.append("&serverTimezone=");
	    urlStrBuf.append(serverTimezone);
	    urlStrBuf.append("&useSSL=");
	    urlStrBuf.append(useSSL);

	    try {
	    	//connect db, driver address
	     //  Class.forName(driver); 
	        // connect mysql by JDBC(providing username, password) 
	    //   this.connect = (Connection) DriverManager.getConnection(urlStrBuf.toString(), dbUserName, dbUserPassword);
	       Class.forName("com.mysql.jdbc.Driver");
	       this.connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/chen?user=chen&password=surgerin&characterEncoding=UTF-8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * @return Connection
	 */
	public Connection getConnect() {
		return connect;
	}

}
