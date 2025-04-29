package main.String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		String s2 = "ab";
		String s3 = 
				"pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring(s2));
		System.out.println(lengthOfLongestSubstring(s3));
	}
	
	public static int lengthOfLongestSubstring(String s) {
	        int max = 0;
	        int start = 0;
	        int end = 0;
	        HashSet<Character> set = new HashSet<Character> ();
	        
	        while(end < s.length()) {
	        	char c = s.charAt(end);
	        	if(!set.contains(c)) {
	        		set.add(c);
	        		max = Math.max(end - start + 1, max);
	        		end++;
	        	} else {
	        		set.remove(s.charAt(start));
	        		start++;
	        	}
	        }
	        
	        return max;
	    }
}
