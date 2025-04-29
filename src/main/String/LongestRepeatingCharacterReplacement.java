package main.String;

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		String s = "BAAA";
		String s2= "AABABBA";
		System.out.println(characterReplacement(s,0));
		System.out.println(characterReplacement(s2,1));
	}
	 public static int characterReplacement(String s, int k) {
		 int start = 0, max = 0, result = 0;
	        int[] dict = new int[26];
	        
	        for(int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            dict[c-'A']++;
	            max = Math.max(max, dict[c-'A']);
	            if(i-start+1 > max+k){
	                dict[s.charAt(start) - 'A']--;
	                start++;
	            }
	            result = Math.max(result, i-start+1);
	        }
	        
	        return result;
	    }
}
