package com.touristmanagement.place_service.placedto;

import java.math.BigDecimal;

public class TouristPlaceRequest {

	private String packageName;
	private BigDecimal packagePrice;
	private String season;
	
	public TouristPlaceRequest(String packageName, BigDecimal packagePrice, String season) {
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.season = season;
	}
	
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public BigDecimal getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(BigDecimal packagePrice) {
		this.packagePrice = packagePrice;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	
	
	
	
	
}
