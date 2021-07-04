/*
   Remove Duplicates from Sorted List
   
   Given a sorted linked list, delete all duplicates such that each element appear only once.
   
   Example 1:
   Input: 1 -> 1 -> 2
   Output: 1 -> 2
   
   Example 2:
   Input: 1 -> 1 -> 2 -> 3 -> 3
   Output: 1 -> 2 -> 3
   
   ---
   
   Algorithm:

   Approach 1:

   1. Make two pointer Nodes
      previous
      front
   2. On the list:
   
      head -> 1 -> 1 -> 2 -> 3 -> 3
      
      previous will be pointing at first 1
      front will be pointing at second 1
   3. if head is null, return null
   
      otherwise,
   
      while(front != null) 
      
      compare the values of previous.val and front.val
      
      if they are equal
               previous.next = front.next;
               front = front.next;
      
      if they are not
               previous = front;
               front = front.next;
               
   4. At the end, return the head.
   
   Time Complexity:
   
   O(N), where the number of Nodes in the list. Because each node is checked exactly once if it
         is a duplicate or not.
         
   
   Space Complexity:
   
   O(1), We didn't used additional space to store anything.

   -----

   Approach 2:

   1. If the head is null, return head

   2. Point the current to head

   3. while(current's next is not null)

         if current's value == current's next's value
            current's next = current's next's next

         otherwise,
            current = current's next

   4. At the end, return head. We are only using 1 ListNode reference on this one.

   Time-Complexity: O(N), where N is the number of nodes in the LinkedList
   Space-Complexity: O(1)
 
*/

class RemoveDuplicatesSortedList
{
   public static void main (String[] args)
   {
      ListNode list1 = new ListNode(1, new ListNode(1, new ListNode(2)));
      
      ListNode list2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
      
      deleteDuplicates(list2);
          
   }

   // Approach 2
   public static ListNode deleteDuplicates(ListNode head) {
      if(head == null) {
         return head;
      }

      ListNode current = head;

      while(current.next != null) {
         if(current.val == current.next.val) {
            current.next = current.next.next;
         }
         else {
            current = current.next;
         }
      }

      return head;
   }

   // Approach 1
   /*
   public static ListNode deleteDuplicates(ListNode head)
   {
      if(head == null)
      {
         return head;
      }
      
      else
      {
         ListNode previous = head;
         ListNode front = head.next;
         
         while(front != null)
         {
            if(previous.val == front.val)
            {
               previous.next = front.next;
               front = front.next;
            }
            
            else
            {
               previous = front;
               front = front.next;
            }
         }
         
         return head;
      }
   }
    */
   
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