/*
   Delete Node in a Linked List
   
   Write a function to delete a node in a singly-linked list. You will not 
   be given access to the head of the list, instead you will be given access to the
   node to be deleted directly.
   
   It is guaranteed that the node to be deleted is not a tail node in the list.
   
   ------
   
   Algorithm:
   
   1. Swap with Next Node.
   
      Let's say we have:
      
      4 -> 5 -> 1 -> 9
      
      Our input node points at 5
      
      Since we don't have the memory address of the node that points to 4,
      and it also guaranteed that the input node is not a tail node, that means it's next is not null.
      
      we can change 5 node's value 1
      And, point 5's next value to 9
      
      This results:
      
      4 -> 1 -> 9
      
   -----
   
   Time Complexity: O(1)
   Space Complexity: O(1)  
   
*/

class DeleteNode
{
   public static void main(String[] args)
   {
      ListNode myList5 = new ListNode(5, new ListNode(1, new ListNode(9)));
      ListNode myList = new ListNode(4, myList5);
      
      deleteNode(myList5);
   }
   
   public static void deleteNode(ListNode node)
   {
      node.val = node.next.val;
      node.next = node.next.next;
   }
   
   private static class ListNode
   {
      int val;
      ListNode next;
      
      ListNode()
      {
      
      }
      
      ListNode(int val)
      {
         this.val = val;
      }
      
      ListNode(int val, ListNode next)
      {
         this.val = val;
         this.next = next;
      }
   }
}