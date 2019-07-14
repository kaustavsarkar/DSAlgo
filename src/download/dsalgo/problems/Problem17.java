package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem17 {

	public static void main(String[] args) {
		int[] array = 
			//{12, 121};
			{ 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319,
				412 };
		// { 0, 0, 0, 0, 0 };
		// { 8, 89 };
		// { 3, 30, 34, 5, 9 };
		// { 980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923,
		// 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369,
		// 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113,
		// 302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168,
		// 866, 689, 444, 684, 365, 470, 176, 910, 204, 324, 657,
		// 161, 884, 623, 814, 231, 694, 399, 126, 426 };
		Problem17 problem = new Problem17();
		System.out.println(problem.largestNumber(array));
		;
	}
	 public String largestNumber(final List<Integer> a) {
		    
		    String[] arr = new String[a.size()];
		    for (int i = 0; i < a.size(); i++) {
		        arr[i] = String.valueOf(a.get(i));
		    }
		    
		    
		    Arrays.sort(arr, new Comparator<String>(){
		        public int compare(String a, String b){
		            return (b+a).compareTo(a+b);
		        }
		    });
		    
		 
		    StringBuilder sb = new StringBuilder();
		    for(String s: arr){
		        sb.append(s);
		    }
		 
		    if(sb.charAt(0) == '0'){     //check if all zeroes are there
		        return String.valueOf(0);
		    }
		    
		    return sb.toString();   
		    }
	public String largestNumber(final int[] A) {
		List<String>[] arrList = new ArrayList[10];
		int index = 0;
		StringBuilder sum = new StringBuilder();

		for (int num : A) {
			if (num < 10) {
				index = num % 10;
				addAtIndex(index, num, arrList);
			} else {
				index = findIndex(num);
				addAtIndex(index, num, arrList);
			}
		}

		// Sort indices if not null
		/**
		 * Sorted in descending order and at index i if there is a one digit
		 * number it shall come before/after iith term.
		 */
		for (int i = 0; i < arrList.length; i++) {
			List<String> list = arrList[i];
			index = i + 1;
			if (list != null) {
				list.sort((a, b) -> {
					return -Integer.valueOf(a+b).compareTo(Integer.valueOf(b+a));
				});
			}
		}

		for (int counter = arrList.length - 1; counter >= 0; counter--) {
			List<String> list = arrList[counter];
			if (list != null) {
				for (String num : list) {
					sum.append(num);
				}
			}
		}

		if (sum.toString().startsWith("0") && sum.toString().endsWith("0")) {
			return "0";
		}

		return sum.toString();
	}

	private int findIndex(int num) {
		int index = 10;
		int mod = 10;
		while (index >= 10) {
			index = num / mod;
			mod *= 10;
		}
		return index;
	}

	private void addAtIndex(int index, Integer num, List<String>[] arrList) {
		if (arrList[index] == null) {
			arrList[index] = new ArrayList<>();
		}
		arrList[index].add(num.toString());
	}
}
