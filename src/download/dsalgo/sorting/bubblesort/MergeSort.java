package download.dsalgo.sorting.bubblesort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		System.out.println(6 >>> 1);
		
		int[] array = { 14, 7, 3, 12, 9, 11, 6, 2 };
		MergeSort ms = new MergeSort();

		ms.mergeSort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(array));
		
	}

	public void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) >> 1;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, end);
		}
	}

	public void merge(int[] array, int start, int end) {
		int mid = (start + end) >> 1;
		int middle = mid + 1;
		int[] temp = new int[end - start + 1];
		int init = start, counter = 0;
		while (init <= mid && middle <= end) {
			if (array[init] < array[middle]) {
				temp[counter++] = array[init++];
			} else {
				temp[counter++] = array[middle++];
			}
		}

		while (init <= mid) {
			temp[counter++] = array[init++];
		}

		while (middle <= end) {
			temp[counter++] = array[middle++];
		}

		for (int i = 0; i < temp.length; i++) {
			array[start + i] = temp[i];
		}
	}

	public void swap(int[] array, int i, int j) {
		array[i] += array[j];
		array[j] = array[i] - array[j];
		array[i] -= array[j];
	}

}
