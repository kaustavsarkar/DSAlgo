package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra
 * space.
 * 
 * Example:
 * 
 * Input : [1, 0] Return : [0, 1]
 * 
 * @author kaussark
 *
 */
public class Problem42 {

	public static void main(String[] args) {
		Problem42 problem = new Problem42();
		Integer[] array = { 6, 4, 3, 2, 5, 1, 7, 0 }; // 7 5 2 3 1 4 0 6
		// {2,1,3,0};
		// { 4, 0, 2, 1, 3 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
		problem.arrange(list);

		System.out.println(list);
	}

	public void arrange(ArrayList<Integer> A) {
		int n = A.size();
		for (int i = 0; i < n; i++) {
			A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n);
		}
		for (int i = 0; i < n; i++) {
			A.set(i, A.get(i) / n);
		}
	}
}
