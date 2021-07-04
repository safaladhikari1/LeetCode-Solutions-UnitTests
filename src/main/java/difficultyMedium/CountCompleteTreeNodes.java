/**
 * Count Complete Tree Nodes
 *
 * Problem Source: https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Algorithm:
 *
 * Approach 1: Traverse the whole tree using dfs (pre-order traversal) to count the number of nodes
 *
 * Time-Complexity: O(N), where N is the number of nodes in the tree.
 *
 * Approach 2:
 *
 * Using the advantage of full binary tree inside a complete tree.
 *
 * Reference: https://youtu.be/4wPlA_InnGY
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)/63523
 *
 * 1. If we have a full binary tree (a tree where all nodes have 2 child nodes)
 *    Number of total nodes in a tree = 2 ^ height of the tree - 1
 *
 *    If the tree has height = 3
 *
 *    Total number of nodes = 2 ^ 3 - 1 = 7
 *
 * 2. To make sure that we don't visit every nodes in the tree; at each node, we check if we have
 *    full binary tree, if we do we have the formula  (2^h - 1) to get the total number of nodes in that sub tree.
 *
 * 3. We have helper methods to get height of left sub tree, height of right sub tree.
 *
 * 4. On count method,
 *
 *    if root is null
 *      return 0
 *
 *    get the left height
 *    get the right height
 *
 *    If left height and right height are equal, it's full binary tree
 *      get the total count using (2^h - 1)
 *
 *      We can use two ways, (2 << left) - 1, bitwise operations
 *      since left and right are equal, we can use either
 *
 *      Every bit wise left to 1, multiplies the number by 2
 *
 *      For example:
 *
 *      0 0 0 0 0 1 1 1 = 7
 *
 *      0 0 0 0 0 1 1 1 << 2
 *
 *      0 0 0 1 1 1 0 0 = 28
 *
 *      Or, use the Math.pow() method, and cast to int.
 *
 *    Otherwise,
 *      go root.left + root.right + 1 (count for root node)
 *
 *  Time-Complexity: O(log N * log N), logN to calculate the height one time.
 *                   Reference: https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
 *  Space-Complexity: O(1)
 */

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));

        System.out.println(countNodes(testTree));
    }

    // Approach 2
    public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getLeftHeight(root.left);
        int right = getRightHeight(root.right);

        if(left == right) {
            return (2 << left) - 1;
            // return (int)Math.pow(2, left) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int getLeftHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + getLeftHeight(root.left);
    }

    public static int getRightHeight(TreeNode root) {
        int count = 0;

        while(root != null) {
            count++;
            root = root.right;
        }

        return count;
    }

    // Approach 1: Traverse the whole tree using dfs (pre-order traversal) to count the number of nodes
    /*
    public static int countNodes(TreeNode root) {
        int[] count = new int[1];

        dfs(root, count);

        return count[0];
    }

    public static void dfs(TreeNode root, int[] count) {
        if(root == null) {
            return;
        }

        if(root != null) {
            count[0]++;
        }

        dfs(root.left, count);
        dfs(root.right, count);
    }

     */

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
