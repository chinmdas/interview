package com.practice.chin.ds.algo;

public class StringManipulation {

	public static void main(String[] args) {
		String line ="aow are yaa ,  abc";
		String[] arr = line.split(",");
	      String str=arr[0].trim();
	      String scrubs = arr[1].trim();
	      for(int i=0;i<scrubs.length();i++){
	        char c = scrubs.charAt(i);
	        int index=0;
	        while(str.indexOf(c,index)!=-1){
	          int remove=str.indexOf(c,index);
	          if(remove==0){
	            str=str.substring(remove+1);
	          }else if(remove==str.length()-1){
	            str=str.substring(0,str.length()-1);
	          }else{
	            str=str.substring(0,remove)+str.substring(remove+1,str.length());
	          }
	          index=remove;
	        }
	      }
	      System.out.println(str);

	}

}
