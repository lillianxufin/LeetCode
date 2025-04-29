package main.Sorting;

public class BinarySearch {
	public static void main(String[] args0) {
		int[] nums = {2,3,5,12,22};
		int res1 = search(nums,5); 
		int res2 = search(nums,35); 
		System.out.println(res1);
		System.out.println(res2);
	}
	public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
        	int mid = (left + right)/2;
        	if(nums[mid] == target) return mid;
        	
        	if(nums[mid] > target) right = mid - 1;
        	
        	if(nums[mid] < target) left = mid + 1;
        }
        return -1;
    }
}
