/*
   Binary Tree Tilt
   
   Given the root of a binary tree, return the sum of every tree node's tilt.
   
   The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. 
   
   If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
   
   The rule is similar if there the node does not have a right child.
   
   Problem Source: https://leetcode.com/problems/binary-tree-tilt/
   
   --------
   
   Algorithm:
   
   1. Let's say we have a Binary Tree:
      
                        4
                2             9
          3          5              7
          
      Output = 15
      
      On the left,
      
      Because tilt of node 3 at the bottom left = 0 - 0 because node.left and node.right are null, so 0
      Similarly, tilt of node 5 is 0
      Tilt of node 2 is 3 - 5, 2 (absolute value)
      
      On the right,
      
      Tilt of node 7 is 0
      Tilt of node 9 is 0 - 7 = 7
      
      On the middle,
      
      Tilt of node 4 is (2+3+5) - (9+7) = 6
      
      If you add all those tilts, you will get 15.
      
  2.  This problem is naturally Post Order Traversal:
  
      Instead of  creating global variable int or instantiating int, and passing it to our helper method, that does the post order traversal,
      We will create a sum array of length 1, and pass in the sum array.
      And return the sum[0]
      
      This is because if we pass in as int, primitive data type, it will make a copy and does not change the original int.
      So when we return it, we will only be returning the original instantiated int, which will be 0.
      
      If we make an array, it will pass the reference to that array, so it will change the values in the array on our recursion.
      
 3.   On helper method,
      
      we will pass in root, sum array
      
      our base case is when root is null, return 0
      
      We will do post order traversal, by going all the way to the left, return the value of (left side of the node + right side of the node + root.val)
      
      Store it in our int left.
      
      We will do the same on our right int, by going to the right.
      
      On Sum[0], we will be doing Math.abs(left - right) and adding the value to it, and passing it on every recursive call.
      
      At the end our Sum[0] will have sums of every tilt as example on Step 1.
      
  4. On our findTilt() method, we will return the sum[0]
  
  -------------
  
  Time-Complexity: O(N), where N is the number of nodes in the tree. We visit every nodes in the tree once on our post order traversal.
  Space-Complexity: O(H), where H is the height of the tree. If the tree is not balanced, the height might be high, which means we will incur
                    additional memory consumption in our recursion method's call stack.     
*/

class BinaryTreeTilt
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
      
      System.out.println(findTilt(myTree));   
   }
   
   public static int findTilt(TreeNode root)
   {
      int[] sum = new int[1];
      
      helper(root, sum);
      
      return sum[0];     
   }
   
   public static int helper(TreeNode root, int[] sum)
   {
      if(root == null)
      {
         return 0;
      }
      
      int left = helper(root.left, sum);
      int right = helper(root.right, sum);
      sum[0] += Math.abs(left - right);
      
      return left + right + root.val;     
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