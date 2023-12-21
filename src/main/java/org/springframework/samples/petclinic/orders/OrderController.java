package org.springframework.samples.petclinic.orders;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@PostMapping("/create")
	public String submitOrder(@RequestBody OrderRequestPayload requestPayload){
		OrderService orderService = new OrderService();
		Gson gson = new Gson();
		if(!(requestPayload==null)){

			return gson.toJson(orderService.processOrder(requestPayload));

		}
        return null;
    }

	@GetMapping("/success")
	public String SuccessPage(){
		return "orderCompletion";
	}
}
