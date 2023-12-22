package com.practice.chin.ds.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubStringsAvaialbleInArray {

	public static void main(String[] args) {
		String str = "barfoofoobarthefoobarman";
		String[] words = {"foo","bar","the"};
		
		for(int i : findSubstring(str,words)) {
			System.out.println(i);
		}
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<String> wordList = Arrays.asList(words);
		int len = words[0].length();
		List<Integer> result = new ArrayList<>();
		int check = 0;
		int i = 0;
		int start = -1;
		while (i < s.length() - len+1) {
			String sub = s.substring(i, i + len);
			if (wordList.contains(sub)) {
				if (start == -1) {
					if(result.isEmpty()) {
						start = s.indexOf(sub);
					}else {
						start = s.indexOf(sub,result.size()*words.length*words[0].length());
					}
				}
				check++;
				i = i + len;
			} else {
				if (check == words.length) {
					result.add(start);
					start = -1;
				}
				check = 0;
				i++;
			}
		}
		return result;
	}

}
