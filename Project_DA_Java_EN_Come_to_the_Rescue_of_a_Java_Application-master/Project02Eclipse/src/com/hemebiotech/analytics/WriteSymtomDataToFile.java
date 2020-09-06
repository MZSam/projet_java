package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymtomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymtomDataToFile(String filepath) {
		this.filepath =filepath;
		
	}
	
	
	public void writeResult(List<String> results) {
		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter (filepath);
				
				int i = 1;
				int resultsSize = results.size();
				
				for (String result: results)
				{
					if (i < resultsSize)
					{
						writer.write(result  + "\n");
						System.out.println("je suis l�" + resultsSize +" " + i);
					}
					else
					{
						writer.write(result);
						System.out.println("je suis l�" + resultsSize +" " + i);
					}
					
					i++;
				}
				
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
