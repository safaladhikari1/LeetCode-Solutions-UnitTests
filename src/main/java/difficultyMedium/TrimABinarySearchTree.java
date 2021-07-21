package difficultyMedium;

import helperClass.TreeNode;

/**
 * Trim a Binary Search Tree
 *
 * Problem Source: https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * Algorithm:
 *
 * 1. We are using Pre order traversal: M, L, R on the following BST, with low = 1, high = 3
 *
 *                          3
 *                   0              4
 *                          2
 *                   1
 *
 * 2. If the root is null, return null
 *
 * 3. If root.val < low
 *          return trimBST(root.right, low, high)
 * 4. If root.val > high
 *          return trimBST(root.left, low, high)
 *
 * 5. root.left = trimBST(root.left, low, high)
 *
 * 6. root.right = trimBST
 *
 * Detailed recursion explanation:
 *
 *    Is 3 less than low, No
 *    Is 3 more than high, No
 *
 *    3.left = root(0)
 *
 *    Is 0 less than low, Yes
 *
 *      Ignore everything on left of 0, because it's BST so it will all be less than 0, and we can exclude that subtree
 *      return by recursing to the right of 0, root(2)
 *
 *    Is 2 less than low, No
 *    Is 2 more than high, No
 *
 *    Per Pre order traversal, Recurse left, by setting
 *    2.left = root(1) i.e. 1 = 2.left
 *
 *    Is 1 less than low, No
 *    Is 1 more than high, No
 *
 *    1.left is null
 *    1.right is null
 *
 *    2.left is done
 *    2.right is null
 *
 *    0.right returns
 *
 *    3.left is root(2)
 *
 *    It will look like:
 *
 *                  3
 *            2         4
 *       1
 *
 *    Similarly, it avoids 4 using the same logic above.
 *
 * Time-Complexity: O(N), where N is the number of nodes in the tree, we visit every nodes at least once
 * Space-Complexity: O(N), worst case, we have N recursive call stacks in our recursion.
 *
 *

 */
public class TrimABinarySearchTree {

    public static void main(String[] args) {
        TrimABinarySearchTree solution = new TrimABinarySearchTree();
        TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        solution.trimBST(root, 1, 3);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root == null) {
            return null;
        }

        if(root.val < low) {
            return trimBST(root.right, low, high);
        }

        if(root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
