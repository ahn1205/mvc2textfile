package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;


import util.jdbcutil;

public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle"); 
		} catch (Exception e) {
			System.out.println("클래스 로딩중 에러");
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int checkId(String id) {
		
		int result = 0;
		
		String sql ="select * from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				result = 1;
			} else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	

	//회원가입 처리
	public int insert(UserVO vo) {
		int result = 0;
		
		String sql = "insert into users(id, pw, name, email, email2, hp,hp2,hp3,address,address2) values(?,?,?,?,?,?,?,?,?,? )";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getPw() );
			pstmt.setString(3, vo.getName() );
			pstmt.setString(4, vo.getEmail() );
			pstmt.setString(5, vo.getEmail2() );
			pstmt.setString(6, vo.getHp());
			pstmt.setString(7, vo.getHp2());
			pstmt.setString(8, vo.getHp3());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, vo.getAddress2());
					
			
			
			result = pstmt.executeUpdate(); //성공시 1, 실패시 0반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	
	
	//로그인 검증 메서드
	public int login(String id, String pw) {
		
		int result= 0;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //로그인 성공
				result = 1;
			} else { //로그인실패
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, rs);
			
		}
		return result;
	}
	
	//모든 회원정보를 가져오는 메서드
	public UserVO getInfo(String id) {
		
		UserVO vo = new UserVO();
		
		String sql = "select * from users where id = ?" ;
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//pw를 제외하고, rs에 있는 회원정보를 vo담는 코드.
			if(rs.next()) {
				
				vo.setId( rs.getString("id") );				
				vo.setName( rs.getString("name") );
				vo.setEmail( rs.getString("email") );
				vo.setEmail2( rs.getString("email2") );
				vo.setHp( rs.getString("hp"));
				vo.setHp2( rs.getString("hp2"));
				vo.setHp3( rs.getString("hp3"));
				vo.setAddress( rs.getString("address"));
				vo.setAddress2( rs.getString("address2"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//회원정보 수정
	public int update(UserVO vo) {
		
		int result = 0;
		
		String sql = "update users set pw = ?, name = ?, email = ?,  email2 = ?,hp =?, hp2=?, hp3=?,address = ?, address2 = ? where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw()  );
			pstmt.setString(2, vo.getName() );
			pstmt.setString(3, vo.getEmail() );
			pstmt.setString(4, vo.getEmail2() );
			pstmt.setString(5, vo.getHp() );
			pstmt.setString(6, vo.getHp2() );
			pstmt.setString(7, vo.getHp3() );
			pstmt.setString(8, vo.getAddress() );
			pstmt.setString(9, vo.getAddress2() );
			pstmt.setString(10, vo.getId() );
			
			result = pstmt.executeUpdate(); //성공시1 , 실패시 0
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, null);
		}
		return result;
		
	}
	
	
	//회원탈퇴 메서드
	public int delete(String id ) {
		
		int result = 0;
		
		String sql = "delete from users where id = ?"; 
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(conn, pstmt, null);
		}
		
		
		return result;
	}
	
	
	
}
