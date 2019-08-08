package download.dsalgo.problems;

public class Problem207 {

	public static void main(String[] args) {
		System.out.println(new Problem207().maxStep(4, 6));
	}

	public static int maxStep(int tries, int fault) {
		int[][] memo = new int[tries + 1][tries + 1]; // tries vs jump

		for (int trial = 1; trial <= tries; trial++) {
			for (int jump = 0; jump <= trial; jump++) {
				if (jump < memo[trial].length) {
					if (jump < trial) {// check in previous trial
						memo[trial][jump] = memo[trial - 1][jump];
					} else if (memo[trial][jump - 1] + jump == fault) {// stay
						memo[trial][jump] = memo[trial][jump - 1];
						if(memo[trial][jump - trial] + jump != fault) {
							memo[trial][jump] = memo[trial][jump - trial] + jump;
						}
					} else if (memo[trial][jump - 1] + jump != fault) {// take
																		// next
																		// jump
						memo[trial][jump] = memo[trial][jump - 1] + jump;
					}
				}
			}
		}
		return memo[tries][tries];
	}
}
