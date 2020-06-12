package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDAO;
import user.model.UserVO;





public class UserGetInfoServiceImpl implements userservice{


	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		
		request.setAttribute("user_vo", vo);
		
		if(vo.getId()==null) {		
			return 0;
		} else {
			return 1;
		}
	}

}
