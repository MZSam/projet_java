package com.hemebiotech.analytics;



import java.util.ArrayList;

public class AnalyticsCounter {
	
	

	public static void main(String args[]) throws Exception {
		// first get input
		
	ArrayList<String> results = Symptom.countResults("Project02Eclipse/symptoms.txt");
	WriteSymtomDataToFile symptomsWriter = new WriteSymtomDataToFile("result.out");
	symptomsWriter.writeResult(results);	
	
	
		
	}
}
