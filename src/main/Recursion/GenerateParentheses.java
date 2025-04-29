package main.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	private static List<String> result;
	public static void main(String[] args0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		result = new ArrayList<String>();
		generateParenthesis(n);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result.toString());
		bw.newLine();
		br.close();
		bw.close();
	}
	 public static List<String> generateParenthesis(int n) {
	        
	        helper(result, "", n, n);
	        return result;
	    }
	 
	 private static void helper(List<String> result, String cur, int left, int right) {
		 if(left == 0 && right == 0) {
			 result.add(cur);
			 return;
		 }
		 
		 if(left > 0) {
			 helper(result, cur + "(", left-1, right);
		 }
		 
		 if(right > left) {
			 helper(result, cur + ")", left, right-1);
		 }
	 }
}
