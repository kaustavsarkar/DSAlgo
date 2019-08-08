package download.dsalgo.problems;

import java.util.*;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example :
 * 
 * Input : [1 2] Return : 1
 * 
 * @author kaussark
 *
 */
public class Problem203 {

	public static void main(String[] args) {

	}

	public int maxProfit(final List<Integer> A) {
		if(A == null || A.size() < 2) {
			return 0;
		}
		int maxSpent = -A.get(0);
		int maxProfit = -A.get(0);

		for (int day = 1; day < A.size(); day++) {
			int profit = A.get(day) + maxSpent;
			//I should buy at this day
			if(profit <= 0) {
				maxSpent =-A.get(day);
			} else {
				maxProfit = Math.max(maxProfit, profit);
			}
		}
		return maxProfit > 0 ? maxProfit : 0;
	}
}
