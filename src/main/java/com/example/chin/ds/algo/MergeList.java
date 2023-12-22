package com.practice.chin.ds.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeList {

	public static void main(String[] args) {
		int[][] arr = {{6,8},{1,9},{2,4},{4,7}};
		System.out.println(merge(arr));
	}
	
	
	
    public static List<List<Integer>> merge(int[][] arr) {
    	Arrays.sort(arr,(arr1,arr2)->arr1[0]-arr2[0]);
    	
    	List<List<Integer>> mainList = new ArrayList<>();
    	int index=0;
    	for(int i=0;i<arr.length;i++) {
    		if(i==0) {
    			List<Integer> list = new ArrayList<>();
    			list.add(arr[i][0]);
    			list.add(arr[i][1]);
    			mainList.add(list);
    		}else {
    			if(mainList.get(index).get(1)>=arr[i][0]) {
    				if(mainList.get(index).get(1)<arr[i][1]) {
    					mainList.get(index).set(1, arr[i][1]);
    				}
    			}else {
    				List<Integer> list = new ArrayList<>();
        			list.add(arr[i][0]);
        			list.add(arr[i][1]);
        			mainList.add(list);
        			index++;
    			}
    		}
    	}
    	
    	
    	return mainList;
    	
    }

}
