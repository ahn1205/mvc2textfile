package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.ContentServiceImpl;
import board.service.DeleteServiceImpl;
import board.service.GetListServiceImpl;
import board.service.HitServiceImpl;
import board.service.IBoardService;
import board.service.RegistServiceImpl;
import board.service.UpdateServiceImpl;





@WebServlet("*.board")
public class BoardContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 public BoardContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length());
		
		IBoardService service = null;
		
		if(command.equals("/bbs.board")) {
			
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("/bbs/bbs.jsp").forward(request, response);
		} else if(command.equals("/bbs_writer.board")) {			
			
			request.getRequestDispatcher("/bbs/bbs_writer.jsp").forward(request, response);
		} else if(command.equals("/regist.board")) {
			service = new RegistServiceImpl();			
			service.execute(request, response);
			
			
			response.sendRedirect("bbs.board"); //다시 컨트롤러를 태워준다.
		} else if(command.equals("/content.board")) { //상세보기화면 요청
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			
			//조회수 관련한 service 실행
			service = new HitServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("/bbs/bbs_content.jsp").forward(request, response);
			
		}else if(command.equals("/modify.board")) { //수정 화면 실행
			/*
			 * 화면에서 경로에 bno 값을 전달합니다.
			 * UpdateServiceImpl()을 전달합니다.
			 * 포워드로 board_modify.jsp로 이동
			 * 화면에서는 태그란에 데이터값을 출력 
			 */
			service = new ContentServiceImpl();
			service.execute(request, response);			
			
			request.getRequestDispatcher("/bbs/bbs_modify.jsp").forward(request, response);
		} else if(command.equals("/update.board")) { //수정처리 요청
			
			/*
			 * 1. UpdateServiceImpl을 생성합니다.
			 * 2. 서비스 영역에서는 bno, title, content울 받아서 update() 메서드를 실행
			 * 3. DAO의 update() 에서는 update구문으로 데이터를 수정
			 * 4. 페이지 이동을 상세화면으로 연결 (단, 필요한 값을 전달해야 함)
			 * 
			 * sql = "update board set title =?, content =? where bno = ?"
			 * 
			 */
			
			service = new UpdateServiceImpl();
			service.execute(request, response);				
			
			String bno = request.getParameter("bno");
			//다시 컨트롤러에 태울때 redirect로 보냄
			response.sendRedirect("content.board?bno="+ bno); //content.board는 bno값을 반드시 필요로 함.
		} else if(command.equals("/delete.board")) {
			/*
			 * 1. DeleteServiceImpl을 생성합니다
			 * 2. 서비스 영역에서는bno를 받아서 delete()메서드 실행
			 * 3. DAO의 delete()에서는 delete구문으로 삭제 
			 * 4. 페이지 이동을 목록으로
			 * 
			 * sql = "delete from board where bno = ?"
			 */
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect(request.getContextPath()+"/main.do");
		}
		
	}

}
