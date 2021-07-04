/*
   LeetCode Problem: https://leetcode.com/problems/add-two-numbers/
   
   Explanation: https://youtu.be/1Spw7DEtB14
   
   -------
   Algorithm:
   
   1. The above video explains it well, but the idea is
      
      If the digits are stored in reversed order:
      
      2 4 3
      5 6 4
      
      Output is 7 0 8
      
      Because: 342 + 465 = 807
      
   2. This means:
   
      If we do the normal addition for:
      
      2 4 3
      5 6 4
      
      We have to find out a way to only store the first digit of the sum, carry the second digit to the next column.
      
      2 + 5 = 7, it stays.
      4 + 6 = 0, 1 carries.
      3 + 4 + 1 = 8 stays.
      
      Output is 7 0 8
      
   3. On our solution below:
      
      We create a result ListNode, head
      
      currentResult points to the result head
      
      iniatilize carry = 0
      
      ListNode carry1 is pointing at l1, carry2 is pointing at l2.
      
      while(current1 != null || current2 != null)
         x = if current1 != null, it is current1.val or 0
         y = if current2 != null, it is current2.val or 0
         
         sum = x + y + carry
         
         carry = sum/10, this gives us the carry
         
         currentResult.next = new ListNode(sum % 10), this will give us the first digit of the 2 digits, if it is more than 10, if it is less than 10, it will give us the only digit.
         
         if current1 != null, move the current1 to current1.next
         if current2 != null, move the current2 to current2.next
         
      if carry > 0
         currentResult.next = new ListNode(carry), this happens on the case where there is a carry on the last column 9 + 4 + 1(carry):
         
         2 4 9
         5 6 4
         
         7 0 4 1
         
         This is because:
         
         942 + 465 = 1407
         
    ---------------
     
    Time-Complexity: O(max(M, N)), where M and N are the length of l1 and l2 respectively. The algorithm above iterates at most max(M, N) times
    
    Space-Complexity: O(max(M, N)), the length of the new list is at most max(m, n) + 1     
            
*/

class AddTwoNumbers
{
   public static void main(String[] args)
   {
      ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
      ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
      
      addTwoNumbers(l1, l2);
   }
   
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
   {
      ListNode result = new ListNode();
      ListNode currentResult = result;
      
      int carry = 0;
      
      ListNode current1 = l1;
      ListNode current2 = l2;
      
      while(current1 != null || current2 != null)
      {
         int x = (current1 != null) ? current1.val : 0;
         int y = (current2 != null) ? current2.val : 0;
         
         int sum = x + y + carry;
         
         carry = sum/10;
         
         currentResult.next = new ListNode(sum % 10);
         
         currentResult = currentResult.next;
         
         
         if(current1 != null)
         {
            current1 = current1.next;
         }
         
         if(current2 != null)
         {
            current2 = current2.next;
         }                 
          
      }
      
      if(carry > 0)
      {
         currentResult.next = new ListNode(carry);
      }
      
      return result.next;
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