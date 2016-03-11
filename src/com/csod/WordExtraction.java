package com.csod;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.csod.Word;

public class WordExtraction {
	
	TreeMap<String, Word> ConcordanceWordMap = new TreeMap<String, Word>();
	String inputString;
	public String[] InputStringSentences;

	public WordExtraction(String InputStr){
		this.inputString = InputStr;
	}
	
	public int getNumberofSentences(){
		
		if(inputString.length()>1){
			String[] InputStringSentences = inputString.split("\\.");
		return InputStringSentences.length;
		}
		else
		return 0;
	}
	
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
	
	public String[] getWordsFromSentence(String sentence){
		String[] listOfWords = sentence.split("\\s");
		return listOfWords;
	}
	
	public void buildConcordanceForSentence(Integer sentNumber){
		String[] wordList = getWordsFromSentence(getSentenceBySentenceNumber(sentNumber));
		
		
		for(int i=0; i< wordList.length; i++){
			
			ArrayList<Integer> arrListWordOccurence = new ArrayList<Integer>();
			
			if(wordExistsInConcordance(wordList[i])){
								
				Word wordObj = ConcordanceWordMap.get(wordList[i]);
				wordObj.wordFrequency++;
				 if(!wordObj.sentenceNumber.contains(sentNumber))
					 wordObj.sentenceNumber.add(sentNumber);
			}
			
			else{
				arrListWordOccurence.add(sentNumber);
				ConcordanceWordMap.put(wordList[i], new Word(wordList[i],arrListWordOccurence,1));
			}
		}
		
	}
	
	public boolean wordExistsInConcordance(String extractedWord){
		if(ConcordanceWordMap.containsKey(extractedWord))
			return true;
		else
			return false;
		
	}
	
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
