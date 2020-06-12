package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDAO;
import user.model.UserVO;





public class UserloginServiceImpl implements userservice {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");


		UserDAO dao = UserDAO.getInstance();

		int result = dao.login(id, pw);
		System.out.println(result);
		System.out.println(id);
		if(result==1){
			
			//로그인 성공시에 회원정보를 얻어오는 작업
			UserVO vo = dao.getInfo(id);
			String name = vo.getName(); //이름을 얻음

			HttpSession session = request.getSession();

			//아이디와 이름을 세션에 저장
			session.setAttribute("id", id);
			session.setAttribute("name", name);

			return result;
		} else {
			return result;
		}
	}

}
