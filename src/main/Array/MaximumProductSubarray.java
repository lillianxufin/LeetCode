package main.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaximumProductSubarray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] is = input.split("\\s+");
		int[] nums = new int[is.length];
		for(int i = 0; i < nums.length; i++) nums[i]=Integer.valueOf(is[i]);
		int res = maxProduct(nums);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(res));
		bw.newLine();
		bw.flush(); 
		br.close();
		bw.close();
	}

	public static int maxProduct(int[] nums) {
        int result = nums[0];
        int min = result;
        int max = result;
        
        for(int i = 1; i < nums.length; i++) {
        	if (nums[i] > 0)  {
        		max = Math.max(max*nums[i], nums[i]);
        		min = Math.min(min*nums[i], nums[i]);
        	}else {
        		int temp = max;
        		max = Math.max(min*nums[i], nums[i]);
        		min = Math.min(temp*nums[i], nums[i]);
        	}
        	result = Math.max(result, max);
        }
        return result;
    }
}
