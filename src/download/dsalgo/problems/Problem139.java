package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two arrays A & B of size N each. Find the maximum N elements from the
 * sum combinations (Ai + Bj) formed from elements in array A and B.
 * 
 * For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 ,
 * 1+4=5 , 2+3=5 , 2+4=6 and maximum 2 elements are 6, 5
 * 
 * Example:
 * 
 * N = 4 a[]={1,4,2,3} b[]={2,5,1,6}
 * 
 * Maximum 4 elements of combinations sum are 10 (4+6), 9 (3+6), 9 (4+5), 8
 * (2+6)
 * 
 * @author kaussark
 *
 */
public class Problem139 {

	public static void main(String[] args) {
		Integer[] lis1 = { 3, 2, 4, 2 };
		Integer[] lis2 = { 4, 3, 1, 2 };

		System.out.println(
				new Problem139().solve(new ArrayList<>(Arrays.asList(lis1)),
						new ArrayList<>(Arrays.asList(lis2))));
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A,
			ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A.isEmpty() || B.isEmpty()) {
			return result;
		}
		if (A.size() == 1) {
			result.add(A.get(0) + B.get(0));
			return result;
		}
		int size = A.size();
		MaxHeap heap = new MaxHeap(size * size);
		for (int numA : A) {
			for (int numB : B) {
				int sum = numA + numB;
				heap.insert(sum);
			}
		}
		int counter = 0;
		while (counter < size) {
			result.add(heap.extractMax());
			counter++;
		}

		return result;
	}
}
