package main.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args0) {
		List<List<Integer>> res = combine(4,2);
		System.out.println(res);
	}
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
        	nums[i] = i + 1;
        }
        
        backtrack(result, new ArrayList<>(), nums, 0, k);
        return result;
    }
	
	private static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int index, int count) {
		if(count == 0) {
			result.add(new ArrayList<Integer>(cur));
			
			return;
		}
		
		for(int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			backtrack(result, cur, nums, i+1, count-1);
			cur.remove(cur.size()-1);
		}
	}
}
