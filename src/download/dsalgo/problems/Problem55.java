package download.dsalgo.problems;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ... 1 is read off as one 1 or 11. 11 is read off as
 * two 1s or 21.
 * 
 * 21 is read off as one 2, then one 1 or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Example:
 * 
 * if n = 2, the sequence is 11.
 * 
 * @author kaussark
 *
 */
public class Problem55 {

	public static void main(String[] args) {
		Problem55 problem = new Problem55();
		System.out.println(problem.countAndSay(13));
	}
	 public String _countAndSay(int A) {
	        char ch;int j =0;
	        String start = "1";
	        for(int i = 0; i < A - 1; i++){
	            StringBuilder str = new StringBuilder();
	            while (j < start.length()){
	                ch = start.charAt(j);
	                int count = count(start.substring(j), ch);
	                str.append(count);
	                str.append(ch);
	                j = j + count;
	            }

	            start = str.toString();
	            j = 0;
	        }

	        return start;
	    }

	    public int count(String s, char c){

	        int count = 0;
	        for(char ch : s.toCharArray()){
	            if(ch == c){
	                count++;
	            }else{
	                break;
	            }
	        }

	        return count;
	    }
	public String countAndSay(int A) {
		StringBuilder sequence = new StringBuilder();
		char charac = '1';
		sequence.append(1);
		for (int i = 1; i < A; i++) {
			String prev = sequence.toString();
			sequence = new StringBuilder();
			int count = 0;
			int start = 0;
			while (start + count < prev.length()) {
				if (prev.charAt(start + count) == charac) {
					count++;
				} else {
					sequence.append(count + "" + charac);
					start = start+count;
					charac = prev.charAt(start);
					count = 0;
				}

				if (start + count == prev.length()) {
					sequence.append(count + "" + charac);
					charac = sequence.charAt(0);
				}
			}
		}

		return sequence.toString();
	}
}
