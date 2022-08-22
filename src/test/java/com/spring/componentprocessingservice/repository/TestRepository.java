package com.spring.componentprocessingservice.repository;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.componentprocessingservice.entity.OrderDetails;
import com.spring.componentprocessingservice.entity.OrderResponse;
import com.spring.componentprocessingservice.util.AccessoryReplacement;
import com.spring.componentprocessingservice.util.IntegralRepair;
import com.spring.componentprocessingservice.util.ItemService;


@SpringBootTest
class TestRepository {
	@Autowired
	OrderResponseRepository orderResponseRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	boolean x;
	
/*
 * This method is used to test whether request request details are saved or not
 */
	@Test
	void isProcessRequestSaved() {
		
		OrderDetails orderDetails = new OrderDetails("requestID123","HeyUserIamDuplicate", "815487890", "Integral", "Lappy", 5);
		orderDetails=orderDetailsRepository.save(orderDetails);
		boolean isNotnull =orderDetailsRepository.findById(orderDetails.getRequestId())!=null;
		assertThat(isNotnull).isTrue();
		orderDetailsRepository.deleteById(orderDetails.getRequestId());
	}
	/*
	 * This method is used to test whether response request details are saved or not
	 */
	@Test
	void isProcessResponseSaved() {
		String id = UUID.randomUUID().toString();
		OrderResponse orderResponse = new OrderResponse(id, 250, 380,"date_string");
		boolean isNotnull =orderResponseRepository.save(orderResponse)!=null;
		assertThat(isNotnull).isTrue();
		orderResponseRepository.deleteById(id);	
		}
	
	@Test
	void isIntegral() {
		String id = UUID.randomUUID().toString();
		OrderDetails orderDetails = new OrderDetails("requestID567","HeyAppIamTester", "815487891", "Integral", "ABC", 6);
		orderDetails=orderDetailsRepository.save(orderDetails);
		
		OrderResponse orderResponse = new OrderResponse(id, 3000, 380,"date_string");
		
		ItemService isItem = new IntegralRepair();
		
		 double expintegralDuration = isItem.getProcessingCharge()*orderDetails.getQuantity();
		 
		 double ActualintegralDuration = orderResponse.getProcessingCharge();
		
		 //int expintegralCharge =isItem.getProcessingDurationInDays();
		 
		 System.out.println("exp"+expintegralDuration);
		 
		 
		 
		 if (Double.compare(expintegralDuration, ActualintegralDuration) == 0) {
			 
	            x=true;
	        }
		 
		 assertThat(x).isTrue();
		 
		 System.out.println("Actual"+ActualintegralDuration);
		
	}
	
	@Test
	void isAccessoryItem() {
		String id = UUID.randomUUID().toString();
		
		OrderDetails orderDetails = new OrderDetails("requestID567","HeyAppIamTester", "815487891", "Accessory", "ABC", 6);
		orderDetails=orderDetailsRepository.save(orderDetails);
		OrderResponse orderResponse = new OrderResponse(id, 1800, 800,"date_string" );
		
		ItemService isItem = new AccessoryReplacement();
		
		 double expintegralDuration = isItem.getProcessingCharge()*orderDetails.getQuantity();
		 
		 double ActualintegralDuration = orderResponse.getProcessingCharge();
		
		 //int expintegralCharge =isItem.getProcessingDurationInDays();
		 
		 System.out.println("exp"+expintegralDuration);
		 
		 
		 
		 if (Double.compare(expintegralDuration, ActualintegralDuration) == 0) {
			 
	            x=true;
	        }
		 
		 assertThat(x).isTrue();
		 
		 System.out.println("Actual"+ActualintegralDuration);
		
	}
	
	
	

}