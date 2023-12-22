package com.practice.chin.atla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapRead {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("alby", 110);
		map.put("shyam", 99);
		map.put("rohan", 110);
		map.put("raghav", 98);
		Map<String,Integer> map1 = new LinkedHashMap<>();
		map1.put("ds", 100);
		map1.put("ls", 101);
		System.out.println("chin = "+ map1.get("chin"));
		map1.remove(map1.keySet().iterator().next());
		System.out.println(map1.keySet().iterator().next());
		
		List<Entry<String,Integer>> list = new ArrayList<>();
		
		for(Entry<String,Integer> entry : map.entrySet()) {
			list.add(entry);
		}
		
		Comparator<Entry<String,Integer>> compare = (o1,o2) -> o2.getValue()-o1.getValue();
		
		Collections.sort(list, compare);
		
		System.out.println(list.get(0).getKey());
		
	}

}
