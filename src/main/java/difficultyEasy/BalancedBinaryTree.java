/*
   Balanced Binary Tree
   
   Given a binary tree, determine if it is height-balanced.
   
   For this problem, a height-balanced binary tree is defined as:
   
   a binary tree in which the left and right subtrees of every node differ in height no more than 1.
   
   -----
   LeetCode Problem: https://leetcode.com/problems/balanced-binary-tree/
   
   -----
   
   Algorithm: 
   
   1. If we have a tree like:
            3
            
         9     20
         
            15     7 
      
      If the tree only has one root node, height = 0
      the child nodes on the left, has height 1
      the child nodes on the right, has height 2
      
      2 - 1 = 1
      
      We are allowed to have no more than 1 in difference in heights.
      
      So the above tree is balanced.
      
   2. We check if the root is null, if it is return true.
      Then, we check if the height of the root is equal to -1.
      If it is not equal to -1, the tree is balanced.
      If it is equal to -1, the tree is unbalanced.
      
   3. We have a private getHeight(TreeNode root) method that returns int.
      
      if root is null, return 0. Our base case.
      
      Otherwise recurse to root.left and save the output to int left
      recurse to root.right and save the output to int right
      
      if(left == -1 or right == -1 or Math.abs(left - right) > 1)
      {
          we return -1;
      }
      
      because if one of the child node returns -1, we want to pass the -1 to the parent node (up) and so on.
      
      Otherwise, we return Math.max(left, right) + 1; 
      Because the height is the maximum of left and right.
  
  4. If the getHeight() method does not return -1, then it's a balanced tree.
     If it returns -1, it's unbalanced tree.
      
  -----
  Time-Complexity: O(N), where N is the number of nodes in the tree. 
                   We visit every nodes during this recursion using depth first approach.
  
  Space-Complexity: O(NLogN), why?
  
  -----
  
  Resources used: 
  
  https://youtu.be/_pP1UaL-Xi8
  
  https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html
*/


class BalancedBinaryTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      
      System.out.println(isBalanced(myTree));
   }
   
   public static boolean isBalanced(TreeNode root)
   {
      if(root == null)
      {
         return true;
      }
      
      return getHeight(root) != -1;
   }
   
   private static int getHeight(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      
      if(left == -1 || right == -1 || Math.abs(left - right) > 1)
      {
         return -1;
      }
      
      return Math.max(left, right) + 1;
   }
   
   private static class TreeNode
   {
      int data;
      TreeNode left;
      TreeNode right;
      
      TreeNode()
      {
      
      }
      
      TreeNode(int data)
      {
         this.data = data;
      }
      
      TreeNode(int data, TreeNode left, TreeNode right)
      {
         this.data = data;
         this.left = left;
         this.right = right;
      }
   }
}