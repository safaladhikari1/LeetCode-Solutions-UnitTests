/*
   Non-decreasing Array
   
   Problem Source: https://leetcode.com/problems/non-decreasing-array/
   
   -----
   
   Algorithm:
   
   1. It basically wants us to find out if we can make input: nums as an increasing array, by modifying at most one element if needed.
   
   2. Increasing array is defined as nums[i] <= nums[i + 1]
   
   3. So let's take an example
      
      [4, 2, 3]
      
      We can have a count = 0, this counts how many element are there which are not in increasing order.
      If the count is greater than 1, we will return false.
      
      We will loop through the array until the second last element of the array
      
      At first, 4 is greater than 2
         increment the count
         
      Then loop again
      2 < 3, it doesn't enter the if statement
      
      The loop ends.
      
      So we can return true.
   
  4. For example:
  
      [4, 2, 1]
      
      At first loop, 4 is greater than 2,
         increment count
         
      Second loop, 2 is greater than 1
         increment count
         
      since count is 1, it returns false.
      
  5. For example:
  
      [3, 4, 2, 3]
      
      At first loop, 3 < 4, nothing happens
      At second loop, 4 > 2
         increment count
         
      Now it enters if(i > 0 ..) statement
         Check if 2 is less than 3
            It is, so change 2 to 4
            
       Because of the example array {-1, 4, 2, 3}, we will have to compare agains [i - 1]
       
      Now the array, [3, 4, 4, 3] 
      At third loop, 4 > 3 it returns false.
      
   -------
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1)   
   
*/

class NondecreasingArray
{
   public static void main(String[] args)
   {
      System.out.println(checkPossibility(new int[] {3, 4, 2, 3}));
   }
   
   public static boolean checkPossibility(int[] nums)
   {
      int count = 0;
      
      for(int i=0; i < nums.length - 1; i++)
      {
         if(nums[i] > nums[i+1])
         {
            count++;
            
            if(count > 1)
            {
               return false;
            }
            
            if(i > 0 && nums[i+1] < nums[i-1])
            {
               nums[i+1] = nums[i];
            }                       
         }
      }
      
      return true;
   }
}