package main.Sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] arg0) {
		int[] nums = {4,7, 6,3,5,8,2,9,11,13, 10};
		//int[] nums = {1, -9};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void quickSort(int[] nums, int left, int right) {
		if(nums.length < 2) {
			return;
		}
		if(left < right) {
		int p = partition(nums, left, right);
		quickSort(nums, left, p-1);
		quickSort(nums, p+1, right);
		}
	}
	
	private static int partition(int[] nums, int left, int right) {
		int p = left;
		int t;
		for(int i = left; i < right; i++) {
			if(nums[i] < nums[right]) {
				t = nums[p];
				nums[p] = nums[i];
				nums[i] = t;
				p++;
			}
		}
		t = nums[p];
		nums[p]=nums[right];
		nums[right]=t;
		System.out.println(nums[p]);
		System.out.println(Arrays.toString(nums));
		return p;
	}
}
