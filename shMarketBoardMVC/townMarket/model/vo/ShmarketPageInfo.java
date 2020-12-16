package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

public class ShmarketPageInfo {

	private int currentPage; // 사용자가 요청한 페이지
	private int listCount;   //현재 일반 게시판 총 갯수
	private int boardLimit;  //한페이지당 게시글 몇개까지 보여줄것인지
	private int pageLimit;   //한 페이지 하단에 보여질 페이지 최대 갯수
	private int maxPage;     //마지막 페이지
	private int startPage;   // 하단에 보여질 바의 시작수
	private int endPage;     //사용자가 요청한 페이지 하단에 보여질 페이징 바의 끝수	
	
	public ShmarketPageInfo() {
		
	}
	
	public ShmarketPageInfo(int currentPage, int listCount, int boardLimit, int pageLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.boardLimit = boardLimit;
		this.pageLimit = pageLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

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

	@Override
	public String toString() {
		return "ShmarketPageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", boardLimit="
				+ boardLimit + ", pageLimit=" + pageLimit + ", maxPage=" + maxPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}
	
	
}
