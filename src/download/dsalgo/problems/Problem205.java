package download.dsalgo.problems;

/**
 * You are given a sequence of black and white horses, and a set of K stables
 * numbered 1 to K. You have to accommodate the horses into the stables in such
 * a way that the following conditions are satisfied:
 * 
 * You fill the horses into the stables preserving the relative order of horses.
 * For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1.
 * You have to preserve the ordering of the horses. No stable should be empty
 * and no horse should be left unaccommodated. Take the product (number of white
 * horses * number of black horses) for each stable and take the sum of all
 * these products. This value should be the minimum among all possible
 * accommodation arrangements Example:
 * 
 * 
 * Input: {WWWB} , K = 2 Output: 0
 * 
 * Explanation: We have 3 choices {W, WWB}, {WW, WB}, {WWW, B} for first choice
 * we will get 1*0 + 2*1 = 2. for second choice we will get 2*0 + 1*1 = 1. for
 * third choice we will get 3*0 + 0*1 = 0.
 * 
 * Of the 3 choices, the third choice is the best option.
 * 
 * If a solution is not possible, then return -1
 * 
 * @author kaussark
 *
 */
public class Problem205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrange(String a, int b) {
		if (a.length() < b) {
			return -1;
		}
		int[][] dp = new int[b][a.length()];
		// for (int []i: dp){Arrays.fill(i,-1);}
		for (int i = 0; i < b; i++) {
			int w, l;
			w = l = 0;
			for (int j = i; j <= i + a.length() - b; j++) {

				if (i == 0) {
					if (a.charAt(j) == 'W')
						w++;
					else
						l++;
					dp[0][j] = w * l;
				} else {
					w = l = 0;
					int k = j;
					int min = Integer.MAX_VALUE;
					while (k >= i) {
						if (a.charAt(k) == 'W')
							w++;
						else
							l++;
						// System.out.println("ss "+dp[i-1][k-1]+w*l);
						dp[i][j] = dp[i - 1][k - 1] + w * l;
						if (dp[i][j] == 0)
							break;
						if (min > dp[i][j]) {
							min = dp[i][j];
						} else
							dp[i][j] = min;
						k--;
					}

				}

			}
		}
		/*
		 * for (int []i:dp){ for (int j:i){ System.out.print(j+" "); }
		 * System.out.println(); }
		 */
		return dp[b - 1][a.length() - 1];
	}
}
