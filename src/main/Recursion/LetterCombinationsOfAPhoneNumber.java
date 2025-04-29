package main.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		List<String> res = letterCombinations(input);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(res.toString());
		bw.newLine();
		br.close();
		bw.close();
	}
	 public static List<String> letterCombinations(String digits) {
		 String[] dict = new String[] {
				 " ",
				 "",
				 "abc",
				 "def",
				 "ghi",
				 "jkl",
				 "mno",
				 "",
				 "pqrs",
				 "tuv",
				 "wxyz"
		 };
		 char[] cur = new char[digits.length()];
		 List<String> result = new ArrayList<>();
		 getCombinations(digits, dict, 0, cur, result);
		 return result;
	 }
	 
	 private static void getCombinations(String digits, String[] dict, int l, char[] cur, List<String> result) {
		 if(l == digits.length()) {
			 if(digits.length() > 0) {
				 result.add(new String(cur));
			 }
			 
			 return;
		 }
		 
		 String s = dict[Character.getNumericValue(digits.charAt(l))];
		 for(int i = 0; i < s.length(); i++) {
			 cur[l] = s.charAt(i);
			 getCombinations(digits, dict, l+1, cur, result);
		 }
	 }
}
