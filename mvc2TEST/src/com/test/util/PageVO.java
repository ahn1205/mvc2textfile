package com.test.util;

public class PageVO {

	//화면에 그려질 버튼들의 개수를 계산하는 클래스
	
	private int startPage; //시작번호
	private int endPage; //끝번호
	private int total; //전체게시글 수
	
	private int pageNum; //현재 조회하는 페이지
	
	private boolean next; //다음버튼 활성화 여부
	private boolean prev; //이전버튼 활성화 여부
	
	private Criteria cri; //페이징 기준
	
	private int amount; //현 페이지에서 몇개의 데이터를 보여줄건가
	
	//생성될 때 total, Criteria를 받아서 계산을 처리하도록 선언.
	public PageVO(int total, Criteria cri) {
		//전달되는 매개변수에서 초기값을 저장
		this.total = total; 
		this.cri = cri;
		this.pageNum = cri.getPageNum();
		this.amount =cri.getCount();
		//끝페이지 계산
		//조회하는 페이지 번호가 1~10 이면 -> 10
		//조회하는 페이지 번호가 11~20 -> 20
		//계산식 = (int)Math.ceil(조회하는 페이지 번호 / (double)한번에 보여질 페이지번호) * 한번에 보여질 페이지번호
		this.endPage = (int)Math.ceil( this.pageNum / 5.0 ) * 5;
		
		//계산식 = 끝 페이지 번호 - 한번에 보여질  페이지번호 + 1
		this.startPage = endPage - 5+1;//-5+1
		
		//페이지 번호가 적을 때 나타내는 진짜 끝번호
		//토탈- 131개의 게시물에서 
		//1번클릭시 보여야되는 끝번호 10,
		//endPage =  10, realEnd = 14
		//11클릭시 보여야되는 끝번호 14	   
		//endPage = 20, realEnd 14
				
		//계산식 = (int)Math.ceil(전체 게시글수 / 몇개의 데이터를 보여줄지)
		int realEnd = (int)Math.ceil(this.total / (double)this.amount );
		
		//마지막 페이지세팅에서 보여줘야하는 번호
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		//이전페이지 버튼 활성화 여부
		//startPage -> 1, 11, 21, 31.........
		//startPage가 1보 크면 true
		this.prev = startPage > 1;
		
		//다음페이지 버튼 활성화 여부
		//예를 들어서 131개 게시물에서 진짜 끝번호 14
		//1~10번 조회할때 endPage = 10;
		//이때만 true이어야 하기 때문에
		this.next = realEnd > this.endPage;
		
//		System.out.println(startPage+" "+endPage);		
	}
	
	//게터, 세터
		
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
