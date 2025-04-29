package main.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathtoGetFood2 {
	public static void main(String[] args) {
		char[][] grid = {{'X','X','X','X','X','X'},{'X','*','0','0','0','X'},{'X','0','0','#','0','X'},{'X','X','X','X','X','X'}};
		System.out.println(getFood(grid));
	}
	
	 public static int getFood(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '*') queue.offer(new int[] {i, j});
			}
		}
		
		int steps = 0;
		int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				if(grid[cur[0]][cur[1]] == '#') return steps;
				for(int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] != 'X') {
						visited[x][y] = true;
						queue.offer(new int[] {x, y});
					}
				}
			}
			steps++;
		}
		return -1;
	 }
}
