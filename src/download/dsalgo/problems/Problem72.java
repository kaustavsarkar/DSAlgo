package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * Example :
 * 
 * Input : [1 2 2 3 1] Output : 3
 * 
 * @author kaussark
 *
 */
public class Problem72 {

	public static void main(String[] args) {
		Integer[] array = {1, 2, 2 ,3, 3};
		Problem72 problem = new Problem72();
		System.out.println(problem.singleNumber(new ArrayList<>(Arrays.asList(array))));
		
	}

	public int singleNumber(final List<Integer> A) {
		if(A.size() == 1) {
			return A.get(0);
		}
		Collections.sort(A);
		for (int i = 0; i < A.size(); i++) {
			int num1 = i;
			int num2 = ++i;
			if(num2 == A.size()) {
				num2 = i-2;
			}
			if((A.get(num1)^A.get(num2)) != 0) {
				return A.get(num1);
			}
		}
		return 0;
	}
}
