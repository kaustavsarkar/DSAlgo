package download.dsalgo.problems;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding
 * column number.
 * 
 * Example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * @author kaussark
 *
 */
public class Problem33 {

	public static void main(String[] args) {
		Problem33 problem = new Problem33();
		int num = problem._titleToNumber("BBA");
		System.out.println(num);
	}

	public int _titleToNumber(String A) {

		int len = A.length();
		int num = 0;
		int i = 0;
		while (len > 0) {
			num = 26 * num + (A.charAt(i) - 'A' + 1);
			len--;
			i++;

		}
		return num;

	}

	public int titleToNumber(String A) {
		int colNum = 0;
		int base = 'A' - 1;
		char[] chars = A.toCharArray();
		for (int i = 0; i < A.length(); i++) {
			colNum += (chars[chars.length - 1 - i] - base) * Math.pow(26, i);
		}

		return colNum;
	}

}
