package com.practice.chin.ds.algo;

public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
        int len = grid[0].length;
        int wid = grid.length;
        boolean[][] visited = new boolean[len][wid];
        int count=0;
        for(int i=0;i<wid;i++){
            for(int j=0;j<len;j++){
                
                if(grid[i][j]=='1' && visited[i][j]==false){
      
                    visit(grid,i,j,visited);
                    count++;
                }
                
            }
        }
        return count;
    }
    public static void visit(char[][] grid,int i, int j,boolean[][] visited) {
        if(i<0 || j>=grid.length || i>=grid[0].length || j<0 || visited[i][j]==true || grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        visit(grid,i+1,j,visited);
        visit(grid,i-1,j,visited);
        visit(grid,i,j+1,visited);
        visit(grid,i,j-1,visited);
    }
    
    public static void main(String[] args) {
		System.out.println((int)(Math.random()*10));
		System.out.println(1==1?"true":"false");
	}

}
