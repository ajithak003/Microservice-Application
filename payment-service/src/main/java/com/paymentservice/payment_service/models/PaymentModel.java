/**
 * 
 */
package com.paymentservice.payment_service.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_booking_2916")
public class PaymentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID")
	private long paymentId;
	@Column(name = "PACKAGE_BOOKING_ID")
	private long paymentBookingId;
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	@Column(name = "AMOUNT")
	private double amount;
	@Column(name = "PAYMENT_DATE",updatable = false)
	private LocalDateTime paymentDateTime;
	@Column(name = "STATUS")
	private String status;
	
	
	@PrePersist
	public void prePersist() {
		this.paymentDateTime = LocalDateTime.now();
		if(this.status == null) {
			this.status = "SUCCESS";
		}
	}
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public long getPaymentBookingId() {
		return paymentBookingId;
	}
	public void setPaymentBookingId(long paymentBookingId) {
		this.paymentBookingId = paymentBookingId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
