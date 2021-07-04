/*
   Maximum Binary Tree
   
   Problem Source: https://leetcode.com/problems/maximum-binary-tree/
   
   -------
   
   Algorithm:
   
   1. We have an array:
      
      [3,2,1,6,0,5]
      
      The root node is the maximum value of the array, which is 6
      
      Since there are elements in the left side of the 6
      
      The maximum value of the left side is 3
      
      So far our tree will look like:
      
            6
        3
        
      Since there are no elements in the left side of 3
      The right side only has 2, 1 left, because we are recursively going on different sides of the array on separate call stack
      The maximum is 2, we put it on the right side of 3
      And so on and so on.
      
      So our tree will look like:
      
                        6
               3                 5
                  2        0         
                     1         
      
   2. So the intution is:
   
      We will recursively build the array, starting with the root node
      
      by passing in our array, left index which is 0, right index which is lastindex of the array
      
      On the recursion, we will stop when left > right
      
         This way, if there no elements in the left side of the array, it starts going right side, so it can create nodes in the right side of the tree
      
      Recursively
         we will create the root node
         root.left will start from left, to maxIndex - 1
         root.right will start from maxIndex + 1, right
         
      maxIndex is the index of the maximum element in the array.
      
   3. Return rootnode.
   
   --------
   
   Time complexity: O(N^2), because on each recursive call stack, we are traversing the N elements to find the maximum index
   Space-complexity: O(N), the higher the N, the higher our recursive call stack can be in the worst case. 
   
   https://leetcode.com/problems/maximum-binary-tree/solution/         
*/


class MaximumBinaryTree
{
   public static void main(String[] args)
   {
      constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
   }
   
   public static TreeNode constructMaximumBinaryTree(int[] nums)
   {
      return helper(nums, 0, nums.length - 1);
   }
   
   private static TreeNode helper(int[] nums, int left, int right)
   {
      if(left > right)
      {
         return null;
      }
      
      int maxIndex = left;
      
      for(int i=left; i <= right; i++)
      {
         if(nums[i] > nums[maxIndex])
         {
            maxIndex = i;
         }
      }
      
      TreeNode rootNode = new TreeNode(nums[maxIndex]);
      rootNode.left = helper(nums, left, maxIndex - 1);
      rootNode.right = helper(nums, maxIndex + 1, right);
      
      return rootNode;
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