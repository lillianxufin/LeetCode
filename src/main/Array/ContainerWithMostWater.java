package main.Array;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] input = {2,3,3,4,1,2,3};
		System.out.println(maxArea(input));
	}
	public static  int maxArea(int[] height) {
	        int max = 0;
	        int left = 0;
	        int right = height.length - 1;
	        
	        while(left < right) {
	        	max = Math.max(max, Math.min(height[left], height[right])*(right - left));
	        	if(height[left] < height[right]) left++;
	        	else right--;
	        }
	        
	        return max;
	    }
}
