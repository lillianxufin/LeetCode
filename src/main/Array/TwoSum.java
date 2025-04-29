package main.Array;

import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] intArray1 = {1, 2, 5, 2};
		int target1 = 7;
		
		int[] intArray2 = {};
		int target2 = 7;
		
		int[] intArray3 = {3,3,3,3};
		int target3 = 6;
		
		int[] intArray4 = {3};
		int target4 = 6;
		
		
		int[] intArray5 = {1,2,7,8,12};
		int target5 = 6;
		
		printOutResult(findTwoSum(intArray1, target1));
		
		printOutResult(findTwoSum(intArray2, target2));
		
		printOutResult(findTwoSum(intArray3, target3));
		
		printOutResult(findTwoSum(intArray4, target4));
		
		printOutResult(findTwoSum(intArray5, target5));
	}
	
	// N^2
	public static int[] findTwoSum2(int[] array, int target) {
		for(int i = 0; i < array.length; i++) {
			for(int j = i+1; j < array.length; j++) {
				if(array[i] + array[j] == target) {
					int[] result = {i, j};
					return result;
				}
			}
		}
		return new int[]{};
	}
	
	public static int[] findTwoSum(int[] array, int target) {
		HashMap<Integer, Integer> map = new HashMap<> ();
		for(int i = 0; i < array.length; i++){
			int comp = target - array[i];
			if(map.containsKey(comp)){
				return new int[] {i, map.get(comp)};
			} else {
				map.put(array[i], i);
			}
		}
		return new int[] {};

	}
	
	public static void printOutResult(int[] result) {
		if(result.length == 2) {
			System.out.println("[" + result[0] + "," + result[1] + "]");
		} else {
			System.out.println("Result not found.");
		}
	}

}
