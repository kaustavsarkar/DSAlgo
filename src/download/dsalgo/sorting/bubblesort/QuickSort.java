package download.dsalgo.sorting.bubblesort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 14, 7, 3, 12, 9, 11, 6, 2, 8 };
		QuickSort qs = new QuickSort();

		//qs.quickSort(array, 0, array.length - 1);//[2, 3, 6, 7, 8, 9, 11, 12, 14]
		qs.randQuickSort(array, 0, array.length-1);//[2, 3, 6, 7, 8, 9, 11, 12, 14]

		System.out.println(Arrays.toString(array)); 
	}

	public void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}
	
	public void randQuickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = randomPartition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	public int randomPartition(int[] array, int left, int right) {
		int randPivot = ThreadLocalRandom.current().nextInt(left, right + 1);
		swap(array, right, randPivot);
		return partition(array, left, right);
	}

	public int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int hook = left - 1;
		for (int counter = left; counter < right; counter++) {
			if (array[counter] < pivot) {
				hook++;
				swap(array, hook, counter);
			}
		}
		swap(array, ++hook, right);
		return hook;
	}

	public void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		array[i] += array[j];
		array[j] = array[i] - array[j];
		array[i] -= array[j];
	}

}
