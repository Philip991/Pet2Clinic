package org.springframework.samples.petclinic.stripePayments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayload {
	private String intentID;
	private String clientSecret;
}
