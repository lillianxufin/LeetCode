package main.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] array1 = {-2, 3, -1, 2, -9, -1, 1};
		int[] array2 = {-2, 2, -9, -1, -1, -1};
		int[] array3 = {};
		int[] array4 = {2};
		int[] array5 = {-2, 3, -1, 2, -9, -1};
		int[] array6 = {-1, -1, 2};
		int[] array7 = {-1, -1, 1, 0};
		
		System.out.println(threeSum(array1));
		System.out.println(threeSum(array2));
		System.out.println(threeSum(array3));
		System.out.println(threeSum(array4));
		System.out.println(threeSum(array5));
		System.out.println(threeSum(array6));
		System.out.println(threeSum(array7));
		
		
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       
       if(nums == null || nums.length < 3) return result;
       
       for(int i = 0; i < nums.length - 2; i++) {
    	   if(nums[i] > 0) break;
    	   if(i > 0 && nums[i] == nums[i-1]) continue;
    	   
    	   int left = i + 1;
    	   int right = nums.length -1;
    	   while(left < right) {
    		   int sum = nums[i] + nums[left] + nums[right];
    		   if(sum == 0) {
    			   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
    			   while(left < right && nums[left] == nums[left+1]) left++;
    			   while(left < right && nums[right] == nums[right-1]) right--;
    			   left++;
    			   right--;
    		   }
    		   if(sum > 0) right--;
    		   if(sum < 0) left++;
    	   }
       }
       
       return result;
    }
}
