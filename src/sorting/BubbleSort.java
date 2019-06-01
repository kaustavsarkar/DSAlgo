package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int array[] = { 17, 16, 3, 0, 13, 10, 1, 5, 7, 12, 4, 8, 9, 27 };
        // { 30, 50, 23, 12, 33, 2, 1, 9 };
        BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.bubbleSort(array);

       // bubbleSort.partialMaxBubbleSort(array, 3);

        bubbleSort.betterPartialBubbleSort(array, 12);
        
        System.out.println(Arrays.toString(array));
    }

    public void betterPartialBubbleSort(int[] array, int k) {
        // find pivot
        int length = array.length;
        if (k > length / 2) {
            partialMinBubbleSort(array, length - k);
        } else {
            partialMaxBubbleSort(array, k);
        }
    }

    public void partialMinBubbleSort(int[] arr, int k) {
        int length = arr.length;

        for (int i = length - 1; i > length - 1 - k; i--) {
            int smallest = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
        }

    }

    public void partialMaxBubbleSort(int[] array, int k) {
        int length = array.length;
        for (int i = 0; i < k; i++) {
            int largest = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] > array[largest]) {
                    largest = j;
                }
            }
            swap(array, i, largest);
        }

    }

    public void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];

    }

}
