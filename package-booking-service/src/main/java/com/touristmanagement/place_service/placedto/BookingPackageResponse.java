package com.touristmanagement.place_service.placedto;

import java.time.LocalDate;


public class BookingPackageResponse {

	private long userId;
	private int noOfPerson;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private TouristPlaceResponse touristPlaceresponse;
	private PaymentResponse paymentReponse;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TouristPlaceResponse getTouristPlaceresponse() {
		return touristPlaceresponse;
	}
	public void setTouristPlaceresponse(TouristPlaceResponse touristPlaceresponse) {
		this.touristPlaceresponse = touristPlaceresponse;
	}
	public PaymentResponse getPaymentReponse() {
		return paymentReponse;
	}
	public void setPaymentReponse(PaymentResponse paymentReponse) {
		this.paymentReponse = paymentReponse;
	}
	
	
}
