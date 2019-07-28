package download.dsalgo.problems;

import java.util.*;

/**
 * Given a set of strings. Find the length of smallest string which has all the
 * strings in the set as substring
 * 
 * Constraints: 1) 1 <= Number of strings <= 18 2) Length of any string in the
 * set will not exceed 100.
 * 
 * Example: Input: [“abcd”, “cdef”, “fgh”, “de”] Output: 8 (Shortest string:
 * “abcdefgh”)
 * 
 * @author kaussark
 *
 */
public class Problem189 {

	public static void main(String[] args) {
		String[] strings = { "qkourllircql", "smvtrmvjpr", "yagcifbarp",
				"lbjtunkgbfuw", "nlvyb", "tdqchahic", "xypbkkvywecd",
				"ydonbnqpjtjlbj", "jnajop", "aagbamddoe" };
		// { "khtrvkmqdsxdaq", "srlnf", "ifevl", "koxebfas",
		// "kguoyurb", "cvgpklfu", "lrhvevujwcjpi", "xfnwafx",
		// "jwwyhkhee" };
		// { "cpsklryvmcp", "nbpbwllsrehfmx", "kecwitrsglre",
		// "vtjmxypu" };
		// {"abcd", "cdef", "fgh", "de"};
		System.out.println(new Problem189()
				._solve(new ArrayList<>(Arrays.asList(strings))));
	}
	public int _solve(ArrayList<String> listStr) {
        if (listStr == null) return 0;
        
        int n = listStr.size();
        if (n == 0) return 0;
        
        String[] arrStr = listStr.toArray(new String[n]);
        
        int len = n;
        while (len > 1) {
            int overlapMax = 0;
            int I = 0, J = 0;
            String resStr = "";
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    String curStr = findOverlap(arrStr[i], arrStr[j]);
                    int overlapCur = - curStr.length() + arrStr[i].length() + arrStr[j].length();
                    //System.out.println(i + " " + j + " " + curStr);
                    if (overlapMax < overlapCur) {
                        overlapMax = overlapCur;
                        resStr = curStr;
                        I = i;
                        J = j;
                    }
                }
            }
            --len;
            if (overlapMax == 0) {
                arrStr[0] += arrStr[len];
            } else {
                arrStr[I] = resStr;
                arrStr[J] = arrStr[len];
            }
        }
        System.out.println(arrStr[0]);
        return arrStr[0].length();
    }
    private String findOverlap(String a, String b) {
        int la = a.length();
        int lb = b.length();
        String res = a + b;
        for (int k = 1; k <= la; k++) {
            if (k > lb) break;
            if (b.endsWith(a.substring(0, k))) {
                res = b + a.substring(k);
            }
        }
        for (int k = 1; k <= lb; k++) {
            if (k > la) break;
            if (a.endsWith(b.substring(0, k))) {
                String tmpRes = a + b.substring(k);
                if (res.length() > tmpRes.length())
                    res = tmpRes;
            }
        }
        return res;
    }

	public int solve(ArrayList<String> listStr) {
		int size = listStr.size();
		while (size != 1) {
			int start = 0;
			int end = 0;
			int maxLength = 0;

			String result = "";

			for (int first = 0; first < size; first++) {
				for (int second = first + 1; second < size; second++) {
					String f = listStr.get(first);
					String s = listStr.get(second);
					String string = findOverLappingPair(listStr.get(first),
							listStr.get(second));
					if (string.length() > maxLength) {
						maxLength = string.length();
						result = string;
						start = first;
						end = second;
					}

				}

			}
			size--; // ignore last element in next cycle
			if (maxLength == 0) {
				listStr.set(0, listStr.get(0) + listStr.get(size));
			} else {
				listStr.set(start, result);
				listStr.set(end, listStr.get(size));
			}
		}
		System.out.println(listStr.get(0));
		return listStr.get(0).length();
	}

	private String findOverLappingPair(String string1, String string2) {
		String string3 = "";
		int max = Integer.MIN_VALUE;
		int length1 = string1.length();
		int length2 = string2.length();

		// Check for suffix of string1 and prefix of string2
		for (int index = 1; index < Math.min(length1, length2); index++) {
			if (string1.endsWith(string2.substring(0, index))) {
				if (index > max) {
					string3 = string1 + string2.substring(index);
					max = index;
				}
			}
		}

		for (int index = 1; index < Math.min(length2, length1); index++) {
			if (string2.endsWith(string1.substring(0, index))) {
				if (index > max) {
					string3 = string2 + string1.substring(index);
					max = index;
				}
			}
		}

		return string3;
	}

}
