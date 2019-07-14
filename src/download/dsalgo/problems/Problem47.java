package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {

	public static void main(String[] args) {
		Problem47 problem = new Problem47();
		Integer[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		for (Integer[] row : matrix) {
			input.add(new ArrayList<>(Arrays.asList(row)));
		}

		System.out.println(problem.searchMatrix(input, 19));

	}

	public int _searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		if (a.size() < 1)
			return 0;

		int yLength = a.get(0).size();

		int max = (a.size() * yLength) - 1;
		int min = 0;
		int mid;
		int x;
		int y;
		while (min <= max) {
			mid = min + ((max - min) / 2);
			x = mid / yLength;
			y = mid % yLength;
			if (a.get(x).get(y) == b) {
				return 1;
			} else if (a.get(x).get(y) > b) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return 0;

	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int rowNum = inRange(a, b);
		if (rowNum < 0 || rowNum > a.size()) {
			return 0;
		}
		int colLength = a.get(rowNum).size() - 1;
		int min = 0;
		int max = colLength;
		while (min <= max) {
			int mid = min + ((max - min) / 2);
			if (b > a.get(rowNum).get(mid)) {
				min = mid + 1;
			} else if (b < a.get(rowNum).get(mid)) {
				max = mid - 1;
			} else {
				return 1;
			}
		}

		return 0;
	}

	private int inRange(List<? extends List<Integer>> matrix, int b) {

		int min = 0;
		int max = matrix.size() - 1;

		while (min <= max) {
			int midRow = min + ((max - min) / 2);
			int colLength = matrix.get(midRow).size() - 1;
			// if B is smaller than first element move up
			if (b < matrix.get(midRow).get(0)) {
				max = midRow - 1;
			} else if (b > matrix.get(midRow).get(colLength)) {
				min = midRow + 1;
			} else {
				return midRow;
			}
		}

		return -1;
	}
}
