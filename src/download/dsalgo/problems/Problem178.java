package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * It’s Tushar’s birthday today and he has N friends. Friends are numbered [0,
 * 1, 2, …., N-1] and i-th friend have a positive strength S(i). Today being his
 * birthday, his friends have planned to give him birthday bombs (kicks :P).
 * Tushar’s friends know Tushar’s pain bearing limit and would hit accordingly.
 * If Tushar’s resistance is denoted by R (>=0) then find the lexicographically
 * smallest order of friends to kick Tushar so that the cumulative kick strength
 * (sum of the strengths of friends who kicks) doesn’t exceed his resistance
 * capacity and total no. of kicks hit are maximum. Also note that each friend
 * can kick unlimited number of times (If a friend hits x times, his strength
 * will be counted x times)
 * 
 * Note:
 * 
 * Answer format = Vector of indexes of friends in the order in which they will
 * hit. Answer should have the maximum no. of kicks that can be possibly hit. If
 * two answer have the same no. of kicks, return one with the lexicographically
 * smaller. [a1, a2, …., am] is lexicographically smaller than [b1, b2, .., bm]
 * if a1 < b1 or (a1 = b1 and a2 < b2) … . Input cases are such that the length
 * of the answer does not exceed 100000. Example: R = 11, S = [6,8,5,4,7]
 * 
 * ans = [0,2] Here, [2,3], [2,2] or [3,3] also give the maximum no. kicks.
 * 
 * @author kaussark
 *
 */
public class Problem178 {

	public static void main(String[] args) {
		Integer[] strength = { 8, 7, 6, 5, 4 };

		// { 8, 8, 6, 5, 4 };
		Integer totalPOwer = 13;
		// 10;
		System.out.println(new Problem178()._solve(totalPOwer,
				new ArrayList<>(Arrays.asList(strength))));
	}

	public ArrayList<Integer> _solve(int A, ArrayList<Integer> B) {
		int maxKicks = A / Collections.min(B);
		int min = Collections.min(B);
		int i = 0;
		ArrayList<Integer> result = new ArrayList<>();
		int currentKicks = 0;
		while (i < B.size()) {
			if (((A - B.get(i)) >= 0) && 
					((currentKicks + ((A - B.get(i)) / min) + 1) == maxKicks)) {
				result.add(i);
				A = A - B.get(i);
				currentKicks++;
			} else
				i++;

		}
		return result;
	}

	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		ArrayList<ArrayList<Integer>> kickIndices = new ArrayList<>();
		// first find max kicks by one member
		for (int i = 0; i < B.size(); i++) {
			int remain = A;
			int strength = B.get(i);
			ArrayList<Integer> temp = new ArrayList<>();
			while (remain >= 0) {
				remain = remain - strength;
				if (remain >= 0) {
					temp.add(i);
				}
			}
			kickIndices.add(temp);
		}

		for (int rowx = 0; rowx < B.size(); rowx++) {
			for (int colx = rowx + 1; colx < B.size(); colx++) {
				if (B.get(rowx) + B.get(colx) - A <= 0) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(rowx);
					temp.add(colx);
					kickIndices.add(temp);
					break;
				}
			}
		}
		int maxSize = 0;
		int maxIndex = 0;

		kickIndices.sort((a, b) -> {
			int index = 0;
			while (index < Math.min(a.size(), b.size()) - 1
					&& a.get(index).compareTo(b.get(index)) == 0) {
				index++;
			}

			return a.get(index).compareTo(b.get(index));
		});

		for (int i = 0; i < kickIndices.size(); i++) {
			int curr = kickIndices.get(i).size();
			if (curr > maxSize) {
				maxSize = curr;
				maxIndex = i;
			}
		}
		return kickIndices.get(maxIndex);
	}
}
