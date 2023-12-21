package org.springframework.samples.petclinic.orders;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestPayload {

	@NotBlank(message = "Amount cannot be blank")
	@NotEmpty(message = "Amount cannot be empty")
	@NotNull(message = "Amount cannot be null")
	private String amount;

	@NotBlank(message = "Order Product cannot be blank")
	@NotEmpty(message = "Order Product cannot be empty")
	@NotNull(message = "Order Product cannot be null")
	private String orderProduct;

	@NotBlank(message = "Email cannot be blank")
	@NotEmpty(message = "Email cannot be empty")
	@NotNull(message = "Email cannot be null")
	private String email;
}
