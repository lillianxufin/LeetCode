package main.Array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MaxSubArray {
	public static void main(String[] args) throws IOException {
		int[] array1 = {-2, 3, -1, 2, -9};
		int[] array2 = {-2, 3, -1, 2, -9, 2};
		int[] array3 = {-2, 3, -1, 2, -1, 2};
		
		int res1 = maxSubArray(array1);
		int res2 = maxSubArray(array2);
		int res3 = maxSubArray(array3);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(res1));
		bw.newLine();
		bw.write(String.valueOf(res2));
		bw.newLine();
		bw.write(String.valueOf(res3));
		bw.close();
	}
	
	public static int maxSubArray(int[] nums) {
       int currentSum = 0;
       int maxSum = Integer.MIN_VALUE;
       
       for(int i = 0; i < nums.length; i++) {
    	   currentSum = currentSum + nums[i];
    	   if(currentSum > maxSum) maxSum = currentSum;
    	   if(currentSum < 0) currentSum = 0;
       } 
       return maxSum;
    }
}
