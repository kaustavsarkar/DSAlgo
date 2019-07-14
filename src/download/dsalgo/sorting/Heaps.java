package download.dsalgo.sorting;

import java.util.Arrays;

import download.dsalgo.problems.Problem17;

public class Heaps {

	public static void main(String[] args) {
		int[] array =
				// { 980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838,
				// 923, 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369,
				// 515,
				// 722, 302, 496, 124, 692, 993, 341, 785, 400, 113, 302, 563,
				// 121,
				// 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684,
				// 365,
				// 470, 176, 910, 204, 324, 657, 161, 884, 623, 814, 231, 694,
				// 399,
				// 126, 426 };
				{ 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Heaps heaps = new Heaps();
		heaps.buildMaxHeap(array);
		System.out.println(Arrays.toString(array));
	}

	public void buildMaxHeap(int[] array) {
		for (int i = array.length >> 1; i >= 0; i--) {
			// maxHeapify(array, i); //[12, 11, 7, 9, 10, 6, 1, 8, 4, 2, 5, 3]
			maxHeapIt(array, i);//[12, 10, 11, 8, 9, 5, 6, 7, 3, 1, 4, 2, 0]
		}
	}

	public void maxHeapIt(int[] array, int i) {
		int largest = i;
		int left = left(largest);
		int right = right(largest);

		while ((left < array.length && array[i] < array[left])
				|| (right < array.length && array[i] < array[right])) {
			if (left < array.length && array[left] > array[i]) {
				largest = left;
			} else {
				largest = i;
			}

			if (right < array.length && array[right] > array[largest]) {
				largest = right;
			}

			if (largest != i) {
				swap(i, largest, array);
				left = left(largest);
				right = right(largest);
				i = largest;
			}
		}
	}

	public void maxHeapify(int[] array, int i) {
		int left = left(i);
		int right = right(i);
		int largest = 0;
		if (left < array.length && array[left] > array[i]) {
			largest = left;
		} else {
			largest = i;
		}
		if (right < array.length && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(i, largest, array);
			maxHeapify(array, largest);
		}

	}

	public int left(int i) {
		return (i << 1) + 1;
	}

	public int right(int i) {
		return (i + 1) << 1;
	}

	public int parent(int i) {
		return (i - 1) >> 1;
	}

	private void swap(int i, int j, int[] array) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}
}
