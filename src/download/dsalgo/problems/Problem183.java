package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem183 {

	public static void main(String[] args) {
		System.out.println((int)Math.ceil(Math.sqrt(1)));
		System.out.println(new Problem183().solution(1, 1));
	}

	public int solution(int A, int B) {
		double num = (int) Math.ceil(Math.sqrt(A));
		List<Integer> frequency = new ArrayList<>();
		while (num * num <= B) {
			frequency.add(findSqrt(num));
			num = num + 1;
		}
		if(frequency.isEmpty() ) {
			return 0;
		}
		System.out.println(frequency);
		Collections.sort(frequency);
		return frequency.get(frequency.size() - 1);
	}

	private int findSqrt(double a) {
		int rounds = 0;
		while (a > 1 && a == (int) a) {
			a = Math.sqrt(a);
			rounds++;
		}
		return rounds;
	}
}
