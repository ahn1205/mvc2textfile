package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcutil {
			
		public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
			}
			
		}
		
	}

