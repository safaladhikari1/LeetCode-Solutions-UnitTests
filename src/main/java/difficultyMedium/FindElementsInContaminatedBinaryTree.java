/*
   Problem Source: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
   
   -----
   
   Algorithm:
   
   The way I understand the problem is it wants to 
   
   1. Create FindElements constructor, by passing in a TreeNode root
   2. Create find method, that returns boolean if the target value exist in the new Binary Tree, after it has been contaminated.
   
   We are allowed to contiminate the tree using the following rules:
   
   root.val == 0
   
   If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
   
   If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
   
   
   For example: the original tree is 
   
   -1
   
        -1
        
   After the tree is contaminated, it will be 
   
   0
        2
        
   Then we can instantiate FindElements object, with the root of the new contaminated tree
   And check if findElementsobject.find(2), which returns true
   
   -----
   
   Steps:
   
   1. Create a TreeNode class
   2. Create a HashSet<Integer> in the FindElements class
   3. Create a constructor for FindElements(TreeNode root)
      
      if(root == null)
         return
         
      This means, the original binary tree's root is not null, so contaminate it with helper method by passing in
      root.val = 0, according to our rule above.
      
      helper(root, 0)
      
   4. On helper method
      
      Change the root value to our new value
      
      if(root.left != null)
         
         helper(recurse to the left, change the root value to 2*value + 1)
         
      if(root.right != null)
         helper(recurse to the right, change the root value to 2*value + 2)
         
   5. For find method
         return if our set contains the target.
         
   -----
   
   Inside the FindElements class:
   
   For FindElements() constructor
   
   Time-Complexity: O(N), where N is the number of the nodes in the original tree
   
   Space-Complexity: O(H), where H is the height of the original tree, the deeper the tree, the deeper the call stack                     

   
   For find() method
   
   Time-Complexity: O(1), search operation in HashSet is constant
   Space-Complexity: O(N), where N is the node values of the contaminated tree in our HashSet.

*/

import java.util.Set;
import java.util.HashSet;

class FindElementsInContaminatedBinaryTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(-1, null, new TreeNode(-1));
      
      FindElements findElementsObj = new FindElements(myTree);
      
      System.out.println(findElementsObj.find(2));
  
   }
   
   public static class FindElements
   {
      Set<Integer> mySet = new HashSet<>();
      
      public FindElements(TreeNode root)
      {
         if(root == null)
         {
            return;
         }
         
         helper(root, 0);
      }
      
      public void helper(TreeNode root, int val)
      {
         root.val = val;
         
         mySet.add(val);
         
         if(root.left != null)
         {
            helper(root.left, 2*val + 1);
         }
         if(root.right != null)
         {
            helper(root.right, 2*val + 2);
         }
      }
      
      public boolean find(int target)
      {
         return mySet.contains(target);
      }
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