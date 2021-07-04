/*
   Binary Tree Paths
   
   Given a binary tree, return all root-to-leaf paths.
   
   Note: A leaf is a node with no children.
   
   --------
   Algorithm:
   
   1. So basically if we are given an input of root node of a Tree
             1
         2       3
            5
      
      The output is root-to leaf paths, in a string format in a List.
      ["1 ->2 -> 5", "1 -> 3"]
      
   2. We make a public method binaryTreePaths(root)
      
      Create an ArrayList of String
      Create a StringBuilder, instead of String concatenation.
      Because StringBuilder is immutable object instead of a String.
      String is immutable in Java, creates a copy in every recursion, which is a waste of our memory.
      
      We make private treePaths(root, myList, sb), so we can pass our treenode, list and string builder
      
      returns our list.
   
   3. On the private method,
   
      If the root is null, return it.
      
      save the length of the string builder on len, because we can use this later when we are backtracking.
      
      append the root. val in string builder.
      
      if(root left is null and root right is null)
         Convert the stringbuilder to string, and add it to our list.        
      
      else
        append("->") to our string builder
        recurse root.left, passing in list and string builder
        recurse root.right, passing in list and string builder
        
      *** If you notice, when the string gets added to the string builder
          On each recursive call, the root.left or root.right are in their own state
          That means, len values are different on every state.
          
          sb.setLength() gets called on every state,
          So it just decreases the string builder length, as it is backtracking on those recursive calls
          
          eventually it sets the sb length to 0, which is empty string builder
          each time, after myList.add(sb.toString()) gets executed.
          
          sb.setLength() is explained on https://www.tutorialspoint.com/java/lang/stringbuilder_setlength.htm
    
    ---------------
    
    Time-Complexity: O(N), where N is the number of nodes in the tree on our depth first approach.
                     We visit every nodes at least once.      
    
    Space-Complexity: O(H), where H is the height of the tree, the higher the H, the higher our recursive call stack, while traversing using depth first approach in this tree.
    
    --------
    
    To further optimize this solution:
    
    One this to note is, our 
    
    sb.setLength(len); 
    
    is being called on every recursive stack call, while backtracking. That call needs to be accounted for our Time-Complexity as well. Something to think about.     
*/

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
      
      System.out.println(binaryTreePaths(myTree));
      
   }
   
   public static List<String> binaryTreePaths(TreeNode root)
   {
      List<String> myList = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      
      treePaths(root, myList, sb);
      
      return myList;      
   }
   
   private static void treePaths(TreeNode root, List<String> myList, StringBuilder sb)
   {
      if(root == null)
      {
         return;
      }
      
      int len = sb.length();
      sb.append(root.val);
      
      if(root.left == null && root.right == null)
      {
         myList.add(sb.toString());
      }
      else
      {
         sb.append("->");
         treePaths(root.left, myList, sb);
         treePaths(root.right, myList, sb);
      }
      
      sb.setLength(len);
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