package download.dsalgo.problems;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * Example, Given:
 * 
 * s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac", return true. When s3 =
 * "aadbbbaccc", return false.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author kaussark
 *
 */
public class Problem216 {

	public static void main(String[] args) {
		String a = "LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh";
		String b = "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf";
		String c = "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh";
		System.out.println(new Problem216().isInterleave(a, b, c));
	}

	public int isInterleave(String A, String B, String C) {
		int aLength = A.length();
		int bLength = B.length();
		int cLength = C.length();

		if (aLength + bLength != cLength) {
			return 0;
		}

		int memo[][] = new int[aLength + 1][bLength + 1];
		memo[0][0] = 1;

		// Fill first row
		for (int col = 1; col <= bLength; col++) {
			char c = C.charAt(col - 1);
			char b = B.charAt(col - 1);
			if (B.charAt(col - 1) != C.charAt(col - 1)) {
				memo[0][col] = 0;
			} else {
				memo[0][col] = 1 & memo[0][col - 1];
			}
		}
		// Fill first column
		for (int row = 1; row <= aLength; row++) {
			char c = C.charAt(row - 1);
			char a = A.charAt(row - 1);
			if (A.charAt(row - 1) != C.charAt(row - 1)) {
				memo[row][0] = 0;
			} else {
				memo[row][0] = 1 & memo[row - 1][0];
			}
		}

		// compute for rest
		for (int aCounter = 1; aCounter <= aLength; aCounter++) {
			for (int bCounter = 1; bCounter <= bLength; bCounter++) {
				char cChar = C.charAt(aCounter + bCounter - 1);
				char aChar = A.charAt(aCounter - 1);
				char bChar = B.charAt(bCounter - 1);
				if (cChar != aChar && cChar != bChar) {
					memo[aCounter][bCounter] = 0;
				} else {
					memo[aCounter][bCounter] = (cChar == aChar
							? memo[aCounter - 1][bCounter]
							: 0)
							| ((cChar == bChar)
									? memo[aCounter][bCounter] = memo[aCounter][bCounter
											- 1]
									: 0);
				}
			}
		}
		return memo[aLength][bLength];
	}
}
