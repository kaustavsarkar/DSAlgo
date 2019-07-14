package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Sample Input :
 * 
 * (1, 1) (2, 2) Sample Output :
 * 
 * 2 You will be given 2 arrays X and Y. Each point is represented by (X[i],
 * Y[i])
 * 
 * @author kaussark
 *
 */
public class Problem137 {

	public static void main(String[] args) {
		Integer[] x = { 0, 0, 1 };
		// { 1, 1 };
		Integer[] y = { 1, -1, -1 };
		// { 2, 2 };
		System.out.println(
				new Problem137().maxPoints(new ArrayList<>(Arrays.asList(x)),
						new ArrayList<>(Arrays.asList(y))));
	}

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a.isEmpty() || b.isEmpty()) {
			return 0;
		}
		if (a.size() == 1 && b.size() == 1) {
			return 1;
		}
		int maxRow = 0;
		int maxCol = 0;
		int maxPoint = 0;
		int first = 0;
		int second = 0;

		// Check for max similar across X
		ArrayList<Integer> temp = (ArrayList<Integer>) a.clone();
		Collections.sort(temp);
		while (second < temp.size()) {
			second = first + 1;
			while (second < temp.size()
					&& temp.get(first).compareTo(temp.get(second)) == 0) {
				second++;
			}
			maxRow = Math.max(maxRow, second - first);
			first = second;
		}

		// check for max similar across y
		temp.clear();
		first = 0;
		second = 0;
		temp = (ArrayList<Integer>) b.clone();
		Collections.sort(temp);
		while (second < temp.size()) {
			second = first + 1;
			while (second < temp.size()
					&& temp.get(first).compareTo(temp.get(second)) == 0) {
				second++;
			}
			maxCol = Math.max(maxCol, second - first);
			first = second;
		}
		maxPoint = Math.max(maxCol, maxRow);
		// Check along slope
		temp.clear();
		// add x-y in temp
		for (int i = 0; i < a.size(); i++) {
			temp.add(a.get(i) - b.get(i));
		}
		Collections.sort(temp);

		first = 0;
		second = 0;
		while (second < temp.size()) {
			second = first + 1;
			while (second < temp.size()
					&& temp.get(first).compareTo(temp.get(second)) == 0) {
				second++;
			}
			maxCol = Math.max(maxPoint, second - first);
			first = second;
		}

		return maxPoint;
	}
}
