package main.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graphValidTreeBFS {
	public static void main(String[] arg0) {
		int n = 5;
		int[][] edges = {{3,1},{1,2},{0,3},{1,4}};
		System.out.println(validTree(n, edges));
	}
	
	public static boolean validTree(int n, int[][] edges) {
		if(n-1 != edges.length) return false;
		
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for(int[] e : edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		
		queue.offer(0);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(visited[v]) return false;
			visited[v] = true;
			for(int i : graph.get(v)) {
				if(!visited[i]) queue.offer(i);
			}
		}
		
		for(boolean b : visited) {
			if(!b) return false;
		}
		
		return true;
    }
}
