/*
   132 Pattern
   
   Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

   Return true if there is a 132 pattern in nums, otherwise, return false.
   
   Examples:
   
   Input: nums = [1,2,3,4]
   Output: false
   Explanation: There is no 132 pattern in the sequence.
   
   Input: nums = [3,1,4,2]
   Output: true
   Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
   
   --------
   
   Algorithm:
   
   Approach 1: BruteForce Solution
   
   1. We are simply checking every (i, j, k) combination to see if there is any 132 pattern.
      where, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j]
      
      using 3 nested for loops.
      
   Time-Complexity: O(N^3), where N is the size of nums array
   Space-Complexity: O(1), constant extra space is used.
   
   -----------
   
   Approach 2: Better BruteForce Solution
   
   1. From the three nested loops and our condition we know that:
   
      i < j < k and nums[i] < nums[k] < nums[j]
      
      So, we can simply Remove the pointer i, and use a variable min to store the minimum value before nums[j]

   2. Doing this we will calculate the minimum value between nums[j] and min (previously nums[i]) inside nums[j] for loop
   
      So we can reduce the for loop from 3 to 2.
      
   Time complexity : O(n^2) Two loops are used to find the nums[j],nums[k]nums[j],nums[k] pairs. Here, n refers to the size of nums array.

   Space complexity : O(1) Constant extra space is used.
   
   ----------
   
   Approach 3: MonoStack Solution explained on video: https://leetcode.com/problems/132-pattern/solution/
   
   1. Make the minimum array before nums[j], same length as input array
   
      Input: [3, 5, 0, 3, 4]
      
      Minimum: [3, 3, 0, 0, 0]
      
   2. Now we make a monotonic stack, from the back of the input array in decreasing order
   
      for(int j=nums.length - 1; j >= 0; j--)
         while(!stack.empty() && stack.peek() < nums[j])
      
      [4, 3, 0]
      
      We check if nums[j] is greater than stack.peek()
      
      On the loop from the back, when it is at 5, index 1 we know that
      
      5 is greater than stack.peek() i.e. 0, but stack.peek() is not greater than min[index: 1] which is 3.
         In order to be true, nums[j] > nums[k] but also nums[k] has to be greater than min, nums[i]
         
      We pop the 0
      
      Similarly, 5 is greater than 3, and it does not meet the if clause, we pop the 3.
      
      5 is greater than 4, this time stack.peek() is 4 and it is greater than min[j], which is 3.
      
  3. Therefore the 132 pattern is [3, 5, 4] on the input array: [3, 5, 0, 3, 4]
  
     where, index: i < j < k and nums[i] < nums[k] < nums[j]
     
  4. It is a different way of thinking and using the monotone Stack.   
  
   Time complexity: O(N)
   Space Complexity: O(N)

*/

import java.util.Stack;

class OneThreeTwoPattern
{
   public static void main(String[] args)
   {
       //System.out.println(find132pattern(new int[] {1, 2, 3, 4}));
       //System.out.println(find132pattern(new int[] {3, 1, 4, 2}));
       //System.out.println(find132pattern(new int[] {-1, 3, 2, 0}));
       //System.out.println(find132pattern(new int[] {1, 0, 1, -4, -3}));
       
       System.out.println(find132pattern(new int[] {3, 5, 0, 3, 4}));
   }
   
   // Monotone Stack Solution
   public static boolean find132pattern(int[] nums)
   {
      int[] min = new int[nums.length];
      min[0] = nums[0];
      
      for(int j=1; j<nums.length; j++)
      {
         min[j] = Math.min(nums[j], min[j-1]);
      }
      
      Stack<Integer> stack = new Stack<>();
      
      for(int j=nums.length - 1; j >= 0; j--)
      {
         while(!stack.empty() && stack.peek() < nums[j])
         {
            if(stack.peek() > min[j])
            {
               return true;
            }
            
            stack.pop();
         }
         
         stack.push(nums[j]);
      }
      
      return false;      
   }
   
   
   // Better Bruteforce Solution
   /*
   public static boolean find132pattern(int[] nums)
   {
      int min = nums[0];
      
      for(int j=1; j < nums.length - 1; j++)
      {
         min = Math.min(min, nums[j]);
         
         if(min == nums[j])
         {
            continue;
         }
         
         for(int k=j+1; k < nums.length; k++)
         {
            if(nums[k] > min && nums[k] < nums[j])
            {
               return true;
            }         
         }
         
      }
      
      return false;     
   }
   */
     
   
   // Bruteforce solution
   /*
   public static boolean find132pattern(int[] nums)
   {
      for(int i=0; i < nums.length - 2; i++)
      {
         for(int j=i+1; j < nums.length - 1; j++)
         {
            for(int k = j+1; k < nums.length; k++)
            {
               if(nums[k] > nums[i] && nums[k] < nums[j])
               {
                  return true;
               }
            }
         }
      }
      
      return false;
   }
   */
   
   
   /*
   public static boolean find132pattern(int[] nums)
   {
      int lastIndex = nums.length - 1;
      
      for(int i=lastIndex; i >=2; i--)
      {
         int lastVal = nums[i];
         int secondLastVal = nums[i-1];
         int thirdLastVal = nums[i-2];
         
         if(lastVal > thirdLastVal && lastVal < secondLastVal)
         {
            return true;
         }
      }
           
      return false;
   }
   */   
}