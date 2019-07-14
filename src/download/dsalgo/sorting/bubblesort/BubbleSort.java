package download.dsalgo.sorting.bubblesort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {5 ,1, 4, 2, 8,10000,0};
		
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	public int[] bubbleSort(int[] arr) {

		int l = arr.length;

		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}

		}

		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int a = arr[i];
		arr[i] = a + arr[j];
		arr[j] = a;
		arr[i] = arr[i] - arr[j];
	}
}
