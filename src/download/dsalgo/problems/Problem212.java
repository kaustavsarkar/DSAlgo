package download.dsalgo.problems;

/**
 * Given two words A and B, find the minimum number of steps required to convert
 * A to B. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character Example : edit
 * distance between "Anshuman" and "Antihuman" is 2.
 * 
 * Operation 1: Replace s with t. Operation 2: Insert i.
 * 
 * @author kaussark
 *
 */
public class Problem212 {

	public static void main(String[] args) {
		String a = "bbbaabaa";
				//"aaa"; 
				//"aac";
		String b = "aababbabb"; 
				//"aa"; 
				//"abac";
		System.out.println(new Problem212().minDistance(a, b));
	}
	public int minDistance(String A, String B) {
		return 0;
	}
	public int _minDistance(String A, String B) {
		if (A.length() < B.length()) {
			int ans = _minDistance(B, A);
			return ans;
		}

		int leftCounter = 0;
		int bEnd = B.length() - 1;
		int aEnd = A.length() - 1;
		while (leftCounter < B.length()
				&& A.charAt(leftCounter) == B.charAt(leftCounter)) {
			leftCounter++;
		}

		while (bEnd >= 0 && aEnd >= 0 && B.charAt(bEnd) == A.charAt(aEnd)) {
			bEnd--;
			aEnd--;
		}
		if(aEnd <leftCounter) {
			return 1;
		}
		String aSub = A.substring(leftCounter,aEnd+1);
		//String bSub = A.substring(leftCounter,bEnd+1);
		
		
		return aSub.length();
	}

}
