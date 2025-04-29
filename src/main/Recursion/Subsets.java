package main.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args0) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>>  result = new ArrayList<List<Integer>>();
       backtrack(result, nums, new ArrayList<Integer>(), 0);
       
       return result;
    }
	
	private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> cur, int index) {
		result.add(new ArrayList<Integer>(cur));
		
		for(int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			backtrack(result, nums, cur, i + 1);
			cur.remove(cur.size()-1);
		}
	}
}
