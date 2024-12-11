package com.touristmanagement.place_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.touristmanagement.place_service.models.TouristPlace;

@Repository
public interface TouristPlaceDAO extends JpaRepository<TouristPlace, Long>{

}
