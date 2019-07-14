package download.dsalgo.problems;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative. Note2: Your
 * answer should not have leading zeroes. For example, 00 is not a valid answer.
 * For example, given strings "12", "10", your answer should be “120”.
 * 
 * NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA /
 * PYTHON ). We will retroactively disqualify such submissions and the
 * submissions will incur penalties.
 * 
 * @author kaussark
 *
 */
public class Problem69 {

	public static void main(String[] args) {
		Problem69 problem = new Problem69();
		System.out.println(problem.multiply("99", "99"));
	}
	public String _multiply(String a, String b) {
        int[] res = new int[a.length() + b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                res[i + j + 1] += (a.charAt(i) - '0') * (b.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = res.length-1; i >= 0; i--) {
            int val = res[i] + carry;
            res[i] = val % 10;
            carry = val / 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length-1 && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append( (char) (res[i] + '0') );
            i++;
        }
        return sb.toString();
    }
	public String multiply(String A, String B) {

		if(A.equals("0") || B.equals("0")) {
			return "0";
		}
		
		if(A.equals("1")) {
			return B;
		} else if(B.equals("1")) {
			return A;
		}
		
		int maxLen = Math.max(A.length(), B.length());
		int[][] sums = new int[maxLen][];
		int[] a = getIntegerArr(A, maxLen);
		int[] b = getIntegerArr(B, maxLen);

		int bCounter = maxLen - 1;
		while (bCounter >= 0) {
			int[] array = new int[(2 * maxLen)];
			int bnum = b[bCounter];
			int aCounter = maxLen - 1;
			int carry = 0;
			while (aCounter >= 0) {
				int anum = a[aCounter];
				array[2 * maxLen - aCounter - bCounter
						- 2] = (((bnum * anum) + carry) % 10);
				carry = (bnum * anum) / 10;
				aCounter--;
			}
			if (carry > 0) {
				array[2 * maxLen - aCounter - bCounter - 2] = carry;
			}
			sums[bCounter--] = array;
		}

		String sum = getSum(sums);
		int filter = 0;
		while (sum.charAt(filter) == '0') {
			filter++;
		}

		return sum.substring(filter, sum.length());
	}

	private String getSum(int[][] sums) {
		StringBuilder sum = new StringBuilder();
		int cols = sums[0].length;
		int rows = sums.length;
		// go by cols
		int carry = 0;
		for (int i = 0; i < cols; i++) {
			int num = 0;
			for (int j = 0; j < rows; j++) {
				num = (num + sums[j][i]);

			}
			num = num + carry;
			carry = num / 10;
			sum.append(num % 10);
		}

		return sum.reverse().toString();
	}

	private int[] getIntegerArr(String a, int maxLen) {
		int[] array = new int[maxLen];
		int diff = maxLen - a.length();
		for (int i = 0; i < a.length(); i++) {
			array[i + diff] = Integer.parseInt(a.substring(i, i + 1));
		}

		return array;
	}

}
