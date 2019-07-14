package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
 * Considering each array element Ai as the edge length of some line segment,
 * count the number of triangles which you can form using these array values.
 * 
 * Notes:
 * 
 * You can use any value only once while forming each triangle. Order of
 * choosing the edge lengths doesn’t matter. Any triangle formed should have a
 * positive area.
 * 
 * Return answer modulo 109 + 7.
 * 
 * For example,
 * 
 * A = [1, 1, 1, 2, 2]
 * 
 * Return: 4
 * 
 * @author kaussark
 *
 */
public class Problem88 {

	public static void main(String[] args) {
		Integer[] array = 
//			{ 11, 18, 13, 1, 19, 14, 8, 15, 16, 20, 12, 6, 10, 5,
//				17, 2, 4 };
		//{ 4, 6, 13, 16, 20, 3, 1, 12};
		 { 1, 1, 1, 2, 2 };
		System.out.println(
				new Problem88()._nTriang(new ArrayList<>(Arrays.asList(array))));
	}

	public int _nTriang(ArrayList<Integer> a) {
		int c = 0;
		// sprt the array
		Collections.sort(a);
		int mod = 1000000007;
		// fix one side and then find others or you can say how many triangles
		// are possible with ith side
		for (int i = 0; i < a.size() - 2; i++) {
			int k = i + 2;
			// now fix second side
			for (int j = i + 1; j < a.size(); ++j) {
				// find the rightmost point which satisfies the triangle
				// formation condtiion
				while (k < a.size() && a.get(i) + a.get(j) > a.get(k))
					++k;
				if (k > j)
					c = (c % mod + (k - j - 1) % mod) % mod;
			}
		}
		return c;
	}

	public int nTriang(ArrayList<Integer> A) {

		Collections.sort(A);

		if (A.size() < 3) {
			return 0;
		} else if (A.size() == 3 && A.get(0) + A.get(1) > A.get(2)) {
			return 1;
		}

		int count = 0;
		int start = 0;
		while (start < A.size() - 2) {
			int hook = start + 1;
			int counter = hook + 1;
			while (counter < A.size() && hook < counter) {
				if (A.get(start) + A.get(hook) > A.get(counter)) {
					count++;
					counter++;
				} else {
					hook++;
					counter = hook + 1;
				}

				if (counter == A.size() && hook < counter) {
					hook++;
					counter--;
				}

				if (hook == counter) {
					counter++;
				}
			}

			start++;

		}

		return count;
	}
}
