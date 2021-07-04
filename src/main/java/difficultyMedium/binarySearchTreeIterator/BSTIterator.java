/*
   Binary Search Tree Iterator
   
   Problem Source: https://leetcode.com/problems/binary-search-tree-iterator/
   
   ----------
   
   Algorithm:
   
   1. We will use Stack to store our nodes while processing for this Iterator
   
   2. For the constructor of the Iterator
      
      Since we are using in-order traversal,
      
      we will take the root/current as argument, and point the current to the left most null element (below the smallest element) in the BST
      
      while(current != null)
      {
         nodeStack.push(current);
         current = current.left;
      }
      
      The nodes are added because we will have to process them on our next() method
      
   3. For next() method
      
      It first retrieves the smallest element of the BST. i.e. stack.pop(), the one on the top of the stack
      
      Now there will be two cases,
      
      Also described in the article:
      
      Algorith, Approach 2: Controlled Recursion section of the article: https://leetcode.com/problems/binary-search-tree-iterator/solution/
      
      1. If the node at the top of the stack is the leaf node (node.left and node.right are both null), which is the best case, we can simply return node.val;
      
      2. If the node has the right child
         
         Since we have already processed all the left child on constructor above, we can only check if current.right != null
         
            If it is not null, add the right child to nodeStack.
            
            and dive to the left our right child, and keep on adding them to our nodeStack for processing on later next() calls
            
   
   4. For hasNext() method, we can simply check if the nodeStack is empty or not.
   
   --------         
   
   Time-Complexity: 
   
   hasNext(): O(1) operation, we are simply checking if the nodeStack is empty or not.
   
   next():
      
      If we just pop an element and if it is a leaf node, it's O(1) operation.
      
      If the node has node.right, it has to iterate over a lot of nodes. On worst case, it is O(N)
      The amortized average time complexity is O(1), as explained on the article above.       
  
  Space-Complexity: O(N), where N is the number of nodes in the tree, which is also occupied by our stack for simulating the inorder traversal.             

  -----------
  
  Example of the working Iterator: https://github.com/safaladhikari1/Java-Concepts2/blob/master/BinarySearchTree/src/edu/greenriver/it/trees/BinarySearchTree.java 
  
  Let's say we have a BST
  
               7
               
         3         15
         
              9         20
              
  
  1. When we call the BSTIterator constructor, we are first adding nodes on the left to our stack
  
      [7, 3] 
  
      3 is at the top, current is pointing to left most null
  
       BSTIterator.next() will pop 3, and output 3
  
  2. Now if we run BSTIterator.next() again
  
      It will pop 7, but also check if 7.right != null, which is true
     
      So it pushes [15, 9] on the stack
      
      Then, output 7
  
  3.  Next time you run BSTIterator.next(), it will output 9 And so on.                   
   
   
*/


import java.util.Stack;

class BSTIterator
{
   private Stack<TreeNode> nodeStack = new Stack<>();
   
   public BSTIterator(TreeNode current)
   {
      // point the current to left most null element (below the smallest) in the BST
      while(current != null)
      {
         nodeStack.push(current);
         current = current.left;
      }
   }
   
   public boolean hasNext()
   {
      return !nodeStack.isEmpty();
   }
   
   public int next()
   {
      // Retrieve the next element to report
      TreeNode next = nodeStack.pop();
      
      // If there is a right sub-tree, find the smallest element
      // adding nodes to the stack as we go
      
      if(next.right != null)
      {
         // add the right child
         nodeStack.push(next.right);
         
         // and dive to the left of our right child
         TreeNode current = next.right;
         
         while(current.left != null)
         {
            nodeStack.push(current.left);
            current = current.left;
         }
      }
      
      return next.val; 
   }
   
   public class TreeNode
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