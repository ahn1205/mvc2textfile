package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;


public class RegistServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//폼에서 전달된 값을 처리
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content =request.getParameter("content");
		
		System.out.println(writer);
		System.out.println(title);
		System.out.println(content);
		
		//DAO객체 생성
		//regist메서드 호출
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);
		
	}

}

