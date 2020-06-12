package com.test.util;

import java.sql.*;

public class JdbcUtil {

	//conn, pstmt, rs를 닫는 작업
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			
		} catch (Exception e) {
			System.out.println("jdbc close에러");
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {
			System.out.println("jdbc close에러");
		}
	}
}
