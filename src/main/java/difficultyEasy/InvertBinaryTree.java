/*
   Invert Binary Tree
   
   Input:      
                        4
                 2            7
           1         3    6         9
   
   Output:
                        4
                7             2
          9          6    3         1
          
   ---------------
   
   Algorithm:
   
   1. We are using depth first approach with post order traversal (left node, right node, and current node)
      
      Try drawing a tree like the following:
      
                                       4(L, R, M)
                     2(L, R, M)                        7(L, R, M)
           1(L, R, M)         3(L, R, M)    6(L, R, M)            9(L, R, M)
           
   2. If you hand trace the algorithm using the solution below:
   
      We first visit node all the way to the right corner, then come up.
      Once we are done with 7, it will look like:
      
                         4
                 2            7
           1         3    9         6
           
      
      Then we come up, and go to the left side, once we are done with 2, it will look like:
      
                         4
                 2            7
           3         1    9         6
     
     Finally, once we are done with both 2 on the left and 7 on the right, we swap the nodes, so the answer will be:
     
                        4
                7             2
          9          6    3         1
          
     
     I recommend hand tracing the algorithm, to get a better understanding on what's happening.
     
     ------------
     
     Time-Complexity: O(N), N is the number of nodes in the tree, we visit each node in the tree only once.
     Space-Complexity: Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
      
     --------------  
     Iterative Approach 2 is mentioned on: https://leetcode.com/problems/invert-binary-tree/solution/ 
                                        
*/



class InvertBinaryTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
      
      invertTree(myTree);
      
      
   }
   
   public static TreeNode invertTree(TreeNode root)
   {
      if(root == null)
      {
         return null;
      }
      
      TreeNode right = invertTree(root.right);
      TreeNode left = invertTree(root.left);
      
      root.left = right;
      root.right = left;
      
      return root;
   }
   
   public static class TreeNode
   {
      int val;
      TreeNode left;
      TreeNode right;
      
      public TreeNode()
      {
      
      }
      
      public TreeNode(int val)
      {
         this.val = val;
      }
      
      public TreeNode(int val, TreeNode left, TreeNode right)
      {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}