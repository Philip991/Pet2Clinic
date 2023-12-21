package org.springframework.samples.petclinic.orders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {

	public OrderResponsePayload processOrder(OrderRequestPayload requestPayload){
		OrderResponsePayload responsePayload = new OrderResponsePayload();
		try {

			if(!requestPayload.getOrderProduct().isEmpty() && !requestPayload.getEmail().isEmpty() && !requestPayload.getAmount().isEmpty()){
				responsePayload.setResponseMessage("Order Placed Successfully");
				responsePayload.setResponseCode("00");
				log.info("Request Payload===>>>{}",requestPayload);
				return responsePayload;
			}else {
				responsePayload.setResponseMessage("Something went wrong");
				responsePayload.setResponseCode("99");
				log.info("Request Payload===>>>{}",requestPayload);
				return responsePayload;
			}

		}catch (Exception e){
			responsePayload.setResponseMessage(e.getMessage());
			return responsePayload;
		}
	}
}
