package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…,
 * AN-1. Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending
 * order) that sub array, then the whole array should get sorted. If A is
 * already sorted, output -1.
 * 
 * Example :
 * 
 * Input 1:
 * 
 * A = [1, 3, 2, 4, 5]
 * 
 * Return: [1, 2]
 * 
 * Input 2:
 * 
 * A = [1, 2, 3, 4, 5]
 * 
 * Return: [-1]
 * 
 * @author kaussark
 *
 */
public class Problem21 {
	public static void main(String[] args) {
		Integer[] array = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15}; 
			//{1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
				//{1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19}; 
			//{ 1, 1, 1, 1, 1 };
		// { 1, 3, 2, 4, 5 };
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(array));

		Problem21 problem = new Problem21();
		List<Integer> indices = problem.subUnsort(A);
		System.out.println(indices);
	}

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		ArrayList<Integer> indices = new ArrayList<>();
		int start = -1;
		int end = 0;
		//Check interim start and end
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i - 1) > A.get(i)) {
				if (start > -1) {
					start = Math.min(start, i - 1);
				} else {
					start = i - 1;
				}
				end = i;
				swap(i - 1, i, A);
			}
		}
		
		//check if there is larger element to left of start
		for (int i = 0; i < start; i++) {
			if(A.get(i) >= A.get(start)) {
				start = i;
			}
		}
		
		

		if (start > -1) {
			indices.add(start);
			indices.add(end);
		} else {
			indices.add(-1);
		}
		return indices;
	}

	private void swap(int i, int i2, ArrayList<Integer> a) {
		int temp = a.get(i);
		int temp2 = a.get(i2);
		a.remove(i);
		a.add(i, temp2);
		a.remove(i2);

		a.add(i2, temp);
	}
}
