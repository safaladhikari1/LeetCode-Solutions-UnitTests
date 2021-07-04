/**
 * Univalued Binary Tree
 *
 * Problem Source: https://leetcode.com/problems/univalued-binary-tree/
 *
 * Algorithm:
 *
 * 1. We are just passing in int[] memo and boolean[] result as a reference on each recursive call
 *    as we are doing DFS down the tree using pre order traversal
 *
 * 2. At any point, if root.val does not equal to the memo[0]
 *    Then we set the result[0] to false. result[0] is previously true
 *
 * 3. At the end, return the result[0]
 *
 * Time-Complexity: O(N), where N is the total number of nodes in the tree
 * Space-Complexity: O(H), where H is the height of the tree. The greater the height (longest route from root to leaf),
 *                   the deeper our recursive call stack.
 *
 * ------
 *
 * Another approach using BFS with Queue structure: https://leetcode.com/problems/univalued-binary-tree/discuss/211397/JavaPython-3-BFS-and-DFS-clean-codes-w-brief-analysis.
 *
 */

public class UnivaluedBinaryTree
{
    public static void main(String[] args)
    {
        TreeNode testTree = new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)));

        System.out.println(isUnivalTree(testTree));
    }

    /**
     * Returns whether the given tree is univalued.
     *
     * @param root the root of the tree
     * @return boolean
     */
    public static boolean isUnivalTree(TreeNode root)
    {
        int[] memo = new int[1];
        boolean[] result = new boolean[1];
        result[0] = true;
        memo[0] = root.val;

        helper(root, memo, result);

        return result[0];
    }

    private static void helper(TreeNode root, int[] memo, boolean[] result)
    {
        if(root == null)
        {
            return;
        }
        else if(memo[0] != root.val)
        {
            result[0] = false;
            return;
        }
        else
        {
            helper(root.left, memo, result);
            helper(root.right, memo, result);
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
