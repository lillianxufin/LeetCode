package main.Sorting;

public class MedianofTwoSortedArrays {
	 public static void main(String[] args0) {
		 int[] nums1 = {1,1,2,4};
		 int[] nums2 = {1,3,4,6};
		 double res = findMedianSortedArrays(nums1, nums2);
		 System.out.println(res);
	 }
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	     int n1 = nums1.length;
	     int n2 = nums2.length;
	     
	     if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
	     
	     int k = (n1 + n2 + 1)/2;
	     
	     int left = 0;
	     int right = n1;
	     
	     while(left < right) {
	    	 int m1 = (left + right)/2;
	    	 int m2 = k - m1;
	    	 
	    	 if(nums1[m1] < nums2[m2-1]) {
	    		 left = m1+1;
	    	 } else {
	    		 right = m1;
	    	 }
	     }
	     
	     int m1 = left;
	     int m2 = k -left;
	     
	    int c1 = Math.max(m1==0?Integer.MIN_VALUE : nums1[m1-1], 
	    			 m2==0?Integer.MIN_VALUE : nums2[m2-1]);
	    int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], 
	    		m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
	    			
	    if ((n1 + n2) % 2 == 1)
            return c1;    
	    else
                
        return (c1 + c2) * 0.5;
 	    }
}
