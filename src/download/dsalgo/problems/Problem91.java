package download.dsalgo.problems;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5
 * 
 * @author kaussark
 *
 */

public class Problem91 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(7);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		StringBuilder pointer = new StringBuilder();
		ListNode node = new Problem91().partition(node1, 6);
		while (node != null) {
			pointer.append(node.val + "->");
			node = node.next;
		}

		System.out.println(pointer);
	}

	public ListNode _partition(ListNode A, int B) {

		ListNode head = null;
		ListNode cur = null;
		ListNode last = null;
		ListNode next = null;
		while (A != null) {
			next = A.next;
			if (A.val < B) {
				if (head == null) {
					head = A;
				} else {
					if (cur == null) {
						A.next = head;
						head = A;
					} else {
						ListNode temp = cur.next;
						cur.next = A;
						A.next = temp;
					}
				}
				cur = A;
			} else {
				if (head == null) {
					head = A;
				} else {
					if (last != null)
						last.next = A;
					else {
						cur.next = A;
					}
				}
				last = A;
			}
			A = next;
		}
		if (last != null) {
			last.next = null;
		} else if (cur != null) {
			cur.next = null;
		}
		return head;

	}

	public ListNode partition(ListNode A, int B) {
		ListNode node = new ListNode(A.val);
		A = A.next;
		ListNode left = null;
		ListNode check = null;
		ListNode right = null;

		while (A != null) {
			ListNode newNode = new ListNode(A.val);
			if (newNode.val < B) {
				newNode.next = check;
				if (left != null) {
					left.next = newNode;
				}
				left = newNode;
			} else if (check == null) {
				check = newNode;
				left.next = check;
				right = check;
			} else {
				right.next = newNode;
				right = newNode;
			}
			A = A.next;
		}

		return node;
	}
}
