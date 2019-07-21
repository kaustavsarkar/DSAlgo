package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * Example : Given binary tree
 * 
 * 3 / \ 9 20 / \ 15 7 return
 * 
 * [ [3], [20, 9], [15, 7] ]
 * 
 * @author kaussark
 *
 */
public class Problem162 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(new Problem162().zigzagLevelOrder(root));
	}
	public ArrayList<ArrayList<Integer>> _zigzagLevelOrder(TreeNode A) {
        boolean leftToRight = true;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> eachLevel = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = A;
        TreeNode curr;
        queue.add(temp);
        queue.add(null);
        while (!queue.isEmpty()) {
            eachLevel.clear();
            while (queue.peek() != null) {
                curr = queue.poll();
                if(leftToRight) {
                    eachLevel.add(curr.val);
                }else{
                    eachLevel.add(0,curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }
            curr = queue.poll();
            if (curr == null && !queue.isEmpty()) {
                queue.add(null);
            }
            leftToRight = !leftToRight;
            result.add(new ArrayList<>(eachLevel));
        }
        return result;
    }
	private static class LevelOrder {
		TreeNode node;
		Integer level;

		public LevelOrder(TreeNode node, Integer level) {
			this.node = node;
			this.level = level;
		}

		public String toString() {
			return "[" + node.val + ":" + level + "]";
		}
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		Stack<LevelOrder> levelStack = new Stack<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Map<Integer, Deque<TreeNode>> levelOrderMap = new HashMap<>();

		LevelOrder levelOrder = new LevelOrder(A, 1);
		levelStack.push(levelOrder);
		while (!levelStack.isEmpty()) {
			levelOrder = levelStack.pop();
			if (levelOrder != null && levelOrder.node != null) {
				Integer level = levelOrder.level;
				TreeNode left = levelOrder.node.left;
				TreeNode right = levelOrder.node.right;
				levelStack.push(new LevelOrder(left, level + 1));
				levelStack.push(new LevelOrder(right, level + 1));
				if (levelOrderMap.containsKey(level)) {
					if (level % 2 != 0) {
						levelOrderMap.get(level).addFirst(levelOrder.node);
					} else {
						levelOrderMap.get(level).addLast(levelOrder.node);
					}
				} else {
					Deque<TreeNode> levelList = new LinkedList<>();
					levelList.add(levelOrder.node);
					levelOrderMap.put(level, levelList);
				}
			}
		}

		for (Map.Entry<Integer, Deque<TreeNode>> levels : levelOrderMap
				.entrySet()) {
			Deque<TreeNode> level = levels.getValue();
			ArrayList<Integer> list = new ArrayList<>();
			while (!level.isEmpty()) {
				list.add(level.pollFirst().val);
			}
			result.add(list);
		}

		return result;
	}
}
