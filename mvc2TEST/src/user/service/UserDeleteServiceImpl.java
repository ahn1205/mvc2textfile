package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDAO;





public class UserDeleteServiceImpl implements userservice{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.login(id, pw);
		
		if(result==1) {
			return dao.delete(id);
		} else {			
			return 2;
		}
		
	}

}
