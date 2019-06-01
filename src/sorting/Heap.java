package sorting;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        int[] array = { 17, 16, 3, 0, 13, 10, 1, 5, 7, 12, 4, 8, 9, 27 };
        System.out.println("HEAP SIZE : " + array.length);
        Heap heap = new Heap();
        heap.buildMaxHeap(array); // [27, 16, 17, 7, 13, 10, 3, 5, 0, 12, 4, 8,
                                  // 9, 1]
        heap.buildMinHeap(array); // [0, 4, 1, 5, 12, 8, 3, 16, 7, 17, 13, 10,
                                  // 9, 27]
        array = heap.maxHeapSort(array);
        array = heap.minHeapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] minHeapSort(int[] array) {
        int length = array.length;
        buildMinHeap(array);
        int[] sortedArray = new int[length];

        for (int i = 0; i < length; i++) {
            sortedArray[i] = array[0];
            array[0] = Integer.MAX_VALUE; // Analogous to infinity
            minHeapify(array, 0);
        }

        return sortedArray;
    }

    public int[] maxHeapSort(int[] array) {
        buildMaxHeap(array);
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = array[0];
            array[0] = 0;
            maxHeapify(array, 0);
        }
        return sortedArray;
    }

    public void buildMinHeap(int[] array) {
        int length = array.length;

        for (int i = length / 2; i >= 0; i--) {
            minHeapify(array, i);
        }
    }

    public void buildMaxHeap(int[] array) {
        int length = array.length;

        for (int i = length / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    public void minHeapify(int[] heap, int index) {
        int left = leftChild(heap, index);
        int right = rightChild(heap, index);
        int smallest = 0;

        if (left < heap.length && heap[left] < heap[index]) {
            smallest = left;
        } else {
            smallest = index;
        }

        if (right < heap.length && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(heap, smallest, index);
            minHeapify(heap, smallest);
        }
    }

    public void maxHeapify(int[] heap, int index) {

        int left = leftChild(heap, index);
        int right = rightChild(heap, index);
        int largest = 0;

        if (left < heap.length
                && heap[left] > heap[index]) {
            largest = left;
        } else {
            largest = index;
        }

        if (right < heap.length
                && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(heap, largest, index);
            maxHeapify(heap, largest);
        }

    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public int leftChild(int[] heap, int index) {
        return 2 * index + 1;
    }

    public int rightChild(int[] heap, int index) {
        return 2 * (index + 1);
    }

    public int parent(int[] heap, int index) {
        return (index - 1) / 2;
    }
}
