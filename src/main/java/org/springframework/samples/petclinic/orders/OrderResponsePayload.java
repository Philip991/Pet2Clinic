package org.springframework.samples.petclinic.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponsePayload {
	public String responseMessage;
	public String responseCode;
}
