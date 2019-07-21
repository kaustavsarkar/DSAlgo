package download.dsalgo.problems;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example :
 * 
 * Input : 3 Return : 3
 * 
 * Steps : [1 1 1], [1 2], [2 1]
 * 
 * @author kaussark
 *
 */
public class Problem176 {

	public static void main(String[] args) {

	}

	public int climbStairs(int A) {
		int[] pos = new int[A + 1];
		pos[0] = 1;
		if (A > 0) {
			pos[1] = 1;
		}

		for (int i = 2; i <= A; i++) {
			pos[i] = pos[i - 1] + pos[i - 2];
		}
		return pos[A];
	}

}
