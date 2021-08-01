package difficultyEasy;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Average of Levels in Binary Tree
 *
 * Problem Source: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Algorithm:
 *
 * 1. We are doing BFS level order traversal, as explained in
 *    Approach 2 section of article: https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
 *
 *  Time-Complexity: O(N), N is the number of nodes in the binary tree. We visit each nodes at least once.
 *  Space-Complexity: O(M), M is the maximum number of nodes at any level of the input binary tree.
 *                    The maximum size of the pipeLine queue is M.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> resultList = new LinkedList<>();
        Queue<TreeNode> pipeLine = new LinkedList<>();
        double tempVal = 0.0;

        if(root == null) {
            return resultList;
        }

        pipeLine.add(root);

        while(!pipeLine.isEmpty()) {
            int size = pipeLine.size();

            for(int i=0; i < size; i++) {
                TreeNode tempNode = pipeLine.poll();
                tempVal += tempNode.val;

                if(tempNode.left != null){
                    pipeLine.add(tempNode.left);
                }

                if(tempNode.right != null) {
                    pipeLine.add(tempNode.right);
                }
            }

            resultList.add(tempVal / size);

            tempVal = 0.0;
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode testTree2 = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
        System.out.println(solution.averageOfLevels(testTree2));
    }
}













