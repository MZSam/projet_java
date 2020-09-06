package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Symptom {
public 	String symptom;
public boolean checked = false;

public Symptom(String symptom) {
	this.symptom = symptom;
	this.checked = false;
}

public static int findElement(String symptom,List<Symptom> symptoms) {
	
	int countSymptom = 0;
	
	for (Iterator<Symptom> iterator = symptoms.iterator(); iterator.hasNext();) 
	{
        Symptom value = iterator.next();
        if(value.symptom.equals(symptom))
        {
        	value.checked = true;
             countSymptom ++;
        }
      }
	return countSymptom;
}


public static ArrayList<String> countResults(String path) {
	
	List<Symptom> symptoms = new ArrayList<Symptom>();
	ISymptomReader symptomReader = new ReadSymptomDataFromFile(path);
	symptoms = symptomReader.GetSymptoms();
	
	ArrayList<String> results = new ArrayList<String>();
	
	Iterator<Symptom> ite = symptoms.iterator();
	while(ite.hasNext())
	{
		Symptom currentSymptom = ite.next();
		
		if (!currentSymptom.checked)
		{
		int symptomCount = Symptom.findElement(currentSymptom.symptom, symptoms);
		results.add(currentSymptom.symptom + ": " + symptomCount);
		}
		
		
	}
	
	
	Collections.sort(results);
	return results;
}
}


