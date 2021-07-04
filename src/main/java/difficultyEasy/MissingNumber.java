/*
   Missing Number
   
   Given an array nums containing n distinct numbers in the range[0, n], return the only number
   in the range that is missing from the array.
   
   Follow up: Could you implement a solution using only O(1) extra space complexity and O(N) run time complexity?
   
   -----
   
   Algorithm:
   
   Approach 1: 
   
   1. If we have input of nums: [3, 0, 1]
      
      And our range will be: [0, 3], 3 is the length of the array
      
      The number missing can be found by: 
      
      (length of the array + each index) - (sum of each index on that array)
      
  2. It's a nifty solution explained in: https://youtu.be/4LrVhAxJUsA
  
  
  
  Time-Complexity: O(N), where N is the elements in the array
  Space-Complexity: O(1), no additional space used any where inside the solution.
  
  ---------
  
  Approach 2: (My BruteForce Solution)
  
  1. Create a boolean[] counter array, which initiliazes to false in java
  2. loop through the counter, mark every elements in the input array, to true.
  
  3. Then if we loop the counter again, which ever index in the array is false, that is the index (number) that was missing in our input array.
  
  -----
  
  Time-Complexity: O(N), where N is the elements in the array
  Space-Complexity: O(N), where N is the length of the array + 1, for our boolean counter array.
*/

class MissingNumber
{
   public static void main(String[] args)
   {
      int[] testArray = {3, 0, 1};
      int[] testArray2 = {0, 1};
      int[] testArray3 = {0};
      
      System.out.println(missingNumber(testArray));
   }
   
   public static int missingNumber(int[] nums)
   {
      int initialSum = nums.length;
      
      int actualSum = 0;
      
      for(int i=0; i<nums.length; i++)
      {
         initialSum += i;
         actualSum += nums[i];
      }
      
      return initialSum - actualSum;
   }
   
   /*
   public static int missingNumber(int[] nums)
   {
      boolean[] counter = new boolean[nums.length + 1];
      
      int index = 0;
      
      for(int i=0; i<counter.length-1; i++)
      {
         counter[nums[i]] = true;
      }
      
      for(int i=0; i < counter.length; i++)
      {
         if(counter[i] != true)
         {
            return index;
         }
         index++;
      }
      
      return index;
   }
   */
}