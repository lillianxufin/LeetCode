package main.String;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
	
	 public static void main(String[] args) {
		 String a = "test";
		 String b = "abcd";
		 String c = "abdc";
		 
		 String d = "34wq89080890a&*(&JLF";
		 String e = "34wq89080890a&*(&JLf";
		 String f = "34wq89080890a&*(&JLF";
		 System.out.println(isAnagramUnicode(d,e));
		 System.out.println(isAnagramUnicode(d,f));
	 }
	 
	 public static boolean isAnagram(String s, String t) {
		 int[] dict = new int[26];
		 Arrays.fill(dict, 0);
		 
		 if(s.length() != t.length()) return false;
		 
		 for(int i = 0; i < s.length(); i++) {
			 dict[s.charAt(i) - 'a']++;
		 }
		 
		 for(int i = 0; i < t.length(); i++) {
			 dict[t.charAt(i) - 'a']--;
			 if(dict[t.charAt(i) - 'a'] < 0) return false;
		 }
		 
		 
		 
		 return true;
	    }
	 
	 public static boolean isAnagramUnicode(String s, String t) {
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 
		 if(s.length() != t.length()) return false;
		 
		 for(int i = 0; i < s.length(); i++) {
			 if(map.containsKey(s.charAt(i))) {
				 map.put(s.charAt(i), map.get(s.charAt(i))+1);
			 } else {
				 map.put(s.charAt(i), 1);
			 }
		 }
		 
		 for(int i = 0; i < t.length(); i++) {
			 if(map.containsKey(t.charAt(i))) {
				 map.put(t.charAt(i), map.get(t.charAt(i))-1);
				 if(map.get(t.charAt(i)) < 0) {
					 return false;
				 }
			 } else {
				 return false;
			 }
		 }	 
		 return true;
	 }

}
