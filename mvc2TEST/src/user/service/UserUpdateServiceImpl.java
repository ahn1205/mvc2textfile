package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDAO;
import user.model.UserVO;





public class UserUpdateServiceImpl implements userservice{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");		
		String pw = request.getParameter("pw");	
		String name = request.getParameter("name");
		String hp = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		
		
		UserDAO dao = UserDAO.getInstance();
				
			UserVO vo = new UserVO(id, pw, name, email, email2, hp, hp2, hp3, address, address2,null);
			
			int result = dao.update(vo);
			System.out.println(result);
			if(result == 1) { //비밀번호 및 회원정보 변경 성공
				HttpSession session = request.getSession();				
				session.setAttribute("name", name);
				
				return result;				
			}else {	//비밀번호 및 회원정보 변경 실패
				return result;
			}
		
	}

}
