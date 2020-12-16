package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

public class ReportReason {

	private int reportReasonNo;
	private String reportReason;
	
	public ReportReason() {
		
	}	
	
	public ReportReason(int reportReasonNo, String reportReason) {
		super();
		this.reportReasonNo = reportReasonNo;
		this.reportReason = reportReason;
	}

	public ReportReason(String reportReason) {
		super();
		this.reportReason = reportReason;
	}

	public int getReportReasonNo() {
		return reportReasonNo;
	}

	public void setReportReasonNo(int reportReasonNo) {
		this.reportReasonNo = reportReasonNo;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	@Override
	public String toString() {
		return "ReportReason [reportReasonNo=" + reportReasonNo + ", reportReason=" + reportReason + "]";
	}
	

}
