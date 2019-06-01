package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        MergeSort merge = new MergeSort();
        int arr[] = { 3, 48, 29, 1, 15, 7 , 77};
        int low = 0;
        int high = arr.length - 1;
        merge.divide(arr, high, low);
        System.out.println(Arrays.toString(arr));
    }

    public void divide(int[] arr, int high, int low) {
        if (low < high) {
            int middle = (low + high + 1) / 2;
            divide(arr, middle - 1, low);// left side
            divide(arr, high, middle);// right side
            merge(arr, low, high, middle);
        }
    }

    public void merge(int[] arr, int l, int h, int m) {
        int temp[] = new int[h - l + 1];
        for (int i = 0; i < temp.length; i++) { // copying array to temp array
            temp[i] = arr[l + i];
        }
        int low = 0;
        int high = temp.length;
        int mid = (low + high) / 2;
        int middle = mid;
        int counter = 0;
        while (low < middle && mid < high) { // loop till low comes to mid || mid reaches high
            if (temp[low] < temp[mid]) {
                arr[l + counter++] = temp[low++];
            } else {
                arr[l + counter++] = temp[mid++];
            }
        }
        while (low < middle) { //Add anything remaining below middle
            arr[l + counter++] = temp[low++];
        }
        while (mid < high) { // Add anything remaining post middle
            arr[l + counter++] = temp[mid++];
        }
    }

    // 0000,1,5,7,3,8,9,00000
}
