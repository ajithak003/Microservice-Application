package com.touristmanagement.place_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touristmanagement.place_service.models.TouristPlace;
import com.touristmanagement.place_service.placedto.TouristPlaceRequest;
import com.touristmanagement.place_service.placedto.TouristPlaceResponse;
import com.touristmanagement.place_service.repository.TouristPlaceDAO;


@Service
public class TouristPlaceService {
	
	TouristPlaceDAO touristPlaceDAO;
	
	@Autowired
	public TouristPlaceService(TouristPlaceDAO touristPlaceDAO) {
		this.touristPlaceDAO = touristPlaceDAO;
	}

	public void createTourPlace(TouristPlaceRequest TouristPlace) {
		
		TouristPlace place = new TouristPlace();
		place.setPackageName(TouristPlace.getPackageName());
		place.setPackagePrice(TouristPlace.getPackagePrice());
		place.setSeason(TouristPlace.getSeason());
		
		touristPlaceDAO.save(place);
		
	}

	public List<TouristPlaceResponse> getAllTourplaces() {
		
		List<TouristPlace> places = touristPlaceDAO.findAll();
		
		List<TouristPlaceResponse> responsePlaces = places.stream()
				.map(place -> mapToTouristPlaceResponse(place)).toList();
		
		return responsePlaces;
	}

	private TouristPlaceResponse mapToTouristPlaceResponse(TouristPlace place) {
		
		TouristPlaceResponse responsePlace = new TouristPlaceResponse(place.getPackageName(),place.getPackagePrice(),
				place.getSeason(),place.getStatus(), place.getId());
				
		return responsePlace;
	}
	
	

}
