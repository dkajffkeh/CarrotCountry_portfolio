package com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo;

import java.sql.Date;

import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

public class PostBoard extends ShmarketPageInfo {
	
	private int postNo;
	private String categoryNo;
	private int memNo;
	private String localNo;
	private String memNickname;
	private String postName;
	private String postContent;
	private String categoryName;
	private String parcelNum;
	private String prodStatus;
	private String dealType;
	private String site;
	private String thumbnailPath;
	private String thumbnailFilename;
	private String thumbnailLoadPath;
	private int postViews;
	private int postReports;
	private int postLikes;
	private int prodPrice;
	private Date EnrollDate;
	private String blindCheck;	
	private String postRefund;
	private int likeNum;
	
	public PostBoard() {
		
	}	
	
	public PostBoard(int currentPage, int listCount, int boardLimit, int pageLimit, int maxPage, int startPage,
			int endPage, int postNo, int memNo, String localNo, String postName, String categoryName,
			String thumbnailPath, String thumbnailFilename, String thumbnailLoadPath, int postViews, int postLikes,
			int prodPrice, int likeNum) {
		super(currentPage, listCount, boardLimit, pageLimit, maxPage, startPage, endPage);
		this.postNo = postNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.postName = postName;
		this.categoryName = categoryName;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
		this.likeNum = likeNum;
	}
	
	public PostBoard(int postNo, int memNo, String localNo, String postName, String categoryName, String thumbnailPath,
			String thumbnailFilename, String thumbnailLoadPath, int postViews, int postLikes, int prodPrice,
			int likeNum) {
		super();
		this.postNo = postNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.postName = postName;
		this.categoryName = categoryName;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
		this.likeNum = likeNum;
	}

	public PostBoard(int postNo, String postName, String postContent, String thumbnailPath, String thumbnailFilename,
			String thumbnailLoadPath) {
		super();
		this.postNo = postNo;
		this.postName = postName;
		this.postContent = postContent;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
	}

	public PostBoard(int postNo, String categoryNo, int memNo, String localNo, String memNickname, String postName,
			String postContent, String categoryName, String parcelNum, String prodStatus, String dealType, String site,
			String thumbnailPath, String thumbnailFilename, String thumbnailLoadPath, int postViews, int postReports,
			int postLikes, int prodPrice, Date enrollDate, String blindCheck, String postRefund) {
		super();
		this.postNo = postNo;
		this.categoryNo = categoryNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.memNickname = memNickname;
		this.postName = postName;
		this.postContent = postContent;
		this.categoryName = categoryName;
		this.parcelNum = parcelNum;
		this.prodStatus = prodStatus;
		this.dealType = dealType;
		this.site = site;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postReports = postReports;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
		EnrollDate = enrollDate;
		this.blindCheck = blindCheck;
		this.postRefund = postRefund;
	}

	public PostBoard(int postNo, int memNo, String localNo, String postName, String categoryName, String thumbnailPath,
			String thumbnailFilename, String thumbnailLoadPath, int postViews, int postLikes, int prodPrice) {
		super();
		this.postNo = postNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.postName = postName;
		this.categoryName = categoryName;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
	}

	public PostBoard(int postNo, String categoryNo, int memNo, String localNo, String memNickname, String postName,
			String postContent, String categoryName, String parcelNum, String prodStatus, String dealType, String site,
			String thumbnailPath, String thumbnailFilename, String thumbnailLoadPath, int postViews, int postReports,
			int postLikes, int prodPrice, Date enrollDate, String blindCheck) {
		super();
		this.postNo = postNo;
		this.categoryNo = categoryNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.memNickname = memNickname;
		this.postName = postName;
		this.postContent = postContent;
		this.categoryName = categoryName;
		this.parcelNum = parcelNum;
		this.prodStatus = prodStatus;
		this.dealType = dealType;
		this.site = site;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postReports = postReports;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
		EnrollDate = enrollDate;
		this.blindCheck = blindCheck;
	}	

	public PostBoard(String categoryNo, int memNo,String memNickname,int prodPrice,String postName, String postContent,
			String prodStatus, String dealType, String site) {
		super();
		this.categoryNo = categoryNo;
		this.memNo = memNo;
		this.prodPrice = prodPrice;
		this.memNickname = memNickname;
		this.postName = postName;
		this.postContent = postContent;
		this.prodStatus = prodStatus;
		this.dealType = dealType;
		this.site = site;
	}		

