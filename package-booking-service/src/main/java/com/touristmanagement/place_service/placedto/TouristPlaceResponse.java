package com.touristmanagement.place_service.placedto;

import java.math.BigDecimal;

public class TouristPlaceResponse {
	
	private String packageName;
	private BigDecimal packagePrice;
	private String season;
	private String status;
	private long packageId;
	
	public TouristPlaceResponse(String packageName, BigDecimal packagePrice, String season, String status, long packageId) {
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.season = season;
		this.status = status;
		this.packageId = packageId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}
	
	

}
