package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import user.service.JoinServiceImpl;
import user.service.UserDeleteServiceImpl;
import user.service.UserGetInfoServiceImpl;
import user.service.UserUpdateServiceImpl;
import user.service.UserloginServiceImpl;
import user.service.userservice;




@WebServlet("*.users")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); 
		String path = request.getContextPath(); 
		String command = uri.substring(path.length());
			
		System.out.println(command);
		
		userservice service = null;
		
		
		
		if(command.equals("/join.users")) {			
			request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
		}		
		else if(command.equals("/joinForm.users")) {
			
			service = new JoinServiceImpl();
			int result = service.execute(request, response);
			
			
			if (result == 1) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디가 중복 되었습니다.')");
				out.println("history.go(-1)");
				out.println("</script>");
				
			}else{
				response.sendRedirect("login.users");
			}
			
		} else if(command.equals("/login.users")) {
		
			request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
		}else if(command.equals("/loginForm.users")) {
			
			service = new UserloginServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("mypage.users");
			} else {
				response.setContentType("text/html; charset=utf-8");				
				PrintWriter out = response.getWriter(); //out 객체 생성
				
				out.println("<script>");
				out.println("alert('로그인 실패')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
			
		} else if(command.equals("/mypage.users")) {
			request.getRequestDispatcher("/user/user_mypage.jsp").forward(request, response);
		} else if(command.equals("/mypageinfo.users")) {
			
			
			service = new UserGetInfoServiceImpl();
			int result = service.execute(request, response);
			
			if(result==0) {//값얻어오기 실패
				response.setContentType("text/html; charset=utf-8");				
				PrintWriter out = response.getWriter(); //out 객체 생성
				
				out.println("<script>");
				out.println("alert('로그인 정보 얻기 실패')");
				out.println("history.go(-1)");
				out.println("</script>");
			} else {
			
			request.getRequestDispatcher("/user/user_mypageinfo.jsp").forward(request, response);
			}
		} else if(command.equals("/mypageinfoForm.users")) {
			
			service = new UserUpdateServiceImpl();
			int result = service.execute(request, response);
			
			if(result==0) {
				response.setContentType("text/html; charset=utf-8");				
				PrintWriter out = response.getWriter(); //out 객체 생성
								
				out.println("<script>");
				out.println("alert('회원정보 수정 실패')");
				out.println("history.go(-1)");
				out.println("</script>");
			}else {
				response.setContentType("text/html; charset=utf-8");				
				PrintWriter out = response.getWriter(); //out 객체 생성
				
				out.println("<script>");
				out.println("alert('회원정보 수정 성공')");
				out.println("location.href='mypage.users'");
				out.println("</script>");
				
			}			
			
		}else if(command.equals("/delete.users")) {
			
			
			service = new UserDeleteServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("login.users");
			} else {
				response.setContentType("text/html; charset=utf-8");				
				PrintWriter out = response.getWriter(); //out 객체 생성
				
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다.')");		
				out.println("history.go(-1)");
				out.println("</script>");
			}
			
		}
		
		
		
	}

}
