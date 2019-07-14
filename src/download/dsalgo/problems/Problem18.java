package download.dsalgo.problems;

import java.util.Arrays;

public class Problem18 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4 };
		Problem18 problem = new Problem18();
		int[] wave = problem.wave(array);
		System.out.println(Arrays.toString(wave));
	}

	public int[] wave(int[] A) {

		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i++) {
			swap(i,++i,A);
		}

		return A;
	}

	private void swap(int i, int j, int[] arr) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}
