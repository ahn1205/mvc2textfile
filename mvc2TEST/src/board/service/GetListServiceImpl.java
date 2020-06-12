package board.service;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.test.util.Criteria;
import com.test.util.PageVO;

import board.model.BoardDAO;
import board.model.BoardVO;

public class GetListServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//DAO객체 생성
//		BoardDAO dao = BoardDAO.getInstance();

		//DB에서 모든 글목록을 조회해서 VO에 담고, VO를 list에 추가
//		List<BoardVO> list = dao.getList(); //목록조회 결과를 list형태로 받음

		//다음 화면에서 사용하기 위해서 request객체에 강제 저장
//		request.setAttribute("boardList", list);


		//페이징
		//DAO객체 생성
		BoardDAO dao = BoardDAO.getInstance();

		Criteria cri = new Criteria(1,10);	

		//2번 페이지 부터 클릭했을 때 처리할 코드
		if( request.getParameter("pageNum") != null|request.getParameter("amount")!=null) {

			String pageNum = request.getParameter("pageNum");
			cri.setPageNum( Integer.parseInt(pageNum) );
			String amount = request.getParameter("amount");
			cri.setCount(Integer.parseInt(amount));
		}


		ArrayList<BoardVO> list = dao.getList(cri);
		request.setAttribute("boardList", list);
				

		//화면에 보여질 페이지 버튼을 계산 처리
		//총게시글 수
		int total = dao.getTotal();
		PageVO vo = new PageVO(total, cri);

		request.setAttribute("pageVO", vo);
	}
}
