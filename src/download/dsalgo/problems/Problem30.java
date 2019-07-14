package download.dsalgo.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Hamming distance between two non-negative integers is defined as the number
 * of positions at which the corresponding bits are different.
 * 
 * For example,
 * 
 * HammingDistance(2, 7) = 2, as only the first and the third bit differs in the
 * binary representation of 2 (010) and 7 (111).
 * 
 * Given an array of N non-negative integers, find the sum of hamming distances
 * of all pairs of integers in the array. Return the answer modulo 1000000007.
 * 
 * Example
 * 
 * Let f(x, y) be the hamming distance defined above.
 * 
 * A=[2, 4, 6]
 * 
 * We return, f(2, 2) + f(2, 4) + f(2, 6) + f(4, 2) + f(4, 4) + f(4, 6) + f(6,
 * 2) + f(6, 4) + f(6, 6) =
 * 
 * 0 + 2 + 1 2 + 0 + 1 1 + 1 + 0 = 8
 * 
 * @author kaussark
 *
 */
public class Problem30 {

	public static void main(String[] args) {
		Integer[] array = { 2, 4, 6 };
		Problem30 problem = new Problem30();
		System.out.println(problem.hammingDistance(Arrays.asList(array)));
		;
	}

	public int hammingDistance(final List<Integer> A) {
		long dist = 0;
		int mod = 1000000007;

		for (int i = 0; i < 31; i++) {
			int ones = 0;
			for (int j = 0; j < A.size(); j++) {
				int num = A.get(j);
				ones += (num & (1 << i)) != 0 ? 1 : 0;
			}
			int zeroes = A.size() - ones;
			dist += (2l * ones * zeroes) % mod;
		}

		return (int) (dist % mod);
	}

	public int _hammingDistance(final List<Integer> A) {

		long dist = 0;
		int mod = 1000000007;

		for (int i = 0; i < A.size(); i++) {
			for (int j = i; j < A.size(); j++) {
				if (A.get(i) != A.get(j)) {
					dist += 2 * pairDist(A.get(i), A.get(j));
				}
			}
		}

		return (int) (dist % mod);
	}

	public long pairDist(int i, int j) {
		int xor = i ^ j;
		String bin = Integer.toBinaryString(xor);
		long dist = 0;

		for (Character c : bin.toCharArray()) {
			dist += Long.parseLong(c.toString());
		}

		return dist;
	}

}
