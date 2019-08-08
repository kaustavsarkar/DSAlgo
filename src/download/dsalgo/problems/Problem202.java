package download.dsalgo.problems;

import java.util.*;

/**
 * You are given a set of coins S. In how many ways can you make sum N assuming
 * you have infinite amount of each coin in the set.
 * 
 * Note : Coins in set S will be unique. Expected space complexity of this
 * problem is O(N).
 * 
 * Example :
 * 
 * Input : S = [1, 2, 3] N = 4
 * 
 * Return : 4
 * 
 * Explanation : The 4 possible ways are {1, 1, 1, 1} {1, 1, 2} {2, 2} {1, 3}
 * Note that the answer can overflow. So, give us the answer % 1000007
 * 
 * @author kaussark
 *
 */
public class Problem202 {

	public static void main(String[] args) {
		Integer[] coins = { 1, 2, 3 };
		int value = 4;
		System.out.println(new Problem202()
				.coinchange2(new ArrayList<>(Arrays.asList(coins)), value));
	}

	public int coinchange2(ArrayList<Integer> A, int B) {
		long[] memo = new long[B+1];
		memo[0] = 1;
		int mod = 1000007;
		
		for(int index = 0; index < A.size(); index++) {
			for(int sum = 0; sum <= B; sum++) {
				if(sum >= A.get(index)) {
					memo[sum] += memo[sum - A.get(index)];
				}
			}
		}
		return  (int) (memo[B]%mod);
	}
}
