package main.Array;

public class BuyAndSellStock {
	public static void main(String[] args) {
		int[] prices1 = {};
		int[] prices2 = {7,1,5,3,6,4};
		
		int[] prices3 = {3,1};
		int[] prices4 = {1,1,1};
		
		int[] prices5 = {9,19,1,29};
		
		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
		System.out.println(maxProfit(prices3));
		System.out.println(maxProfit(prices4));
		System.out.println(maxProfit(prices5));
		
	}
	
	public static int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++) {
        	int money = prices[i] - min;
        	if (prices[i] < min) {
        		min = prices[i];
        	}
        	if(money > max) {
        		max = money;
        	}
        }
        
        return max;
    }

}
