/**
 * @author Safal Adhikari
 * @version 1.0
 *
 * Convert BST to Greater Tree
 *
 * Problem Source: https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * Algorithm:
 *
 * 1. We are using Reverse In-Order traversal for this problem
 *
 *    Inorder: Left, Me, Right
 *    Reverse-Inorder: Right, Me, Left
 *
 * 2. The basic idea is, before visiting any node in the tree, we must first visit all nodes with greater value.
 *    In a BST, the greater value nodes are located in the right subtree.
 *
 * 3. We are also passing int[] sum = new int[1], sum array as reference, so can change the sum[0] with its pointer, on each recursive call stack.
 *    This helps us to avoid using global variable for sum.
 *
 * 4. Then on helper method, our base case is if the root is null, return
 *    Otherwise, traverse to the right, pass in sum
 *    Store the root.val in sum
 *    Change the root.val = sum[0] (current running sum)
 *    recurse to the left.
 *
 * 5. At the end, return the root node on the parent method.
 *
 * -------------
 *
 * Time-Complexity: O(N), where N is the number of nodes in the tree. We visit all nodes in the tree, at least once.
 * Space-Complexity: O(N), the higher the N, the higher our recursive call stack.
 *                   On worse case, if we have a tree with only left, or right subtrees. The call stack will grow until
 *                   the end of the longest path is reached (height of the tree.), which also includes all N nodes.
 *
 * Reference: https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
 *
 */

public class ConvertBSTGreaterTree
{
    public static void main(String[] args)
    {
        TreeNode myTree = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null , new TreeNode(8))));

        bstToGst(myTree);
    }

    /**
     * Returns the root of a tree, after it gets converted to a greater tree.
     *
     * @param root the root node of the tree
     * @return the root of the tree.
     */
    public static TreeNode bstToGst(TreeNode root)
    {
        int[] sum = new int[1];

        helper(root, sum);

        return root;
    }

    /**
     * helper method for the bstToGst() method above.
     *
     * @param root root of the tree
     * @param sum reference to sum array from the bstToGst() method.
     */
    public static void helper(TreeNode root, int[] sum)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            helper(root.right, sum);
            sum[0] += root.val;
            root.val = sum[0];
            helper(root.left, sum);
        }
    }

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {

        }

        TreeNode(int val)
        {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
