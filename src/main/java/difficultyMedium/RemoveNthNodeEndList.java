/*
   Problem: Remove Nth Node from End of List
   Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
   
   ----
   
   Algorithm:
   
   Explained in: https://youtu.be/Kka8VgyFZfc
   
   1. Create a dummy Node
      Point dummy.next to head
   
   2. Create two pointers, fast and slow pointing at dummy node.
   
   3. while fast.next is not null
         
         fast is fast.next
         
         if n-- is less than or equal to 0
            this means, when the distance between slow and fast is exactly n or lesser (because we keep decrementing n), 
            then move slow, this way the distance between slow and fast is constant moving forward
  
   4. when fast.next is null
         while loop stops
         
   5. Assign slow.next = slow.next.next
   
   6. Return dummy.next
   
   ------
   
   Time-Complexity: O(N), we visit every nodes in the LinkedList at least once
   Space-Complexity: O(1)                
              
*/

class RemoveNthNodeEndList
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
      
      removeNthFromEnd(myList, 2);
   }
   
   public static ListNode removeNthFromEnd(ListNode head, int n)
   {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      
      ListNode fast = dummy;
      ListNode slow = dummy;
      
      while(fast.next != null)
      {
         fast = fast.next;
         
         if(n-- <= 0)
         {
            slow = slow.next;
         }        
      }
      
      slow.next = slow.next.next;
      
      return dummy.next;      
   }
   
   // Bruteforce Algorithm, doesn't work
   /*
   public static ListNode removeNthFromEnd(ListNode head, int n)
   {
      if(head.next == null)
      {
         return null;
      }
      
      ListNode fast = head;
      ListNode slow = fast;
      int counter = 0;
      
      while(fast.next != null)
      {
         fast = fast.next;
         counter++;
         
         if(counter == n)
         {
            slow = slow.next;
            counter = 0;
         }
      }
      
      slow.next = slow.next.next;
      
      return head;
   }
   */
   
   public static class ListNode
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