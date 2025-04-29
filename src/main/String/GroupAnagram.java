package main.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("a", "berte");
		//System.out.println(map.toString());
		map.get("a").substring(0, 2);
		//System.out.println(map.toString());
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
	       HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	       
	       for(int i = 0; i < strs.length; i++) {
	    	   String s = strs[i];
	    	   char[] array = s.toCharArray();
	    	   Arrays.sort(array);
	    	   String key = String.valueOf(array);
	    	   
	    	   if(map.containsKey(key)) {
	    		   map.get(key).add(s);
	    	   } else {
	    		   List<String> list = new ArrayList<String>();
	    		   list.add(s);
	    		   map.put(key, list);
	    	   }
	       }
	       
	       return new ArrayList<List<String>> (map.values());
	    }
}
