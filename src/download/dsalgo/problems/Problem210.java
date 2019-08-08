package download.dsalgo.problems;

import java.util.*;

/**
 * Given an array with non negative numbers, divide the array into two parts
 * such that the average of both the parts is equal. Return both parts (If
 * exist). If there is no solution. return an empty list.
 * 
 * Example:
 * 
 * 
 * Input: [1 7 15 29 11 9]
 * 
 * Output: [9 15] [1 7 11 29]
 * 
 * The average of part is (15+9)/2 = 12, average of second part elements is (1 +
 * 7 + 11 + 29) / 4 = 12
 * 
 * NOTE 1: If a solution exists, you should return a list of exactly 2 lists of
 * integers A and B which follow the following condition : numElements in A <=
 * numElements in B If numElements in A = numElements in B, then A is
 * lexicographically smaller than B (
 * https://en.wikipedia.org/wiki/Lexicographical_order ) NOTE 2: If multiple
 * solutions exist, return the solution where length(A) is minimum. If there is
 * still a tie, return the one where A is lexicographically smallest. NOTE 3:
 * Array will contain only non negative numbers.
 * 
 * @author kaussark
 *
 */
public class Problem210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private ArrayList<Integer> array;
	private boolean[][][] dp;
	private ArrayList<Integer> indexSetA;

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> array) {
		if (array == null || array.isEmpty()) {
			return new ArrayList<>();
		}

		this.array = array;
		Collections.sort(this.array);

		int sum = 0;
		for (int element : array) {
			sum += element;
		}

		int n = array.size();

		// memoization table by three states : (index, sum of setA, size of
		// setA)
		this.dp = new boolean[n][1 + sum][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 1 + sum; j++) {
				for (int k = 0; k < n; k++) {
					this.dp[i][j][k] = true;
				}
			}
		}

		this.indexSetA = new ArrayList<>();

		// iterate for third state : size of setA which varies from 1 to n-1
		for (int sizeA = 1; sizeA < n; sizeA++) {
			if ((sum * sizeA) % n != 0) {
				continue;
			}

			int sumA = (sum * sizeA) / n;

			if (isPartitionPossible(0, sumA, sizeA) == true) {
				break;
			}
		}

		return generatePartitions();
	}

	private boolean isPartitionPossible(final int index, final int sumA,
			final int sizeA) {
		if (sizeA == 0) {
			return sumA == 0;
		}

		int n = this.array.size();
		if (index >= n) {
			return false;
		}

		if (this.dp[index][sumA][sizeA] == false) {
			return false;
		}

		if (sumA >= this.array.get(index)) {
			// include the current index i.e. include the current element in
			// setA
			this.indexSetA.add(index);
			if (isPartitionPossible(index + 1, sumA - this.array.get(index),
					sizeA - 1) == true) {
				return true;
			}
			this.indexSetA.remove(this.indexSetA.size() - 1);
		}

		if (isPartitionPossible(index + 1, sumA, sizeA)) {
			// skip the current index i.e. don't include the current element in
			// setA
			return true;
		}

		this.dp[index][sumA][sizeA] = false;
		return this.dp[index][sumA][sizeA];
	}

	private ArrayList<ArrayList<Integer>> generatePartitions() {
		int i = 0, j = 0;
		int sizeA = this.indexSetA.size();
		int n = this.array.size();

		if (sizeA == n || sizeA == 0) { // no solution exists
			return new ArrayList<>();
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		result.add(new ArrayList<>());

		// index i is used to iterate over all elements and index j is used to
		// iterate over indexSetA
		while (i < n && j < sizeA) {
			if (i == this.indexSetA.get(j)) {
				result.get(0).add(this.array.get(i));
				j++;
			} else {
				result.get(1).add(this.array.get(i));
			}
			i++;
		}

		while (i < n) {
			result.get(1).add(this.array.get(i));
			i++;
		}

		return result;
	}
}
