package com.practice.chin.atla;

public class BubbleSearch {
	
	public static int k=3;

	public static void main(String[] args) {
		
		int[] arr = {5,6,7,8,1,2,3};
		
		System.out.println(find(arr));

	}

	private static int find(int[] arr) {
		boolean first=true;
		if(arr[0]>k) {
			first=false;
		}
		int rotated=0;
		for(int i=0;i<arr.length;i++) {
			if(i>0) {
				if(arr[i]<arr[i-1]) {
					rotated=i;
					break;
				}
			}
		}
		
		if(first) {
			System.out.println("first");
			bubble(0,rotated,arr);
		}else {
			System.out.println("here");
			bubble(rotated,arr.length,arr);
		}
		return -1;
	}
	
	public static int bubble(int start,int end,int[] arr) {
		System.out.println("start = "+start+" , end = "+end);
		while(end>=start) {
			int mid=(end+start)/2;
			if(arr[mid]>k) {
				bubble(start,mid-1,arr);
			}else if(arr[mid]<k) {
				bubble(mid+1,end,arr);
			}else {
				return mid;
			}
		}
		return -1;
	}

}
