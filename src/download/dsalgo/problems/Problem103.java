package download.dsalgo.problems;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author kaussark
 *
 */
public class Problem103 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		node.print();
		ListNode rotate = new Problem103().rotateRight(node, 9);
		rotate.print();
	}

	int counter = 0;

	public ListNode rotateRight(ListNode A, int B) {
		int size = 0;
		ListNode temp = A;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		System.out.println(size);
		int rotation = B % size;
		System.out.println(rotation);
		if (rotation == 0) {
			return A;
		}
		ListNode fast = A;
		ListNode pre = A;
		for (int i = 0; i < size - rotation; i++) {
			pre = fast;
			fast = fast.next;
		}
		pre.next = null;
		A.print();
		fast.print();
		ListNode last = fast;
		while (last.next != null) {
			last = last.next;
		}
		last.next = A;
		A = fast;

		return A;
	}
}
