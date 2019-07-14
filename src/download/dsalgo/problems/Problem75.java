package download.dsalgo.problems;

/**
 * Reverse bits of an 32 bit unsigned integer
 * 
 * Example 1:
 * 
 * x = 0,
 * 
 * 00000000000000000000000000000000 => 00000000000000000000000000000000 return 0
 * 
 * Example 2:
 * 
 * x = 3,
 * 
 * 00000000000000000000000000000011 => 11000000000000000000000000000000 return
 * 3221225472
 * 
 * Since java does not have unsigned int, use long
 * 
 * @author kaussark
 *
 */
public class Problem75 {

	public static void main(String[] args) {
		System.out.println(new Problem75().reverse(2));
		//2 - 1073741824
	}

	public long reverse(long a) {
		if (a == 0) {
			return a;
		}
		long num = 0;
		int bitShift = 31;
		while (bitShift >= 0) {
			long temp = (a >> (32 - bitShift - 1)) & 1;
			num += temp << bitShift;
			bitShift--;	
		}

		return num;
	}
}
