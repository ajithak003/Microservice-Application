package com.paymentservice.payment_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.payment_service.dao.PaymentDAO;
import com.paymentservice.payment_service.models.PaymentModel;
import com.paymentservice.payment_service.paymentdto.PaymentRequest;
import com.paymentservice.payment_service.paymentdto.PaymentResponse;

@Service
public class PaymentService {
	
	PaymentDAO paymentDAO;
	
	@Autowired
	public PaymentService(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public void createPayment(PaymentRequest paymentRquest) {
		
		PaymentModel payment = mapToPaymentModel(paymentRquest);
		paymentDAO.save(payment);
		
	}
	
	public List<PaymentResponse> getAllPayments(List<Long> packageBookingIds) {
		
		List<PaymentModel> payments = paymentDAO.findByPaymentBookingId(packageBookingIds);
		
		List<PaymentResponse> PaymentResponses = payments.stream().map(payment -> mapToPaymentResponse(payment)).toList();
		return PaymentResponses;
	}

	private PaymentModel mapToPaymentModel(PaymentRequest paymentRquest) {
		
		PaymentModel payment = new PaymentModel();
		payment.setAmount(paymentRquest.getAmount());
		payment.setPaymentType(paymentRquest.getPaymentType());
		payment.setPaymentBookingId(paymentRquest.getPaymentBookingId());
		
		return payment;
	}
	
	private PaymentResponse mapToPaymentResponse(PaymentModel payment) {
		
		PaymentResponse paymentResponse = new PaymentResponse();
		
		paymentResponse.setAmount(payment.getAmount());
		paymentResponse.setPaymentBookingId(payment.getPaymentBookingId());
		paymentResponse.setPaymentDateTime(payment.getPaymentDateTime());
		paymentResponse.setPaymentId(payment.getPaymentId());
		paymentResponse.setPaymentType(payment.getPaymentType());
		paymentResponse.setStatus(payment.getStatus());
		
		return paymentResponse;
	}

	

}
