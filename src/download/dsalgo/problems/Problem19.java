package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem19 {
	public static void main(String[] args) {
		Problem19 problem = new Problem19();
		int rooms = 23;

		// A : [ 49, 8, 22, 28, 9, 15, 42, 3 ]
		// B : [ 72, 38, 66, 51, 49, 57, 79, 30 ]
		// C : 2
		
		// A : [ 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28,
		// 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 ]
		// B : [ 28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65,
		// 35, 91, 13, 76, 60, 90, 67, 22, 51, 53 ]
		// C : 23
		Integer[] arr = {13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8};
			//{ 49, 8, 22, 28, 9, 15, 42, 3 };
		Integer[] dep = {28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53}; 
			//{ 72, 38, 66, 51, 49, 57, 79, 30 };
		ArrayList<Integer> arrive = new ArrayList<>();
		ArrayList<Integer> depart = new ArrayList<>();

		arrive.addAll(Arrays.asList(arr));
		depart.addAll(Arrays.asList(dep));

		boolean acco = problem.hotel(arrive, depart, rooms);
		System.out.println(acco);
	}

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart,
			int K) {
		int arrCounter = 0;
		int depCounter = 0;
		int guests = 0;

		arrive.sort((a,b)->a.compareTo(b));
		depart.sort((a,b)->a.compareTo(b));
		
		while (arrCounter < arrive.size() && depCounter < depart.size()) {

			if (arrive.get(arrCounter) < depart.get(depCounter)) {
				++guests;
				arrCounter++;
			} else if (arrive.get(arrCounter) == depart.get(depCounter)) {
				arrCounter++;
				depCounter++;
			} else {
				--guests;
				depCounter++;
			}

			if (guests > K) {
				return false;
			}

		}

		return true;
	}

	public boolean _hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart,
			int K) {
		Map<Integer, Integer> bookings = new HashMap<>();

		for (int i = 0; i < arrive.size(); i++) {
			int start = arrive.get(i);
			int end = depart.get(i);
			for (int j = start; j < end; j++) {
				int guests = bookings.get(j) == null ? 0 : bookings.get(j);
				if (guests == K) {
					return false;
				} else {
					bookings.put(j, guests + 1);
				}
			}
		}

		System.out.println(bookings);

		return true;
	}
}
