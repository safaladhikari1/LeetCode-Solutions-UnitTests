/*
   Minimum Depth of Binary Tree
   
   Given a binary tree, find its minimum depth.
   
   The minimum depth is the number of nodes along the shortest path from the root
   down to the nearest leaf node.
   
   Note: A leaf is a node with no children.
   
   Example:
   
   Given binary tree [3, 9, 20, null, null, 15, 7]
   
               3
           9        20
      null  null  15    7
      
   return its minimum depth = 2
   
   ----
   
   Algorithm:
   
   Explanation: https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
   
   1. Basically we try to find the minDepth from root.left and root.right on both root sides of the tree
      
      Then whichever has the least, we add 1 and return it.
      
      For example on our input tree:
      
                  3
           9             20
      null   null   15          7
      
      
   2. We check if the root is null
   
      If the root.left is null and root.right is null
         return 1
      
      If only root.left is null
         Then recurse to the right, to check if there are any leaf nodes in the right side of the tree
      
      If only root.right is null   
         Then recurse to the left, to check if there are any leaf nodes in the left side of the tree
      
      Store the value for val1 for left
      Store the value for val2 for right           
      
   3. Return the minimum value from val1, val2 + 1.                        
      
   ----
   
   Time-Complexity: O(N), where N is the number of nodes in the tree
   Space-Complexity: O(H), where H is the height of the tree, the deeper the tree, the higher the recursion call stack on this solution.
   
   This solution uses Depth First Search Approach, where it traverses every nodes in the tree.
   
*/
class MinimumDepth
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      
      System.out.println(minDepth(myTree));      
      
   }
   
   public static int minDepth(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      
      if(root.left == null && root.right == null) // check if it's a leaf node?
      {
         return 1;
      }
      
      if(root.left == null)
      {
         return minDepth(root.right) + 1;
      }
      
      if(root.right == null)
      {
         return minDepth(root.left) + 1;
      }
      
      int val1 = minDepth(root.left);
      int val2 = minDepth(root.right);
      
      return Math.min(val1, val2) + 1;
           
   }
   
   /*
   public static int minDepth(TreeNode root)
   {
      if(root == null)
      {
         return 0;
      }
      
      if(root.left == null)
      {
         return minDepth(root.right) + 1;
      }
      
      if(root.right == null)
      {
         return minDepth(root.left) + 1;   
      }
      
      int val1 = minDepth(root.left);
      int val2 = minDepth(root.right);
      
      return Math.min(val1, val2) + 1;
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