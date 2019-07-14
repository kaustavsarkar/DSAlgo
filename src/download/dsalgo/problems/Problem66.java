package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given an integer, convert it to a roman numeral, and return a string
 * corresponding to its roman numeral version
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example :
 * 
 * Input : 5 Return : "V"
 * 
 * Input : 14 Return : "XIV" Note : This question has a lot of scope of
 * clarification from the interviewer. Please take a moment to think of all the
 * needed clarifications and see the expected response using “See Expected
 * Output” For the purpose of this question,
 * https://projecteuler.net/about=roman_numerals has very detailed explanations.
 * 
 * @author kaussark
 *
 */
public class Problem66 {

	public static void main(String[] args) {
		Problem66 problem = new Problem66();
		System.out.println(problem.intToRoman(3998));
	}
	public String _intToRoman(int n) {
        String o[]={"","I","II","III","IV","V","VI","VII","VIII","IX"}; 
        String t[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String c[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}; 
        String m[]={"","M","MM","MMM"}; 
        return m[n/1000]+c[(n%1000)/100]+t[(n%100)/10]+o[n%10];
    }
	private static class RomanNums implements Comparable<RomanNums> {
		Integer arab;
		String roman;

		public RomanNums(Integer arab, String rom) {
			this.arab = arab;
			this.roman = rom;
		}

		@Override
		public int compareTo(RomanNums o) {
			return arab.compareTo(o.arab);
		}

		@Override
		public String toString() {
			return "RomanNums [arab=" + arab + ", roman=" + roman + "]";
		}
		
		

	}

	public String intToRoman(int A) {
		List<RomanNums> romes = new ArrayList<>();
		romes.add(new RomanNums(1, "I"));
		romes.add(new RomanNums(4, "IV"));
		romes.add(new RomanNums(5, "V"));
		romes.add(new RomanNums(9, "IX"));
		romes.add(new RomanNums(10, "X"));
		romes.add(new RomanNums(40, "XL"));
		romes.add(new RomanNums(50, "L"));
		romes.add(new RomanNums(90, "XC"));
		romes.add(new RomanNums(100, "C"));
		romes.add(new RomanNums(400, "CD"));
		romes.add(new RomanNums(500, "D"));
		romes.add(new RomanNums(900, "CM"));
		romes.add(new RomanNums(1000, "M"));

		int count = 1;
		StringBuilder roman = new StringBuilder();

		while (A > 0) {
			int temp = A % (10 * count);
			A = A - temp;
			StringBuilder num = new StringBuilder();
			while (temp > 0) {
				int diff = findMin(romes, temp);
				num.append(romes.get(diff).roman);
				temp = temp - romes.get(diff).arab;
			}
			roman.insert(0, num.toString());
			count *= 10;

		}

		return roman.toString();
	}

	private int findMin(List<RomanNums> romans, int temp) {
		int start = 0;
		int end = romans.size()-1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (temp < romans.get(mid).arab) {
				end = mid - 1;
			} else if (temp > romans.get(mid).arab) {
				start = mid + 1;
			} else {
				return  mid;
			}
		}

		return end;
	}

}
