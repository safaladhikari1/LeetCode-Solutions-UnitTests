/*
   Leaf-Similar Trees
   
   Two binary trees are considered leaf-similar if their leaf value sequence is the same.
   Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
   
   Problem Source: https://leetcode.com/problems/leaf-similar-trees/
   
   -------
   
   Algorithm:
   
   1. The algorithm uses Depth First Approach
      
      We will have our helper method that does the DFS using pre-order traversal
      if(root.left == null && root.right == null)
         add the root.val to our ArrayList
      
      recurse root.left
      recurse root.right
      
   2. On our leafSimilar method
         We will create two ArrayList, to add the root.val for both root1 and root2.
         
         Then we will call our helper method for both root1 and root 2
   3. At the end, check if root1's ArrayList is equal root2's ArrayList.
   
   -------
   
   Time-Complexity: O(T1 + T2), where T1 and T2 are the height of tree1 and tree2 respectively.
   Space-Complexity: O(T1 + T2), the higher the tree, the deeper our call stack for recursion.            
*/

import java.util.List;
import java.util.ArrayList;

class LeafSimilarTrees
{
   public static void main(String[] args)
   {
      TreeNode tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      TreeNode tree2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
      
      System.out.println(leafSimilar(tree1, tree2));     
   }
   
   public static boolean leafSimilar(TreeNode root1, TreeNode root2)
   {
      List<Integer> root1List = new ArrayList<>();
      List<Integer> root2List = new ArrayList<>();
      
      helper(root1, root1List);
      helper(root2, root2List);      
      
      return root1List.equals(root2List);
   }
   
   public static void helper(TreeNode root, List<Integer> list)
   {
      if(root == null)
      {
         return;
      }
      
      if(root.left == null && root.right == null)
      {
         list.add(root.val);
      }
      
      helper(root.left, list);
      helper(root.right, list);
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