package download.dsalgo.problems;

public class Problem182 {
	private static final int MOD = 1000000009;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int solve(int n, int s) {
	        Integer[][] dp = new Integer[n+1][s+1];
	        int sol = solve(n, s, dp);
	        // System.out.println(Arrays.deepToString(dp));
	        return sol;
	    }
	    
	    private int solve(int n, int s, Integer[][] dp) {
	        if (n == 0 && s == 0) {
	            return 1;
	        } else if (s == 0 && n != 0) {
	            return 0;
	        } else if (n == 0 && s != 0) {
	            return 0;
	        } else {
	            if (dp[n][s] == null) {
	                int sum = 0;
	                for (int i = 0; i <= 9 && i <= s; i++) {
	                    sum = ((sum % MOD) + (solve(n-1, s - i, dp) % MOD)) % MOD;
	                }
	                dp[n][s] = sum;
	            }
	            return dp[n][s];
	        }
	    }
}
