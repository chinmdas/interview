package com.practice.chin.atla;

import java.util.TreeSet;

public class TreeSetImpl {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("1");
		treeSet.add("7");
		treeSet.add("9");
		
		System.out.println(treeSet.last());

	}

}
