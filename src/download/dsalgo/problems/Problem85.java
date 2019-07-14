package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Print concentric rectangular pattern in a 2d matrix. Let us show you some
 * examples to clarify what we mean.
 * 
 * Example 1:
 * 
 * Input: A = 4. Output:
 * 
 * 4 4 4 4 4 4 4 4 3 3 3 3 3 4 4 3 2 2 2 3 4 4 3 2 1 2 3 4 4 3 2 2 2 3 4 4 3 3 3
 * 3 3 4 4 4 4 4 4 4 4 Example 2:
 * 
 * Input: A = 3. Output:
 * 
 * 3 3 3 3 3 3 2 2 2 3 3 2 1 2 3 3 2 2 2 3 3 3 3 3 3 The outermost rectangle is
 * formed by A, then the next outermost is formed by A-1 and so on.
 * 
 * You will be given A as an argument to the function you need to implement, and
 * you need to return a 2D array.
 * 
 * @author kaussark
 *
 */
public class Problem85 {

	public static void main(String[] args) {
		System.out.println(new Problem85().prettyPrint(3));
	}

	public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		
		Integer[][] matrix = new Integer[2*A-1][2*A-1];
		ArrayList<ArrayList<Integer>> pretty = new ArrayList<>();
		
		int counter = A;
		while (counter > 0) {
			int length = (A+ counter) - 1;
			int row = A - counter;
			int col = A - counter;
			// traverse n-cth row till cols
			while (col < length) {
				matrix[row][col] =  counter;
				col++;
			}
			col--;
			row++;
			// traverse nth column till length
			while (row < length) {
				matrix[row][col] =  counter;
				row++;
			}
			row--;
			col--;
			// traverse nth row
			while (col >= A - counter) {
				matrix[row][col] =  counter;
				col--;
			}
			col++;
			row--;
			//traverse n-cth row
			while(row > A - counter) {
				matrix[row][col] =  counter;
				row--;
			}

			counter--;
			
		}

		for(Integer[] i : matrix) {
			pretty.add(new ArrayList<>(Arrays.asList(i)));
		}
		
		return pretty;
	}
}
