package com.hemebiotech.analytics;

import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	
	public static int findElement(String symptom,List<Symptom> symptoms) {
		
		int countSymptom = 0;
		
		for (Iterator<Symptom> iterator = symptoms.iterator(); iterator.hasNext();) 
		/*Iterator<String> ite = symptoms.iterator();
		while(ite.hasNext()) {*/
		{
            Symptom value = iterator.next();
            if(value.symptom.equals(symptom))
            {
            	value.checked = true;
                 countSymptom ++;
            }
          }
		
		
		/*for(int i = 0; i < symptoms.size();i++){
		    if(symptoms.get(i).equals(symptom)){
		    	symptoms.removeIf(symptom::equals);
		    }
		}*/
		
	  /* for (String currentSymptom : symptoms )
	   {
		   if (currentSymptom == symptom)
			{
			   //symptoms.remove(currentSymptom);
				countSymptom ++;
			}
		   
	   }*/
		/*	*/
		
	
		return countSymptom;
	}
	
	public static void main(String args[]) throws Exception {
		// first get input
		
// Majd
		List<Symptom> symptoms = new ArrayList<Symptom>();
		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		symptoms = symptomReader.GetSymptoms();
		
		ArrayList<String> results = new ArrayList<String>();
		
		Iterator<Symptom> ite = symptoms.iterator();
		while(ite.hasNext())
		{
			Symptom currentSymptom = ite.next();
			
			if (!currentSymptom.checked)
			{
			int symptomCount = findElement(currentSymptom.symptom, symptoms);
			
			System.out.println(" this is    "+ currentSymptom + " " + symptomCount);
			results.add(currentSymptom.symptom + ": " + symptomCount);
			}
			
			
		}
		
	/*	for(String currentSymptom : symptoms) {
			if (symptoms.size() == 0)
				break;
		
		}
		*/
		/*while(! symptoms.isEmpty())
		{
			
			
		//results.add(currentSymptom + " : " + symptomCount);
		}*/
		
		System.out.println("list symptoms = " + symptoms.get(0));
		
/*		int symptomCount = 0;
		String symptom;
		int i =0
		while (i < symptoms.size())
		{
			for (symptom:symptoms)
				if
			
		}
		
	*/	
		
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
//		int headacheCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		
		
		System.out.println(results.size());
		
	WriteSymtomDataToFile symptomsWriter = new WriteSymtomDataToFile("result.out");
	symptomsWriter.writeResult(results);	
		
/*		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
