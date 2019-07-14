package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * R in other words, Given 2 sorted arrays, find all the elements which occur in
 * both the arrays.
 * 
 * Example :
 * 
 * Input : A : [1 2 3 3 4 5 6] B : [3 3 5]
 * 
 * Output : [3 3 5]
 * 
 * Input : A : [1 2 3 3 4 5 6] B : [3 5]
 * 
 * Output : [3 5] NOTE : For the purpose of this problem ( as also conveyed by
 * the sample case ), assume that elements that appear more than once in both
 * arrays should be included multiple times in the final output.
 * 
 * @author kaussark
 *
 */
public class Problem78 {

	public static void main(String[] args) {
		Integer[] a = { 10000000 };
		Integer[] b = { 10000000 };
		System.out.println(
				new Problem78().intersect(Arrays.asList(a), Arrays.asList(b)));
	}

	public ArrayList<Integer> intersect(final List<Integer> A,
			final List<Integer> B) {
		ArrayList<Integer> list = new ArrayList<>();
		int acounter = 0;
		int bcounter = 0;

		while (acounter < A.size() && bcounter < B.size()) {
			if (A.get(acounter).compareTo(B.get(bcounter)) == 0) {
				list.add(A.get(acounter));
				acounter++;
				bcounter++;

			} else if (A.get(acounter).compareTo(B.get(bcounter)) < 0) {
				acounter++;
			} else {
				bcounter++;
			}
		}

		return list;
	}
}
