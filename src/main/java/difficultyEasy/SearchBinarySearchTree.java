/*
   Search in a Binary Search Tree
   
   Problem Source: https://leetcode.com/problems/search-in-a-binary-search-tree/
   
   ------
   
   Algorithm:
   
   1. Base case is if root is null, return null
   
   2. If the search value is less than root value
         recurse to the left
         
   3. If the search value is greater than root value
         recurse to the right
         
   4. Otherwise, the root value must be equal to search value
         Then return the root.
         
   -----
   
   Time-Complexity: O(LogN)
   Space-Complexity: O(H), where H is the height of the tree. 
                     Height of the Tree is the longest route from root to the leaf node.                  

*/

class SearchBinarySearchTree
{
   public static void main(String[] args)
   {
   
   }
   
   public static TreeNode searchBST(TreeNode root, int val)
   {
      if(root == null)
      {
         return null;
      }    
      else if(val < root.val)
      {
         return searchBST(root.left, val);
      }
      else if(val > root.val)
      {
         return searchBST(root.right, val);
      }

      return root;
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