package download.dsalgo.problems;

import java.util.*;

/**
 * You are given an integer N. You have to find smallest multiple of N which
 * consists of digits 0 and 1 only. Since this multiple could be large, return
 * it in form of a string.
 * 
 * Note:
 * 
 * Returned string should not contain leading zeroes. For example,
 * 
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1. For N = 2,
 * 10 is the answer.
 * 
 * @author kaussark
 *
 */
public class Problem236 {

	public static void main(String[] args) {
		int i = 2;
		char c = (char) (i+'0');
		System.out.println(c);
	}
	public static String _multiple(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Invalid args");
        }

        String result = "0";

        if (num > 0) {
            // A set to store all the visited nodes
            boolean[] isVisited = new boolean[num];
            Arrays.fill(isVisited, false);

            Set<Integer> visitedSet = new HashSet<>();
            // The queue used by BFS
            Queue<Node> queue = new ArrayDeque<>();

            // Add the first number 1 and mark it visited
            queue.add(new Node(true, 1 % num, null));
            isVisited[1 % num] = true;

            // The final destination node which represents the answer
            Node destNode = null;

            while (!queue.isEmpty()) {
                // Get the next node from the queue
                Node currNode = queue.remove();

                if (currNode.val == 0) {
                    // We have reached a valid multiple of num
                    destNode = currNode;
                    break;
                } else {
                    // Visit the next 2 neighbors
                    // Append 0 - (currNode.val * 10)
                    // Append 1 - (currNode.val * 10) + 1

                    // Append a '0'
                    int val1 = (currNode.val * 10) % num;
                    if (!isVisited[val1]) {
                        queue.add(new Node(false, val1, currNode));
                        isVisited[val1] = true;
                    }
                    
                    // Append a '1'
                    int val2 = (val1 + 1);
                    if (val2 == num) {
                        val2 = 0;
                    }
                    if (!isVisited[val2]) {
                        queue.add(new Node(true, val2, currNode));
                        isVisited[val2] = true;
                    }
                }
            }

            // Trace the path from destination to source
            if (destNode == null) {
                throw new IllegalStateException("Result should not be null");
            } else {
                StringBuilder reverseResultBuilder = new StringBuilder();
                Node currNode = destNode;
                while (currNode != null) {
                    reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
                    currNode = currNode.prev;
                }
                result = reverseResultBuilder.reverse().toString();
            }
        }

        return result;
    }

    private static class Node {
        public final boolean isDigitOne;
        public final int val;
        public final Node prev;
        public Node(boolean isDigitOne, int val, Node prev) {
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.prev = prev;
        }
    }
	public String multiple(int A) {
		//long multiple = 1;
		Queue<Long> candidateQueue = new LinkedList<>();
		candidateQueue.offer(1l);
		while (candidateQueue.peek() % A != 0) {
			Long multiple = candidateQueue.poll();
			candidateQueue.addAll(getNextCandidates(multiple));
		}
		return candidateQueue.peek().toString();
	}

	public List<Long> getNextCandidates(long num) {
		List<Long> candidates = new ArrayList<Long>();
		candidates.add(num * 10);
		candidates.add((num * 10) + 1);
		return candidates;
	}

}
