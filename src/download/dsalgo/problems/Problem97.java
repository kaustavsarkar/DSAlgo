package download.dsalgo.problems;

public class Problem97 {

	public static void main(String[] args) {
		ListNode num1 = new ListNode(1);
		num1.next = new ListNode(2);
		num1.next.next = new ListNode(9);
		ListNode num2 = new ListNode(0);
		num2.next = new ListNode(2);
		num2.next.next = new ListNode(1);

		ListNode sum = new Problem97().addTwoNumbers(num1, num2);
		sum.print();
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		if (A == null && B == null) {
			return null;
		}
		if (A == null) {
			return B;
		} else if (B == null) {
			return A;
		}
		ListNode addition = null;
		ListNode addPointer = null;

		int carry = 0;
		while (A != null || B != null) {
			int num1 = A == null ? 0 : A.val;
			int num2 = B == null ? 0 : B.val;
			int sum = (num1 + num2 + carry) % 10;
			carry = (num1 + num2 + carry) / 10;
				if (addition == null) {
					addition = new ListNode(sum);
					addPointer = addition;
				} else {
					addPointer.next = new ListNode(sum);
					addPointer = addPointer.next;
				}

			A = A != null ? A.next : A;
			B = B == null ? B : B.next;
		}

		if (carry != 0) {
			addPointer.next = new ListNode(carry);
		}

		return addition;
	}

}
