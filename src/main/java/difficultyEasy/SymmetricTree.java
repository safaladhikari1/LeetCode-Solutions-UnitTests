/*
   Symmetric Tree
   
   Given a binary tree, check whether it is a mirror of itself(i.e, symmetric around its center)
   
   For example, this binary tree [1, 2, 2, 3, 4, 4, 3] is symmetric.
   
             1
        2         2
     3     4   4     3
  
   But the following [1, 2, 2, null, 3, null, 3] is not
      
              1
          2       2
             3       3
   
   Solve it both recursively and iteratively.
   
   ---------
   Algorithm:
   
   1. When do we have a symmetric tree?
   
      A tree is symmetric if the left subtree is a mirror reflection of the right subtree
      
             1
        2         2
     3     4   4     3
     
     On the above tree, we have subNode1 2 and subNode2 2 equal, 
     subNode1.left 3, subNode2.right 3 equal
     subNode1.right 4, subNode2.left 4 equal
     
     That's when a tree is symmetric.
     
   2. To check this:
      
      we will pass the root node n1 on isSymmetric() method
      
      we will actually do the work on private symmetric() method, 
      we will pass root node n1 and root node n1 to this symmetric() method
      
  3. a. Check first if both n1 and n2 are null
        return true, because they are symmetrical
        
     b. Check if either of n1 and n2 are null
        At this point, we know that n1 and n2 are both not null.
        But if one of them is null, return false, it is not symmetrical
     
     c. check n1.val == n2.val, if the root nodes are equal
         check n1.left and n2.right
          check n1.right and n2.left
          
        All the above has to be true to return true (because they are joined by && operator)
        or it's false.  
        
  -----
  
  Time Complexity: O(N), because we visit every nodes in the tree once, where N is the total number of nodes in the tree
  Space Complexity: O(N), where N is the recursive call stack (in the worst case, the tree is linear). The recursive calls
                  are bound by the height of the tree.
*/

class SymmetricTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
      
      System.out.println(isSymmetric(myTree));      

   }
   
   public static boolean isSymmetric(TreeNode n1)
   {
      return symmetric(n1, n1);
   }
   
   private static boolean symmetric(TreeNode n1, TreeNode n2)
   {
      if(n1 == null && n2 == null)
      {
         return true;
      }
      
      if(n1 == null || n2 == null)
      {
         return false;
      }
      
      return n1.val == n2.val && symmetric(n1.left, n2.right) && symmetric(n1.right, n2.left);
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