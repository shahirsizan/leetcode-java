// CPS academy sheet (Arrays & Matrix)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import java.util.Arrays;


public class BestTimeBuySellStock {
	
	public int maxProfit(int[] prices) {
		
		int buyingPrice = prices[0];
		int maxProfit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			int currentPrice = prices[i];
			int currentProfit = currentPrice - buyingPrice;
			
			if (currentPrice < buyingPrice) {
				buyingPrice = currentPrice;
			}
			
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
		}
		
		return maxProfit;
	}
	
	
	public static void main(String[] args) {
		BestTimeBuySellStock myObj = new BestTimeBuySellStock();
		
		// Example 1:
		int[] prices1 = {7, 1, 5, 3, 6, 4};
		int result1 = myObj.maxProfit(prices1);
		// Buy at 1 (Day 2), Sell at 6 (Day 5). Profit = 5. Expected: 5
		System.out.println("--- Example 1 ---");
		System.out.println("Prices: " + Arrays.toString(prices1));
		System.out.println("Max Profit: " + result1);
		
		System.out.println("-----------------");
		
		// Example 2:
		int[] prices2 = {7, 6, 4, 3, 1};
		int result2 = myObj.maxProfit(prices2);
		// No profit is possible. Expected: 0
		System.out.println("--- Example 2 ---");
		System.out.println("Prices: " + Arrays.toString(prices2));
		System.out.println("Max Profit: " + result2);
	}
}