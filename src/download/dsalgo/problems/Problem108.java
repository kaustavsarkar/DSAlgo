package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i]
 * in the array such that the element has an index smaller than i.
 * 
 * More formally,
 * 
 * G[i] for an element A[i] = an element A[j] such that j is maximum possible
 * AND j < i AND A[j] < A[i] Elements for which no smaller element exist,
 * consider next smaller element as -1.
 * 
 * Example:
 * 
 * Input : A : [4, 5, 2, 10, 8] Return : [-1, 4, -1, 2, 2]
 * 
 * Example 2:
 * 
 * Input : A : [3, 2, 1] Return : [-1, -1, -1]
 * 
 * @author kaussark
 *
 */
public class Problem108 {

	public static void main(String[] args) {
		Integer[] array = { 39, 27, 11, 4, 24, 32, 32, 28, 8, 1 };
		System.out.println(new Problem108()
				.prevSmaller(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

		ArrayList<Integer> prevSmall = new ArrayList<>();
		prevSmall.add(-1);
		Stack<Integer> mins = new Stack<>();
		if (A.size() == 0 || A.size() == 1) {
			return prevSmall;
		}
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > A.get(i - 1)) {
				prevSmall.add(A.get(i - 1));
				mins.push(A.get(i - 1));
			} else if (A.get(i) <= A.get(i - 1)) {
				while (!mins.isEmpty() && mins.peek() >= A.get(i)) {
					mins.pop();
				}
				if (mins.isEmpty()) {
					prevSmall.add(-1);
				} else {
					prevSmall.add(mins.peek());
				}
				
				mins.push(A.get(i));
			}
		}

		return prevSmall;
	}
}
