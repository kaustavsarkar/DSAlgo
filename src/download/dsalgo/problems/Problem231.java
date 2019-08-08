package download.dsalgo.problems;

import java.util.*;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than floor(n/2) times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example :
 * 
 * Input : [2, 1, 2] Return : 2 which occurs 2 times which is greater than 3/2.
 * 
 * @author kaussark
 *
 */
public class Problem231 {

	public static void main(String[] args) {

	}

	public int majorityElement(final List<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return A.get(0);
		}
		Collections.sort(A);
		int median = (A.size()+1) >> 1;
		return A.get(median);
	}
}
