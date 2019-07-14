package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. The subsets must be sorted
 * lexicographically. Example : If S = [1,2,2], the solution is:
 * 
 * [ [], [1], [1,2], [1,2,2], [2], [2, 2] ]
 * 
 * @author kaussark
 *
 */
public class Problem120 {
	HashSet<ArrayList<Integer>> map = new HashSet<>();
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		Integer[] array = { 6, 6, 3, 3, 6, 5 };
		// { 1, 2, 2, 3, 3 };
		System.out.println(Arrays.toString(array));
		System.out.println(new Problem120()
				.subsetsWithDup(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<ArrayList<Integer>> _subsetsWithDup(ArrayList<Integer> A) {
		Collections.sort(A);
		solve(0, new ArrayList<Integer>(), A);
		return res;
	}

	private void solve(int index, ArrayList<Integer> cur,
			ArrayList<Integer> A) {
		if (!map.contains(cur)) {
			map.add(cur);
			res.add(new ArrayList<Integer>(cur));
		}

		for (int i = index; i < A.size(); i++) {
			cur.add(A.get(i));
			solve(i + 1, cur, A);
			cur.remove(A.get(i));
		}
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		result.add(new ArrayList<>());
		if (A.isEmpty()) {
			return result;
		}
		Collections.sort(A);
		System.out.println(A);
		for (int i = 0; i < A.size(); i++)
			genSubSets(result, new ArrayList<>(), i, A);

		return result;
	}

	public void genSubSets(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> subset, int index, ArrayList<Integer> A) {
		if (index >= A.size()) {
			return;
		}

		for (int i = index; i < A.size(); i++) {
			subset.add(A.get(i));
			if (!result.contains(subset)) {
				result.add((ArrayList<Integer>) subset.clone());
			}
			genSubSets(result, subset, index + 1, A);
			return;
		}
	}
}
