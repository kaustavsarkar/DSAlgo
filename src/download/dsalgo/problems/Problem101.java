package download.dsalgo.problems;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example, Given linked list: 1->2->3->4->5, and n = 2. After removing the
 * second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note: If n is greater than the size of the list, remove the first node of the
 * list. Try doing it using constant additional space.
 * 
 * @author kaussark
 *
 */
public class Problem101 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next = new ListNode(8);
		node.next.next.next.next.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next.next.next.next.next = new ListNode(10);

		ListNode newNode = new Problem101().removeNthFromEnd(node, 9);
		newNode.print();
	}

	public ListNode removeNthFromEnd(ListNode A, int B) {

		if (B == 0) {
			return A;
		}

		// Nth node is B ahead of Pth Node
		ListNode nthNode = A;
		ListNode pthNode = A;
		ListNode prev = null;
		for (int i = 1; i < B && nthNode != null; i++) {
				nthNode = nthNode.next;
		}

		while (nthNode != null && nthNode.next != null) {
			prev = pthNode;
			pthNode = pthNode.next;
			nthNode = nthNode.next;
		}

		if (prev == null) {
			return A.next;
		} else {
			prev.next = pthNode.next;
			pthNode.next = null;
			return A;
		}
	}

}
