package main.String;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abbcdfdcda";
		System.out.println(longestPalindrome(s));
	}
	public static String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        
        int start = 0, len = 0;
        for(int i = 0; i < s.length(); i++) {
        	int currentLen = Math.max(getPalindromeLength(s, i, i), getPalindromeLength(s, i, i+1));
        	if(currentLen > len) {
        		len = currentLen;
        		start = i - (len - 1)/2;
        	}
        }
        
        return s.substring(start, start + len);
    }
	
	private static int getPalindromeLength(String s, int l, int r) {
		while(l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
			l--;
			r++;
		}
		return r-l-1;
	}
}
