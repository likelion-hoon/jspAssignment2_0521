package jspbook3.addrbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBean {

	Connection conn = null;
	PreparedStatement pstmt = null;

	/*
	 * Oracle 연결정보 String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	 * String jdbc_url = "jdbc:oracle:thin:@220.68.14.7:1521";
	 */

	/* MySQL 연결정보 */
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb";

	// DB연결 메서드
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

	// 신규 주소록 메시지 추가 메서드
	public boolean insertDB(LoginAddrBook loginaddrbook) {
		connect();
		// sql 문자열 , user_id 는 자동 등록 되므로 입력하지 않는다.

		String sql = "insert into login(user_id,passwd) values(?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginaddrbook.getUser_id());
			pstmt.setString(2, loginaddrbook.getPasswd());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	// login DB에 있는 패스워드를 가져오는 메서드

	

}
