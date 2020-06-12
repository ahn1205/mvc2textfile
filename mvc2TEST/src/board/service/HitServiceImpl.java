package board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;


public class HitServiceImpl implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");

		Cookie[] nos = request.getCookies();

		boolean bool= true;
		for(Cookie c:nos) {
			if(c.getValue().equals(bno)) {
				bool=false;
				break;
			}
		}
		if(bool) {
			BoardDAO dao = BoardDAO.getInstance();
			dao.hit(bno);			
		}

		Cookie no = new Cookie("hit", bno);		
		no.setMaxAge(60);
		response.addCookie(no);

	}

}
