package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.util.Criteria;
import com.test.util.JdbcUtil;




public class BoardDAO {
	//1. 스스로의 객체를 멤버변수로 선언하고 1개로 제한
	private static BoardDAO instance = new BoardDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private
	private BoardDAO() {
		//커넥션풀을 꺼내는 작업
		try {
			InitialContext ctx = new InitialContext(); //초기 설정파일 저장되는 객체
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			System.out.println("커넥션 풀링 에러 발생");
		}
		
	}
	//3. 외부에서 객체를 요구할때 getter메서드만 써서 반환
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//-----------중복되는 코드는 멤버변수로 선언-----------
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//글 등록 메서드
	public void regist(String writer, String title, String content) {
		
		String sql = "insert into board(bno,writer, title, content) values(bno_seq.nextval,?,?,? )";
	
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
	}
	/*
	//게시물 목록 조회 메서드
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * from board order by bno desc";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				//rs.getString(컬럼명), rs.getInt(컬럼명), rs.getTimestamp(컬럼명)
				//데이터를 vo에 담고, vo를 list에 저장하는 코드 작성
				
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(bno, writer, title, content, regdate, hit);
				
				list.add(vo); //리스트에 추가				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	*/
	
	//페이징 게시물 목록 처리 메서드
		public ArrayList<BoardVO> getList(Criteria cri) {
			
			ArrayList<BoardVO> list = new ArrayList<>();
			
			/*
			 * String sql = "select rn,bno,writer,title,content, regdat hit\r\n" +
			 * "from(select rownum rn,\r\n" + "        bno,\r\n" + "        writer,\r\n" +
			 * "        title,\r\n" + "        content,\r\n" + "        hit        \r\n" +
			 * "from (\r\n" + "        select * \r\n" +
			 * "        from board order by bno desc\r\n" + "        )\r\n" +
			 * ") where rn>? and rn <?";
			 */
			String sql = "select *\r\n" + 
					"from(select rownum rn,\r\n" + 
					"        bno,\r\n" + 
					"        writer,\r\n" + 
					"        title,\r\n" + 
					"        content,\r\n" + 
					"        regdate,\r\n" + 
					"        hit        \r\n" + 
					"from (\r\n" + 
					"        select * \r\n" + 
					"        from board order by bno desc\r\n" + 
					"        )\r\n" + 
					") where rn>? and rn <=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cri.getPageStart() ); //시작번호 
				pstmt.setInt(2, cri.getPageCount() ); //몇개의 데이터를 조회할 건가
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int bno = rs.getInt("bno");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Timestamp regdate = rs.getTimestamp("regdate");
					int hit = rs.getInt("hit");
					
					BoardVO vo = new BoardVO(bno, writer, title, content, regdate, hit);
//					System.out.println(vo.toString());
					list.add(vo); //리스트에 추가
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			
			
			return list;
		}
	
		//총 게시물 수를 구하는 메서드
		public int getTotal() {
			
			int total = 0;
			
			String sql = "select count(*) as total from board";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					total = rs.getInt("total");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			return total;
		}
		
	
	
	
	
	//상세보기 처리 메서드
	public BoardVO getContent(int bno) {
		
		BoardVO vo = null;
		
		String sql = "select * from board where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) { //다음행에 대한 조회
				
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				vo = new BoardVO(bno, writer, title, content, regdate, hit);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}		
		return vo;
	}
	
	//수정 처리 메서드
	public void update(String bno, String title, String content) {
		
		String sql = "update board set title =?, content =? where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title );
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	//삭제 메서드 실행
	public void delete(String bno) {
		
		String sql = "delete from board where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	public void hit(String bno) {
		String sql ="update board set hit = hit+1 where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
	}	
	
}
