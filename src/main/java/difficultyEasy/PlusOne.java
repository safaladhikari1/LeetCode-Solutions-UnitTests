/*
   Plus One
   
   Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
   
   The digits are stored such that the most significant digit is at the head of the list, and
   each element in the array contains a single digit.
   
   You may assume the integer does not contain any leading zero, except the number 0 itself.
   
   Example 1:
   
   Input: digits = [1, 2, 3]
   Output: [1, 2, 4]
   
   Explanation: The array represents the integer 123
   
   Example 2:
   
   Input: digits = [4, 3, 2, 1]
   Output: [4, 3, 2, 2]
   
   Explanation: The array represents the integer 4321.
   
   Example 3:
   
   Input: digits = [0]
   Output: [1]
   
   Constraints:
   
   1 <= digits length <= 100
   0 <= digits[i] <= 9 
   
   ----
   
   Algorithm:
   
   1. Get the length of the nums array
   2. Start looping from the last element of the array
   3. If the last element is < 9
      This means, last element is between 0 and 8
      increment the last element
      return the array, easy!
   4. Otherwise,
      the last element == 9
      
      Then convert that element to 0
      
      Remember if we had added 1 to 9, it would have been 10, with 1 carry over to the left
      
   5. Clever trick:
      
      create  new int[length + 1];
      point the nums to this new array
      
      only convert nums[0] = 1;
      
      return nums;
   
   Time Complexity:
   
   O(N), N is the length of the digits in the nums array
   O(1), we didn't used any extra spaces.
   
   We divided the solutions into if the nums[i] is 9 or not 9, looping through the last element.   
   
*/

import java.util.Arrays;

class PlusOne
{
   public static void main(String[] args)
   {
      int[] testArray = {8, 9, 9, 9};
      System.out.println(Arrays.toString(plusOne(testArray)));
   }
   
   public static int[] plusOne(int[] nums)
   {
      int length = nums.length;
      
      for(int i = length - 1; i >= 0; i--)
      {
         // This means that the lastElement is from 0 - 8
         if(nums[i] < 9)
         {
            nums[i]++;
            return nums;   
         }
         
         // Convert the last element to 0
         nums[i] = 0;
      }
      
      // defaults all the ints to 0
      nums = new int[length + 1];
      nums[0] = 1;
      
      return nums;
   }
}