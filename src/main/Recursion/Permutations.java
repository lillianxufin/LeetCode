package main.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args0) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = permute(nums);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer> (), nums);
        return result;
    }
	
	private static void backTrack(List<List<Integer>> result, List<Integer> cur, int[] nums) {
		if(cur.size() == nums.length) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(cur.contains(nums[i])) 
				continue;
			cur.add(nums[i]);
			backTrack(result, cur, nums);
			cur.remove(cur.size()-1);	
		}
	}
}
