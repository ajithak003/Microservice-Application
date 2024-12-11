package com.touristmanagement.place_service.placedto;

import java.time.LocalDate;

public class BookingPackageRequest {

	private long userId;
	private long packageId;
	private int noOfPerson;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPackageNme() {
		return packageId;
	}
	public void setPackageNme(long packageId) {
		this.packageId = packageId;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public long getPackageId() {
		return packageId;
	}
	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}
	
}
