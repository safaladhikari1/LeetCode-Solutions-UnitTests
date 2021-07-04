/*
   Increasing Order Search Tree
   
   Problem Source: https://leetcode.com/problems/increasing-order-search-tree/
   
   --------
   
   Algorithm:
   
   1. Use the helper method:
    
      Traverse the Tree using In-order Traversal (Left, Me, Right)
      Add the root.values to an ArrayList during the traversal
   2. On the outer method:
      
      Create another root2, with the first value of the ArrayList
      Then take out the other values from the ArrayList, and add to root2.right using current pointer
   3. Return the root 2
   
   ------
   
   Time-Complexity: O(N), where N is the number of nodes in the tree
   Space-Complexity: O(N), we store all the node values in our ArrayList.   


*/

import java.util.List;
import java.util.ArrayList;

class IncreasingOrderSearchTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(5, new TreeNode(1), new TreeNode(7));
      
      increasingBST(myTree);
   }
   
   public static TreeNode increasingBST(TreeNode root)
   {
      List<Integer> myList = new ArrayList<>();
      
      helper(myList, root);
      
      TreeNode root2 = new TreeNode(myList.get(0));
      TreeNode current = root2; 
      
      for(int i=1; i < myList.size(); i++)
      {
         current.right = new TreeNode(myList.get(i));
         current = current.right;
      }
      
      return root2;
   }
   
   private static void helper(List<Integer> myList, TreeNode root)
   {
      if(root == null)
      {
         return;
      }
      
      helper(myList, root.left);
      myList.add(root.val);
      helper(myList, root.right);     
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