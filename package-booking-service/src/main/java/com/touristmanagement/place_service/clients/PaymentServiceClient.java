package com.touristmanagement.place_service.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.touristmanagement.place_service.placedto.PaymentResponse;


@FeignClient(name = "payment-service")
public interface PaymentServiceClient {
	
	@GetMapping("/api/payment/getallpayments")
	public List<PaymentResponse> getAllPayments(@RequestParam List<Long> packageBookingIds);

}
