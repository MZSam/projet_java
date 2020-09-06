package com.hemebiotech.analytics;

import java.util.HashMap;

/**
 * @author majd Zeidan
 * this interface helps in writing the final result into output file result.out 
 */

public interface ISymptomWriter {
	
	void writeResult(HashMap<String,Long> results);

}
