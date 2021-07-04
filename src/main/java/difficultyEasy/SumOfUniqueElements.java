/*
   Sum of Unique Elements
   
   You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

   Return the sum of all the unique elements of nums.
   
   Input: nums = [1,2,3,2]
   Output: 4
   Explanation: The unique elements are [1,3], and the sum is 4.
   
   -----
   
   Algorithm: 
   
   1. We have a constraint of nums[i] is more than 1 and less than 100
   
      So we can create a elementTable of size 100
      
   2. On the first for loop, we can basically decrementing all of our nums[i] in our elementTable
   
   3. Then we loop through nums again, and check if any of those nums[i] elements have -1 value in elementTable
   
      If it is, just add it to our sum.
      
      We are doing nums[i] - 1, because of the zero index, we have elementTable size of 100
      
   4. At the end, return the sum.
   
   Time-Complexity: O(N), where N is the length of the nums array
   Space-Complexity: O(1), element Table is fixed size array      

*/

class SumOfUniqueElements
{
   public static void main(String[] args)
   {
      System.out.println(sumOfUnique(new int[] {1, 2, 3, 2}));
      
      System.out.println(sumOfUnique(new int[] {10}));
   }
   
   public static int sumOfUnique(int[] nums)
   {
      int sum = 0;
      
      int[] elementTable = new int[100];
      
      for(int i=0; i < nums.length; i++)
      {
         elementTable[nums[i] - 1]--;   
      }
      
      for(int i=0; i < nums.length; i++)
      {
         if(elementTable[nums[i] - 1] == -1)
         {
            sum += nums[i];
         }
      }
      
      return sum;
   }
}