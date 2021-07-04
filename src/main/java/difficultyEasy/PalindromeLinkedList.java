/*
   Palindrome Linked List
   
   Given a singly linked list, determine if it is a palindrome.
   
   Example 1:
   
   Input: 1 -> 2
   Output: false
   
   Example 2:
   
   Input: 1 -> 2 -> 2 -> 1
   Output: True
   
   --------
   
   Algorithm:
   
   A Palindrome linked list is a list, which has same values from both forwards and backwards.
   
   1. This is kind of two part problem. In first part, we will go through the linked list using two pointers:
      Fast and Slow.
      
      Fast will move two steps ahead of Slow, such that when slow is in the middle, fast is at the end of the linked list.
      
   2. Once slow is at the middle, we reverse the slow right from the middle of the linked list.
   3. Then we will have to linked list to compare to, fast and slow, where we compare values from slow to fast, and if the
      values are same, it is a palindrome linkedlist, if the values are not same, it is not palindrome linked list.
      
      Let's get started.
   
      head : 1 -> 2 -> 2 -> 1 -> null
   
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast != null && fast.next != null)
      {
         slow = slow.next;
         fast = fast.next.next;
      }
      
      At this time, fast is at null, while slow is at 2.
      
      head : 1 -> 2 -> 2 (slow) -> 1 -> null (fast)
      
      Then we point fast to head again.
      
      And we reverse the list just for the slow using the reverseList method. For more information: https://github.com/safaladhikari1/CodingProblems/tree/master/LeetCode/Easy/ReverseLinkedList
      
      After the reversal, slow will look like:
      
      slow: 1 -> 2 -> null
      fast: 1 -> 2 -> 2 -> null
      
      Keep in mind, it will mess up the original list starting from slow.
      
      Now we just compare the values between slow and fast.
      
      while(slow != null)
      {
         if(slow.val != fast.val)
         {
            return false;
         }
         
         slow = slow.next;
         fast = fast.next;
      }
      
      return true;
      
   ---------
   
   Time-Complexity: O(N), where N is the number of nodes in the list.
   Space-Complexity: O(1)             

*/

class PalindromeLinkedList
{
   public static void main(String[] args)
   {
      ListNode myNode = new ListNode(1, new ListNode(0, new ListNode(1)));
      
      System.out.println(isPalindrome(myNode));
   }
   
   public static boolean isPalindrome(ListNode head)
   {
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast != null && fast.next != null)
      {
         slow = slow.next;
         fast = fast.next.next;
      }
      
      fast = head;
      slow = reverseList(slow);
      
      while(slow != null)
      {
         if(slow.val != fast.val)
         {
            return false;
         }
         
         slow = slow.next;
         fast = fast.next;
      }
      
      return true;   
   }
   
   public static ListNode reverseList(ListNode head)
   {
      ListNode previous = null;
      
      while(head != null)
      {
         ListNode nextTemp = head.next;
         head.next = previous;
         previous = head;
         head = nextTemp;
      }
      
      return previous;
   }
   
   /*
   public static boolean isPalindrome(ListNode head)
   {
      ListNode current = head;
      
      if(current == null || current.next == null)
      {
         return true;
      }
      
      HashMap<Integer, Integer> myMap = new HashMap<>();

      while(current != null)
      {
         if(!myMap.containsKey(current.val))
         {
            myMap.put(current.val, 1);
         }
         else
         {
            myMap.put(current.val, myMap.get(current.val) - 1);
         }
         
         if(myMap.get(current.val) <= 1)
         {
            return true;
         }
         
         current = current.next;
      }
          
      return false;
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