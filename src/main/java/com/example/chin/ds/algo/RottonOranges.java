package com.practice.chin.ds.algo;

import java.util.LinkedList;
import java.util.Queue;

public class RottonOranges {

	public static void main(String[] args) {
		//int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
		int[][] arr = {{0,2}};
		System.out.println(orangesRotting(arr));

	}
	
	public static int orangesRotting(int[][] grid) {
        int len = grid.length;
        int wid = grid[0].length;
        int total=0;
        int rotton=0;
        int time=0;
        int fresh=0;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] dp = new boolean[len][wid];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<wid;j++){
                if(grid[i][j]==2){
                    rotton++;
                    queue.add(new Pair(i,j));
                    dp[i][j]=true;
                }
                if(grid[i][j]!=0){
                    total++;
                }
                if(grid[i][j]==1){
                	fresh++;
                }
            }
        }
        
        int freshToRotton=0;
        
        if(total==rotton){
            return time;
        }else if(queue.isEmpty() || fresh==0){
            return -1;
        }else{
            while(!queue.isEmpty()){
            	int size= queue.size();
            	for(int i=0;i<size;i++) {
            		Pair pair = queue.poll();
                
                    if(pair.x+1<len && grid[pair.x+1][pair.y]==1 && dp[pair.x+1][pair.y]==false){
                        queue.add(new Pair(pair.x+1,pair.y));
                        dp[pair.x+1][pair.y]=true;
                        freshToRotton++;
                    }
                    if(pair.x-1>=0 && grid[pair.x-1][pair.y]==1 && dp[pair.x-1][pair.y]==false){
                        queue.add(new Pair(pair.x-1,pair.y));
                        dp[pair.x-1][pair.y]=true;
                        freshToRotton++;
                    }
                    if(pair.y+1<wid && grid[pair.x][pair.y+1]==1 && dp[pair.x][pair.y+1]==false){
                        queue.add(new Pair(pair.x,pair.y+1));
                        dp[pair.x][pair.y+1]=true;
                        freshToRotton++;
                    }
                    if(pair.y-1>=0 && grid[pair.x][pair.y-1]==1 && dp[pair.x][pair.y-1]==false){
                        queue.add(new Pair(pair.x,pair.y-1));
                        dp[pair.x][pair.y-1]=true;
                        freshToRotton++;
                    }
            	}
            	time++;
                
            }
        }
        if(rotton+freshToRotton==total){
            return time-1;
        }else{
            return -1;
        }
    }

}


class Pair{
    public int x;
    public int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
