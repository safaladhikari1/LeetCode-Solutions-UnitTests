package difficultyEasy;

import helperClass.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 *
 * Problem Source: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Algorithm:
 *
 * 1. Make a LinkedList for result
 * 2. Pass the root and Linkedlist by reference to the private method
 * 3. Private void method
 *         Base case, if root is null, return
 *         Recurse left
 *         Add the root.val to LinkedList
 *         Recurse right
 * 4. At the end, return the linked list
 *
 * Time-Complexity: O(N), where N is the number of nodes in the tree
 * Space-Complexity: O(N), where N is the height of the tree, the deeper the tree, the higher our recursive call stack.
 *
 * Approach 2:
 *
 * Iterating method using Stack: https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new LinkedList<>();
        inorderRecurse(root, resultList);
        return resultList;
    }

    private void inorderRecurse(TreeNode rootA, List<Integer> resultListA) {
        if(rootA == null){
            return;
        }

        inorderRecurse(rootA.left, resultListA);
        resultListA.add(rootA.val);
        inorderRecurse(rootA.right, resultListA);
    }

}
