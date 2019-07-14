package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * Example : Given array S = {1 0 -1 0 -2 2}, and target = 0 A solution set is:
 * 
 * (-2, -1, 1, 2) (-2, 0, 0, 2) (-1, 0, 0, 1) Also make sure that the solution
 * set is lexicographically sorted. Solution[i] < Solution[j] iff Solution[i][0]
 * < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k]
 * < Solution[j][k])
 * 
 * @author kaussark
 *
 */
public class Problem130 {

	public static void main(String[] args) {
		Integer[] array = { 9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5,
				-1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8,
				-4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6,
				-4, 2, 0, 10, 1, -2, 5, -2 };
		System.out.println(new Problem130()
				.fourSum(new ArrayList<>(Arrays.asList(array)), 0));
	}

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
		if (A.size() < 4) {
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(A);
		for (int i = 0; i < A.size() - 3; i++) {
			for (int j = i + 1; j < A.size() - 2; j++) {
				int left = j + 1;
				int right = A.size() - 1;

				while (left < right) {
					if (A.get(i) + A.get(j) + A.get(left) + A.get(right) == B) {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(A.get(i));
						temp.add(A.get(j));
						temp.add(A.get(left));
						temp.add(A.get(right));
						if (!result.contains(temp))
							result.add(temp);
						left++;
						right--;
					} else if (A.get(i) + A.get(j) + A.get(left)
							+ A.get(right) < B) {
						left++;
					} else {
						right--;
					}

				}
			}
		}
		return result;

	}
}
