package download.dsalgo.problems;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example :
 * 
 * Input : 1 -> 5 -> 4 -> 3
 * 
 * Returned list : 1 -> 3 -> 4 -> 5
 * 
 * @author kaussark
 *
 */
public class Problem98 {

	public static void main(String[] args) {
		ListNode node = new ListNode(5);
		node.next = new ListNode(4);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(1);
		
		ListNode sorted = new Problem98().sortList(node);
		sorted.print();
	}

	public ListNode sortList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}

		ListNode mid = getMid(A);
		ListNode nextMid = mid.next;
		mid.next = null;

		ListNode leftNode = sortList(A);
		ListNode rightNode = sortList(nextMid);

		ListNode sorted = mergeSort(leftNode, rightNode);

		return sorted;
	}

	private ListNode mergeSort(ListNode leftNode, ListNode rightNode) {
		if (leftNode == null) {
			return rightNode;
		}

		if (rightNode == null) {
			return leftNode;
		}

		ListNode result = null;
		ListNode resultPointer = null;

		while (leftNode != null && rightNode != null) {
			int num1 = leftNode.val;
			int num2 = rightNode.val;

			if (num1 < num2) {
				if (result == null) {
					result = leftNode;
					resultPointer = result;
				} else {
					resultPointer.next = leftNode;
					resultPointer = resultPointer.next;
				}

				leftNode = leftNode.next;
			} else {
				if (result == null) {
					result = rightNode;
					resultPointer = result;
				} else {
					resultPointer.next = rightNode;
					resultPointer = resultPointer.next;
				}

				rightNode = rightNode.next;
			}
		}
		
		
		while (rightNode != null) {
			resultPointer.next = rightNode;
			resultPointer = resultPointer.next;
			rightNode = rightNode.next;
		}

		while (leftNode != null) {
			resultPointer.next = leftNode;
			resultPointer = resultPointer.next;
			leftNode = leftNode.next;
		}

		return result;
	}

	private ListNode getMid(ListNode a) {
		if (a == null) {
			return a;
		}
		ListNode fast = a.next;
		ListNode slow = a;

		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}
}
