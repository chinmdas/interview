package com.practice.chin.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByOperation {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("oc");
		list.add("b");
		list.add("jql");
		list.add("ac");
		list.add("mnp");
		list.add("tp");
		
		Map<Integer,List<String>> map= list.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(map);
	}

}
