package difficultyMedium;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 *
 * Problem Source: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Algorithm:
 *
 * 1. Make an outerList, initialize it
 *    Make a queue, initialize
 *    Make a innerlist
 *    Make zigZag to false
 *    Intialize pipeLine queue
 *
 * 2. We are doing level order traversal,
 *    First the null check
 *
 * 3. Then add root to the queue
 *
 * 4. While queue is not empty
 *      follow the  level order traversal technique
 *      create an innerList first
 *      loop until the queue's size
 *
 *      We are using zigZag boolean value to alter the add method in our innerList
 *      If it's true, add the values from the respective level, at the beginning of the list
 *      If it's false, add the values from the respective level, at the end of the list
 *
 *      This will create the zipZag pattern on our innerList for each levels.
 *
 * 5. After the for loop ends, add the innerList to outerList, zipZag gets altered.
 *
 * 6. At the end, return the outerList
 *
 * Time-Complexity: O(N), where N is the number of nodes in the tree.
 * Space-Complexity: O(N)
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode testRoot1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        TreeNode testRoot2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(solution.zigzagLevelOrder(testRoot2));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> outerList = new LinkedList<>();
        List<Integer> innerList;
        Queue<TreeNode> pipeLine = new LinkedList<>();
        boolean zigZag = false;

        if(root == null) {
            return outerList;
        }

        pipeLine.add(root);

        while (!pipeLine.isEmpty()) {
            int pipeLineSize = pipeLine.size();
            innerList = new LinkedList<>();

            for(int i=0; i < pipeLineSize; i++) {
                TreeNode currentNode = pipeLine.poll();

                if(zigZag) {
                    innerList.add(0, currentNode.val);
                }
                else {
                    innerList.add(currentNode.val);
                }

                if(currentNode.left != null) {
                    pipeLine.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    pipeLine.add(currentNode.right);
                }
            }

            outerList.add(innerList);
            zigZag = !zigZag;
        }

        return outerList;
    }

}
