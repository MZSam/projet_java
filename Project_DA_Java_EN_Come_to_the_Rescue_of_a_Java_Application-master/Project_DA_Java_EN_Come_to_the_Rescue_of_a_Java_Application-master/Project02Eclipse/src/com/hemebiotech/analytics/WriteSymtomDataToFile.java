package com.hemebiotech.analytics;

/**
 * this class help in writing the symptoms into the result file
 * it contains the a public constructor with the file path as input
 * the function writeResult help in writing the symptoms into the result file
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymtomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymtomDataToFile(String filepath) {
		this.filepath =filepath;
		
	}
	
	
	public void writeResult(HashMap<String,Long> results) {
	
		
		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter (filepath);
				Map<String, Long> sortedMap = new TreeMap<String, Long>(results);
				String lastElement =((TreeMap<String, Long>) sortedMap).lastEntry().getKey();
				
				sortedMap.forEach((key, value) -> {
					try {

						if (lastElement != key) {
							writer.write(key.toString() + ":" + value.toString() + "\n");

						} else {
							writer.write(key.toString() + ":" + value.toString());
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	

}
