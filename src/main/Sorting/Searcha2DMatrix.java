package main.Sorting;

public class Searcha2DMatrix {
	public static void main(String[] args0) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target2 = 13;
		System.out.println(searchMatrix(matrix,target));
		System.out.println(searchMatrix(matrix2,target2));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		 int m = matrix.length, n = matrix[0].length;
	        int left = 0, right = m*n;
	        while(left<right){
	            int mid = (left+right)/2;
	            int v = matrix[mid/n][mid%n];
	            if(v==target) return true;
	            if(v<target) left = mid + 1;
	            else right = mid;
	        }
	        return false;
    }
}
