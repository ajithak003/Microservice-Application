package com.touristmanagement.place_service.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_package_2916")
public class TouristPlaceBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PACKAGE_BOOKING_ID")
	private long packageBookingId;
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "NO_OF_PERSON")
	private int noOfPerson;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "PACKAGE_ID", referencedColumnName = "PACKAGE_ID")
	private TouristPlace touristPlace;

	
	@PrePersist
	public void prePersist() {
		if(status == null)
			this.status = "SUCCESS";
	}
	
	public long getPackageBookingId() {
		return packageBookingId;
	}
	public void setPackageBookingId(long packageBookingId) {
		this.packageBookingId = packageBookingId;
	}
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
	public TouristPlace getTouristPlace() {
		return touristPlace;
	}
	public void setTouristPlace(TouristPlace touristPlace) {
		this.touristPlace = touristPlace;
	}
	

}
