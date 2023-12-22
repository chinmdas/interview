package com.practice.chin.atla;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Duplicate {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		
		List<Integer> arr = list.stream().distinct().collect(Collectors.toList());
		System.out.println(arr);

	}

}
