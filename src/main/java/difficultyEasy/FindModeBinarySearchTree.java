import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
   Find Mode in Binary Search Tree
   
   Problem Source: https://leetcode.com/problems/find-mode-in-binary-search-tree/
   
   -----
   
   Approach 1 Using HashMap:
   
   Algorithm
   
   1. Create a Map<Integer, Integer>
      
      we will use our helper method first to do pre order traversal,
      add all the node values and it's counter (how many times same elements appeared in the tree) in the map
      
   2. Let's say we have a BST
   
            1
                    2
               2
               
      The map will have
        1, 1
        2, 2
        
      in key value pairs
      
   3. Now on our findMode method
      
      we will have the check how many node keys are there in the tree, who has the maximum value of the key-value pairs in the map
      And add those node keys in the array, and return the array.
      
      We will create an array list
      First we will initialize the max to Integer.MIN_VALUE
      
      Then we will loop using, for(Map.Entry<Integer, Integer> pair : nodeTracker.entrySet())
         here will get the maximum value of all the key-value pairs in the nodeTracker map
         
      Now we will loop again, for(Map.Entry<Integer, Integer> pair : nodeTracker.entrySet())
         This time, if the pair.getValue() == max
            Then we will add it our Arraylist
              
      
      At the end, we will instantiate result array, same size as arraylist
      
      We wil add all the elements from arraylist to our result array
      
   4. Return the result array.
   
    Time Complexity: O(N), where N is the number of nodes in the tree
    Space Complexity: O(N), we used hash map to store the key value pairs for each node in the tree.
    
    -------
    
    Approach 2:
    
    On the above approach, we didn't use the property of Binary Search Tree
    i.e. when we do inorder traversal on BST, it returns the sorted node values
    
    This article has this approach, which is efficient because of O(1) space complexity.
    
    Solution from username: y0urgr4ce
    
    https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98100/Java-4ms-Beats-100-Extra-O(1)-solution-No-Map/223599 

*/

class FindModeBinarySearchTree
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)))));
   }
   
   // Remove static to make it work on Leetcode
   
   private static Map<Integer, Integer> nodeTracker = new HashMap<>();
   
   public static int[] findMode(TreeNode root)
   {
      helper(root, nodeTracker);
      
      List<Integer> list = new ArrayList<>();
      int max = Integer.MIN_VALUE;
      
      for(Map.Entry<Integer, Integer> pair : nodeTracker.entrySet())
      {
         if(pair.getValue() > max)
         {
            max = pair.getValue();
         }
      }
      
      for(Map.Entry<Integer, Integer> pair : nodeTracker.entrySet())
      {
         if(pair.getValue() == max)
         {
            list.add(pair.getKey());
         }
      }
      
      int[] result = new int[list.size()];
      
      int index = 0;
      
      for(int num : list)
      {
         result[index] = num;
         index++;
      }
      
      return result;
   }
   
   private static void helper(TreeNode root, Map<Integer, Integer> trackerMap)
   {
      if(root == null)
      {
         return;
      }
      else
      {
         trackerMap.put(root.val, trackerMap.getOrDefault(root.val, 0) + 1);
         
         helper(root.left, trackerMap);
         helper(root.right, trackerMap);   
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