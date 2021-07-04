/*
   Flatten Binary Tree to LinkedList
   
   Given a binary tree, flatten it to a linked list in-place.
   
   For example, given the following tree:
   
                      1
                     / \
                    2   5
                   / \   \
                  3   4   6
                  
   The flattened tree should look like:
   
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
             
   ----------
   
   Algorithm:
   
   1. This algorithm follows Reverse Pre Order Traversal.
   
      Pre Order Traversal: Root, Go Left, Go Right
      
      Reverse Pre Order Traversal: Go Right, Go Left, Root
      
   2. So we basically traverse all the way to the right at 6
      Then build out linked list, using bottom up approach.
      
      But we also need an extra node, to store our node's address during recursion
      We make a variable previous, and initially point it to null.
      
   3. if(root == null)
      {
         return;
      }
      
      flatten(root.right);
      flatten(root.left);
      
      This takes all the way down to 6 on the right.
      
      root.left is also null,
      
      So we say, 6.right = previous
                 6.left = null
                 
                 previous = 6.
                 
      Now we start building our linkedlist from bottom to the top.
      
   4. If you hand trace it, on each stack call it builds the linked list in the order of: 6, 5, 4, 3, 2, 1
   
      At the end 1.right will be pointing at 2, just like in the above diagram
      previous and root will be pointing at 1.
      
   -------
   
   Time-Complexity: O(N), we visit every nodes in the tree at least once with the recursion.
   Space-Complexity: O(H), where H is the height of the tree, the deeper the tree, the more memory recursion call stack will incur.
                                    
*/


/*
class FlattenBinaryTreeToLinkedList
{
   public static void main(String[] args)
   {
           
      TreeNode myTree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
      
      TreeNode myTree2 = new TreeNode(0);
      
      
      flatten(myTree2);
   
   }
   
   // in order to run this code make sure the methods and private fields are static below.
   // If you are pasting the code to Leetcode, you will have to remove the static.
   private TreeNode previous = null;
   
   public void flatten(TreeNode root)
   {
      if(root == null)
      {
         return;
      }
      
      flatten(root.right);
      flatten(root.left);
      
      root.right = previous;
      root.left = null;
      
      previous = root;     
   }
      
   private class TreeNode
   {
      int value;
      TreeNode left;
      TreeNode right;
      
      TreeNode()
      {
      
      }
      
      TreeNode(int value)
      {
         this.value = value;
      }
      
      TreeNode(int value, TreeNode left, TreeNode right)
      {
         this.value = value;
         this.left = left;
         this.right = right;
      }   
   }
}

 */