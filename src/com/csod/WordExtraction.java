package com.csod;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.csod.Word;

public class WordExtraction {
	
	// TreeMap will hold key value pairs for words in input string. Key is word from input string, while value is an object of type Word
	TreeMap<String, Word> ConcordanceWordMap = new TreeMap<String, Word>();
	
	String inputString;
	
	public String[] InputStringSentences;

	// Parameterized Constructor. Takes string as parameter
	public WordExtraction(String InputStr){
		this.inputString = InputStr;
	}
	
	// Method that returns, number of sentences in input string
	public int getNumberofSentences(){
		
		if(inputString.length()>1){
			String[] InputStringSentences = inputString.split("\\.");
		return InputStringSentences.length;
		}
		else
		return 0;
	}
	
	// Method that returns a particular sentence, from input string
	public String getSentenceBySentenceNumber(int sentenceNumber){
		String sentence = "";
		try{
		InputStringSentences = inputString.split("\\.");
		sentence = InputStringSentences[sentenceNumber].toLowerCase().toString();
		}
		catch(Exception e){
			System.out.println("Exception occurred while fetching sentence " + sentenceNumber);
			System.out.println("Sentence you attempted to retrieve might not be present.");
			e.printStackTrace();
		}
		return sentence;
     }
	
	// Method that returns an array of words, that a sentence is made up of
	public String[] getWordsFromSentence(String sentence){
		String[] listOfWords = sentence.split("\\s");
		return listOfWords;
	}
	
	// Method that builds concordance for a given sentence.
	// Each word in the sentence, is added to the TreeMap. If word already exists in TreeMap, it's occurrence and frequency attributes are updated.
	
	public void buildConcordanceForSentence(Integer sentNumber){
		String[] wordList = getWordsFromSentence(getSentenceBySentenceNumber(sentNumber));
		
		
		for(int i=0; i< wordList.length; i++){
			
			ArrayList<Integer> arrListWordOccurence = new ArrayList<Integer>();
			
			// If word exists, increment frequency and occurrence ArrayList
			if(wordExistsInConcordance(wordList[i])){
								
				Word wordObj = ConcordanceWordMap.get(wordList[i]);
				wordObj.wordFrequency++;
				
				// If a word repeats within a sentence, skip updating occurrence
				 if(!wordObj.sentenceNumber.contains(sentNumber))
					 wordObj.sentenceNumber.add(sentNumber);
			}
			
			else{
				// If word is new, set sentence number to which it was first seen, and set frequency to 1
				arrListWordOccurence.add(sentNumber);
				ConcordanceWordMap.put(wordList[i], new Word(wordList[i],arrListWordOccurence,1));
			}
		}
		
	}
	
	// Method used to determine, whether to perform an insert or update into TreeMap 
	public boolean wordExistsInConcordance(String extractedWord){
		if(ConcordanceWordMap.containsKey(extractedWord))
			return true;
		else
			return false;
	}
	
	// Method that builds concordance map for all sentences found in input string
	// and, displays the Concordance onto the console
	public void displayConcordanceMap(){
		int numberOfSentences = getNumberofSentences();
		for(Integer i=0; i<numberOfSentences; i++){
			buildConcordanceForSentence(i);
		}
		
		if(ConcordanceWordMap.size()>0)
		{
			System.out.println(" Word  | Occurs in setences | Frequency	");
			for(Entry<String, Word> entry : ConcordanceWordMap.entrySet()){
				Word wordObject = entry.getValue();
				System.out.println(" " + entry.getKey() + " | " + wordObject.sentenceNumber.toString() + " | " + wordObject.wordFrequency);
			}
		}
	}
	

}
