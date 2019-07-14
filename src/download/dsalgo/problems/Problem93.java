package download.dsalgo.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem93 {

	public static void main(String[] args) {

	}

	public ListNode detectCycle(ListNode a) {
		Set<Integer> visited = new HashSet<>();
		while (a != null) {
			if (!visited.contains(a.val)) {
				visited.add(a.val);
			} else {
				return a;
			}

			a = a.next;
		}
		return null;
	}
}
