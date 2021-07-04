/*
   PathSum II
   
   Problem Source: https://leetcode.com/problems/path-sum-ii/
   
   -----
   
   Algorithm:
   
   1. The goal is to return a List<List<Integer>>
   
      basically outerList, which has innerList of ArrayList of node values, where root-to-leaf paths sum equals targetSum
      
   2. We created outerList, List<List<Integer>>
      innerList, List<Integer>
      
      passed in root, outerList, innerList and targetSum in the helper method
      
   3. In the helper method,
      
      Base case is, if root is null
         return
         
      Otherwise add node value to innerList
      
      When we are at the leaf node i.e.
      
      if(root.left == null && root.right == null && targetSum == root.val)        
         check if the targetSum == root.val
         if it is, make a new ArrayList out of already built innerList, and added to outerList       
      
      Since we are subtracting, targetSum -= root.val on each recursive call stack
      If we have root-to-leaf paths whose sum equals targetSum, targetSum == root.val must be equals on the above if statement
      
      Then recurse to the left
      recurse to the right
      
   4. At the end, while backtracking, we have to remove the last element from the innerList
      So when we recurse to the root.right, we have an empty innerList
      
   5. After the recursion is over, on the main method, return the outerList. 
   
   -----
   
   Time-Complexity: O(N), where N is the number of nodes in the tree, we visit all the tree nodes at least once
   Space-Complexity: O(N), we store all the tree nodes in our innerList and remove it while backtracking.      

*/


import java.util.List;
import java.util.ArrayList;

class PathSumII
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))); 
      
      System.out.println(pathSum(myTree, 22));  
   }
   
   public static List<List<Integer>> pathSum(TreeNode root, int targetSum)
   {
      List<List<Integer>> outerList = new ArrayList<>();
      List<Integer> innerList = new ArrayList<>();
      
      helper(root, outerList, innerList, targetSum);
      
      return outerList;
   }
   
   public static void helper(TreeNode root, List<List<Integer>> outerList, List<Integer> innerList, int targetSum)
   {
      if(root == null)
      {
         return;
      }
      
      innerList.add(root.val);
      
      if(root.left == null && root.right == null && targetSum == root.val)
      {
         outerList.add(new ArrayList<>(innerList)); // make a new arraylist out of built-in arraylist so far
      }
      
      targetSum -= root.val;
      helper(root.left, outerList, innerList, targetSum);
      helper(root.right, outerList, innerList, targetSum);
      
      innerList.remove(innerList.size() - 1);      
   }
   
   
   
   // Bruteforce Solution (Does not work)
   /*  
   static List<Integer> innerList = new LinkedList<>();
   static List<List<Integer>> outerList = new ArrayList<>();
   static int currentSum = 0;   

   public static List<List<Integer>> pathSum(TreeNode root, int targetSum)
   {
      
      helper(root, currentSum, targetSum);
      
      return outerList;
   }
   
   public static void helper(TreeNode root, int currentSum, int targetSum)
   {
      if(root == null)
      {
         return;
      }
      
      if(root.left == null && root.right == null)
      {
         if(currentSum == targetSum)
         {
            outerList.add(innerList);
            innerList.clear();    
         }
         
         innerList.clear(); 
      }
  
      currentSum += root.val;
      innerList.add(root.val);
      
      helper(root.left, currentSum, targetSum);
      helper(root.right, currentSum, targetSum);
   }
   */
   
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