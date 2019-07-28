package download.dsalgo.problems;

/**
 * Given expression with operands and operators (OR , AND , XOR) , in how many
 * ways can you evaluate the expression to true, by grouping in different ways?
 * Operands are only true and false. Input:
 * 
 * string : T|F&T^T here '|' will represent or operator '&' will represent and
 * operator '^' will represent xor operator 'T' will represent true operand 'F'
 * will false Output:
 * 
 * different ways % MOD where MOD = 1003 Example:
 * 
 * string : T|F only 1 way (T|F) => T so output will be 1 % MOD = 1
 * 
 * @author kaussark
 *
 */
public class Problem191 {

	public static void main(String[] args) {
		String input = "F|T^T&F";
		System.out.println(new Problem191().cnttrue(input));
	}

	int[][][] memo = null;
	int MOD = 1003;

	public int cnttrue(String A) {
		memo = new int[A.length()][A.length()][2];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				memo[i][j][0] = memo[i][j][1] = -1;
			}
		}
		return findWays(A, 0, A.length() - 1, true) % MOD;
	}

	private int findWays(String a, int start, int end, boolean flag) {

		if (start > end || start < 0 || end < 0 || start > end
				|| start >= a.length() || end >= a.length()) {
			return 0;
		}

		if (start == end) {
			boolean elem = a.charAt(start) == 'T' ? true : false;

			return elem ^ flag ? 0 : 1;
		}

		if (memo[start][end][flag ? 0 : 1] != -1) {
			return memo[start][end][flag ? 0 : 1] % MOD;
		}
		int count = 0;
		for (int index = start + 2; index <= end; index += 2) {
			if (a.charAt(index - 1) == '|') {
				if (flag) {// countFalse*countTrue + countTrue*countFalse +
							// countTrue*countTrue
					count += findWays(a, start, index - 2, flag)
							* findWays(a, index, end, !flag)
							+ findWays(a, start, index - 2, !flag)
									* findWays(a, index, end, flag)
							+ findWays(a, start, index - 2, flag)
									* findWays(a, index, end, flag);
				} else { // countFalse*countFalse
					count += findWays(a, start, index - 2, flag)
							* findWays(a, index, end, flag);
				}
			} else if (a.charAt(index - 1) == '&') {
				if (flag) {// countTrue*countTrue
					count += findWays(a, start, index - 2, flag)
							* findWays(a, index, end, flag);
				} else {// countFalse*countTrue + countTrue*countFalse +
						// countFalse*countFalse
					count += findWays(a, start, index - 2, flag)
							* findWays(a, index, end, !flag)
							+ findWays(a, start, index - 2, !flag)
									* findWays(a, index, end, flag)
							+ findWays(a, start, index - 2, flag)
									* findWays(a, index, end, flag);
				}
			} else if (a.charAt(index - 1) == '^') {
				if (!flag) {// countFalse*countFalse + countTrue*countTrue
					count += (findWays(a, start, index - 2, !flag)
							* findWays(a, index, end, !flag))
							+ (findWays(a, start, index - 2, flag)
									* findWays(a, index, end, flag));
				} else {// countFalse*countTrue + countTrue*countFalse
					count += findWays(a, start, index - 2, flag)
							* findWays(a, index, end, !flag)
							+ findWays(a, start, index - 2, !flag)
									* findWays(a, index, end, flag);
				}
			}
			count = count % MOD;
		}

		return memo[start][end][flag ? 0 : 1] = count;
	}
}
