package main.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathtoGetFood {
	public static void main(String[] args) {
		char[][] grid = {{'X','X','X','X','X','X'},{'X','*','0','0','0','X'},{'X','0','0','#','0','X'},{'X','X','X','X','X','X'}};
		System.out.println(getFood(grid));
	}
	
	 public static int getFood(char[][] grid) {
		 int[][] dirs = {{0, 1},{0, -1},{-1, 0},{1,0}};
		 int m = grid.length;
		 int n = grid[0].length;
		 Queue<int[]> queue = new LinkedList<>();
		 boolean[][] visited = new boolean[m][n];
		 for(int i = 0; i < m; i++) {
			 for(int j = 0; j < n; j++) {
				 if(grid[i][j] == '*') {
					 queue.offer(new int[] {i, j});
				 }
			 }
		 }
		 
		 int step = 0;
		 while(!queue.isEmpty()) {
			 int size = queue.size();
			 for(int i = 0; i < size; i++) {
				 int[] curr = queue.poll();
				 if(grid[curr[0]][curr[1]] == '#') {
					 return step;
				 }
				 for(int[] dir : dirs) {
					 int x = curr[0] + dir[0];
					 int y = curr[1] + dir[1];
					 if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 'X' && !visited[x][y]) {
						 visited[x][y]= true;
						 queue.offer(new int[] {x,y});
					 }
				 }
			 }
			 step++;
		 }
		 return -1;
	 }
}
