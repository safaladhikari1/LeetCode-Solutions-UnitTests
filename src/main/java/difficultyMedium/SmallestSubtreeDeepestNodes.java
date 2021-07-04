/*
   Problems:
   
   https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/submissions/
   https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/submissions/
   
   
   Remove static, if you are running it on LeetCode.
   
   -----
   
   Algorithm:
   
   1. Let's say we have a Binary Tree:
   
                        3
                        
                   5          1
                   
              6      2     0     8
              
                  7     4
                  
                  
       If the above binary tree is our input
       Our output is the tree that is pointing to [2, 7, 4]
       
       because it is the small tree that has the deepest nodes.
       
    2. We can find out that by using global variables
    
       deepLevel = 0
       result TreeNode = null
       
    3. We will call our helper method, by passing in root node and the initial value of level = 0
       
       Once we find the tree that has the deepest nodes, we will store that on result variable.
       And we will return it on lcaDeepestLeaves method.
       
    4. Our base case is, if root is null
         return the level, which should be the current level for that tree.
         Current Level is always going to be the maximum of left level and right level.
         
       We will traverse to the left, and get our left level.
       When our tree hits our first base case on  node 6
         it's left level will be 3
       Similary right level will be 3
       
       We will store 3 on our currentLevel
       
       deepLevel will be 3 for now
       
       Since leftLevel matches deepLevel and right Level matches deepLevel
         we will point the result to root, which will be 3 on that call stack.
         
   5. Similarly the root.left of node 5 is done, it recurses to the right.
      
      It follows the same pattern, then it points the result to 2
      because on that call stack, leftLevel becomes 4
      right Level becomes 4
      
      deepLevel is also 4
      
   6. Then it doesn't change because the deepLevel on above tree is 4
      And leftLevel never equals the deepLevel onwards.
      
   ------
   
   Time-Complexity: O(N), where N is the nodes in the tree
   Space-Complexity: O(H), where H is the height of the tree. the heigher the tree, the higher our recursion call stack.               
                                                      
*/


class SmallestSubtreeDeepestNodes
{
   private static int deepLevel = 0;
   private static TreeNode result = null;
   
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1));
      
      lcaDeepestLeaves(myTree);   
   }
   
   public static TreeNode lcaDeepestLeaves(TreeNode root)
   {
      helper(root, 0);
      
      return result;
   }
   
   private static int helper(TreeNode root, int level)
   {
      if(root == null)
      {
         return level;
      }
      
      int leftLevel = helper(root.left, level + 1);
      int rightLevel = helper(root.right, level + 1);
      
      int currentLevel = Math.max(leftLevel, rightLevel);
      deepLevel = Math.max(currentLevel, deepLevel);
      
      if(leftLevel == deepLevel && rightLevel == deepLevel)
      {
         result = root;
      }
      
      return currentLevel;
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