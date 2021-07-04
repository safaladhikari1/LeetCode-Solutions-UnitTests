/*
   Intersection of Two Linked Lists
   
   Write a program to find the node at which the intersection of two singly linked lists begins.
   
   If the two linkedlists have no intersection at all, return null.
   
   LeetCode Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/
   
   ------
   
   Video explanation on the problem: https://youtu.be/c7dOI-hDa2Q
   
   ------
   
   Algorithm:
   
   1. Check first if either head1 is null or head2 is null, if either of them are null, return null.
   
   2. Make two pointers:
      current1 pointing at head1
      current2 pointing at head2
      
      Start a while loop, saying if current1 != current2
      
      current1 goes to current1.next
      current2 goes to current2.next
      
   3. If they have an intersection, and if both current1 and current2 are moving at the same pace, they will find each other,
      
      if(current1 == current2), returns current1;
      
   4. If one list is bigger than another, means, if they go the end of the list, and point at null,
      
      we point current1 to head2, current2 to head1
      
   5. Even if they both do not intersect,
      
      When both of them point at null, they are equal, and returns current1, which will be pointing at null.
      
   6. Otherwise, eventually if they really have an intersection, they both will point at the same, and we will return current1 or current2, they both will be pointing at same node.
   
   ------
   
   Time-Complexity: O(N), where N is the number of nodes we are iterating on List Nodes.
   
   Space-Complexity: O(1), we didn't use any memory to store anything on our approach on this solution.
   
*/

class IntersectionTwoLinkedLists
{
   public static void main(String[] args)
   {
      ListNode IntersectionNode = new ListNode(8, new ListNode(4, new ListNode(5, null)));
      
      ListNode head1 = new ListNode(4, new ListNode(1, IntersectionNode));
      
      ListNode head2 = new ListNode(5, new ListNode(6, new ListNode(1, IntersectionNode)));
      
      System.out.println(getIntersectionNode(head1, head2));      
   }
   
   public static ListNode getIntersectionNode(ListNode head1, ListNode head2)
   {
      if(head1 == null || head2 == null)
      {
         return null;
      }
      
      ListNode current1 = head1;
      ListNode current2 = head2;
      
      while(current1 != current2)
      {
         current1 = current1.next;
         current2 = current2.next;
         
         if(current1 == current2)
         {
            return current1;
         }
         
         else if(current1 == null)
         {
            current1 = head2;
         }
         
         else if(current2 == null)
         {
            current2 = head1;
         }       
      }
      
      return current1;
   }
   
   private static class ListNode
   {
      int data;
      ListNode next;
      
      ListNode(int data, ListNode next)
      {
         this.data = data;
         this.next = next;
      }
   }
}