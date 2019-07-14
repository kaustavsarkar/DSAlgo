package download.dsalgo.problems;

public class Problem67 {

	public static void main(String[] args) {
		Problem67 problem = new Problem67();
		System.out.println(problem.addBinary("1010110111001101101000",
				"1000011011000000111100110"));
	}

	public String addBinary(String A, String B) {
		StringBuilder binary = new StringBuilder();

		int counter = 0;
		int rem = 1;
		while (rem > 0 || (counter < A.length() || counter < B.length())) {
			int a = A.length() - counter <= 0 ? 0
					: Integer.valueOf(A.substring(A.length() - counter - 1,
							A.length() - counter));
			int b = B.length() - counter <= 0 ? 0
					: Integer.valueOf(B.substring(B.length() - counter - 1,
							B.length() - counter));

			if (counter == 0) {
				rem = 0;
			}

			int o = add(a, b, rem);
			if (a + b + rem > 1) {
				rem = 1;
			} else {
				rem = 0;
			}
			binary.append(o);
			counter++;
		}

		return binary.reverse().toString();
	}

	private int add(int a, int b, int rem) {
		return a ^ b ^ rem;
	}
}
