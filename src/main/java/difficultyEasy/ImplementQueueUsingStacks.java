/*
   Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support
   all the functions of a normal queue(push, peek, pop and empty).
   
   Problem Source: https://leetcode.com/problems/implement-queue-using-stacks/
   Explanation: https://youtu.be/BI3JzvNyV3o

*/

import java.util.Stack;

class ImplementQueueUsingStacks
{
   public static void main(String[] args)
   {
      MyQueue testQueue = new MyQueue();
      
      testQueue.push(1);
      testQueue.push(2);
      testQueue.peek();
      testQueue.pop();
      testQueue.empty();   
   }
   
   private static class MyQueue
   {
      private Stack<Integer> pushStack;
      private Stack<Integer> popStack;
      
      // Initialize the two stacks datastructure here.
      public MyQueue()
      {
         pushStack = new Stack();
         popStack = new Stack();      
      }
      
      // Push element x to the back of the queue.
      // Time complexity: O(1), adding elements to pushStack is an O(1) operation
      // Space complexity: O(N), N is the number of elements being added to the stack.
      public void push(int x)
      {
         this.pushStack.push(x);
      }
      
      // Uses peek method and Checks if the this.popStack is empty first
      // If it is empty, removes the element from the pushStack, and pushes to popStack
      // Doing this inverts the elements in popStack.
      // Then we remove the first thing at the top of popStack
      
      // Time complexity: Amortized O(1), Worst-case O(N)
      //                  See here for more explanation: https://leetcode.com/problems/implement-queue-using-stacks/solution/    
      // Space Complexity: O(1)     
      public int pop()
      {
         peek();       
         return this.popStack.pop();
      }
      
      // Same as above but instead of removing the element at the end from the popStack, this method returns it.
      // Time complexity: O(1)
      // Space Complexity: O(1)
      public int peek()
      {
         if(this.popStack.empty())
         {
            while(!this.pushStack.empty())
            {
               this.popStack.push(this.pushStack.pop());
            }
         }
         
         return this.popStack.peek();         
      }
      
      // Checks if either popStack or pushStack has any elements in there, if there is, it isn't empty.     
      // Time complexity: O(1)
      // Space complexity: O(1)
      public boolean empty()
      {
         return this.popStack.empty() && this.pushStack.empty();
      }
   }
}