package download.dsalgo.problems;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author kaussark
 *
 */
public class Problem34 {

	public static void main(String[] args) {
		Problem34 problem = new Problem34();

		String s = problem.convertToTitle(1405);
		System.out.println(s);
	}

	public String convertToTitle(int A) {
		StringBuilder col = new StringBuilder();
		int base = 'A' - 1;
		int rem = -1;
		while (A != 0) {
			rem = A % 26;
			if (rem != 0) {
				col.insert(0,(char) (base + rem));
				A = (A - rem) / 26;
			} else {
				A = (A / 26)-1;
				col.insert(0,(char) (26+base));
			}

		}

		return col.toString();
	}
}
