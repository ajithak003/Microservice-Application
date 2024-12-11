package com.touristmanagement.place_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.touristmanagement.place_service.placedto.BookingPackageRequest;
import com.touristmanagement.place_service.placedto.BookingPackageResponse;
import com.touristmanagement.place_service.services.BookingPackageService;

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
	public List<BookingPackageResponse> getAllBookings(){
		
		return bookingPackageService.getAllBookings();
	}
	
}
