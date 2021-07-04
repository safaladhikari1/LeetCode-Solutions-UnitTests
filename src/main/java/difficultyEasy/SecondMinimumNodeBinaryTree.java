/**
 * Second Minimum Node in a Binary Tree
 *
 * Source: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * Algorithm:
 *
 * 1. We are using BFS level by level search and visiting every nodes in the tree
 * 2. We also have a flag = true in the beginning
 * 3. Since we need to find the second minimum node in the tree,
 *    While visiting the nodes, we want to check if the currentNode.val > root.val
 *      If it is, store that value in minVal
 *      Change the flag to false
 * 4. There might be a special case where,
 *
 *    [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
 *
 *    Initially we find 3 as the second minimum node
 *
 *    But at the end we also have 2
 *
 *    So we have to check,
 *    if flag is false and currentNode.val != root.val
 *      then store the minimum of current minimum value and currentNode.value
 * 5. At the end, if minVal is still root.val, then we didn't find second Minimum value
 *    Otherwise, return the second Minimum value.
 *
 *
 * Time-Complexity: O(N), where N is the total nodes in the tree
 * Space-Complexity: O(N), we temporarily use queue to process the tree nodes.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumNodeBinaryTree {
    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(findSecondMinimumValue(testTree));
    }

    /**
     * Returns the second minimum node in a binary tree
     *
     * @param root the root of the tree
     * @return int value
     */
    public static int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }

        Queue<TreeNode> BFS = new LinkedList<>();
        BFS.add(root);
        int minVal = root.val;
        boolean flag = true;

        while (!BFS.isEmpty()) {
            int size = BFS.size();

            for (int i=0; i < size; i++) {

                TreeNode tempNode = BFS.poll();

                if(tempNode.val > minVal && flag) {
                    minVal = tempNode.val;
                    flag = false;
                }

                if(!flag && tempNode.val != root.val) {
                    minVal = Math.min(tempNode.val, minVal);
                }

                if(tempNode.right != null) {
                    BFS.add(tempNode.right);
                }

                if(tempNode.left != null) {
                    BFS.add(tempNode.left);
                }
            }
        }

        return minVal == root.val ? -1 : minVal;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
