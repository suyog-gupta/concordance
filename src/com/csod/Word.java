package com.csod;

import java.util.ArrayList;

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

