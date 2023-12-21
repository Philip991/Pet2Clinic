package org.springframework.samples.petclinic.geneticAlgorithm;//package org.springframework.samples.petclinic.geneticAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneticAlgorithmDemo {



	public static void main(String[] args) {
		// Load dataset from CSV
		String csvFile = "/Users/philipoma/Downloads/data.csv"; // Replace with your actual file path as this is mine
		Dataset dataset = loadDataset(csvFile);

		// Initialize population
		Population population = new Population(dataset.getNumFeatures(), 10);

		int generationCount = 0;
		while (generationCount < 60) {
			generationCount++;

			// Do selection, crossover, mutation, and update population
			population.selection();
			population.crossover();
			population.mutation();
			population.updatePopulation();

			// Calculate fitness for each individual in the population
			population.calculateFitness(dataset);

			System.out.println("Generation: " + generationCount +
				" Fittest: " + population.getFittest().fitness);
		}

		System.out.println("\nSolution found in generation " + generationCount);
		System.out.println("Fitness: " + population.getFittest().fitness);
//		System.out.print("Genes: 6");
		for (int gene : population.getFittest().genes) {
			System.out.print(gene);
			System.out.print("Genes: "+ gene);
		}

	}

	// Load dataset from CSV
	private static Dataset loadDataset(String csvFile) {
		Dataset dataset = new Dataset();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				int[] features = new int[values.length - 1]; // Assuming the last column is the target

				for (int i = 0; i < features.length; i++) {
					try {
						features[i] = Integer.parseInt(values[i]);
					} catch (NumberFormatException e) {
						// Handle non-integer values gracefully, e.g., set a default value or skip the column
						features[i] = defaultValueForNonInteger();
					}
				}

				try {
					int target = Integer.parseInt(values[values.length - 1]);
					dataset.addSample(features, target);
				} catch (NumberFormatException e) {
					// Handle non-integer target value gracefully, e.g., set a default value or skip the sample
					System.out.println("Skipping sample with non-integer target value: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataset;
	}

	private static int defaultValueForNonInteger() {
		// Set a default value for non-integer features
		return 0; // Adjust this to your specific requirements
	}
}

