package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.util.function.Function;
import java.util.stream.Collectors;


public class Symptom {
/**
 * this class is used to help in counting the symptoms 
  * it contains also the function countResults this function pass through the file and it gets
 * the symptoms to be counted one by one then it sort the final result by alphabetical order
 */

public static  Map<String, Long> countResults(String path) {
	
		List<String> symptoms = new ArrayList<String>();
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(path);
		symptoms = symptomReader.GetSymptoms();
		Map<String, Long> frequencyMap = symptoms.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		
		return frequencyMap;
	}
}


