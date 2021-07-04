/*
   Lowest Common Ancestor of a Binary Search Tree
   
   Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes
   in the BST.
   
   Picture in the problem source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
   
   ----------
   
   Algorithm:
   
   The lowest common ancestor for two nodes, p and q, will be the ancestor node common to both of them.
   The problem wants us to find the split point, where p and q won't be part of the same subtree or when one is the parent of the other.
   
   We can utilize the following properties of Binary Search Tree to solve this problem:
   
   - Left subtree of a node N contains nodes whose values are lesser than or equal to node N's value.
   - Right subtree of a node N contains nodes whose values are greater than node N's value.
   - Both left and right subtrees are also Binary Search Trees.
   
   Approach 1 (Recursion)
   
   1. We store the values of root, p and q TreeNodes in variables: parentValue, pValue and qValue.
   2. Then check, if pValue is less than parentValue and qValue is less than parentValue
      then recurse to the left, because the splitting point is on the left side of the tree
   3. If pValue is greater than parentValue and qValue is greater than parentValue
      then recurse to the right, because the splitting point is on the right side of the tree
   4. If it does not enter the above recursions, it means the current root is the splitting root.
   
   Time-Complexity: O(N), where N is the number of nodes in the tree. At worse case, we may have to visit every nodes in the tree.
   Space-Complexity: O(N), the maximum amount of space utilized by the recursion stack would be N as well, since the height of a skewed BST could be N.
   
   Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/      

   Approach 2 (Iterative)
   
   1. Since this problem does not involve any backtracing to find the lowest common ancestor node,
      We can traverse down the root using while loop because it just wants us to find the split point.
      
   2. We don't want to change the root, so we make current our traversing Node
   3. while current is not null
      
      If p.val is less than current val and q.val is less than current val
         current can traverse to the left, same reason as our recursive approach.
      If p.val is more than current val and q.val is more than current val
         current can traverse to the right, same reason as our recursive approach.
      Otherwise, we know that the current node is the splitting point.
   4. If it doesn't enter the while loop, we know that the current is null. So return null.
   
   Time-Complexity: O(N), N is the number of nodes in our binary search tree. Worst case, we visit all the nodes in the tree
   Space-Complexity: O(1), we didn't use any additional space for this approach.      
*/


class LowestCommonAncestorOfABinarySearchTree
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
   }
   
   // Iterative Approach
   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
   {
      TreeNode current = root;
      
      while(current != null)
      {
         if(p.val < current.val && q.val < current.val)
         {
            current = current.left;
         }
         else if(p.val > current.val && q.val > current.val)
         {
            current = current.right;
         }
         else
         {
            return current;
         }
      }
      
      return null;
   }
   
   // Recursive Approach
   /*
   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
   {
      int parentValue = root.val;
      int pValue = p.val;
      int qValue = q.val;
      
      if(pValue < parentValue && qValue < parentValue)
      {
         return lowestCommonAncestor(root.left, p, q);
      }
      else if(pValue > parentValue && qValue > parentValue)
      {
         return lowestCommonAncestor(root.right, p, q);
      }
      else
      {
         return root;
      }
   }
   */
   
   public static class TreeNode
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