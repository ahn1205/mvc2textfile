package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {

	//service클래스에서 구현할 메서드를 추상 메서드로 선언, request와 response를 매개변수로 전달받음
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
