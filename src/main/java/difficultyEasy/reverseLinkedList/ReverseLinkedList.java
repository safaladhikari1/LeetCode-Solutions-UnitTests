/*
   Reverse a singly linked list
   
   Example:
   
   Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
   Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
   
   -------
   Using iteratively approach
   
   Algorithm:
   
   1. The idea is we want to visit the nodes in the list, and
      the first node we visit, we want to point it to the previous node and so on...
      
      We need two helpers nodes:
      
      One that stores the previous node
      
      One that stores the next node after changing the reference.
      
   2. We start off with
      
      previous = null;
      current = head;
      
      while(current != null)
      
         1. save the next node after changing the reference in nextTemp node.
         2. point the current node's next value to the previous node
         3. previous node point to the current node.
         4. current node points to the nextTemp node.
         
      (Review the pictures on the ReverseLinkedList folder to see it how it works)
   
   3. At the end, we return previous, which points to the head, with a reversed linked list.
   
   --------
   
   Time-Complexity: O(N), where N is the number of the nodes in the list, and we visit each node at least once.
   Space-Complexity: O(1), we did not use any memory to store anything.       
         
*/


class ReverseLinkedList
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
      reverseList(myList);
   }
   
   // 2nd attempt after 5 months of solving the problem
   public static ListNode reverseList(ListNode head)
   {
      ListNode previous = null;
      ListNode current = head;
      
      while(current != null)
      {
         ListNode currentNext = current.next;
         current.next = previous;
         previous = current;
         current = currentNext;
      }
      
      return previous;
      
   }
   
   /*
   public static ListNode reverseList(ListNode head)
   {
      ListNode previous = null;
      ListNode current = head;
      
      while(current != null)
      {
         ListNode nextTemp = current.next;
         current.next = previous;
         previous = current;
         current = nextTemp;
      }
      
      return previous;
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