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

import com.touristmanagement.place_service.placedto.TouristPlaceRequest;
import com.touristmanagement.place_service.placedto.TouristPlaceResponse;
import com.touristmanagement.place_service.services.TouristPlaceService;

@RestController
@RequestMapping("/api/place")
public class TouristPlaceController {
	
	private final TouristPlaceService touristPlaceService;
	
	@Autowired
	public TouristPlaceController(TouristPlaceService touristPlaceService) {
		this.touristPlaceService = touristPlaceService;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createTourPlace(@RequestBody TouristPlaceRequest placeRequest) {
		
		touristPlaceService.createTourPlace(placeRequest);
		
		return "Successfully Tourist Place Added";
	}
	
	@GetMapping()
	public List<TouristPlaceResponse> getAllTourplaces(){
		
		List<TouristPlaceResponse> responsePlaces = touristPlaceService.getAllTourplaces();
		
		return responsePlaces;
	}

}
