package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import user.model.UserDAO;
import user.model.UserVO;

public class JoinServiceImpl implements userservice{
	
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String hp = request.getParameter("hp");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		
		System.out.println(id);
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO(id,pw,name,email,email2,hp, hp2, hp3, address, address2,null);
		
		if(dao.checkId(id) == 1) {
			return 1;
		}else {
			dao.insert(vo);
			return 0;
		}
		
			
		
	}	
	
	
}
