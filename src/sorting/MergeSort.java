package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        MergeSort merge = new MergeSort();
        int arr[] = { 3, 8, 9, 1, 5, 7  };
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high + 1) / 2;
        merge.merge(arr, low, high, mid);

    }

    // 0000,1,5,7,3,8,9,00000
    public void merge(int arr[], int l, int h, int m) {
        if (h <= l || h <= m) {
            return;
        }
        // Copy Array to temp
        int temp[] = new int[h - l + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[l + i];
        }

        int low = 0;
        int high = temp.length-1;
        int mid = (low + high + 1) / 2;
        int counter = 0;
        //Compare both sides of array
        while (low < m && mid < h) {
            if (temp[low] < temp[mid]) {
                arr[l+counter] = temp[low];
                low++;
            } else {
                arr[l+counter] = temp[mid];
                mid++;
            }
            counter++;
        }
        //Add if remaining values in left
        while(low < m) {
            arr[l+counter] = temp[low];
            low++;
            counter++;
        }
        //Add if remaining values in right
        while(mid < h) {
            arr[l+counter] = temp[mid];
            mid++;
            counter++;
        }
    }
}
