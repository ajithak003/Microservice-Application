package com.paymentservice.payment_service.paymentdto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentResponse {

	private long paymentBookingId;
	private String paymentType;
	private double amount;
	private long paymentId;
	private String paymentDateTime;
	private String status;
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
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDateTime() {
		return paymentDateTime;
	}
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = paymentDateTime.format(formatter);
		this.paymentDateTime = formattedDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
