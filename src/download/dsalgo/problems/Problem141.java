package download.dsalgo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Max Heap is a special kind of complete binary tree in which for every node
 * the value present in that node is greater than the value present in it’s
 * children nodes. If you want to know more about Heaps, please visit this link
 * 
 * So now the problem statement for this question is:
 * 
 * How many distinct Max Heap can be made from n distinct integers
 * 
 * In short, you have to ensure the following properties for the max heap :
 * 
 * Heap has to be a complete binary tree ( A complete binary tree is a binary
 * tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible. ) Every node is greater than all
 * its children Let us take an example of 4 distinct integers. Without loss of
 * generality let us take 1 2 3 4 as our 4 distinct integers
 * 
 * Following are the possible max heaps from these 4 numbers :
 * 
 * 4 / \ 3 2 / 1 4 / \ 2 3 / 1 4 / \ 3 1 / 2 These are the only possible 3
 * distinct max heaps possible for 4 distinct elements.
 * 
 * Implement the below function to return the number of distinct Max Heaps that
 * is possible from n distinct elements.
 * 
 * As the final answer can be very large output your answer modulo 1000000007
 * 
 * Input Constraints : n <= 100
 * 
 * NOTE: Note that even though constraints are mentioned for this problem, for
 * most problems on InterviewBit, constraints are intentionally left out. In
 * real interviews, the interviewer might not disclose constraints and ask you
 * to do the best you can do.
 * 
 * @author kaussark
 *
 */
public class Problem141 {

	public static void main(String[] args) {

		System.out.println(new Problem141().solve(4));
	}
	HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
    long MOD = 1000000007l;
    long[][] nck = new long[101][101];
    int pow2[] = new int[11];
    
    public int _solve(int A) {
        for (int i=1; i<101; i++) {
            nck[i][0] = 1l;
            nck[i][i] = 1l;
        }
        for (int i=2; i<101; i++) {
            for (int j=1; j<i; j++) {
                nck[i][j] = (nck[i-1][j-1] + nck[i-1][j])%MOD;
            }
        }
        pow2[0] = 1;
        for (int i=1; i<11; i++) {
            pow2[i] = 2*pow2[i-1];
        }

        memo.put(0, 1l);
        memo.put(1, 1l);
        memo.put(2, 1l);
        memo.put(3, 2l);
        memo.put(4, 3l);
        return ((int)findSol(A));
    }
    
    public int findHeight(int n) {
        int h = 0;
        while(n!=0) {
            n=n/2;
            h++;
        }
        return h;
    }
    
    public int findLeftTreeElements(int n) {
        int h = findHeight(n);
        return pow2[h-2]-1 + Math.min(n+1-pow2[h-1], pow2[h-2]);
        // number of elements in left tree up to height h-1 = pow2[h-2]-1;
        // elements remaining for last row = n-(pow2[h-1]-1).
    }
    
    public long findSol(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        ////////// solve //////////
        int leftTreeElements = findLeftTreeElements(n);
        long solution = (nck[n-1][leftTreeElements])%MOD;
        solution = (solution*findSol(leftTreeElements))%MOD;
        solution = (solution*findSol(n-1-leftTreeElements))%MOD;
        ///////////////////////////
        memo.put(n, solution);
        return solution;
    }
	public int solve(int A) {
		Set<Integer[]> heapSet = new HashSet<>();
		Integer[] heap = new Integer[A];
		
		for (int i = 0; i < A; i++) {
			heap[i] = i + 1;
		}

		for (int i = heap.length >> 1; i >= 0; i--) {
			heap = maxHeapify(heap.clone(), i);
		}
		return A;
	}

	private int getLeftChild(int position) {
		return (position << 1) + 1;
	}

	private int getRightChild(int position) {
		return (position + 1) << 1;
	}

	private Integer[] maxHeapify(Integer[] array, int position) {
		int left = getLeftChild(position);
		int right = getRightChild(position);
		int largest = 0;
		while (left < array.length || right < array.length) {
			if (left < array.length && array[left] > array[position]) {
				largest = left;
			} else {
				largest = position;
			}
			if (right < array.length && array[right] > array[largest]) {
				largest = right;
			}

			if (largest != position) {
				swap(array, largest, position);
				left = getLeftChild(largest);
				right = getRightChild(largest);
				position = largest;
			}
		}
		return array;
	}

	private void swap(Integer[] array, int pos1, int pos2) {
		if (pos1 == pos2) {
			return;
		}
		array[pos1] = array[pos1] + array[pos2];
		array[pos2] = array[pos1] - array[pos2];
		array[pos1] = array[pos1] - array[pos2];
	}
}
