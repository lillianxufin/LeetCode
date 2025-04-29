package main.Sorting;

public class HIndex {
	 public static void main(String[] args0) {
		 int[] nums = {2,3,0,1,2};
		 int res = hIndex(nums);
		 System.out.println(res);
	 }
	 public static int hIndex(int[] citations) {
	        int n = citations.length;
	        int[] bucket = new int[n+1];
	        int i;
	        
	        for(i = 0; i < n; i++) {
	        	if(citations[i] >= n) {
	        		bucket[n]++;
	        	} else {
	        		bucket[citations[i]]++;
	        	}
	        }
	        
	        int count = 0;
	        for(i = n; i >=0; i--) {
	        	count = count + bucket[i];
	        	if(count >= i) {
	        		return i;
	        	}
	        }
	        
	        return 0;
	    }
}
