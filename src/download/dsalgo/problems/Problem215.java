package download.dsalgo.problems;

public class Problem215 {

	public static void main(String[] args) {
		String A =//"rabbit"; 
				"aaaababbababbaabbaaababaaabbbaaabbb";
		String B =//"rabbbit"; 
				"bbababa";
		System.out.println(new Problem215().numDistinct(A, B));
	}

	public int numDistinct(String A, String B) {
		if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
			return 1;
		}
		
		if(A.length() < B.length()) {
			return 0;
		}

		int[][] memo = new int[B.length() + 1][A.length() + 1];

		// Initialise 1st row
		for (int col = 0; col <= A.length(); col++) {
			memo[0][col] = 1;
		}

		// Run it for rest entries
		for (int row = 1; row <= B.length(); row++) {
			for (int col = 1; col <= A.length(); col++) {

				if (A.charAt(col - 1) != B.charAt(row - 1)) {
					memo[row][col] = memo[row][col - 1];
				} else {
					memo[row][col] = memo[row][col - 1]
							+ memo[row - 1][col - 1];
				}

			}
		}
		return memo[B.length()][A.length()];
	}
}
