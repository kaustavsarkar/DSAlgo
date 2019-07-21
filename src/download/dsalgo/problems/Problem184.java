package download.dsalgo.problems;

public class Problem184 {

	public static void main(String[] args) {

	}

	public int solution(String S) {
		// B-0, A-1, L-2, O-3, N-4
		int[] frequency = new int[5];
		runFrequency(S, frequency);
		
		int minSingle = Math.min(frequency[0], Math.min(frequency[1], frequency[4]));
		int minDouble = Math.min(frequency[2], frequency[3]);
		
		if(minSingle*2 <= minDouble) {
			return minSingle;
		} else {
			return minDouble >> 1;
		}
		
	}

	private void runFrequency(String s, int[] frequency) {
		for (char character : s.toCharArray()) {
			if (character == 'B') {
				frequency[0]++;
			} else if (character == 'A') {
				frequency[1]++;
			} else if (character == 'L') {
				frequency[2]++;
			} else if (character == 'O') {
				frequency[3]++;
			} else if (character == 'N') {
				frequency[4]++;
			}

		}
	}
}
