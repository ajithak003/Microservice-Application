package com.paymentservice.payment_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paymentservice.payment_service.models.PaymentModel;


@Repository
public interface PaymentDAO extends JpaRepository<PaymentModel, Long> {

    @Query("SELECT p FROM PaymentModel p WHERE p.paymentBookingId IN :packageBookingIds")
	List<PaymentModel> findByPaymentBookingId(List<Long> packageBookingIds);

}
