/*
   Remove Linked List Elements
   
   Remove all elements from a linked list of integers
   that have value val.
   
   Example:
   
   Input: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
   val = 6
   
   Output: 1 -> 2 -> 3 -> 4 -> 5
   
   -------
   
   Algorithm:
   
   1. I am using two pointers approach
      
      At the beginning:
      
      ListNode previous points to null
      ListNode current points to head
      
   2. while(current != null)
   
      move previous to current
      And current to current.next
      
      But before that check:
      
      if(current.val == val)
      
         if previous is null, this happens when we have just 1 node: [1] with value 1 and val = 1
            head = current.next, which is null
         
         otherwise,
            previous.next = current.next; it will the chain and ignore the node with similar value and points to the next node
                       
         current = current.next , current keeps on moving.
   
   3. At the end, return the head.
   
   --------  
   
   Time-Complexity: O(N), where N is the number of nodes in the list, we visit every nodes at least once.
   Space-Complexity: O(1), we didn't use any extra memory to store anything.
   
*/

class RemoveLinkedListElements
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
      
      ListNode myList2 = new ListNode(1);
      removeElements(myList2, 1);      
   }
   
   public static ListNode removeElements(ListNode head, int val)
   {
      ListNode previous = null;
      ListNode current = head;
      
      while(current != null)
      {
         if(current.val == val)
         {
            if(previous == null)
            {
               head = current.next;   
            }
            else
            {
               previous.next = current.next;
            }
                   
            current = current.next;
         }
         else
         {
            previous = current;
            current = current.next;
         }
      }
      
      return head;
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