	public PostBoard(int postNo, String categoryNo, String postName, String postContent, int prodPrice) {
		super();
		this.postNo = postNo;
		this.categoryNo = categoryNo;
		this.postName = postName;
		this.postContent = postContent;
		this.prodPrice = prodPrice;
	}
	
	public PostBoard(int currentPage, int listCount, int boardLimit, int pageLimit, int maxPage, int startPage,
			int endPage, int postNo, String categoryNo, int memNo, String localNo, String memNickname, String postName,
			String postContent, String categoryName, String parcelNum, String prodStatus, String dealType, String site,
			String thumbnailPath, String thumbnailFilename, String thumbnailLoadPath, int postViews, int postReports,
			int postLikes, int prodPrice, Date enrollDate, String blindCheck, String postRefund) {
		super(currentPage, listCount, boardLimit, pageLimit, maxPage, startPage, endPage);
		
		this.postNo = postNo;
		this.categoryNo = categoryNo;
		this.memNo = memNo;
		this.localNo = localNo;
		this.memNickname = memNickname;
		this.postName = postName;
		this.postContent = postContent;
		this.categoryName = categoryName;
		this.parcelNum = parcelNum;
		this.prodStatus = prodStatus;
		this.dealType = dealType;
		this.site = site;
		this.thumbnailPath = thumbnailPath;
		this.thumbnailFilename = thumbnailFilename;
		this.thumbnailLoadPath = thumbnailLoadPath;
		this.postViews = postViews;
		this.postReports = postReports;
		this.postLikes = postLikes;
		this.prodPrice = prodPrice;
		EnrollDate = enrollDate;
		this.blindCheck = blindCheck;
		this.postRefund = postRefund;
	}
	
	

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getLocalNo() {
		return localNo;
	}

	public void setLocalNo(String localNo) {
		this.localNo = localNo;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParcelNum() {
		return parcelNum;
	}

	public void setParcelNum(String parcelNum) {
		this.parcelNum = parcelNum;
	}

	public String getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getThumbnailFilename() {
		return thumbnailFilename;
	}

	public void setThumbnailFilename(String thumbnailFilename) {
		this.thumbnailFilename = thumbnailFilename;
	}

	public String getThumbnailLoadPath() {
		return thumbnailLoadPath;
	}

	public void setThumbnailLoadPath(String thumbnailLoadPath) {
		this.thumbnailLoadPath = thumbnailLoadPath;
	}

	public int getPostViews() {
		return postViews;
	}

	public void setPostViews(int postViews) {
		this.postViews = postViews;
	}

	public int getPostReports() {
		return postReports;
	}

	public void setPostReports(int postReports) {
		this.postReports = postReports;
	}

	public int getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(int postLikes) {
		this.postLikes = postLikes;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Date getEnrollDate() {
		return EnrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		EnrollDate = enrollDate;
	}

	public String getBlindCheck() {
		return blindCheck;
	}

	public void setBlindCheck(String blindCheck) {
		this.blindCheck = blindCheck;
		
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public String getPostRefund() {
		return postRefund;
	}

	public void setPostRefund(String postRefund) {
		this.postRefund = postRefund;
	}
	
	
	
	

	@Override
	public String toString() {
		return "PostBoard [postNo=" + postNo + ", categoryNo=" + categoryNo + ", memNo=" + memNo + ", localNo="
				+ localNo + ", memNickname=" + memNickname + ", postName=" + postName + ", postContent=" + postContent
				+ ", categoryName=" + categoryName + ", parcelNum=" + parcelNum + ", prodStatus=" + prodStatus
				+ ", dealType=" + dealType + ", site=" + site + ", thumbnailPath=" + thumbnailPath
				+ ", thumbnailFilename=" + thumbnailFilename + ", thumbnailLoadPath=" + thumbnailLoadPath
				+ ", postViews=" + postViews + ", postReports=" + postReports + ", postLikes=" + postLikes
				+ ", prodPrice=" + prodPrice + ", EnrollDate=" + EnrollDate + ", blindCheck=" + blindCheck
				+ ", postRefund=" + postRefund + "]";
	}

	
}


