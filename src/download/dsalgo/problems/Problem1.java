package download.dsalgo.problems;

import java.util.Arrays;

//import download.dsalgo.bubblesort.BubbleSort;

/**
 * Write an efficient program for printing k largest elements in an array.
 * Elements in array can be in any order.
 * 
 * @author kaussark
 *
 */
public class Problem1 {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 23, 12, 9, 30, 2, 50 };
		
		// Using bubble sort
		Problem1 p1 = new Problem1();
		p1.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public void bubbleSort(int[] arr) {

		for (int i = 0; i < 3; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}
		}

		return;
	}

	private void swap(int[] arr, int i, int j) {
		int a = arr[i];
		arr[i] = a + arr[j];
		arr[j] = a;
		arr[i] = arr[i] - a;

	}

}
