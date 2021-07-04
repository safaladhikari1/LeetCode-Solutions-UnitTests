/*
   Daily Temperatures:
   
   Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

   For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

   Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

   Problem Source: https://leetcode.com/problems/daily-temperatures/
   
   ------
   
   Algorithm:
   
   1. This problem is best approached using Monotonic Stack
   
      Video: https://youtu.be/m4hvxzLoN_I
      
   2. We have the input array:
   
      [73, 74, 75, 71, 69, 72, 76, 73]
      
      If you look,
      
      For day 1, 74 > 73, so we have 1
      For day 2, 75 > 74, so we have 1
      For day 3, 71 < 75
         So we wait 4 days (75, 71, 69, 72)
         To get 76
         
         That's we have 4 and so on..
         
      Our output array will look like:
      
      [1, 1, 4, 2, 1, 1, 0, 0]
      
    
    3. This is possible using the monotonic stack
       
       The stack keeps the counter of indices. I recommend tracing the code by hand, and you will understand how we get 
       out output array like above.   
            
   ----------
   
   Time-Complexity: O(N), where N is the length of the temperature array.
   Space-Complexity: O(W), where W is the number of allowed index for temperatures[i]
                     Each index gets pushed and popped at most once from the stack
                     The size of the stack is bounded as it represents strictly increasing temperatures.
   
*/


import java.util.Stack;
import java.util.Arrays;

class DailyTemperatures
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
   }
   
   public static int[] dailyTemperatures(int[] temperatures)
   {
      int[] result = new int[temperatures.length];
      
      Stack<Integer> myStack = new Stack<>();
      
      for(int i=0; i<temperatures.length; i++)
      {
         while(!myStack.isEmpty() && temperatures[myStack.peek()] < temperatures[i])
         {
            int index = myStack.pop();
            result[index] = i - index;
         }
         
         myStack.push(i);
      }
      
      return result;
   }
}