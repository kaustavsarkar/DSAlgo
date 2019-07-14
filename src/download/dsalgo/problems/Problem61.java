package download.dsalgo.problems;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Compare two version numbers version1 and version2.
 * 
 * If version1 > version2 return 1, If version1 < version2 return -1, otherwise
 * return 0. You may assume that the version strings are non-empty and contain
 * only digits and the . character. The . character does not represent a decimal
 * point and is used to separate number sequences. For instance, 2.5 is not "two
 * and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 * 
 * @author kaussark
 *
 */
public class Problem61 {

	public static void main(String[] args) {
		Problem61 problem = new Problem61();
		System.out.println(problem.compareVersion("444444444444444444444444",
				"4444444444444444444444444"));
	}

	public int compareVersion(String A, String B) {
		BigDecimal numA = new BigDecimal(0);
		BigDecimal numB = new BigDecimal(0);

		String[] a = A.split("\\.");
		String[] b = B.split("\\.");

		int size = Math.max(a.length, b.length);
		int counter = 0;
		while (numA.compareTo(numB) == 0 && counter < size) {
			numA = counter >= a.length ? new BigDecimal(0)
					: new BigDecimal(a[counter]);
			numB = counter >= b.length ? new BigDecimal(0)
					: new BigDecimal(b[counter]);
			counter++;
		}

		return numA.compareTo(numB);
	}
}
