package download.dsalgo.problems;

import java.util.Arrays;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Input : k = 3
 * 
 * Return : [1,3,3,1] NOTE : k is 0 based. k = 0, corresponds to the row [1].
 * 
 * @author kaussark
 *
 */
public class Problem13 {

	public static void main(String[] args) {
		Problem13 problem = new Problem13();
		int[] row = problem.getRowUsingFact(5);
		System.out.println(Arrays.toString(row));
	}

	public int[] getRowUsingFact(int num) {
		int[] row = new int[num + 1];
		row[0] = 1;
		for (int i = 1; i <= num; i++) {
			row[i] = (num-i+1)*row[i-1]/i;
		}

		return row;
	}

	public int[] getRow(int num) {
		int[] row = new int[num + 1];
		row[0] = 1;
		int[] prev = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			int j = 1;
			row[i] = 1;
			while (j < i) {
				row[j] = prev[j - 1] + prev[j];
				j++;
			}
			prev = row.clone();

		}

		return row;
	}
}
