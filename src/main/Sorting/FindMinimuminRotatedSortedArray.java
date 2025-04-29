package main.Sorting;

public class FindMinimuminRotatedSortedArray {
	public static void main(String[] args0) {
		int[] nums1 = {3,4,5,1,2};
		int[] nums2 = {4,5,6,7,0,1,2};
		int res1 = findMin(nums1); 
		int res2 = findMin(nums2); 
		System.out.println(res1);
		System.out.println(res2);
	}
	public static int findMin(int[] nums) {
		 int left = 0, right = nums.length-1;
	        while(left<right){
	            int mid = (left+right)/2;
	            if(nums[mid]<nums[right]) right = mid;
	            else left = mid + 1;
	        }
	        return nums[left];
    }
}
