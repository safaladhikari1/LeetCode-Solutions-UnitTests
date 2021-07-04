/*
   Binary Tree Level Order Traversal II
   
   Given a binary tree, return the bottom-up level order traversal of its nodes' values.
   (ie, from left to right, level by level from leaf to root).
   
   For example:
   Given bianry tree:
   
               3
        9            20
               15          7
   
   return its bottom-up level order traversal as:
   
   [
      [15, 7],
      [9, 20],
      [3]
   ]
   
   -------------
   Algorithm:
   
   1. Going bottom-up is a way to avoid recursion, saving the memory cost that recursion incurs when it builds
      up the call stack. This approach starts from the beginning, while recursive algorithm often starts from
      the end and works backwards.
      
      We know we have to visit nodes on each level, store it a list, and store the list from every level to our
      masterList. Return the masterList.
      
      To insert items in a LinkedList is O(1), so we will used this data structure for both of our lists.
      
   2. We start off by creating masterList, it's a linkedList.
   
      Check if the root is empty
         if it is, return the masterList, which will be empty too.
         
      Then we will create a queue called pipeLine.
      This queue is used as pipeLine so we can bring it nodes and store them from our tree in each level
      
      Later, we will go through the nodes, add the value from those nodes to our innerList.
      
      Since we start from beginning, we will add root node to pipeLine.
      
   3. while(pipeLine is not empty)
         we will create our innerList
         
         we will store the pipeLine size in levelLength. It tells us how many items are in the pipeLine at current level.
         
         we will make a for loop to loop until our levelLength
            
            we will take off the TreeNode from pipeLine using poll() and assign to currentNode
            add the value of that TreeNode to our innerList.
            
            if(currentNode.left is not null)
               add currentNode.left to pipeLine
               
            if(currentNode.right is not null)
               add currentNode.right to pipeLine
               
        we will add innerList at the beginning of our masterList.                          
          
   4. Return the masterList.
   
   ---------
   
   Time-Complexity: O(N), where N is the number of nodes in our tree. We visit every nodes in the tree at least once.
   Space-Complexity: O(N), the bigger the N, the bigger our size of masterList.   
                        
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/*
class BinaryTreeLevelOrderTraversal
{
   public static void main(String[] args)
   {
      TreeNode myTree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      levelOrderBottom(myTree);
   }
   
   public static List<List<Integer>> levelOrderBottom(TreeNode root)
   {
      List<List<Integer>> masterList = new LinkedList<>();
      
      if(root == null)
      {
         return masterList;
      }
      
      Queue<TreeNode> pipeLine = new LinkedList<>();
      pipeLine.add(root);
      
      while(!pipeLine.isEmpty())
      {
         List<Integer> innerList = new LinkedList<>();
         
         int levelLength = pipeLine.size();
         
         for(int i=0; i<levelLength; i++)
         {
            TreeNode currentNode = pipeLine.poll();
            innerList.add(currentNode.val);
            
            if(currentNode.left != null)
            {
               pipeLine.add(currentNode.left);
            }
            
            if(currentNode.right != null)
            {
               pipeLine.add(currentNode.right);
            }           
         }
         
         masterList.add(0, innerList);              
      }
          
      return masterList;
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
*/
