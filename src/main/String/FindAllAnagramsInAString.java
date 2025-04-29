package main.String;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		System.out.println(findAnagrams(s,p));
	}
	public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList<Integer>();
	        int[] array = new int[26];
	    
	        if(p.length() > s.length()) return result;
	        
	        for(char c : p.toCharArray()) {
	        	array[c-'a']++;
	        }
	        
	        int start = 0, len = p.length(), end = len -1;
	        while(end < s.length()) {
	        	int[] temp = array.clone();
	        	int count = len;
	        	for(int i = start; i<=end; i++) {
	        		if(temp[s.charAt(i)-'a'] > 0) {
	        			temp[s.charAt(i)-'a']--;
	        			count--;
	        		}
	        	}
	        	if(count == 0) result.add(start);
	        	start++;
	        	end++;
	        }  
	        return result;
	    }
}
