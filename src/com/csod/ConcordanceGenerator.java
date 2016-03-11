package com.csod;
import com.csod.WordExtraction;
public class ConcordanceGenerator {

	public static void main(String[] args) {
		WordExtraction wordEx = new WordExtraction("Twinkle twinkle little star. How I twinkle what you are. Mary Had a little lamb");
		wordEx.displayConcordanceMap();
	}

}
