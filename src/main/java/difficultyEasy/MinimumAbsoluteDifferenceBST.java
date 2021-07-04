/*
   Problem Source: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
   
   ---
   
   Algorithm:
   
   Approach 1, Using Global Variables
   
   1. Same explanation as: 
      
      https://github.com/safaladhikari1/CodingProblems/blob/master/LeetCode/Easy/MinimumDistanceBetweenBSTNodes.java
      
      Problem Source: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
      
   -----
   
   Approach 2, Without using Global Variables
   
   1. Same concept as above, 
      
      here we use cacheArray of size 2
      
      we initialize with 
      
      int[] cacheArray = new int[] {-1, Integer.MAX_VALUE};
      
   2. At first, cacheArray[0] is -1, but after we visit our first node, we will put root.val to cache[0]
   
      if(cache[0] != -1)
      {
         cache[1] = Math.min(root.val - cache[0], cache[1]);
      }
      
      Here, we don't need Math.abs() because it is a BST, t      
      
      since it's a BST, root.val will always be greater, so no need of Math.abs
      
   -----
   
   Both solutions
   
   Time-Complexity: O(N), where N is the number of nodes in the tree. We visit every nodes in this BST at least once.
   Space-Complexity: O(H), where H is the height of the tree for our recursive call stack.   
      
*/

class MinimumAbsoluteDifferenceBST
{
   public static void main(String[] args)
   {
      TreeNode myTree= new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6)); 
      
      System.out.println(getMinimumDifference(myTree));  
   }
   
   // Remove static on all variables methods below for leet code.
   
   // Approach 2: Without using Global variables
   public static int getMinimumDifference(TreeNode root)
   {
      int[] cacheArray = new int[] {-1, Integer.MAX_VALUE};
      
      helper(root, cacheArray);
      
      return cacheArray[1];
   }
   
   public static void helper(TreeNode root, int[] cache)
   {
      if(root == null)
      {
         return;
      }
      
      helper(root.left, cache);
      
      if(cache[0] != -1)
      {
         cache[1] = Math.min(root.val - cache[0], cache[1]); 
      }
      
      cache[0] = root.val;
      
      helper(root.right, cache);     
   }
   
   // Approach 1: With Global variables
   /*
   private static int min = Integer.MAX_VALUE;
   private static TreeNode prevNode = null;
   
   public static int getMinimumDifference(TreeNode root)
   {    
      helper(root); 
      
      return min;  
   }
   
   private static void helper(TreeNode root)
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
   */
  
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