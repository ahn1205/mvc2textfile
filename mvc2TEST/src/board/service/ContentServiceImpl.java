package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;


public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * 1. dao에 getcontent(num) 메서드를 생성하고 호출
		 * 2. getContent()메서드 에서는 bno를 가지고, 게시글에 대한 정보를 조회해서 VO에 담는 코드를작성
		 * 3. 메서드 리턴타입 BoardVO
		 * 4. 화면전송을 위해 리턴값을 vo라는 이름으로 강제 저장
		 * sql = "select * from board where bno = ?"
		 */
		
		String bno = request.getParameter("bno"); //화면에서 a태그에 넘어오는 값 처리
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(Integer.parseInt(bno));
		
		//화면에 글정보를 넘겨주기 위해 리퀘스트에 저장
		request.setAttribute("vo", vo);
		
		
		
	}

	
}
