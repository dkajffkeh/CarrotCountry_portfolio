package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

import java.sql.Date;

public class CommentHY {

	private int commentNo;
	private String userNickName;
	private Date enrollDate;
	private String Content;
	private String secretCheck;
	private int postNo;
	private int memNo;
	private String memberNickName;
	
	
	public CommentHY() {

	}
	public CommentHY(int commentNo, String userNickName, Date enrollDate, String content, String secretCheck,
			int postNo, int memNo) {
		super();
		this.commentNo = commentNo;
		this.userNickName = userNickName;
		this.enrollDate = enrollDate;
		Content = content;
		this.secretCheck = secretCheck;
		this.postNo = postNo;
		this.memNo = memNo;
	}
	
	public CommentHY(int commentNo, String userNickName, Date enrollDate, String content, String secretCheck,
			int postNo) {
		super();
		this.commentNo = commentNo;
		this.userNickName = userNickName;
		this.enrollDate = enrollDate;
		Content = content;
		this.secretCheck = secretCheck;
		this.postNo = postNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getSecretCheck() {
		return secretCheck;
	}
	public void setSecretCheck(String secretCheck) {
		this.secretCheck = secretCheck;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	@Override
	public String toString() {
		return "CommentHY [commentNo=" + commentNo + ", userNickName=" + userNickName + ", enrollDate=" + enrollDate
				+ ", Content=" + Content + ", secretCheck=" + secretCheck + ", postNo=" + postNo + ", memNo=" + memNo
				+ ", memberNickName=" + memberNickName + "]";
	}

	
}

