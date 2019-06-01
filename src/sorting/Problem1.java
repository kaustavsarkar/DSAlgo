package sorting;

import java.util.Arrays;

//k largest(or smallest) elements in an array 
public class Problem1 {

    public static void main(String[] args) {
        int array[] = { 1, 23, 12, 9, 30, 2, 50 };
        Problem1 problem = new Problem1();
        //int arr[] = problem.solFirst(array, 3);
        //System.out.println(Arrays.toString(arr));
        int arr2[] = problem.solTwo(array, 3);
        System.out.println(Arrays.toString(arr2));
    }

    //O(nk)
    public int[] solTwo(int[] array, int k) {
        int largeArray[] = new int[k];
        
        //Do bubble sort k times
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.betterPartialBubbleSort(array, k);
        
        for(int i = 0; i<k;i++) {
            largeArray[i] = array[i];
        }
        
        
        return largeArray;
        
    }
    
    // O(nlogn)
    public int[] solFirst(int[] array, int k) {
        if (k >= array.length) {
            return array;
        }
        int[] elements = new int[k];
        Heap heap = new Heap();
        int[] sorted = heap.maxHeapSort(array);
        for (int i = 0; i < k; i++) {
            elements[i] = sorted[i];
        }
        return elements;
    }
}
