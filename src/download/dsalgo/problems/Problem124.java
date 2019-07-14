package download.dsalgo.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * For Given Number N find if its COLORFUL number or not
 * 
 * Return 0/1
 * 
 * COLORFUL number:
 * 
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324
 * 245. And this number is a COLORFUL number, since product of every digit of a
 * contiguous subsequence is different Example:
 * 
 * N = 23 2 3 23 2 -> 2 3 -> 3 23 -> 6 this number is a COLORFUL number since
 * product of every digit of a sub-sequence are different.
 * 
 * Output : 1
 * 
 * @author kaussark
 *
 */
public class Problem124 {

	public static void main(String[] args) {

	}
	public int colorful(int A) {
		char[] characters = String.valueOf(A).toCharArray();
		int[][] product = new int[characters.length][characters.length];
		Set<Integer> prodSet = new HashSet<>();
		
		for(int i =0; i < characters.length;i++) {
			for (int j = i; j < characters.length;j++) {
				if(i==j) {
					product[i][j] = characters[i]-'0';
				} else {
					product[i][j] = product[i][j-1]*(characters[j]-'0');
				}
				
				if(prodSet.contains(product[i][j])) {
					return 0;
				}
				prodSet.add(product[i][j]);
			}
		}
		return 1;
    }
}
