/*
  Move Zeroes:
  
  Given an array nums, write a function to move all 0's to the end of it
  while maintaining the relative order of the non-zero elements.
  
  Example:
  Input: [0, 1, 0, 3, 12]
  Output: [1, 3, 12, 0, 0]
  
  Note:
  
  1. You must do this in-place without making a copy of the array
  2. Minimize the total number of operations.
  
  ------
  
  Algorithm:
  
  1. initialize start = 0
     
     Then loop through the array, and if the elements are not zero
     front load them.
     
     It will bring all the non zero elements to the front of array, keeping their relative order same.
     
     [0, 1, 0, 3, 12]
     
     After the loop, it will be [1, 3, 12, 3, 12];
 
 2. Then start the loop where the start ended, and make the remaining elements to 0
    
    It will convert to [1, 3, 12, 0, 0]      
 
 ------
 
 Time-Complexity: O(N), N is the number of elements in the array. We visit every elements in the array at least once.
 Space-Complexity: O(1), No more additional space is used, besides the one we already have with the input array.
    
*/


import java.util.Arrays;

class MoveZeroes
{
   public static void main(String[] args)
   {
      int[] testArray = {0, 1, 0, 3, 12};
      System.out.println(Arrays.toString(moveZeroes(testArray)));
   }
   
   public static int[] moveZeroes(int[] nums)
   {
      int start = 0;
      
      for(int i=0; i<nums.length; i++)
      {
         if(nums[i] != 0)
         {
            nums[start] = nums[i];
            start++;
         }
      }
      
      for(int i=start; i<nums.length; i++)
      {
         nums[i] = 0;
      }     
      
      return nums;
   }
}