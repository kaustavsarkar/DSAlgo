package download.dsalgo.problems;

import java.util.*;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product. Return an integer corresponding to the maximum
 * product possible.
 * 
 * Example :
 * 
 * Input : [2, 3, -2, 4] Return : 6
 * 
 * Possible with [2, 3]
 * 
 * @author kaussark
 *
 */
public class Problem204 {	

	public static void main(String[] args) {
	}

	public int maxProduct(final List<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return A.get(0);
		}
		int maxProd = 1;
		int prevMaxProd = 1;
		int prevMinProd = 1;
		boolean flag = false;
		
		for(int index = 0; index < A.size(); index++) {
			
			if(A.get(index) > 0) {
				prevMaxProd *= A.get(index);
				prevMinProd = Math.min(prevMinProd*A.get(index), 1);
				flag = !flag;
			} else if(A.get(index)==0) {
				prevMaxProd = 1;
				prevMinProd = 1;
			} else {
				int temp = prevMaxProd;
				prevMaxProd = Math.max(prevMinProd*A.get(index), 1);
				prevMinProd = temp*A.get(index);
			}
			maxProd = Math.max(prevMaxProd, maxProd);
			
		}
		if(!flag && maxProd == 1) {
			return 0;
		}
		
		return maxProd;
	}
}
