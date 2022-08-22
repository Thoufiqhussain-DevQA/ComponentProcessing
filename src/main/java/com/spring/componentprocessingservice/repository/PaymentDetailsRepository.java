package com.spring.componentprocessingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.componentprocessingservice.entity.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, String> {

}
