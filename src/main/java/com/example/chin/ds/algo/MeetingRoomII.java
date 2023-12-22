package com.practice.chin.ds.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomII {
	
	//In how many minimum number of meeting room, we can arrange all the meeting
	public static void main(String[] args) {
		int[][] arr = {{9,12},{13,15},{7,10},{14,19},{14,17}};//[[7, 10], [9, 12], [13, 15], [14, 17], [15, 19]]
		
		int rooms = arrangeMeetings(arr);
		System.out.println(rooms);
	}

	private static int arrangeMeetings(int[][] arr) {
		
		Arrays.sort(arr, (arr1,arr2)->{
			return arr1[0] - arr2[0];
		});
		
		Queue<Integer> queue = new PriorityQueue<>();
		
		for(int[] timing : arr) {
			if(queue.isEmpty()) {
				queue.add(timing[1]); //adding only the end timings
			}else {
				if(timing[0]>=queue.peek()) { 
					queue.poll();      //remove the meeting from the queue
				}
				queue.add(timing[1]);
			}
		}
		
		return queue.size();
	}

}
