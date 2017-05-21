package jspbook3.addrbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAddrBook {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	private int user_num; 
	private String user_id;
	private String passwd;
	
	final String _userid = "jonghoon";
	final String _passwd = "1234";
	
	public String get_userid() {
		return _userid;
	}
	public String get_passwd() {
		return _passwd;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/* MySQL 연결정보 */
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(jdbc_url, "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkUser(String user_id,String passwd) {

		connect(); 
		try {
			ResultSet rs = null;
			String sql = "select user_id,passwd from login"; 
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery(); 
			
			
			while(rs.next()) {
				if(user_id.equals(rs.getString(1)) && passwd.equals(rs.getString(2))) {
					return true; 
				} 
			} 
			
		

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;

	} // checkUser() 함수의 끝

}
