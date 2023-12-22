package com.practice.chin.ds.algo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LRUCache {
    
    private static Deque<Integer> queue;
    private static HashSet<Integer> set;
    private static int cacheSize;
    private static int pf=0;
    public static void refer(int page) {
        if (!set.contains(page)) {
            pf++;
            if (queue.size() == cacheSize) {
                int last = queue.removeLast();
                set.remove(last);
            }
        }
        else {
            queue.remove(page);
        }
        queue.push(page);
        set.add(page);
    }
    
    public static void display() {
        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	cacheSize=3;
        int[] arr= {1,5,4,2,1,4};
        queue = new LinkedList<Integer>();
        set = new HashSet<Integer>();
        for(int i: arr){
            refer(i);
        }
        System.out.println(pf);
        display();
    }
}