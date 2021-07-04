/*
   Binary Tree Level Order Traversal
   
   Problem Source: https://leetcode.com/problems/binary-tree-level-order-traversal/
   
   --
   
   Algorithm:
   
   This problem is similar to
   
   https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
   
   Solution and Approach: https://github.com/safaladhikari1/CodingProblems/blob/master/LeetCode/Easy/BinaryTreeLevelOrderTraversal.java
   
   
   1. We will create an outerList of LinkedList
      
      List<List<Integer>> outerList = new LinkedList<>();
      
   2. If the root is null, return the empty outerList
   
   3. Create a queue of TreeNode, let's call it pipeline
      
      we will add the root first to the queue
      
   4. Inside the while loop, if the pipeline is not empty
      
      we will first create an inner list of linkedlist
      store the size of the pipeline queue on levellength variable
      
      for loop, that goes up to size of pipeline (level length)
      
         remove the treenode from the queue
         add the treenode's value to inner list
         
         if the treenode.left is not null
            add the treenode.left to the queue
         
         if the treenode.right is not null
            add the treenode.right to the queue
            
      Outside the for loop, we are done with level 1, add the innerlist to our outer list
      
   5. Return the outerlist
   
   -------
   
   Time-Complexity: O(N), N is the number of nodes in our tree. We visit every nodes in the tree at least once.
   Space-Complexity: O(N), the bigger the N, the bigger our size of outerlist.        

*/


import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal
{
   public static void main(String[] args)
   {
      System.out.println(levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
   }
   
   public static List<List<Integer>> levelOrder(TreeNode root)
   {
      List<List<Integer>> outerList = new LinkedList<>();
      
      if(root == null)
      {
         return outerList;
      }
      
      Queue<TreeNode> pipeLine = new LinkedList<>();
      pipeLine.add(root);
      
      while(!pipeLine.isEmpty())
      {
         List<Integer> innerList = new LinkedList<>();
         int levelLength = pipeLine.size();
         
         for(int i=0; i < levelLength; i++)
         {
            TreeNode currentNode = pipeLine.poll();
            
            innerList.add(currentNode.val);
            
            if(currentNode.left != null)
            {
               pipeLine.add(currentNode.left);
            }
            
            if(currentNode.right != null)
            {
               pipeLine.add(currentNode.right);
            }
         }
         
         outerList.add(innerList);         
      }
       
      return outerList;
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