package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 * 
 * Calculate the minimum absolute difference between the maximum and minimum
 * number from the triplet a, b, c such that a, b, c belongs arrays A, B, C
 * respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
 * 
 * Example :
 * 
 * Input:
 * 
 * A : [ 1, 4, 5, 8, 10 ] B : [ 6, 9, 15 ] C : [ 2, 3, 6, 6 ] Output:
 * 
 * 1 Explanation: We get the minimum difference for a=5, b=6, c=6 as |
 * max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 * 
 * @author kaussark
 *
 */
public class Problem79 {

	public static void main(String[] args) {
		Integer[] a =  { 1, 4, 5, 8, 10 };
				//{ 1, 4, 5, 8, 10 };
		Integer[] b =  { 6, 9, 10 };
				//{ 6, 9, 15 };
		Integer[] c =  { 2, 3, 6, 10 };
				//{ 2, 3, 6, 6 };

		System.out.println(
				new Problem79().solve(new ArrayList<>(Arrays.asList(a)),
						new ArrayList<>(Arrays.asList(b)),
						new ArrayList<>(Arrays.asList(c))));
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B,
			ArrayList<Integer> C) {
		int a = 0, b = 0, c = 0;
		int diff = Integer.MAX_VALUE;
		int acounter = A.size() - 1;
		int bcounter = B.size() - 1;
		int ccounter = C.size() - 1;

		while (acounter >= 0 && bcounter >= 0 && ccounter >= 0) {
			a = A.get(acounter);
			b = B.get(bcounter);
			c = C.get(ccounter);

			diff = Math.min(diff,
					Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));

			if (a >= b && a >= c) {
				acounter--;
			} else if (b > a && b >= c) {
				bcounter--;
			} else if (c > a && c > b) {
				ccounter--;
			}
		}

		return diff;
	}
}
