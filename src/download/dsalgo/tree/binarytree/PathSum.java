package download.dsalgo.tree.binarytree;


import sun.reflect.generics.tree.Tree;
import sun.reflect.generics.tree.Tree;

import java.nio.file.Path;

/**
 * @author: Kaustav Sarkar
 * @created: 9/12/2019
 */
public class PathSum {

    private static class Tree {
        int data;
        Tree left;
        Tree right;

        public Tree(int data) {
            this.data = data;
        }
    }
    public static void main(String[] ahgs) {
        Tree root = new Tree(10);
        root.left = new Tree(20);
        root.right = new Tree(30);
        root.left.left = new Tree(40);
        root.left.right = new Tree(60);

        System.out.println(PathSum.treePathsSum(root));
    }
    public static int treePathsSum(Tree root)
    {
        return treeSumHelper(root, 0);
        //return sum;
    }

    private static int treeSumHelper(Tree root, int currentSum) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return currentSum*10 + root.data;
        }
        int leftSum = treeSumHelper(root.left,
                root.data + currentSum * 10);
        int rightSum = treeSumHelper(root.right,
                root.data + currentSum * 10);
        return leftSum + rightSum;
    }
}
