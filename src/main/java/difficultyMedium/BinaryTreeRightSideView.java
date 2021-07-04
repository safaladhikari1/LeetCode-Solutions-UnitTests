/**
 * Binary Tree Right Side View
 *
 * Problem source: https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Algorithm:
 *
 * 1. We are doing the level order traversal (BFS)
 * 2. Since we are only adding the right side of the tree,
 *
 *    For level traversal, we create a LinkedList O(1) to add
 *    We create a queue
 *    Then add root to the queue
 *
 *    while queue is not empty
 *      store the queue's size in size
 *
 *      do a for loop up to that size
 *          poll the TreeNode from the queue
 *
 *          Since we are adding the right side TreeNode first,
 *          If i is 0, the add the TreeNode value to the list
 *          Because we know it's going to be the right side
 *
 *          There is 1 case, if the tree is
 *                      1
 *
 *                 2
 *
 *           Then, it will still add 2 to our list, so our result List will be [1, 2]
 *
 * 3. At the end, return the resultList (LinkedList)
 *
 * Time-Complexity: O(N), N is the number of nodes in the tree. We still visit every nodes in the tree
 * Space-Complexity: O(N), the space for our queue.
 *
 * Reference: https://leetcode.com/problems/binary-tree-right-side-view/discuss/56076/Reverse-Level-Order-Traversal-java
 *
 * ----
 * Another approach using DFS: https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
 *
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        TreeNode testTree2 = new TreeNode();

        System.out.println(rightSideView(testTree2));
    }

    /**
     * Returns the values of the nodes as we can see from top to bottom, by standing on the right side of the tree
     *
     * @param root root of a Binary Tree
     * @return LinkedList of the values of the nodes.
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();

        if(root == null) {
            return resultList;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();

        levelQueue.add(root);

        while(!levelQueue.isEmpty()) {
            int size = levelQueue.size();

            for(int i=0; i < size; i++) {
                TreeNode tempNode = levelQueue.poll();

                if(i == 0) {
                    resultList.add(tempNode.val);
                }

                if(tempNode.right != null) {
                    levelQueue.add(tempNode.right);
                }

                if(tempNode.left != null) {
                    levelQueue.add(tempNode.left);
                }
            }
        }

        return resultList;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){

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
