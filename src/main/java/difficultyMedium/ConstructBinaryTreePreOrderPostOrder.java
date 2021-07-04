/*
   Problem Source: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
   
   ----
   
   Still trying to understand
   
   Helpful posts: 
   
   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
   
   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/821268/C-Construct-tree-using-preorder-traversal-first
   
   https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation
   
   More notes on new notebook, page 1.
   take off static for global variables and constructFromPrePost method, for Leetcode.

*/

class ConstructBinaryTreePreOrderPostOrder
{ 
   public static void main(String[] args)
   {
   
   }
   
   public static int preIndex = 0;
   public static int postIndex = 0;
   
   public static TreeNode constructFromPrePost(int[] pre, int[] post)
   {
      TreeNode root = new TreeNode(pre[preIndex]);
      preIndex++;
      
      if(root.val != post[postIndex])
      {
         root.left = constructFromPrePost(pre, post);
      }
      
      if(root.val != post[postIndex])
      {
         root.right = constructFromPrePost(pre, post);
      }
      
      postIndex++;
      
      return root;
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