package com.practice.chin.ds.algo;

public class SquareElementsInSortedOrder {

	public static void main(String[] args) {
		
		int[] arr = {-4,-3,-2,0,1,5};
		
		int[] result = squareAndSort(arr);
		for(int i: result) {
			System.out.println(i);
		}
	}

	private static int[] squareAndSort(int[] arr) {
		int m=0;
		while(arr[m]<0) {
			m++;
		}
		
		int[] square = new int[arr.length];
		int index=0;
		int negIndex=m-1;
		int posIndex=m;
		
		while(posIndex<=arr.length-1 || negIndex>=0) {
			
			if(posIndex>arr.length-1 && negIndex>=0) {
				square[index]=arr[negIndex]*arr[negIndex];
				index++;
				negIndex--;
			}else if(posIndex<=arr.length-1 && negIndex<0) {
				square[index]=arr[posIndex]*arr[posIndex];
				index++;
				posIndex++;
			}else if(posIndex>arr.length-1 && negIndex<0) {
				break;
			}else {
				if(arr[negIndex]*arr[negIndex] > arr[posIndex]*arr[posIndex]) {
					square[index]=arr[posIndex]*arr[posIndex];
					index++;
					posIndex++;
				}else if(arr[negIndex]*arr[negIndex] < arr[posIndex]*arr[posIndex]){
					square[index]=arr[negIndex]*arr[negIndex];
					index++;
					negIndex--;
				}else {
					square[index]=arr[posIndex]*arr[posIndex];
					index++;
					posIndex++;
					square[index]=arr[negIndex]*arr[negIndex];
					index++;
					negIndex--;
				}
			}
		}
		
		return square;
	}

}
