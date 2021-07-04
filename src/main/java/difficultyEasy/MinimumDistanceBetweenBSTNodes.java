/*
   Minimum Distance Between BST Nodes
   
   Problem Source: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
   
   The question is asking, the minimum difference between BST nodes.
   
   -----
   
   Algorithm:
   
   1. We will first instantiate min, as Integer's maximum value (2^31-1 = 2147483647)
      
      https://www.geeksforgeeks.org/integer-max_value-and-integer-min_value-in-java-with-examples/
      
      Then point the prevNode to null
      
   2. Then we will do the In-Order Traversal on the tree
   
                     4
              2            6
         1        3
         
   3. Traverse DFS to the left, the point the prevNode to 1
      
      Then recurse back to root = 2
      
      Then enter the if(prevNode != null)
         And store the min = Math.min(min, 2 - 1)
         
      Point the prevNode to 2
      
      Then recurse root.right, And so on...                  
   
   4. This way, we will keep track of our min value, in our global variable.
   
   5. Return the min at the end.
   
   -------
   
   Time-Complexity: O(N), where N is the nodes in the tree, we visit every node in the tree at least once.
   Space-Complexity: O(H), where H is the height of the tree, the deeper the tree, the higher our recursion call stack.   
          
*/


class MinimumDistanceBetweenBSTNodes
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
      
      System.out.println(minDiffInBST(myTree));
   }
   
   // Take off static for leetcode, otherwise we won't be able to change the
   // min value, because it becomes static
   // We have to change the min value on our recursion
   private static int min = Integer.MAX_VALUE;
   private static TreeNode prevNode = null;
   
   public static int minDiffInBST(TreeNode root)
   {
      helper(root);
      
      return min;
   }
   
   public static void helper(TreeNode root)
   {
      if(root == null)
      {
         return;
      }
      
      helper(root.left);
      
      if(prevNode != null)
      {
         min = Math.min(min, root.val - prevNode.val);
      }
      
      prevNode = root;
      
      helper(root.right);
   }
   
   private static class TreeNode
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