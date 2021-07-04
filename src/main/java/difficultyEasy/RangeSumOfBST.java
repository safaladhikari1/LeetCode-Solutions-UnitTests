/**
 * Range Sum of BST
 *
 * Problem Source: https://leetcode.com/problems/range-sum-of-bst/
 *
 * Algorithm:
 *
 * 1. Make an int[] reference of size 1
 *
 * 2. On a private recursive method,
 *
 *      We are doing the Pre-order traversal (M, L, R)
 *
 *      Check if root is null
 *          return
*
 *      Check me first
 *      (if node.val >= min && node.val <= max)
 *          reference[0] += node.val
*
 *      recurse to the left
 *      recurse to the right
 *
 * 3. Return reference[0]
 *
 * Time-Complexity: O(N), where N is the number of total nodes in the tree
 * Space: O(H), H is the height of the tree, the higher the tree, the deeper our recursive call stacks.
 *
 * ----
 *
 * Another clean approach mentioned under Method 1 of the post:
 *
 * https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 *
 *
 */

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));

        System.out.println(rangeSumBST(testTree, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int[] result = new int[1];

        if(root == null) {
            return 0;
        }

        dfs(root, low, high, result);

        return result[0];
    }

    private static void dfs(TreeNode current, int lowVal, int highVal, int[] resultRef){
        if(current == null) {
            return;
        }

        if(current.val >= lowVal && current.val <= highVal) {
            resultRef[0] += current.val;
        }

        dfs(current.left, lowVal, highVal, resultRef);
        dfs(current.right, lowVal, highVal, resultRef);
    }

    private static class TreeNode {
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
