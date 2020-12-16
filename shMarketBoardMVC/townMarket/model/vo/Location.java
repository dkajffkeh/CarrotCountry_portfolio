package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

public class Location {

	private int local_no;
	private String local_si;
	private String local_gu;
	private String local_dong;

	
	public Location() {
		
	}

	public Location(int local_no, String local_si, String local_gu, String local_dong) {
		super();
		this.local_no = local_no;
		this.local_si = local_si;
		this.local_gu = local_gu;
		this.local_dong = local_dong;
	}


	public Location(String local_si, String local_gu, String local_dong) {
		super();
		
		this.local_si = local_si;
		this.local_gu = local_gu;
		this.local_dong = local_dong;
	}

	public int getLocal_no() {
		return local_no;
	}


	public void setLocal_no(int local_no) {
		this.local_no = local_no;
	}


	public String getLocal_si() {
		return local_si;
	}


	public void setLocal_si(String local_si) {
		this.local_si = local_si;
	}


	public String getLocal_gu() {
		return local_gu;
	}


	public void setLocal_gu(String local_gu) {
		this.local_gu = local_gu;
	}


	public String getLocal_dong() {
		return local_dong;
	}


	public void setLocal_dong(String local_dong) {
		this.local_dong = local_dong;
	}

	@Override
	public String toString() {
		return "Location [local_no=" + local_no + ", local_si=" + local_si + ", local_gu=" + local_gu + ", local_dong="
				+ local_dong + "]";
	}
	
	
}
