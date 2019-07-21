package download.dsalgo.problems;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Example :
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 return true, as there exist a
 * root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author kaussark
 *
 */
public class Problem164 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1000);
		root.left = new TreeNode(2000);
		//root.left.left = new TreeNode(-3001);

		System.out.println(new Problem164().hasPathSum(root, 1000));
	}

	public int _hasPathSum(TreeNode root, int i) {
		// TODO Auto-generated method stub
		return hasPathSum(root, i);
	}

	public int hasPathSum(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			if (node.val == sum)
				return 1;
			else
				return 0;
		}

		int isFound = hasPathSum(node.left, sum - node.val);

		if (isFound != 1) {
			isFound = hasPathSum(node.right, sum - node.val);
		}
		return isFound;
	}
}
