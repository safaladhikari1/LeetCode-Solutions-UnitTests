package difficultyEasy;

import helperClass.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N-ary Tree Preorder Traversal
 *
 * Problem Source: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * Algorithm:
 *
 * 1. Make a result, LinkedList<Integer>
 * 2. On a private dfs recursion using pre order traversal, Me first then the other nodes
 *      Base case is if current is null
 *          return
 *
 *    Add the root.val to the LinkedList. LinkedList is passed by reference
 *
 *    Since it's not a binary tree, it's n-ary tree
 *
 *    We each visit each children nodes using for each loop
 *
 *    For each node, in the root.children
 *      recurse dfs again, passing in the current node, and LinkedList reference
 *
 * 3. After the recursion it adds, all the node.values to the LinkedList
 *
 * 4. We return the linked list
 *
 * Time-Complexity: O(N), where N is the number of nodes in the N-ary tree
 * Space-Complexity: O(N), for the recursive call stacks in the for each loop
 *
 * Iterative Approach mentioned here: https://leetcode.com/problems/n-ary-tree-preorder-traversal/discuss/147955/Java-Iterative-and-Recursive-Solutions
 *
 */
public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> tempResult, Node current) {
        if(current == null) {
            return;
        }

        tempResult.add(current.val);

        for(Node node : current.children) {
            dfs(tempResult, node);
        }
    }

    // Brute force approach, works
    /*
    public List<Integer> preorder(Node root) {
        Queue<Integer> tempStack = new LinkedList<>();

        dfs(tempStack, root);

        List<Integer> result = new LinkedList<>();

        while(!tempStack.isEmpty()) {
            result.add(tempStack.poll());
        }

        return result;
    }

    public void dfs(Queue<Integer> stack, Node current) {
        if(current == null) {
            return;
        }

        stack.add(current.val);

        for(Node node : current.children) {
            dfs(stack, node);
        }
    }

     */
}
