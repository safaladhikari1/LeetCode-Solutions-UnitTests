/*
   Maximum Depth of Binary Tree
   
   Given a binary tree, find its maximum depth.
   
   The maximum depth is the number of nodes along the longest path
   from the root node down to the farthest leaf node.
   
   Note: A leaf is a node with no children.
   
   Example:
   
   Given binary tree: https://leetcode.com/problems/maximum-depth-of-binary-tree/
   
   return its depth = 3
   
   ----
   
   Algorithm:
   
   Approach 1: Using Recursion, Preorder DFS
   
   1. Let's say we have a binary tree
      
               3
         9           20
                  15     7
     
      
      
      our root node = 3, we pass our root node in our method
      
      our base case is,
      
      if(root == null)
      {
         return 0;
      } 
      
      else
      {
         add 1 + Math.max(maxDepth(root.left), maxDepth(root.right));        
      }
      
  2. What this does is, it goes to left of 3 first
     Root (3) is not equal to 0
     adds 1 > Recursion Starts 
     
     then go to left of 9, which is null returns 0, then go to right of 9, which is null, returns 0
     
     So, as of now we have
     
     1 + Math.max(1, here it goes to right (20))
     
  3. On the right, same thing happens, it recurses subnodes after subnodes, at the end of the recursion, it will be
      
     1 + Math.max(1, 2);
     
     which returns 3.
  
  Time Complexity: O(N), where N is the number of nodes in the tree, because it visits every nodes in the tree going down.
  
  Space Complexity: O(H),where H is the height of the tree for our recursion call stack.
  
  ------------
  
  Approach 2: Using BFS
  
  1. We are scanning the tree level by level (BFS search) and counting the levels, returning the levels at the end.
  
  2. If the root is null
         return 0
         
  3. Create a queue
         add root to the queue
     Initialize count to 0
     
  4. while queue is not empty
         Store queue's size
         
         for loop up to the queue size
         
            poll the TreeNode
            
            if root.left is not null
               add to the queue
            
            if root.right is not null
               add to the queue
         
         count++
         
  5. Return the count
  
  -------
  
  Time-Complexity: O(N), where N is the number of nodes in the tree, we visit N nodes and store it temporarily on our queue for processing
  Space-Complexity: O(H), where H is the height of the tree               

*/

import java.util.LinkedList;
import java.util.Queue;

class MaximumDepthOfBinaryTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      
      System.out.println(maxDepth(myTree));     
   }
   
   // Approach 2, Using BFS Search
   public static int maxDepth(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      
      Queue<TreeNode> tempQueue = new LinkedList<>();
      tempQueue.add(root);
      
      int count = 0;
      
      while(!tempQueue.isEmpty())
      {
         int queueSize = tempQueue.size();
         
         for(int i=0; i < queueSize; i++)
         {
            TreeNode removedNode = tempQueue.poll();
            
            if(removedNode.left != null)
            {
               tempQueue.add(removedNode.left);
            }
            
            if(removedNode.right != null)
            {
               tempQueue.add(removedNode.right);
            }
         }
         
         count++;
      }     
        
      return count;
   }   
   
   // Approach 1: Using Recursion, DFS
   
   // Tried the same problem again after few months 03/27/2021
   // It is using pre order traversal, DFS, to get the max depth of both left subtree and right subtree and adds 1, and returns it.
   /*
   public static int maxDepth(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      else
      {
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
      }
   }
   */
   
   // returns the maximum depth of the tree
   /*
   public static int maxDepth(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      
      else
      {
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
      }
   }
   */
   
   // This private class builds a tree node
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