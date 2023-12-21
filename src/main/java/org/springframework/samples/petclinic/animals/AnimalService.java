package org.springframework.samples.petclinic.animals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AnimalService {


	public String getAnimalDetails(String animal){

		try{
			URL url = new URL("https://api.api-ninjas.com/v1/animals?name="+animal);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			connection.setRequestProperty("X-Api-Key", "a8SRpyvtP/W5wFIVpr7oGA==r6KMNbkejBVpDHfd");

			InputStream responseStream = connection.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(responseStream);
			if (root.has("fact")) {
				// Return the animal fact as a String
				return root.path("fact").asText();
			} else {
				// Handle the case where "fact" field is missing
				return "Animal fact not available";
			}
		}catch (Exception e){
			throw new RuntimeException(e);
//			return e.getMessage();
		}


    }

	public static void main(String[] args) {
		AnimalService animalService = new AnimalService();
        String animalFact = animalService.getAnimalDetails("Cheetah");
		System.out.println("Animal fact== "+animalFact);
        return;


	}
}


