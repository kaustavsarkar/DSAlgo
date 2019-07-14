package download.dsalgo.poc;

import java.util.Arrays;

public class Matrix {

	public static void main(String[] args) {
		int[][] pascal = { { 1 }, { 1, 1 }, { 1, 2, 1 }, { 1, 3, 3, 1 },
				{ 1, 4, 6, 4, 1 } };
		
		for(int[] row  : pascal) {
			System.out.println(Arrays.toString(row));
		}
	}
}
