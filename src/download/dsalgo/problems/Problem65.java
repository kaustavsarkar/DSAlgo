package download.dsalgo.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Read more details about roman numerals at Roman Numeric System
 * 
 * Example :
 * 
 * Input : "XIV" Return : 14 Input : "XX" Output : 20
 * 
 * @author kaussark
 *
 */
public class Problem65 {
	public static void main(String[] args) {
		Problem65 problem = new Problem65();
		System.out.println(problem.romanToInt("MDCCCIV"));
	}
	private static Map<Character, Integer> rome = new HashMap<>();
	static {
		
		rome.put('I', 1);
		rome.put('V', 5);
		rome.put('X', 10);
		rome.put('L', 50);
		rome.put('C', 100);
		rome.put('D', 500);
		rome.put('M', 1000);
	}
	public int _romanToInt(String s) {
        Map<Character,Integer> romanArab = new HashMap<>();
        romanArab.put('I' , 1);
        romanArab.put('V' , 5);
        romanArab.put('X' , 10);
        romanArab.put('L' , 50);
        romanArab.put('C' , 100);
        romanArab.put('D' , 500);
        romanArab.put('M' , 1000);
        romanArab.put(' ',0);
        int ans = 0;
        for(int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            char nextChar = index < s.length()-1 ? s.charAt(index+1) : ' ';
            int currNum = romanArab.get(character);
            int nextNum = romanArab.get(nextChar);
            if(character == 'I' && nextNum > currNum) {
                ans += nextNum-currNum;
            } else if(character == 'X' && nextNum > currNum) {
                ans += nextNum - currNum;
            } else if(character == 'C' && nextNum > currNum) {
                ans += nextNum - currNum;
            } else {
                ans += currNum;
            }
        }
         return ans;
    }
	public int romanToInt(String A) {
		int number = 0;
//		Map<Character, Integer> rome = new HashMap<>();
//		rome.put('I', 1);
//		rome.put('V', 5);
//		rome.put('X', 10);
//		rome.put('L', 50);
//		rome.put('C', 100);
//		rome.put('D', 500);
//		rome.put('M', 1000);
		for (int i = 0; i < A.length(); i++) {
			int temp = rome.get(A.charAt(i));
			if (i < A.length() - 1) {
				if (temp < rome.get(A.charAt(i + 1))) {
					number -= temp;
				} else {
					number += temp;
				}
			} else {
				number += temp;
			}
		}

		return number;
	}
}
