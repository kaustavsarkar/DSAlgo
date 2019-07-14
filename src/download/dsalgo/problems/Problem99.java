package download.dsalgo.problems;

/**
 * Given a singly linked list
 * 
 * L: L0 → L1 → … → Ln-1 → Ln, reorder it to:
 * 
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … You must do this in-place without
 * altering the nodes’ values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author kaussark
 *
 */
public class Problem99 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);

		ListNode reordered = new Problem99().reorderList(node);
		reordered.print();
	}

	public ListNode reorderList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode mid = getMid(A);
		ListNode nextToMid = mid.next;

		mid.next = null;
		ListNode aCounter = A;
		ListNode right = nextToMid;
		right = reverseList(right);
		ListNode temp = right;
		while (right != null && aCounter != null) {
			temp = right.next;
			right.next = aCounter.next;
			aCounter.next = right;
			right = temp;
			aCounter = aCounter.next.next;
		}

		return A;
	}

	private ListNode reverseList(ListNode list) {
		ListNode prev = null;
		ListNode curr = list;
		ListNode next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		list = prev;
		return list;
	}
	
	private ListNode getMid(ListNode a) {
		if (a == null) {
			return a;
		}
		ListNode slow = a;
		ListNode fast = a.next;
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
