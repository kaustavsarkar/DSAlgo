package download.dsalgo.green.search;

public class BinarySearch {

	public static void main(String[] args) {
	}

	public int binarySearch(int[] array, int number) {

		int start = 0;
		int end = array.length;
		int mid;

		while (start <= end) {
			mid = (start + end) >> 1;
			if (number > array[mid]) {
				start = mid + 1;
			} else if (number < array[mid]) {
				end = mid;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
