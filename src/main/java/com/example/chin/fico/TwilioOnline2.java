package com.practice.chin.fico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwilioOnline2 {

	public static void main(String[] args) {
		
		List<String> history = new ArrayList<>();
		history.add("137");
		history.add("364");
		history.add("115");
		history.add("724");
		
		System.out.println(slotWheels(history));
	}
	
	
	public static int slotWheels(List<String> history) {
        int[] arr = new int[history.get(0).length()];
        Arrays.fill(arr,Integer.MIN_VALUE);
        
        for(String str : history){
        	str=sortString(str);
            for(int i=0;i<str.length();i++){
                arr[i]=Math.max(arr[i], str.charAt(i) -'0');
            }
        }
        
        int result=0;
        for(int i : arr){
            result+=i;
        }
        Arrays.toString(arr);
        return result;
    }
	
	public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

}
