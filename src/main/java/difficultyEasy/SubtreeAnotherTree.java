/*
   Problem Source: https://leetcode.com/problems/subtree-of-another-tree/
   
   ----
   
   Algorithm:
   
   Explained in Approach 2 section of
   article: https://leetcode.com/problems/subtree-of-another-tree/solution/
   
   https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal

*/

class SubtreeAnotherTree
{
   public static void main(String[] args)
   {
      TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
      TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));
      
      System.out.println(isSubtree(s, t));
   }
   
   public static boolean isSubtree(TreeNode s, TreeNode t)
   {
      if(s == null)
      {
         return t == null;
      }
      
      return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);   
   }
   
   private static boolean isIdentical(TreeNode s, TreeNode t)
   {    
      if(s == null && t == null)
      {
         return true;
      }
      
      if(s == null || t == null)
      {
         return false;
      }
      
      return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
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