/*
   Convert Sorted Array to Binary Search Tree
   
   Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
   
   For example:
   
   Given the sorted array: [-10, -3, 0, 5, 9]
   
   One possible answer is: [0, -3, 9, -10, null, 5], which represents the following height balanced BST:
   
                     0
               -3           9
          -10        5    
   
   ---------
   
   Algorithm:
   
   1. What is Binary Search Tree (BST)?
      It's a binary tree where the nodes are ordered in a specific way:
         
         - The nodes to the left are smaller than the current node.
         - The nodes to the right are larger than the current node.
         
      More information: https://github.com/safaladhikari1/CodingProblems/blob/master/InterviewCake/TreesAndGraphs/BinarySearchTree      
      
      What is height balanced BST?
      
      A height balanced BST is a tree, where the heights of its left and right subtrees differ by at most 1.
      Both subtrees are also balanced.
      
      More information: https://github.com/safaladhikari1/CodingProblems/blob/master/InterviewCake/TreesAndGraphs/Tree
      
   2. If we look at our input array: [-10, -3, 0, 5, 9]
      
      It's sorted, we first check if the length of the array is 0, if it is, return null.
      
      Otherwise, we will build the tree.
      
      Since it's sorted, we can take the middle of the array as our root node.
      Then, whatever is on the left, is our left tree
      Whatever is on the right, is our right tree
      
      left starts at 0
      right starts at the end of the array, 9
      
      We get the middle, which is 0
      
      Build the root node
      
      Then, go left, build the tree, this time left is 0, but the right is middle - 1, so it is -3
      So our middle is (0 + 1) / 2, which is 0
      
      We build root node of  -10
      
      Now, the right is middle - 1, which is 0 - 1, -1
      
      It stops there, and goes to a previous recursion state
      
      If you do this by hand:
      
      At the end our Tree will look like:
      
                   0
            -10          5
                  -3          9    
      
    ----------
    
    Time-Complexity: O(N), since we visit every elements in the array exactly once, which we make the node of.
    Space-Comlexity: O(LogN) for our recursion call stack in a balanced tree.                     
*/

class SortedArrayToBinarySearchTree
{
   public static void main(String[] args)
   {
      sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
   }
   
   public static TreeNode sortedArrayToBST(int[] nums)
   {
      if(nums.length == 0)
      {
         return null;
      }
      else
      {
         return buildTree(nums, 0, nums.length - 1);
      }
   }
   
   public static TreeNode buildTree(int[] nums, int left, int right)
   {
      if(left > right)
      {
         return null;
      }
      else
      {
         int middle = (left + right)/2;
         TreeNode root = new TreeNode(nums[middle]);
         root.left = buildTree(nums, left, middle-1);
         root.right = buildTree(nums, middle+1, right);
         
         return root;
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