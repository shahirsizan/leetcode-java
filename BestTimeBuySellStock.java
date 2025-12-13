import java.lang.Math;
import java.util.Arrays;


public class BestTimeBuySellStock {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		String str = "sizan";

		int buyingPrice = prices[0];
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			int currentPrice = prices[i];
			int currentProfit = currentPrice - buyingPrice;
			maxProfit = Math.max(maxProfit, currentProfit);
			buyingPrice = Math.min(buyingPrice, currentPrice);
		}

		return maxProfit;
	}


	public static void main(String[] args) {
		BestTimeBuySellStock solver = new BestTimeBuySellStock();

		// Example 1:
		int[] prices1 = {7, 1, 5, 3, 6, 4};
		int result1 = solver.maxProfit(prices1);
		// Buy at 1 (Day 2), Sell at 6 (Day 5). Profit = 5. Expected: 5
		System.out.println("--- Example 1 ---");
		System.out.println("Prices: " + Arrays.toString(prices1));
		System.out.println("Max Profit: " + result1);

		System.out.println("-----------------");

		// Example 2:
		int[] prices2 = {7, 6, 4, 3, 1};
		int result2 = solver.maxProfit(prices2);
		// No profit is possible. Expected: 0
		System.out.println("--- Example 2 ---");
		System.out.println("Prices: " + Arrays.toString(prices2));
		System.out.println("Max Profit: " + result2);
	}
}