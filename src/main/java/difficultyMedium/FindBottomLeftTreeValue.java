package difficultyMedium;

import helperClass.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Find Bottom Left Tree Value
 *
 * Problem Source: https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 * Algorithm:
 *
 * 1. We will use BFS level by level order traversal using Queue.
 *
 * 2. Initialize level, maxLevel, result to 0
 *
 * 3. Make a Queue of LinkedList
 *      Add the root to the queue
 *
 * 4. While the queue is not empty
 *      Store the queue size in a variable, level++
 *
 * 5. Do a for loop up to that size
 *      Poll the TreeNode of the queue
 *          if(level is greater than maxLevel)
 *              result is pollNode.val
 *              maxLevel is level
 *
 *          if(pollNode.left is not null)
 *              queue.add(pollNode.left)
 *
 *          if(pollNode.right is not null)
 *              queue.add(pollNode.right)
 *
 * 6. At the end, return the result, which should be the left most TreeNode value of the last row
 *    of the tree.
 *
 * Time-Complexity: O(N), N is the number of nodes in the tree
 * Space-Complexity: O(N), N is the space for our Tree Nodes in the queue.
 *
 * ---
 *
 * Other Approaches:
 *
 * Using BFS right to left: https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98779/Right-to-Left-BFS-(Python-%2B-Java)
 * Using BFS left to right, without keeping track of every node value: https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98779/Right-to-Left-BFS-(Python-+-Java)/272037
 *
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int maxLevel = 0, level = 0, result = 0;

        Queue<TreeNode> pipeLine = new LinkedList<>();
        pipeLine.add(root);

        while(!pipeLine.isEmpty()) {
            int loopSize = pipeLine.size();
            level++;

            for(int i=0; i < loopSize; i++) {
                TreeNode removedNode = pipeLine.poll();

                if(level > maxLevel) {
                    result = removedNode.val;
                    maxLevel = level;
                }

                if(removedNode.left != null) {
                    pipeLine.add(removedNode.left);
                }

                if(removedNode.right != null) {
                    pipeLine.add(removedNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode test1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();
        System.out.println(solution.findBottomLeftValue(test1));
    }
}
