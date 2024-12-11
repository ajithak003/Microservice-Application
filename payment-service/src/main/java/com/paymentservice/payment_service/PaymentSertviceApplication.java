package com.paymentservice.payment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentSertviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSertviceApplication.class, args);
	}

}
