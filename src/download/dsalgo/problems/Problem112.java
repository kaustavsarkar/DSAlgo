package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. Also, the subsets should be sorted in
 * ascending ( lexicographic ) order. The list is not necessarily sorted.
 * Example :
 * 
 * If S = [1,2,3], a solution is:
 * 
 * [ [], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], ]
 * 
 * @author kaussark
 *
 */
public class Problem112 {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3 };
		System.out.println(new Problem112().subsets(new ArrayList<>(Arrays.asList(array))));
	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add(new ArrayList<Integer>());
		if (a.size() == 0)
			return output;
		Collections.sort(a);
		generate(a, output, new ArrayList<Integer>(), 0);
		return output;
	}

	public void generate(ArrayList<Integer> a,
			ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp,
			int index) {
		for (int i = index; i < a.size(); i++) {
			temp.add(a.get(i));
			output.add(new ArrayList<Integer>(temp));
			generate(a, output, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
