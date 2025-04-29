package main.Array;

public class RotatedSortedArray {
	public static void main(String[] args) {
		int[] array1 = {4,5,6,7,0,1,2};
			
		System.out.println(search(array1, 4));
		System.out.println(search(array1, 5));
		System.out.println(search(array1, 2));
		System.out.println(search(array1, 7));
		System.out.println(search(array1, 11));
	}
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = left +(right - left) / 2;
			if(nums[mid] == target) return mid;
			
			if(nums[mid] > nums[right]) {
				if(nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			else {
				if(nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
    }
}
