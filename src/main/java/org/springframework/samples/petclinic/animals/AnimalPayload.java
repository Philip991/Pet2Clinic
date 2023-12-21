package org.springframework.samples.petclinic.animals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalPayload {
	public String name;
	public Taxonomy taxonomy;
	public ArrayList<String> locations;
	public Characteristics characteristics;

	public class Taxonomy{
		public String kingdom;
		public String phylum;
		@JsonProperty("class")
		public String myclass;
		public String order;
		public String family;
		public String genus;
		public String scientific_name;
	}

	public class Characteristics{
		public String prey;
		public String name_of_young;
		public String group_behavior;
		public String estimated_population_size;
		public String biggest_threat;
		public String most_distinctive_feature;
		public String gestation_period;
		public String habitat;
		public String diet;
		public String average_litter_size;
		public String lifestyle;
		public String common_name;
		public String number_of_species;
		public String location;
		public String slogan;
		public String group;
		public String color;
		public String skin_type;
		public String top_speed;
		public String lifespan;
		public String weight;
		public String height;
		public String age_of_sexual_maturity;
		public String age_of_weaning;
	}
}
