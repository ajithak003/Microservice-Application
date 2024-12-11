package com.touristmanagement.place_service.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touristmanagement.place_service.clients.PaymentServiceClient;
import com.touristmanagement.place_service.models.TouristPlace;
import com.touristmanagement.place_service.models.TouristPlaceBooking;
import com.touristmanagement.place_service.placedto.BookingPackageRequest;
import com.touristmanagement.place_service.placedto.BookingPackageResponse;
import com.touristmanagement.place_service.placedto.PaymentResponse;
import com.touristmanagement.place_service.placedto.TouristPlaceResponse;
import com.touristmanagement.place_service.repository.BookingPackageDAO;
import com.touristmanagement.place_service.repository.TouristPlaceDAO;

@Service
public class BookingPackageService {
	
	private final BookingPackageDAO bookingPackageDAO;
	private final TouristPlaceDAO touristPlaceDAO;
	private final PaymentServiceClient paymentServiceClient;

	
	@Autowired
	public BookingPackageService(BookingPackageDAO bookingPackageDAO, TouristPlaceDAO touristPlaceDAO, PaymentServiceClient paymentServiceClient) {
		this.bookingPackageDAO = bookingPackageDAO;
		this.touristPlaceDAO = touristPlaceDAO;
		this.paymentServiceClient = paymentServiceClient;
	}

	public void bookPackage(BookingPackageRequest bookingPackageRequest) {

		TouristPlace place = touristPlaceDAO.findById(bookingPackageRequest.getPackageId())
				.orElseThrow(() -> new RuntimeException("Touris Place Not Exist"));
		
		TouristPlaceBooking touristPlaceBooking = new TouristPlaceBooking();
		
		touristPlaceBooking.setEndDate(bookingPackageRequest.getEndDate());
		touristPlaceBooking.setNoOfPerson(bookingPackageRequest.getNoOfPerson());
		touristPlaceBooking.setStartDate(bookingPackageRequest.getStartDate());
		touristPlaceBooking.setUserId(bookingPackageRequest.getUserId());
		touristPlaceBooking.setTouristPlace(place);
		
		bookingPackageDAO.save(touristPlaceBooking);
		
	}

	public List<BookingPackageResponse> getAllBookings() {
		
		
		List<TouristPlaceBooking> touristPlaceBookings = bookingPackageDAO.findAll();
		
		
		List<Long> packageBookingIds = touristPlaceBookings.stream()
				.map(TouristPlaceBooking::getPackageBookingId)
				.toList();
	
		List<PaymentResponse> paymentResponses = paymentServiceClient.getAllPayments(packageBookingIds);
		Map<Long, PaymentResponse> paymentResponseMap = paymentResponses.stream()
				.collect(Collectors.toMap(PaymentResponse::getPaymentBookingId, response -> response));
		
		List<BookingPackageResponse> bookingPackageResponses = touristPlaceBookings.stream()
				.map(touristPlaceBooking -> 
				mapToBookingPackageResponse(touristPlaceBooking,paymentResponseMap.get(touristPlaceBooking.getPackageBookingId())))
				.collect(Collectors.toList());
		
		return bookingPackageResponses;
	}

	private BookingPackageResponse mapToBookingPackageResponse(TouristPlaceBooking touristPlaceBooking,PaymentResponse paymentResponse) {
		BookingPackageResponse bookingPackageResponse = new BookingPackageResponse();
		bookingPackageResponse.setEndDate(touristPlaceBooking.getEndDate());
		bookingPackageResponse.setNoOfPerson(touristPlaceBooking.getNoOfPerson());
		bookingPackageResponse.setStartDate(touristPlaceBooking.getStartDate());
		bookingPackageResponse.setUserId(touristPlaceBooking.getUserId());
		bookingPackageResponse.setStatus(touristPlaceBooking.getStatus());
		
		TouristPlaceResponse touristPlaceResponse = new TouristPlaceResponse(
				touristPlaceBooking.getTouristPlace().getPackageName(),
				touristPlaceBooking.getTouristPlace().getPackagePrice(),
				touristPlaceBooking.getTouristPlace().getSeason(),
				touristPlaceBooking.getTouristPlace().getStatus(),
				touristPlaceBooking.getTouristPlace().getId()
				);
		bookingPackageResponse.setTouristPlaceresponse(touristPlaceResponse);
		bookingPackageResponse.setPaymentReponse(paymentResponse);

		return bookingPackageResponse;
	}
	

}
