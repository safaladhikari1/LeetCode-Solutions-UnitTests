/*
   Maximum Depth of N-ary Tree
   
   Problem Source: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
   
   -------
   
   Algorithm:
   
   1. Similar to Maximum Depth of Binary Tree as explained in:
   
      https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/152659/Java-solution-with-explain-same-logic-with-Maximum-Depth-of-binary-tree
      
      https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/549474/Java-100-Recursion-%2B-Explaination
      
      In calculating maximum depth of Binary Tree
      
      https://leetcode.com/problems/maximum-depth-of-binary-tree/
   
   2. Since each node only had maximum of 2 nodes
   
       public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
      }
   
      Our base case was when root == null, return 0
   
      We went all the way to the left, the maximum depth of the current node was Math.max(left, right) + 1
      
      Then calculated the maximum depth of the left subtree
      
      Then we went all the way to the right, and calculate the maximum depth of the right subtree
   
      Then the maximum of left subtree and right subtree + 1 was the maximum depth of the binary tree (longest path from root to leaf node)
      
   3. For N ary tree
      
      We don't have left and right pointers for each node
      
      We instead have a List of children nodes for each node
      
      So our base case is if root == null, return 0, i.e. when we have went past the leaf node
      
      we created a variable called maxDepth
      
      Then assigned maxDepth to 0
      
      Then for each node, we looped through its children nodes
         and find the depth of each child
         
         if the current depth (depth of each child node) is greater than our maxDepth
            maxDepth is the current depth
            
   4. At the end, return our maxDepth + 1, which accounts for the root node (very first node, 1 in the problem diagram)
                      
   -------
   
   Time-Complexity: O(N), where N is the number of nodes in our tree
   Space-Complexity: O(H), where H is the height of the tree, the deeper our tree, the deeper our call stack.   
   
   
   If it's a balanced N-ary tree, the height will be approximately O(Log(base of 2) N) to O(Log(base of 1) N)                  

*/

import java.util.LinkedList;
import java.util.List;

class MaximumDepthNaryTree
{
   public static void main(String[] args)
   {
      // Building a N-ary tree: https://github.com/VamsiSangam/theoryofprogramming/blob/master/Tree%20Data%20Structures/N-ary%20Tree/Java/NaryTreeNode.java
      
   }
   
   public static int maxDepth(Node root)
   {
      if(root == null)
      {
         return 0;
      }
         
      int maxDepth = 0;
      
      for(Node child : root.children)
      {
         int currentDepth = maxDepth(child);
         
         if(maxDepth < currentDepth)
         {
            maxDepth = currentDepth;
         }
      }
      
      return maxDepth + 1;
   }
   
   // Bruteforce approach, doesn't work
   /*
   public static int maxDepth(Node root)
   {
      int maxValue = 0;
      
      //return helper(root, maxValue) + 1;
      
      return 1;
   }
   
   public static int helper(Node root, int maxValue)
   {
      if(root == null)
      {
         return -1;
      }
      else
      {
         for(Node child : root.children)
         {
            maxValue = Math.max(helper(child, maxValue), helperr)
         }
      }
      
   }
   */
}