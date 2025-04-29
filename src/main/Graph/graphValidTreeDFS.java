package main.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class graphValidTreeDFS {
	public static void main(String[] arg0) {
		int n = 5;
		int[][] edges = {{3,1},{1,2},{0,3},{1,4}};
		System.out.println(validTree(n, edges));
	}
	
	public static boolean validTree(int n, int[][] edges) {
		if(n-1 != edges.length) return false;
		
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int[] e : edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}
		
		if(!dfs(graph, visited, 0, -1)) {
			return false;
		}
		
		for(boolean b : visited) {
			if(!b) return false;
		}
		
		return true;
	}
	
	public  static boolean dfs(HashMap<Integer, List<Integer>> graph, boolean[] visited, int curr, int parent) {
		if(visited[curr]) return false;
		visited[curr] = true;
		for(int v : graph.get(curr)) {
			if(v != parent && !dfs(graph, visited, v, curr)) {
				return false;
			}
		}
		return true;
	}
}
