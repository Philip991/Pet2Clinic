package org.springframework.samples.petclinic.stripePayments.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPayload {

	@NotNull
	@Min(4)
	private Long amount;
	@Email
	private String email;
	@NotBlank
	@Size(min = 5, max = 200)
	private String productName;
}
