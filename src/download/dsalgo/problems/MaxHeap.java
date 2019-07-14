package download.dsalgo.problems;

import java.util.Arrays;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int maxSize;

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		heap = new int[maxSize];
		size = 0;
	}

	private int getParent(int position) {
		return (position - 1) >> 1;
	}

	private int getLeftChild(int position) {
		return (position << 1) + 1;
	}

	private int getRightChild(int position) {
		return (position + 1) << 1;
	}

	private boolean isLeaf(int position) {
		return (position <= size && (getLeftChild(position) > size
				|| getRightChild(position) > size));
	}

	private void maxHeapify(int pos) {

		int left = getLeftChild(pos);
		int right = getRightChild(pos);
		int largest = 0;
		if (left < maxSize && heap[left] > heap[pos]) {
			largest = left;
		} else {
			largest = pos;
		}

		if (right < maxSize && heap[right] > heap[largest]) {
			largest = right;
		}
		if (largest != pos) {
			swap(largest, pos);
			maxHeapify(largest);
		}
	}

	public void insert(int element) {
		int current = size;
		heap[size++] = element;
		
		size = Math.min(maxSize, size);
		while (current > 0 && current < maxSize
				&& heap[current] > heap[getParent(current)]) {
			swap(current, getParent(current));
			current = getParent(current);
		}
	}

	public int extractMax() {
		int popped = heap[0];
		heap[0] = Integer.MIN_VALUE;
		--size;
		maxHeapify(0);
		return popped;
	}

	public int getMax() {
		return heap[0];
	}

	public int getSize() {
		return size;
	}

	private void swap(int pos1, int pos2) {
		if (pos1 == pos2) {
			return;
		}
		heap[pos1] = heap[pos1] + heap[pos2];
		heap[pos2] = heap[pos1] - heap[pos2];
		heap[pos1] = heap[pos1] - heap[pos2];
	}
	
	public String toString() {
		return Arrays.toString(heap);
	}
}
