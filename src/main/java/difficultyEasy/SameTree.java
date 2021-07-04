/*
   Same Tree
   
   Given two binary trees write a function to check if they are the same or not.
   
   Two binary trees are considered the same if they are structurally identical and the nodes
   have the same value.
   
   Examples: https://leetcode.com/problems/same-tree/
   
   --
   
   Algorithm:
   
   1. null?
      
      check first if both p or q nodes are pointing to null
      
      if they are, then check first if both p or q are equal
      if they are equal, means they are null, return true
      
      otherwise return false; 
  
   2. different?
   
      Now check, if p.value != q .value, if they are different, we will have to return false
      they can only move forward if they are equal
   
   3. isSameTree(right, right) && isSameTree(left, left)
   
      We pass the right nodes of each p and q
      it can return true or false
      
      We pass the left nodes of each p and q
      it can return true or false
      
      They have to return true, for the method to return true.
  
  -----
      
   Video Explanation: https://youtu.be/G9wwY-cmuiE
   
  ----
  
   Time Complexity:
   
   O(N), N is the number of nodes in the tree, one visits each node, exactly once.
   
   Space Complexity:
   
   O(Log(N)) , best case of completely balanced tree
   O(N), worst case of unbalanced tree, to keep a recursion stack.   
*/

class SameTree
{
   public static void main(String[] args)
   {
      TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      
      System.out.println(isSameTree(p, q));
   }
   
   public static boolean isSameTree(TreeNode p, TreeNode q)
   {
      if(p == null || q == null)
      {
         // if they are equal; means they are null; return true or return false
         return p == q;
      }
      
      if(p.val != q.val)
      {
         return false;
      }
      
      return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
   }
   
   private static class TreeNode
   {
      int val;
      TreeNode left;
      TreeNode right;
      
      TreeNode()
      {
         this(0, null, null);
      }
      
      TreeNode(int val)
      {
         this(val, null, null);
      }
      
      TreeNode(int val, TreeNode left, TreeNode right)
      {
         this.val = val;
         this.left = left;
         this.right = right;
      }     
   }         
}