package download.dsalgo.problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * You need to do this in place.
 * 
 * Note that if you end up using an additional array, you will only receive
 * partial score.
 * 
 * Example:
 * 
 * If the array is
 * 
 * [ [1, 2], [3, 4] ] Then the rotated array becomes:
 * 
 * [ [3, 1], [4, 2] ]
 * 
 * @author kaussark
 *
 */
public class Problem24 {

	public static void main(String[] args) {
		Integer[][] array = { { 1, 2 }, { 3, 4 } };
		Problem24 problem = new Problem24();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(array[i]));
			matrix.add(temp);
		}

		System.out.println(matrix);

		problem.rotate(matrix);

		System.out.println(matrix);
	}

	public void rotate(ArrayList<ArrayList<Integer>> a) {
		if (a.size() < 2) {
			return;
		}
		int length = a.size();
		// Layer loop
		for (int x = 0; x < length >> 1; x++) {
			for (int y = x; y < length-1-x; y++) {
				int temp = a.get(x).get(y);

				// Moving left to top
				a.get(length - 1 - y).get(x);
				a.get(x).add(y, a.get(length - 1 - y).get(x));
				a.get(x).remove(y + 1);

				// Moving bottom to left
				a.get(length - 1 - x).get(length - 1 - y);
				a.get(length - 1 - y).add(x,
						a.get(length - 1 - x).get(length - 1 - y));
				a.get(length - 1 - y).remove(x + 1);

				// Moving right to bottom
				a.get(y).get(length - 1 - x);
				a.get(length - 1 - x).add(length - 1 - y,
						a.get(y).get(length - 1 - x));
				a.get(length - 1 - x).remove(length - y);

				// Moving top to right
				a.get(y).add(length - 1 - x, temp);
				a.get(y).remove(length - x);
			}
		}
	}
}
