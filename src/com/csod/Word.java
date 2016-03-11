package com.csod;

import java.util.ArrayList;

// Class that defines attributes of a word in the concordance. sentenceNumber ArrayList, holds a list of sentence numbers, in which a word was found
public class Word {
		String word;
		ArrayList<Integer> sentenceNumber;
		int wordFrequency = 0;
		
		public Word(String Word, ArrayList<Integer> sentenceNo, int wordFreq){
			this.word = Word;
			this.sentenceNumber = sentenceNo;
			this.wordFrequency = wordFreq;
		}
	}

