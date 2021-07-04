/*
   Path Sum
   
   Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
   adding up all the values along the path equals the given sum.
   
   Note: A leaf is a node with no children.
   
   Example:
   
   Given the below binary tree and sum = 22,
               
                      5
               4           8
         11        13            4
    7        2                        1
    
   return true, as there exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which sum is 22.            
   
   -----
   
   Algorithm:
   
   1. On the above example, we have a binary tree and sum = 22
   
      We have to check, when we are at our leaf node (root.left == null && root.right == null)
      if the sum equals to the root.data, that we have added so far while traversing the nodes down.
   
   2. We passed in the root node,
      
      check if root == null, it's not we are at 5
      check if sum == root.val, it's not 22 != 5
         check if root.left == null && root.right == null
            it's not.
     
      Then, we recurse on the left, but this time, pass hasPathSum(root.left, sum - root.val)
         sum - root.val is 17
      
   3. We use the above approach repeatedly, until we are at the leaf node (root.left == null && root.right == null)
      And, sum == root.val
      
      On the above example, it will check if sum (2) == root.val
      
      It returns treue for this root-to-leaf path 5 -> 4 -> 11 -> 2
      22, gets subtracted to 17, then 13, then 2.    

   4. Explanation at the end of this video: https://youtu.be/UYiOUI19iHE
   
   -----
   
   Time Complexity:
   
   O(N), worse case, we visit every nodes in the tree, where N is the number of nodes in the tree.
   
   Space Complexity:
   
   O(N), where N is the call stack of the recursion tree.

*/

class PathSum
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
      
      System.out.println(hasPathSum(myTree, 22));   
   }
   
   public static boolean hasPathSum(TreeNode root, int sum)
   {
      if(root == null)
      {
         return false;
      }
      
      if(sum == root.val && root.left == null && root.right == null)
      {
         return true;
      }
      
      return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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