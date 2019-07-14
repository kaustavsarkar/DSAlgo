package download.dsalgo.problems;

/**
 * N number of books are given. The ith book has Pi number of pages. You have to
 * allocate books to M number of students so that maximum number of pages
 * alloted to a student is minimum. A book will be allocated to exactly one
 * student. Each student has to be allocated at least one book. Allotment should
 * be in contiguous order, for example: A student cannot be allocated book 1 and
 * book 3, skipping book 2.
 * 
 * NOTE: Return -1 if a valid assignment is not possible
 * 
 * Input:
 * 
 * List of Books M number of students Your function should return an integer
 * corresponding to the minimum number.
 * 
 * Example:
 * 
 * P : [12, 34, 67, 90] M : 2
 * 
 * Output : 113
 * 
 * There are 2 number of students. Books can be distributed in following fashion
 * : 1) [12] and [34, 67, 90] Max number of pages is allocated to student 2 with
 * 34 + 67 + 90 = 191 pages 2) [12, 34] and [67, 90] Max number of pages is
 * allocated to student 2 with 67 + 90 = 157 pages 3) [12, 34, 67] and [90] Max
 * number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * 
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * 
 * @author kaussark
 *
 */
public class Problem46 {

	public static void main(String[] args) {
		Problem46 problem = new Problem46();
		int[] time = { 12, 34, 67, 90 };
		int students = 3;

		System.out.println(problem.books2(time, students));

	}

	public int books1(int[] A, int K) {
		if (A == null || A.length == 0) {
			return -1;
		}

		// If number of students are greater than books
		if (K > A.length) {
			return -1;
		}

		long low = getMax(A);
		long high = getSum(A);

		long mid = low + (high - low) / 2;
		;

		while (low < high) {
			mid = low + (high - low) / 2;
			int num = numOfStudents(A, mid);

			if (num <= K) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		// low contains optimal max number of pages per student
		return (int) low;
	}

	private int getMax(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int a : array) {
			max = Math.max(max, a);
		}
		return max;
	}

	private long getSum(int[] array) {
		long sum = 0;
		for (int a : array) {
			sum += a;
		}
		return sum;
	}

	private int numOfStudents(int[] array, long maximumPages) {
		int numOfStudents = 1;
		long count = 0;

		for (int a : array) {
			count += a;
			if (count > maximumPages) {
				count = a;
				numOfStudents++;
			}
		}
		return numOfStudents;
	}

	public int books2(int[] A, int B) {

		/*
		 * Number of students exceed the number of books, hence invalid
		 * assignment
		 */
		if (B > A.length)
			return -1;

		/* Lower boundary for Binary Search : All students assigned one book */
		int low = A[0];
		for (int i = 0; i < A.length; i++) {
			if (low < A[i])
				low = A[i];
		}

		/* Upper boundary for Binary Search : One student assigned all books */
		int high = 0;
		for (int i = 0; i < A.length; i++) {
			high += A[i];
		}

		/* Search for the minimum value where isPossible() becomes true */
		while (low < high) {

			int mid = low + ((high - low) / 2);

			if (isPossible(A, mid, B) == true)
				high = mid;
			else
				low = mid + 1;
		}

		return low;
	}

	/*
	 * Checks greedily if is possible to have given maxNumberOfPages for B
	 * students
	 */
	public boolean isPossible(int[] A, int maxNumberOfPages, int B) {
		int total = 0, students = 1;

		for (int i = 0; i < A.length; i++) {
			total += A[i];

			if (total > maxNumberOfPages) {
				total = A[i];
				students++;
			}
		}

		return students <= B ? true : false;
	}

	public int books(int[] A, int B) {
		int maxPages = 0;
		long maxSum = 0;
		int stCount = 0;
		int avgPages = 0;
		int max = 0;
		for (int a : A) {
			max =Math.max(max, a);
			maxSum += a;
		}
		avgPages = (int) (maxSum / B);
		maxSum = 0;
		for (int i = 0; i < A.length; i++) {
			if (maxPages > avgPages && stCount < B - 1) {
				stCount++;
				maxSum = maxPages;
				maxPages = 0;
			}
			maxPages += A[i];
		}

		if (stCount + 1 != B)
			maxSum = checkMaxSum(A, maxSum, stCount, B);
		return (int) Math.max(max, maxSum);
	}

	/**
	 * Check for any smaller alternate
	 * 
	 * @param a
	 * @param maxSum
	 * @param stCount
	 */
	private int checkMaxSum(int[] a, long maxSum, int stCount, int students) {
		// find remaining books and students
		int remaining = 0;
		for (int i = 0; i < a.length; i++) {
			maxSum -= a[i];
			if (maxSum == 0) {
				remaining = a.length - i - 1;
				break;
			}
		}

		while (remaining > 0 && remaining < students - stCount) {
			remaining++;
			for (int i = 0; i < a.length - remaining; i++) {
				maxSum += a[i];
			}
		}

		return (int) maxSum;
	}

}
