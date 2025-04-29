package main.String;

public class ValidPalindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		
		System.out.println(isPalindrome(s));
	}
	public static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
        	char leftChar = s.charAt(left);
        	char rightChar = s.charAt(right);
        	if(Character.isLetterOrDigit(leftChar)) {
        		left++;
        	} else if(Character.isLetterOrDigit(rightChar)) {
        		right--;
        	} else {
        		if(leftChar != rightChar) return false;
        		else left++;
        		right--;
        	}
        }
        
        return true;
    }
}
