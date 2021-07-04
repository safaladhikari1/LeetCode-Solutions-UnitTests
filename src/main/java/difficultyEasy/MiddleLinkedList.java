/*
   Middle of the Linked List
   
   Given a non-empty, singly linked list with head node head, return a middle node of linked list.
   
   If there are two middle nodes, return the second middle node.
   
   Constraint: The number of nodes in the given list will be between 1 and 100.
   
   Examples:
   
   Input: [1, 2, 3, 4, 5]
   Output: [3, 4, 5], returns the head pointing to middle node 3
   
   Input: [1, 2, 3, 4, 5, 6]
   Output: [4, 5, 6], returns the head pointing to middle node 4
   
   ---------
   
   Algorithm 1 (Store Node Addresses in Array Table)
   
   1. So we know there are a total of 100 nodes
      
      So we create a fixed size array of ListNode[] of size 100
      
   2. We visit every nodes in the list
      
      Store the memory address of each node in our array
      keep on tracking the number in our counter variable
      
   3. storeTable[counter / 2], will give us the node address, which is in the middle of the list.
   
   Time-Complexity: O(N), where N is the number of nodes in the list
   Space-Complexity: O(N), the space used by our array table. 
   
   -----------
   
   Algorithm 2 (Using Fast and Slow Pointers)
   
   1. We have two pointers:
      
      fast and slow, initially they both point at head of the list
      
      When slow moves each step, slow = slow.next
      fast moves twice as slow, fast = fast.next.next
      
   2. This way, when fast reaches the end of the list, while(fast != null && fast.next != null)
      We know that slow must be in the middle
      
   3. Return slow
   
   Time-Complexity: O(N), where N is the number of nodes in the list
   Space-Complexity: O(1)      
*/

class MiddleLinkedList
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
   }
   
   // Approach 2 (Using Fast and Slow Pointer)
   public static ListNode middleNode(ListNode head)
   {
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast != null && fast.next != null)
      {
         slow = slow.next;
         fast = fast.next.next;
      }
      
      return slow;
   }
   
   // Approach 1 (Store Node Addresses in Array Table)
   /*
   public static ListNode middleNode(ListNode head)
   {
      ListNode[] storeTable = new ListNode[100];
      
      int counter = 0;
      
      ListNode current = head;
      
      while(current != null)
      {
         storeTable[counter] = current;
         counter++;
         
         current = current.next;
      }
      
      return storeTable[counter / 2];    
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