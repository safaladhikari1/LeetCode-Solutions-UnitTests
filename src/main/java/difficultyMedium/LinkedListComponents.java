/*
   LinkedList Components
   
   We are given head, the head node of a linked list containing unique integer values.
   
   We are also given the list G, a subset of the values in the linked list.
   
   Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
   
   Example:
   
   Input: 
   head: 0->1->2->3
   G = [0, 1, 3]
   
   Output: 2
   
   Explanation: 
   0 and 1 are connected, so [0, 1] and [3] are the two connected components.
   
   --------------- 
   
   Algorithm:
   
   1. The question is basically asking
   
      If we have a linked list 0 -> 1 -> 2 -> 3
      
      And an array [0, 1, 3]
      
      Linked list contains unique integer values, and array has the subset of the node values of the linked list.
      
      Then how many connected components (linked list) of the node values in an array, are there in the input linked list?
      
      So,
      
      If you look at our linked list, 0 -> 1 is one connected component because both node values 0, 1 are there in the array
      Node 3 by itself is another component, because 3 is in the array.
      
      So, we basically need the count of the number of the components
      
   2. We can first instantiate the count to 0
      
      Add all the values from the array in our HashSet, because search operation in HashSet is O(1) 
      
      We can traverse the LinkedList using while loop
      while(current != null)
      
         if our set contains current.val AND
         
         check if it is the last element in the linked list OR check if the next node's value is in the HashTable
         
         If the next value is not in the hash table
         
         Then the current node must be the end of the connected component.
         
         For example:
         
         0 -> 1 -> 2 -> 3
              
         When our current is in 1, we see that our hash table contains 1, but since the hash table does not contain the next node value 2
         Then, we know that 1 is the end of the connected component.
         
         We will increment our count.
         
         Similarly, when the current is in 3, we check if it is the last element in the list
         It is, so we will increment our count.
         
   3.  Return the count, which is 2
  
   ---------   
   
   Time-Complexity: O(N + G.length), where N is the number of nodes in the list and G.length is our array's length. We had to loop through our array to add in our HashTable.
   Space-Complexity: O(G.length), for our HashTable.
        
*/


import java.util.Set;
import java.util.HashSet;

class LinkedListComponents
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
      int[] testG = {0, 1, 3};
      
      System.out.println(numComponents(myList, testG));     
   }
   
   public static int numComponents(ListNode head, int[] G)
   {
      int count = 0;
      ListNode current = head;
      
      Set<Integer> gSet = new HashSet<>();
      
      for(int num : G)
      {
         gSet.add(num);
      }
      
      while(current != null)
      {
         if(gSet.contains(current.val) && (current.next == null || !gSet.contains(current.next.val)))
         {
            count++;
         }
         
         current = current.next;
      }
      
      return count;
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