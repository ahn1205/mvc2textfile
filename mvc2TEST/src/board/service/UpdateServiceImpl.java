package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;



public class UpdateServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//폼에서 전송된 값을 받고
		String bno = request.getParameter("bno");
//		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
//		System.out.println(writer);
		
		//DAO의 update메서드 호출
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(bno, title, content);
		
		
	}

	
}
