package main.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static void main(String[] args0) {
		int[] nums = {1,2,2,3,2};
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println(res.toString());
	}
	 public static List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);;
	        backtrack(result, new ArrayList<>(), nums, 0);
	        
	        return result;
	    }
	 
	 private static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int index) {
		 result.add(new ArrayList<Integer>(cur));
		 
		 for(int i = index; i < nums.length; i++) {
			 if(i != index && nums[i-1] == nums[i]) continue;
			 cur.add(nums[i]);
			 backtrack(result, cur, nums, i + 1);
			 cur.remove(cur.size()-1);
		 }
	 }
	 
	 
}
