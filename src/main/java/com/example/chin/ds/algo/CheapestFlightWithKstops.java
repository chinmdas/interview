package com.practice.chin.ds.algo;

import java.util.*;

public class CheapestFlightWithKstops {

	public static void main(String[] args) {
		int[][] flights= {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int n=4;
		int src=0,dst=3,k=1;
		
		System.out.println(findCheapestPrice(n,flights,src,dst,k));

	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer,List<int[]>> map = new HashMap<>();
		
		for(int[] arr: flights) {
			if(map.get(arr[0])==null) {
				List<int[]> flightList = new ArrayList<>();
				flightList.add(arr);
				map.put(arr[0], flightList);
			}else {
				List<int[]> flightList = map.get(arr[0]);
				flightList.add(arr);
				map.put(arr[0], flightList);
			}
		}
		
		PriorityQueue<Travel> queue = new PriorityQueue<>((t1,t2)->t1.cost-t2.cost);
		queue.add(new Travel(src,0,0));
		
		while(!queue.isEmpty()) {
			
			Travel obj = queue.poll();
			
			if(obj.dest==dst) {
				return obj.cost;
			}
			
			if(obj.stop<=k) {
				if(map.get(obj.dest)!=null) {
					for(int[] arr : map.get(obj.dest)) {
						queue.add(new Travel(arr[1],obj.stop+1,obj.cost+arr[2]));
					}
				}
			}
			
			
		}
		return -1;
	}

}



class Travel{
	
	int dest;
	int stop;
	int cost;
	public Travel(int dest, int stop, int cost) {
		super();
		this.dest = dest;
		this.stop = stop;
		this.cost = cost;
	}
}
