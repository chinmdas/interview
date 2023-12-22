package com.practice.chin.atla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Problem1 {

	public static int countFamilyLogins(List<String> logins) {

		long startTime = System.currentTimeMillis();
		int count = 0;
		for (String str : logins) {
			String newStr = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) + 1);
				newStr += c;
			}
			for(String str1 : logins) {
				if(newStr.equals(str1)) {
					count++;
				}
			}
		}
		long timeTaken = System.currentTimeMillis() - startTime;
	  	System.out.println("Time taken to finish the complete process = "+ ((timeTaken / 1000) / 60) +" minutes and "+((timeTaken / 1000) % 60) +" seconds");
		return count;
	}
	
	
	public static int countFamilyLogins2(List<String> logins) {

		Map<String, Integer> map = new HashMap<>();
		Map<String, String> mapIncremented = new HashMap<>();
		int count = 0;
		for(String s : logins) {
			if(map.get(s)==null) {
				map.put(s, 1);
			}else {
				map.put(s, map.get(s)+1);
			}
		}
		for (String str : logins) {
			String incrementedStr = "";
			if(mapIncremented.get(str)!=null) {
				incrementedStr = mapIncremented.get(str);
			}else {
				for (int i = 0; i < str.length(); i++) {
					if((int)str.charAt(i)==122) {
						char c1=(char) 97;
						incrementedStr += c1;
					}else {
						char c = (char) (str.charAt(i) + 1);
						incrementedStr += c;
					}
				}
				mapIncremented.put(str, incrementedStr);
			}
			
			
			if(map.get(incrementedStr)!=null) {
				count+=map.get(incrementedStr);
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		
		
		char a='a';
		System.out.println(a);
		int z='z';
		System.out.println(z);
		int i = 97;
		char c1=(char) i;
		System.out.println(c1);

		List<String> list = new ArrayList<>();
		list.add("cbz");
		list.add("bat");
		list.add("cbu");
		
		System.out.println(countFamilyLogins(list));
		System.out.println(countFamilyLogins2(list));

	}

}
