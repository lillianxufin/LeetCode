package main.Sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] arg0) {
		int[] nums = {234,5, 67,3,3,8,2,9,234,23};
		//int[] nums = {1};
		mergeSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void mergeSort(int[] nums, int left, int right) {
		if(left < right) {
			int mid = left + (right -left)/2;
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			merge(nums, left, mid, right);
		}
	}
	
	private static void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= right) {
			if(nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		
		while(i <= mid) {
			temp[k++] = nums[i++];
		}
		
		while(j <= right) {
			temp[k++] = nums[j++];
		}
		
		for(i = 0; i < k; i++) {
			nums[left + i] = temp[i];
		}	
		System.out.println(Arrays.toString(nums));
	}
}
