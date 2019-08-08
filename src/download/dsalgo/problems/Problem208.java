package download.dsalgo.problems;

import java.util.*;

/**
 * As it is Tushar’s Birthday on March 1st, he decided to throw a party to all
 * his friends at TGI Fridays in Pune. Given are the eating capacity of each
 * friend, filling capacity of each dish and cost of each dish. A friend is
 * satisfied if the sum of the filling capacity of dishes he ate is equal to his
 * capacity. Find the minimum cost such that all of Tushar’s friends are
 * satisfied (reached their eating capacity).
 * 
 * NOTE:
 * 
 * Each dish is supposed to be eaten by only one person. Sharing is not allowed.
 * Each friend can take any dish unlimited number of times. There always exists
 * a dish with filling capacity 1 so that a solution always exists. Input Format
 * 
 * Friends : List of integers denoting eating capacity of friends separated by
 * space. Capacity: List of integers denoting filling capacity of each type of
 * dish. Cost : List of integers denoting cost of each type of dish.
 * Constraints: 1 <= Capacity of friend <= 1000 1 <= No. of friends <= 1000 1 <=
 * No. of dishes <= 1000
 * 
 * Example:
 * 
 * Input: 2 4 6 2 1 3 2 5 3
 * 
 * Output: 14
 * 
 * Explanation: First friend will take 1st and 2nd dish, second friend will take
 * 2nd dish twice. Thus, total cost = (5+3)+(3*2)= 14
 * 
 * @author kaussark
 *
 */
public class Problem208 {

	public static void main(String[] args) {
		Integer[] frCap = { 2, 3, 1, 5, 4 };
		Integer[] foodCap = { 3, 2, 4, 1 };
		Integer[] cost = { 1, 2, 5, 10 };
		System.out.println(new Problem208().solve(Arrays.asList(frCap),
				Arrays.asList(foodCap), Arrays.asList(cost)));
	}

	public int solve(final List<Integer> A, final List<Integer> B,
			final List<Integer> C) {
		int maxHunger = A.stream()
				.max((hunger1, hunger2) -> hunger1.compareTo(hunger2)).get();
		int[] hungerSpent = new int[maxHunger + 1];
		SortedMap<Integer, Integer> menu = new TreeMap<>(
				(key1, key2) -> key1.compareTo(key2));
		for (int i = 0; i < B.size(); i++) {
			if (menu.containsKey(B.get(i)) && menu.get(B.get(i)) < C.get(i)) {
				continue;
			} else {
				menu.put(B.get(i), C.get(i));
			}
		}
		for (Map.Entry<Integer, Integer> costEntry : menu.entrySet()) {
			for (int hunger = 1; hunger < hungerSpent.length; hunger++) {
				if (hunger >= costEntry.getKey()) {
					if (hunger == menu.firstKey()) {
						hungerSpent[hunger] = menu.get(hunger);
					} else {
						if (hungerSpent[hunger] == 0) {
							hungerSpent[hunger] = hungerSpent[hunger
									- costEntry.getKey()]
									+ costEntry.getValue();
						} else {
							hungerSpent[hunger] = Math.min(
									hungerSpent[hunger - costEntry.getKey()]
											+ costEntry.getValue(),
									hungerSpent[hunger]);
						}
					}
				}
			}
		}
		int totalCost = 0;
		for (int hunger : A) {
			totalCost += hungerSpent[hunger];
		}
		return totalCost;
	}
}
