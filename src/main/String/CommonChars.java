package main.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars {
	public static void main(String[] args) {
		String[] a =  {"bella", "label"};
		System.out.println(commonChars(a));
	}
	public static List<String> commonChars(String[] words) {
       List<String> result = new ArrayList<String>();
       int[] dict = new int[26];
       Arrays.fill(dict, Integer.MAX_VALUE);
       
       for(int i = 0; i < words.length; i++) {
    	   int[] count = new int[26];
    	   for(int j = 0; j < words[i].length(); j++) {
    		   count[words[i].charAt(j) - 'a']++;
    	   }
    	   for(int j = 0; j < 26; j++) {
    		   dict[j] = Math.min(dict[j], count[j]);
    	   }
       }
       
       for(char c = 'a'; c <= 'z'; c++) {
    	   while(dict[c - 'a'] > 0) {
    		   result.add(c+ "");
    		   dict[c - 'a']--;
    	   }
       }
       
       return result;
	}
}
