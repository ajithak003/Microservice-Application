package com.paymentservice.payment_service.paymentdto;


public class PaymentRequest {
	
	private long paymentBookingId;
	private String paymentType;
	private double amount;
	
	
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
	
	

}
