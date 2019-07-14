package download.dsalgo.problems;

import org.omg.CORBA.Current;

/**
 * Sort a linked list using insertion sort.
 * 
 * We have explained Insertion Sort at Slide 7 of Arrays
 * 
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 * 
 * Example :
 * 
 * Input : 1 -> 3 -> 2
 * 
 * Return 1 -> 2 -> 3
 * 
 * @author kaussark
 *
 */
public class Problem92 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		
		System.out.println(new Problem92().insertionSortList(node1));
	}
	
	
	public ListNode putback(ListNode A, int k){
        ListNode head=A;
        if(head.val >k){
            head = new ListNode(k);
            head.next=A;
            A=head;
            return A;
        }
        while(head.next != null){
            if(head.next.val > k){
                ListNode temp = head.next;
                head.next = new ListNode(k);
                head.next.next = temp;
                return A;
            }
            head=head.next;
        }
        return A;
    }
    public ListNode _insertionSortList(ListNode A) {
        ListNode head=A,iter2=A;
        if(A.next == null)
            return A;
        while(iter2.next != null){
            if(iter2.next.val < iter2.val){
                head = putback(head,iter2.next.val);
                iter2.next = iter2.next.next;
            }else{
                iter2=iter2.next;
            }
            
        }
        return head;
    }
	
	private ListNode sorted;

	private void insertSort(ListNode newNode) {
		if(sorted == null || newNode.val <= sorted.val) {
			newNode.next = sorted;
			sorted = newNode;
		} else {
			ListNode curr = sorted;
			while(curr != null && curr.next.val < newNode.val) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode.next;
		}
	}
	
	public ListNode insertionSortList(ListNode A) {
		sorted = null;
		while (A != null) {
			ListNode curr = A;
			insertSort(curr);
			A = A.next;
		}

		return sorted;
	}
}
