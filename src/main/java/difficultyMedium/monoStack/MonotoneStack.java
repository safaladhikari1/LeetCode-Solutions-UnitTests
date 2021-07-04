/*
   Monotone Stack
   
   Monotone Stack is a stack, where we maintain increasing or decreasing order.
   
   Notes from Video: https://youtu.be/TunTV2-griM
   
   Another Video on the same topic: https://youtu.be/m4hvxzLoN_I
    
   ------
   Increasing stack (like a Bucket):
   
   For example:
   
   [2, 6, 9, 8, 1]
   
   If it is a increasing stack, it will be
   
   while(!myStack.empty() && myStack.peek() > nums[i])
   
   [2, 6, 9]
   
   Since 9 is greater, we will pop out 9, and place 8
   
   [2, 6, 8]
   
   When 1 comes, 
   
   all three 2, 6, 8 will have to pop out.
   
   [1] element at the end.
   
   -----
   
   Decreasing Stack (like a Pyramid):
   
   [2, 6, 3, 9, 8, 1]
   
   while(!myStack.empty() && myStack.peek() < nums[i])
   
   [2]
   
   2 gets popped out, 6 will be place here
   
   [6]
   
   [6, 3]
   
   3 and 6 gets popped out,
   
   [9, 8, 1] will be decreasing stack.
   
   -----
   
   Use cases:
   
   1. Next greater element, Previous greater element
   2. Next smaller element, Previous smaller element
   
   ------
   
   LeetCode Problems:
   
   https://leetcode.com/problems/daily-temperatures/
   https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
   https://leetcode.com/problems/next-greater-element-i/
   https://leetcode.com/problems/next-greater-element-ii/
   https://leetcode.com/problems/online-stock-span/
   https://leetcode.com/problems/132-pattern/
   https://leetcode.com/problems/sum-of-subarray-minimums/
   https://leetcode.com/problems/largest-rectangle-in-histogram/ 

*/

import java.util.Stack;

class MonotoneStack
{
   public static void main(String[] args)
   {
   
   }
   
   public static void increasingStack(int[] nums)
   {
      Stack<Integer> myStack = new Stack<>();
      
      for(int i=0; i<nums.length; i++)
      {
         while(!myStack.empty() && myStack.peek() > nums[i])
         {
            myStack.pop();
         }
         
         myStack.push(nums[i]);
      }
   }
}