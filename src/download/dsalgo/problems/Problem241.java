package download.dsalgo.problems;

import java.util.*;

public class Problem241 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(new Problem241().stepnum(a, b));
	}

	public ArrayList<Integer> stepnum(int A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int num = 0; num <= 9; num++) {
			stepNumHelper(A, B, num, result);
		}
		Collections.sort(result);
		return result;
	}

	private void stepNumHelper(int start, int end, int num,
			ArrayList<Integer> result) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(num);

		while (!queue.isEmpty()) {
			int step = queue.poll();

			if (step >= start && step <= end) {
				result.add(step);
			}

			if (step == 0 || step > end) {
				continue;
			}

			int lastDigit = step % 10;

			int adjOne = step * 10 + (lastDigit + 1);
			int adjTwo = step * 10 + (lastDigit - 1);

			if (lastDigit == 0) {
				queue.add(adjOne);
			} else if (lastDigit == 9) {
				queue.add(adjTwo);
			} else {
				queue.add(adjTwo);
				queue.add(adjOne);
			}
		}

	}
}
