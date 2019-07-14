package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of N integers, find the pair of integers in the array which
 * have minimum XOR value. Report the minimum XOR value.
 * 
 * Examples : Input 0 2 5 7 Output 2 (0 XOR 2) Input 0 4 7 9 Output 3 (4 XOR 7)
 * 
 * Constraints: 2 <= N <= 100 000 0 <= A[i] <= 1 000 000 000
 * 
 * @author kaussark
 *
 */
public class Problem71 {

	public static void main(String[] args) {
		Problem71 problem = new Problem71();
		Integer[] array = {12, 4, 6, 2 };
		System.out.println(problem.findMinXor(new ArrayList<>(Arrays.asList(array))));
	}
	public int findMinXor(ArrayList<Integer> A) {
		int min = Integer.MAX_VALUE;
		Collections.sort(A);
		for(int i =0; i < A.size()-1;i++) {
			min = Math.min(min, A.get(i)^A.get(i+1));
		}
		
		return min;
    }
}
