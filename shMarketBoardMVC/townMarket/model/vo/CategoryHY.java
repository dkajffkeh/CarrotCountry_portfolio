package com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo;

public class CategoryHY {

	private int categoryNo;
	private String categoryName;
	private String categotyNo;
	
	
	public CategoryHY() {
		
	}

	public CategoryHY(int categoryNo, String categoryName) {
		
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	public CategoryHY(String categoryName) {
		
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	

	public String getCategotyNo() {
		return categotyNo;
	}

	public void setCategotyNo(String categotyNo) {
		this.categotyNo = categotyNo;
	}

	@Override
	public String toString() {
		return "CategoryHY [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
}
