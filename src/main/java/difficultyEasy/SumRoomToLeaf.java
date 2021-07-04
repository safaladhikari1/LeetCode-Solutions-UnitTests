/*
   Sum of Root to Leaf Binary Numbers
   
   You are given the root of a binary tree where each node has a value 0 or 1.
   Each root-to-leaf path represents a binary number starting with the most
   significant bit. For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
   then this could represent 01101 in binary, which is 13.
   
   For all leaves in the tree, consider the numbers represented by the path from the root
   to that leaf.
   
   Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
   
   Example:
   
               1
        0             1
    0       1     0        1           
               
   
   Input: root = [1, 0, 1, 0, 1, 0, 1]
   Output: 22
   Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
   
   Constraints:
   
   The number of nodes in the tree is in the range [1, 1000]
   Node.val is 0 or 1.
   
   ------------------
   
   Algorithm: Recursive PreOrder Traversal
   
   1. PreOrder Traversal Order: Root, Left, Right
   
   2. We want to do pre order traversal using depth first approach,
      And when root.left == null && root.right == null, we need to return,
      get the sum, and pass it to another recursive stack.
      
      The challenge is converting sum of node.val, which is in binary to decimal.
      
      We do that using bitwise operator:
      
      val = val << 1 | root.val
      
      << 1 is the bitwise shift left, it will drop the the number of bits from the left of the val and add the same number of bits as 0s to the right
      Each shift to the left multiply our number by 2.
      
      | Bitwise OR operator adds the previous val to the current val
      
   3. For example on our first recursive call stack:
   
      1. We pass the val as 0
      2. val = 0 << 1 = 0
             0 | 1(root.val) = 1
      
      dfs(root.left, 1)
      
      1. 1 << 1 = 10
      2. 10 | 0 = 10
      
      dfs(root.left, 10)
      
      1. 10 << 1 = 100
      2. 100 | 0 = 100
      
      Then root.left == null && root.right == null
         returns 100 in binary, (4 in decimal)
         
      And so on.
      
   -----------
   
   Time-Complexity: O(N), where N is the number of nodes in the tree. We visit each node at least once.
   Space-Complexity: O(H), where H is the height of the tree. The higher the tree, the deeper our depth first recursive call stack. 
*/

class SumRoomToLeaf
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
      System.out.println(sumRootToLeaf(myTree));
   }
   
   public static int sumRootToLeaf(TreeNode root)
   {
      return dfs(root, 0);
   }
   
   private static int dfs(TreeNode root, int val)
   {
      int result = 0;
      
      if(root == null)
      {
         return 0;
      }
      
      val = val << 1 | root.val;
      
      if(root.left == null && root.right == null)
      {
         return val;
      }
      
      result += dfs(root.left, val);
      result += dfs(root.right, val);
      
      return result;
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