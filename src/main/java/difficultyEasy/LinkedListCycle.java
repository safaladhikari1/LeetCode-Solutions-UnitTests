/*
   Linked List Cycle: https://leetcode.com/problems/linked-list-cycle/
   
   Given head, the head of a linked list, determine if the linked list has a cycle in it.

   There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

   Return true if there is a cycle in the linked list. Otherwise, return false.

   Follow up:

   Can you solve it using O(1) (i.e. constant) memory?
   
   ----
   
   Approach 1: Hash Table
   
   Algorithm:
   
   1. To detect if a list is cyclic, we can check whether a node has been visited before.
      A natural way is to use a hash table
   2. We go through each node one by one and record each node's reference (or memory address)
      in a hash table. 
   3. If the front is null, it means it reached to the end, and it's not cycle, so it returns false.
   4. On each iteration on the loop, it checks if the hash table already has the reference stored,
      if it does, it's cyclic, and it returns true.
      
  -----
  
  Time-Complexity: O(N), where N is the number nodes in the list, and we visit each node once. Adding a node and search the node's reference on the hash table only O(1) time.
  Space-Complexity: O(N), N is the number of elements added to the hash table, on worst case, it adds all the N nodes in the hash table.       
   
  ------
  
  Approach 2: Two Pointers
  
  Source: https://youtu.be/sMqEwkpvJvQ
     


*/

import java.util.*;

class LinkedListCycle
{
   public static void main(String[] args)
   {
      LinkedNode myList = new LinkedNode(3, null);
      myList.next = new LinkedNode(2);      
      myList.next.next =  new LinkedNode(0, new LinkedNode(-4, myList.next));
      
      System.out.println(hasCycle(myList));
      
   }
   
   public static boolean hasCycle(LinkedNode head)
   {
      Set<LinkedNode> mySet = new HashSet<LinkedNode>();
      
      LinkedNode front = head;
      
      while(front != null)
      {
         if(mySet.contains(front))
         {
            return true;
         }
         
         mySet.add(front);
         
         front = front.next;
      }
      
      return false;
      
   }
   
   private static class LinkedNode
   {
      int val;
      LinkedNode next;
      
      LinkedNode()
      {
      
      }
      
      LinkedNode(int val, LinkedNode next)
      {
         this.val = val;
         this.next = next;
      }
      
      LinkedNode(int val)
      {
         this.val = val;
      }
   }
}