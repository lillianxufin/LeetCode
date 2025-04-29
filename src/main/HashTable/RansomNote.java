package main.HashTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RansomNote {
	public static void main(String[] args0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ransomNote = br.readLine();
		String magazine = br.readLine();
		boolean res = canConstruct(ransomNote, magazine);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(res? "True":"False");
		bw.newLine();
		bw.close();
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
	        int[] dict = new int[26];
	        
	        for(char c : magazine.toCharArray()) {
	        	dict[c - 'a']++;
	        }
	        
	        for(char c : ransomNote.toCharArray()) {
	        	dict[c - 'a']--;
	        	if(dict[c - 'a'] < 0)return false;
	        }
	        
	        return true;
	    }
}
