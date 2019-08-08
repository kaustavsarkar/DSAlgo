package download.dsalgo.problems;

import java.util.*;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements: Each child must have at least one candy. Children with a higher
 * rating get more candies than their neighbors. What is the minimum candies you
 * must give?
 * 
 * Sample Input :
 * 
 * Ratings : [1 2] Sample Output :
 * 
 * 3 The candidate with 1 rating gets 1 candy and candidate with rating cannot
 * get 1 candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In
 * total, 2+1 = 3 candies need to be given out.
 * 
 * @author kaussark
 *
 */
public class Problem228 {

	public static void main(String[] args) {
		Integer[] ratings = { -255, 369, 319, 77, 128, -202, -147, 282, -26,
				-489, -443, -401, 385, 465, -134, 126, 304, 179, 16, 112, 473,
				-467, 279, -233, 66, 76, 408, 148, -369, 328, 138, -164, 492,
				-276, -326, 170, 168, 189, 13, 383, 341, 426, 219, 337, -62,
				-197, 263, 338, -324, 261, 273, -74, -8, -133, 318, -100, 487,
				-196, -465, -495, -136, 94, -201, 491, 204, 323, 156, -337, -99,
				115, 179, 184, -249, 76, -396, 265, 500, -83, 270, 438, -418,
				401, -184, -247, -203, 190, 191, -282, -248, 465, 146, 7, -381,
				326, -409, 474, 186, -206, 447, 17, 156, -273, 381, -307, -206,
				164, -147, 58, -224, 284, 204, 267, 123, 141, -8, 225, -246, 12,
				399, -261, -104, 191, 390, 152, 313, -91, 8, -476, -363, -183,
				-280, -282, -431, 366, 89, -166, -257, 132, 98, -387, 389, -219,
				-332, 227, 386, -33, 361, -308, -494, -33, 110, 423, -465, -417,
				496, -333, -259, 402, 36, 380, -385, -329, 283, 389, 396, -161,
				466, -405, -293, 442, 259, 377, -386, -386, 329, 204, 438, 346,
				-185, -401, -219, 213, 351, -18, -20, 364, 319, 187, 197, 122,
				-182, -126, -211, -448, 44, -360, -345, -147, 480, -387, 222,
				92, -262, -409, 163, 323, -291, -61, -431, -288, -309, -490,
				-494, 328, -207, 398, 475, -228, -37, 44, 227, -371, -91, -440,
				220, 39, -73, 80, -189, 37, 94, -96, -400, -380, 172, -179,
				-442, -119, 411, -184, 218, -18, 170, 430, -157, 345, 418, 390,
				-39, -85, 216, -197, -421, 328, -311, 160, 432, 104, -419, -140,
				-115, -202, 58, 415, 473, -87, 475, 430, 114, -314, 430, -419,
				375, 258, 255, 42, -63, 54, -352, -337, -180, -31, 441, -382,
				-176, 209, -137, 171, -89, 155, 421, 308, -153, 254, -210, -245,
				373, -435, -29, -398, 326, 297, 81, -157, 254, 52, 479, 356,
				-497, -16, 109, -353, -20, -122, -172, 23, 20, -344, 203, 372,
				-306, -9, 238, -190, 495, 9, -2, 125, 150, -180, -340, -1, -347,
				-269, -181, -15, 83, -304, -365, 490, -475, 161, 422, 440, -414,
				380, -446, -404, -352, -144, -297, -62, -23, -223, 359, 127,
				183, -20, 93, -285, -477, 223, 1, 131, -359, -74, 321, 197, 452,
				-338, 367, -337, 183, -41, 218, -75, -212, 208, 188, -38, 91,
				332, 388, -185, -247, 405, -390, -371, 313, -471, 457, 307, 494,
				-467, -225, -3, -271, -164, -120, 101, 385, -12, 234, -368,
				-317, 167, 241, -494, -279, -288, 452, -499, 372, 464, 234, 16,
				40, 264, -474, -400, 429, 33, 495, -285, 201, 190, 328, 127,
				286, 312, 100, -24, 409, -392, 183, -69, -352, -56, -304, -261,
				-296, -140, 453, 253, -215, 195, 288, -300, 10, -104, -491, 275,
				-275, 175, 24, 387, 408 };
		// {1, 2};
		System.out.println(new Problem228()
				.candy(new ArrayList<>(Arrays.asList(ratings))));
	}

	public int candy(ArrayList<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return 1;
		}
		int[] count = new int[A.size()];
		
		for(int i = 0; i < A.size(); i++) {
			count[i] = 1;
		}
		// Check with previous element
		for (int index = 1; index < A.size(); index++) {
			
			if (A.get(index) > A.get(index - 1)) {
				count[index] = Math.max(count[index], count[index - 1] + 1);
			}
		}

		// Check next element
		for (int index = A.size() - 2; index >= 0; index--) {
			if (A.get(index) > A.get(index + 1)) {
				count[index] = Math.max(count[index], count[index + 1] + 1);
			}
		}

		int totalCount = 0;
		for (int counts : count) {
			totalCount += counts;
		}
		return totalCount;
	}

	public int _candy(ArrayList<Integer> A) {
		if (A == null || A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return 1;
		}
		int totalCount = 1;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		// find min index
		for (int i = 0; i < A.size(); i++) {
			int rating = A.get(i);
			if (rating < min) {
				min = rating;
				minIndex = i;
			}
		}
		int leftPrev = 1;
		int rightPrev = 1;
		int leftCounter = minIndex - 1;
		int rightCounter = minIndex + 1;
		while (leftCounter >= 0 || rightCounter < A.size()) {
			// check leftCounter prev val with currVal
			if (leftCounter >= 0)
				if (A.get(leftCounter) > A.get(leftCounter + 1)) {
					leftPrev++;
					totalCount += leftPrev;
				} else {
					leftPrev--;
					totalCount += leftPrev;
				}

			if (rightCounter < A.size())
				if (A.get(rightCounter) > A.get(rightCounter - 1)) {
					rightPrev++;
					totalCount += rightPrev;
				} else {
					rightPrev--;
					totalCount += rightPrev;
				}
			leftCounter--;
			rightCounter++;
		}
		return totalCount;
	}
}
