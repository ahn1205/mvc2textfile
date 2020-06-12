package util;

public class Criteria {
	//select * from board order by num desc limit ?, ?;
	private int pageNum; //페이지 번호
	private int count; //몇개의 데이터를 보여줄껀가 amount
	
	public Criteria() {
		//최초 게시판에 진입할 때 기본값을 1번페이지, 10개 데이터 세팅
		this.pageNum = 1;
		this.count = 10;
	}
	
	public Criteria(int pageNum, int count) {
		//전달받은 매개변수로 페이지 번호를 세팅
		this.pageNum = pageNum;
		this.count = count;
	}
	
	//limit x, count 구문에 전달될 x값을 구하는 메서드
	public int getPageStart() {
		return (pageNum - 1) * count;
	}

	public int getPageCount() {
		return pageNum * count;
	}	
	
	//게터, 세터 (alt + shift + s)
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	
}
