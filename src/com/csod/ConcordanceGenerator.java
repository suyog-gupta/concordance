package com.csod;
import com.csod.WordExtraction;
public class ConcordanceGenerator {

	public static void main(String[] args) {
		// Perform word extraction and display, by providing input string here.
		
		WordExtraction wordEx = new WordExtraction("Twinkle twinkle little star. How I twinkle what you are. Mary Had a little lamb");
		wordEx.displayConcordanceMap();
	}

}
