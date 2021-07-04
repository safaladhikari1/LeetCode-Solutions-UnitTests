/*
   Merge two sorted linked lists and return it as a new sorted list. The new list should be made
   by splicing together the nodes of the first two lists.
   
   Examples:
   
   Input:
   
   head1 -> 1 -> 2 -> 4
   head2 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5
*/

class MergeTwoSortedLists
{
   // Sample Singly Linked List to debug for this problem
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
   
   public static void main(String[] args)
   {
      ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
      ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));
      
      merge(l1, l2);    
   }
   
   public static ListNode merge(ListNode l1, ListNode l2)
   {
      // Creating a dummy ListNode
      ListNode dummy = new ListNode(0);
      ListNode head = dummy;
      
      while(l1 != null && l2 != null)
      {
         if(l1.val < l2.val)
         {
            head.next = l1;
            l1 = l1.next;
         }
         
         else
         {
            head.next = l2;
            l2 = l2.next;
         }
         
         head = head.next;
      }
      
      // If both lists (l1 and l2 are unequal, head.next will point to leftover nodes)     
      if(l1 != null)
      {
         head.next = l1;
      }
      
      if(l2 != null)
      {
         head.next = l2;
      }
      
      ListNode result = dummy.next;   
      return result;
   }   
}