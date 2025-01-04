package com.touristmanagement.place_service.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.touristmanagement.place_service.exception.CustomServiceException;
import com.touristmanagement.place_service.placedto.BookingPackageRequest;
import com.touristmanagement.place_service.placedto.BookingPackageResponse;
import com.touristmanagement.place_service.services.BookingPackageService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api/book")
public class TouristPlaceBookingController {
	
	private final BookingPackageService bookingPackageService;
	
	@Autowired
	public TouristPlaceBookingController(BookingPackageService bookingPackageService){
		this.bookingPackageService = bookingPackageService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String bookPackage(@RequestBody BookingPackageRequest bookingPackageRequest) {
		
		bookingPackageService.bookPackage(bookingPackageRequest);
		
		return "Your Package Successfully created proceed payment to confirm your booking";
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@CircuitBreaker(name = "payment", fallbackMethod = "fallbackMethod")
	@TimeLimiter(name = "payment")
	@Retry(name = "payment")
	public CompletableFuture<List<BookingPackageResponse>> getAllBookings(){
		
		return CompletableFuture.supplyAsync(()-> bookingPackageService.getAllBookings()) ;
	}
	
	public  CompletableFuture<List<BookingPackageResponse>> fallbackMethod(RuntimeException runtimeException){
		
		return CompletableFuture.supplyAsync(() -> {
		throw new CustomServiceException("Oops! Server too busy try again later", HttpStatus.SERVICE_UNAVAILABLE);
		});
		
	}
	
}
