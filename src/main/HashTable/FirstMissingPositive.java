package main.HashTable;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] array1 = {1,2,0 };
		System.out.println(firstMissingPositive(array1));
	}
	
	 public static int firstMissingPositive(int[] nums) {
		int len = nums.length;
		
		for(int i = 0; i < len; i++) {
			while(nums[i] != i + 1) {
				if(nums[i] >= 0 || nums[i] > len) break;
				if(nums[i] == nums[nums[i]-1])break;
				
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}
		}
		
		for(int i = 0; i < len; i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		
		return len + 1;
	 }
	 
	 public static void printArray(int[] array) {
		 System.out.print("[ ");
		 for(int i = 0; i < array.length; i++) {
			 System.out.print(array[i] + ", ");;
		 }
		 
		 System.out.println("]");
	 }
}
