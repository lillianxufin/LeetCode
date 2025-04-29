package main.HashTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
	HashMap<Integer, Integer> map;
	List<Integer> elements;
	Random random;
	public static void main(String[] args0) throws IOException {
		RandomizedSet rs = new RandomizedSet();
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input1=br.readLine();
		rs.insert(Integer.valueOf(input1));
		rs.insert(2);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String output = String.valueOf(rs.getRandom());
		bw.write(output);
		bw.newLine();
		bw.close();
	}
	public RandomizedSet() {
       map = new HashMap<Integer, Integer>();
       elements = new ArrayList<Integer>();
       random = new Random();
    }
    
    public boolean insert(int val) {
       if(map.containsKey(val)) {
    	   return false;
       }
       elements.add(val);
       map.put(val, elements.size()-1);
       return true;
    }
    
    public boolean remove(int val) {
    	int n = elements.size();
       if(map.containsKey(val)) {
    	   if(n > 1) {
    		   int index = map.get(val);
    		   int swapValue = elements.get(n-1);
    		   Collections.swap(elements, index, n-1);
    		   map.put(swapValue, index);
    	   }
    	   map.remove(val);
    	   elements.remove(n-1);
    	   return true;
       }
       return false;
    }
    
    public int getRandom() {
       return elements.get(random.nextInt(elements.size()));
    }
}
