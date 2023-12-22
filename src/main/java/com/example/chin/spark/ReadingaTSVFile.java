package com.practice.chin.spark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ReadingaTSVFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		String sentence ="abc				";
		System.out.println(sentence.split("\t", -1).length);
        System.out.println(split(sentence).length);
		
		

	}

	private static String[] split(String sentence) {
		char splitquery = '\u0009'; 
        
        List<String> splitSentence = new ArrayList<String>();
        
        String w = "";
        for(int i = 0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            
            if(ch == splitquery){
                splitSentence.add(w);
                w = "";
                continue;
            }
            
            w += Character.toString(ch);
            
            if (i == sentence.length()-1){
                splitSentence.add(w);
            }
        }
        System.out.println(splitSentence);
        return splitSentence.toArray(new String[splitSentence.size()]);
	}

}
