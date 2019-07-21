package download.dsalgo.problems;

import java.util.ArrayList;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values
 * in the tree.
 * 
 * Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and
 * w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node
 * that has both v and w as descendants. Example :
 * 
 * 
 * _______3______ / \ ___5__ ___1__ / \ / \ 6 _2_ 0 8 / \ 7 4 For the above
 * tree, the LCA of nodes 5 and 1 is 3.
 * 
 * LCA = Lowest common ancestor Please note that LCA for nodes 5 and 4 is 5.
 * 
 * You are given 2 values. Find the lowest common ancestor of the two nodes
 * represented by val1 and val2 No guarantee that val1 and val2 exist in the
 * tree. If one value doesn’t exist in the tree then return -1. There are no
 * duplicate values. You can use extra memory, helper functions, and can modify
 * the node struct but, you can’t add a parent pointer.
 * 
 * @author kaussark
 *
 */
public class Problem170 {

	public static void main(String[] args) {

	}
	 public int _lca(TreeNode A, int B, int C) {

	        if (A == null) return -1;

	        ArrayList<Integer> pathToB = new ArrayList<>();
	        ArrayList<Integer> pathToC = new ArrayList<>();
	        if(!findNode(B, A, pathToB) || !findNode(C, A, pathToC)){
	            return -1;
	        }

	        if (pathToB.isEmpty() || pathToC.isEmpty()) return -1;

	        int i;
	        for (i = 0; i < pathToB.size() && i < pathToC.size(); i++) {
	            if (!pathToB.get(i).equals(pathToC.get(i))) {
	                break;
	            }
	        }

	        return pathToB.get(i - 1);

	    }

	    private boolean findNode(int b, TreeNode a, ArrayList<Integer> path) {

	        if (a == null) {
	            return false;
	        }

	        path.add(a.val);

	        if (a.val == b) {
	            return true;
	        }
	        if (findNode(b, a.left, path)){
	            return true;
	        }
	        if (findNode(b, a.right, path)){
	            return true;
	        }
	        path.remove(path.size() - 1);
	        return false;

	    }
	boolean firstfound, secondFound;

	public int lca(TreeNode A, int B, int C) {
		
		int node = findElement(A, B, C);
		if(firstfound && secondFound && node != Integer.MIN_VALUE) {
			return node;
		}
		return -1;
	}

	public int findElement(TreeNode node, int num1, int num2) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		if (node.val == num1 || node.val == num2) {
			if (firstfound) {
				secondFound = true;
			} else {
				firstfound = true;
			}
		}

		int leftVal = findElement(node.left, num1, num2);
		int rightVal = findElement(node.right, num1, num2);
		
		if((leftVal == Integer.MIN_VALUE && rightVal == Integer.MIN_VALUE) && (node.val==num1 || node.val==num2)) {
			return node.val;
		}
		return Integer.MIN_VALUE;
	}
}
