package main.Array;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] array1 = {};
		int[] array2 = {2,3,5,7};
		int[] array3 = {2,3,5,7,2};
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		System.out.println(containsDuplicate(array1));
		System.out.println(containsDuplicate(array2));
		System.out.println(containsDuplicate(array3));
	}
	public static boolean containsDuplicate(int[] nums) {
		if(nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		return true;
        	} else {
        		map.put(nums[i], i);
        	}
        }
        return false;
    }
}
