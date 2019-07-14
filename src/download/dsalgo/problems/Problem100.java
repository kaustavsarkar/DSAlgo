package download.dsalgo.problems;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists, and
 * should also be sorted.
 * 
 * For example, given following linked lists :
 * 
 * 5 -> 8 -> 20 4 -> 11 -> 15 The merged list should be :
 * 
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * 
 * @author kaussark
 *
 */
public class Problem100 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
		node1.next = new ListNode(8);
		node1.next.next = new ListNode(20);
		
		ListNode node2 = new ListNode(4);
		node2.next = new ListNode(11);
		node2.next = new ListNode(15);
		
		ListNode merged = new Problem100().mergeTwoLists(node1, node2);
		merged.print();
	}
	public ListNode __mergeTwoLists(ListNode a, ListNode b) {
	    ListNode head=new ListNode(0);
	    ListNode temp=head;
	    while(a!=null && b!=null){
	        if(a.val<=b.val){
	            temp.next=new ListNode(a.val);
	            temp=temp.next;
	            a=a.next;
	        }
	        else{
	            temp.next=new ListNode(b.val);
	            temp=temp.next;
	            b=b.next;
	        }
	    }
	    if(a==null)
	    temp.next=b;
	    else
	    temp.next=a;
	    head=head.next;
	    return head;
	}
	public ListNode _mergeTwoLists(ListNode a, ListNode b) {
        final ListNode head =  new ListNode(0);
        ListNode prev = head;
        while (a != null || b != null) {
            boolean moveA = (b == null) || (a != null && a.val <= b.val);
            if (moveA) {
                prev.next = a;
                a = a.next;
            } else {
                prev.next = b;
                b = b.next;
            }
            prev = prev.next;
            prev.next = null;
        } 
        return head.next;
    }
	
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		if (A == null) {
			return B;
		}
		if (B == null) {
			return A;
		}
		ListNode merged = null;
		ListNode counter = null;
		while (A != null && B != null) {
			int num1 = A.val;
			int num2 = B.val;

			if (num1 < num2) {
				if (merged == null) {
					merged = A;
					counter = merged;
				} else {
					counter.next = A;
					counter = counter.next;
				}
				A = A.next;
			} else {
				if (merged == null) {
					merged = B;
					counter = merged;
				} else {
					counter.next = B;
					counter = counter.next;
				}
				B = B.next;
			}
		}

		while (A != null) {
			counter.next = A;
			counter = counter.next;
			A = A.next;
		}

		while (B != null) {
			counter.next = B;
			counter = counter.next;
			B = B.next;
		}

		return merged;
	}

}
