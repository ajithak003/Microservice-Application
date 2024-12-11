package com.paymentservice.payment_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.payment_service.paymentdto.PaymentRequest;
import com.paymentservice.payment_service.paymentdto.PaymentResponse;
import com.paymentservice.payment_service.services.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
    @PostMapping("/createpayment")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPayment(@RequestBody PaymentRequest paymentRquest) {
    	
    	paymentService.createPayment(paymentRquest);
    	return "Payment Successful !"; 
    }
	
	@GetMapping("/getallpayments")
	@ResponseStatus(HttpStatus.OK)
	public List<PaymentResponse> getAllPayments(@RequestParam List<Long> packageBookingIds){
		
		return paymentService.getAllPayments(packageBookingIds);
	}
	
	
	
}
