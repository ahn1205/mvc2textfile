package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;



public class DeleteServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//폼에서 전달된 값 처리
		String bno = request.getParameter("bno");
		
		
		//삭제메서드
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(bno);
		
		
	}

}
