/*
   Sum of Left Leaves
   
   Find the sum of all left leaves in a given binary tree.
   
           3
       9       20
            15     7
            
   There are two left leaves in the binary tree, with values 9 and 15 respectively. Output is 24.
   
   Problem Source: https://leetcode.com/problems/sum-of-left-leaves/
   
   -----
   
   Algorithm:
   
   1. We know that we only want to add up the TreeNode.val, which is the leaf node and on the left side of the tree.
   
      So we create a private help method:
      
      int sumLeftLeaves(TreeNode root, boolean flag)
      
      that returns an int.
      
  2. If the root is null, return 0, there is nothing to add. Our base case.
  
     Otherwise: else if(root.left == null & root.right == null & flag == true)
         return root. val
         
     Do the recursion with sumLeftLeaves(root.left, true) + sumLeftLeaves(root.right, false);    
  
  -----
  
  If we run through the code:
  
  1. It goes through TreeNode 3, since the flag is false,
     
     It goes to TreeNode 9, it meets the condition  else if(root.left == null & root.right == null & flag == true)
      returns 9
      
      +
      
  2. Then it goes up the root, and goes to the right of the tree, TreeNode 20
     
     It goes to left of the Tree, TreeNode 20, it meets the condition,
      returns 15
      
     Then it goes to right of 20, 
      Here it recurses to root.left and root.right, which returns 0.
      
  3. It goes up the root, the addition is 9 + 15 = 24      
  
  ------
  
  Time-Complexity: O(N), N is number of nodes in the tree. We visit every nodes in the tree.
  Space-Complexity: O(N), N is the height of the tree, the deeper the tree, the more call stack is in the memory for our recursion.    
*/

class SumLeftLeaves
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      
      System.out.println(sumOfLeftLeaves(myTree));
      
   }
   
   public static int sumOfLeftLeaves(TreeNode root)
   {
      
      return sumLeftLeaves(root, false);
      
   }
   
   private static int sumLeftLeaves(TreeNode root, boolean flag)
   {
      if(root == null)
      {
         return 0;
      }
      else if(root.left == null & root.right == null & flag == true)
      {
         return root.val;
      }
      else
      {
         return sumLeftLeaves(root.left, true) + sumLeftLeaves(root.right, false);   
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