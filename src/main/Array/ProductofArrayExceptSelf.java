package main.Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ProductofArrayExceptSelf {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] is = input.split("\\s+");
		int[] nums = new int[is.length];
		for(int i = 0; i < nums.length; i++) nums[i]=Integer.valueOf(is[i]);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] res1 = productExceptSelf(nums);
		int[] res2 = productExceptSelfWithOneSpace(nums);
		bw.write(Arrays.toString(res1));
		bw.newLine();
		bw.write(Arrays.toString(res2));
		bw.newLine();
		bw.close();
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length; 
        int[] fwd = new int[n];
        int[] back = new int[n];
        int[] result = new int[n];
        fwd[0] = 1;
        back[n-1] = 1;
        
        for(int i = 1; i < n; i++) {
        	fwd[i] = nums[i-1]*fwd[i-1];
        }
        
        for(int i = n-2; i >= 0; i--) {
        	back[i] = nums[i+1]*back[i+1]; 
        }
        
        for(int i = 0; i < n; i++) {
        	result[i] = fwd[i]*back[i];
        }
        
        return result;
    }
	
	public static int[] productExceptSelfWithOneSpace(int[] nums) {
		int n = nums.length; 
        int[] result = new int[n];
        int right = 1;
        result[0] = 1;
        
        for(int i = 1; i < n; i++) {
        	result[i] = nums[i-1]*result[i-1];
        }
        
        for(int i = n-1; i >= 0; i--) {
        	result[i] = result[i] * right;
        	right = right * nums[i];
        }
        
        return result;
    }
}
