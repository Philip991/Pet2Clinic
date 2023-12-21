package org.springframework.samples.petclinic.stripePayments;//package org.springframework.samples.petclinic.stripePayments;
//
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.PaymentIntent;
//import com.stripe.param.PaymentIntentCreateParams;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.samples.petclinic.stripePayments.model.RequestPayload;
//import org.springframework.samples.petclinic.stripePayments.model.ResponsePayload;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class StripeController {
//
//	@Value("${stripe.api.secretKey}")
//	public String secretKey;
//
//
//	@PostMapping("/create")
//	public ResponsePayload createPayment(@RequestBody RequestPayload requestPayload) throws StripeException {
//		Stripe.apiKey = secretKey;
//
//			PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
//				.setAmount(requestPayload.getAmount() * 100L)
//				.putMetadata("productName", requestPayload.getProductName())
//				.setCurrency("usd")
//				.setAutomaticPaymentMethods(
//					PaymentIntentCreateParams
//						.AutomaticPaymentMethods
//						.builder()
//						.setEnabled(true)
//						.build()
//				).build();
//
//			PaymentIntent intent = PaymentIntent.create(params);
//
//			return new ResponsePayload(intent.getId(), intent.getClientSecret());
//
//	}
//}


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.samples.petclinic.stripePayments.model.RequestPayload;
import org.springframework.samples.petclinic.stripePayments.model.ResponsePayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeController {
	@PostMapping("/create-payment-intent")
	public ResponsePayload createPaymentIntent(@RequestBody RequestPayload request)
		throws StripeException {
		PaymentIntentCreateParams params =
			PaymentIntentCreateParams.builder()
				.setAmount(request.getAmount() * 100L)
				.putMetadata("productName",
					request.getProductName())
				.setCurrency("usd")
				.setAutomaticPaymentMethods(
					PaymentIntentCreateParams
						.AutomaticPaymentMethods
						.builder()
						.setEnabled(true)
						.build()
				)
				.build();
		PaymentIntent intent =
			PaymentIntent.create(params);
		return new ResponsePayload(intent.getId(),
			intent.getClientSecret());
	}
}
