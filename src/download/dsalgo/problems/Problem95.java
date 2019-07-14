package download.dsalgo.problems;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author kaussark
 *
 */
public class Problem95 {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next= new ListNode(1);
		node.next.next= new ListNode(1);
		node.next.next.next= new ListNode(2);
		node.next.next.next.next= new ListNode(2);
		node.next.next.next.next.next= new ListNode(3);
		node.next.next.next.next.next.next= new ListNode(4);
		node.next.next.next.next.next.next.next= new ListNode(4);
		
		ListNode fin = new Problem95().deleteDuplicates(node);
		fin.print();
	}

	public ListNode deleteDuplicates(ListNode A) {
		ListNode temp = A;
		while(temp != null && temp.next != null) {
			if(temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
			//A.print();
		}
		
		return A;
	}
}
