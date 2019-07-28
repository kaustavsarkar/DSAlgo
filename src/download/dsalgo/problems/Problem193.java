package download.dsalgo.problems;

import java.util.*;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * Example :
 * 
 * Input : [1 2 1 2] Output : 2
 * 
 * Explanation : Day 1 : Buy Day 2 : Sell Day 3 : Buy Day 4 : Sell
 * 
 * @author kaussark
 *
 */
public class Problem193 {

	public static void main(String[] args) {

	}

	public int maxProfit(final List<Integer> prices) {
		if(prices==null || prices.isEmpty() || prices.size() < 2) {
			return 0;
		}
		return maxProfit(prices, 2);
	}

	private int maxProfit(List<Integer> prices, int totalTransact) {
		int[][] profits = new int[totalTransact+1][prices.size()];

		for (int transact = 1; transact < profits.length; transact++) {
			int maxSpent = -prices.get(0); // Spent on first day
			for (int day = 1; day < profits[transact].length; day++) {
				profits[transact][day] = Math.max(profits[transact][day - 1],
						prices.get(day) + maxSpent);
				maxSpent = Math.max(maxSpent, profits[transact-1][day] - prices.get(day));

			}
		}

		return profits[totalTransact][prices.size()-1];
	}

}
