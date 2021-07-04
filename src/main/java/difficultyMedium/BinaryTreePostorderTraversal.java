/*
   Given the root of a binary tree, return the postorder
   traversal of its nodes values.
   
   Input: root = [1, null, 2, 3]
   Output: [3, 2, 1]
   
   Source: https://leetcode.com/problems/binary-tree-postorder-traversal/
   
   -------
   Approach 1: Recursion Solution
   
   Algorithm:
   
   1. This is the easy approach:
      We create an ArrayList to store the node values.
      
      We create a private method postorderTraversal(Treenode, list)
      
      we pass in tree node, and the array list
      
      For post order:
         left
         right
         root
         
      We recurse left, we recurse right, and add the values
      
      Our base case if (root != null)
      
   Time Complexity: O(N), where N is the number of nodes in the tree
   Space Complexity: O(H), where H is the height of the tree. The higher the tree, the higher the call stack in this recursion.
   
   -----
   
   Approach 2: Iterative Solution
   
   Algorithm:
   
   1. We create 1 stack called traversal, create 1 linked list called result.
   
      we pass in the root in the postorderTraversal(root)
      
      if the root is null, then return the result, which is empty.
      
      Otherwise, we know that the root is not null
      
      So, push that root on traversal stack
      
      while(traversal is not empty)
      
         TreeNode top = pop the node that's in the stack
         result.add(0, top.val)
         
         This means, we are adding the top value to the top of our linked list for each iteration.
         As oppose to Arraylist, it takes constant time to add an element to the head of a linked list, without any memory shift.
         
         Then we check top.left != null
            traversal.push(top.left);
            
         Then we check top.right != null
            traversal.push(top.right);   
          
         We are in the loop until we visit all the nodes in the tree, add them to the stack, pop them, add the node value to our linkedlist.
   
   2. At the end we return the result.
   
   ------
   Time-Complexity: O(N), where N is the number of nodes in the tree.
   Space-Complexity: O(H), where H is the height of the tree, the higher the tree, the more nodes we have to put on our stack that takes memory.      
          
*/


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class BinaryTreePostorderTraversal
{
   public static void main(String[] args)
   {
      TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
      postorderTraversal(root);
   }
   
   // Iterative Solution
   public static List<Integer> postorderTraversal(TreeNode root)
   {
      Stack<TreeNode> traversal = new Stack<>();
      List<Integer> result = new LinkedList<>();
      
      if(root == null)
      {
         return result;
      }
      
      traversal.push(root);
      
      while(!traversal.isEmpty())
      {
         TreeNode top = traversal.pop();
         result.add(0, top.value);
         
         if(top.left != null)
         {
            traversal.push(top.left);
         }
         
         if(top.right != null)
         {
            traversal.push(top.right);
         }
      }
      
      return result;
        
   }
   
   // Recursive Solution   
   /*
   public static List<Integer> postorderTraversal(TreeNode root)
   {
      List<Integer> myList = new ArrayList<>();
      
      postorderTraversal(root, myList);
      
      return myList;
   }
   
   private static void postorderTraversal(TreeNode root, List<Integer> list)
   {
      if(root != null)
      {
         postorderTraversal(root.left, list);
         postorderTraversal(root.right, list);
         list.add(root.value);
      }
   }
   */
   
   private static class TreeNode
   {
      int value;
      TreeNode left;
      TreeNode right;
      
      TreeNode()
      {
      
      }
      
      TreeNode(int value)
      {
         this.value = value;
      }
      
      TreeNode(int value, TreeNode left, TreeNode right)
      {
         this.value = value;
         this.left = left;
         this.right = right;
      }     
   }
}  