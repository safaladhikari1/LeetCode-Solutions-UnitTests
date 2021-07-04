/*
   Max Consecutive Ones
   
   Given a binary array, find the maximum number of consecutive 1s in this array.
   
   Example 1:
   
   Input: [1, 1, 0, 1, 1, 1]
   Output: 3
   
   Explanation: The first two digits or the last three digits are consecutive 1s.
                The maximum number of consecutive 1s is 3.
                
   Note: The input array will only contain 0 and 1.
   
   ---------
   
   Algorithm:
   
   1. We will have two variables:
      currentMax, which keeps track of the number of sequential 1s in the array
      result, will keep track of the maximum currentMax in the array, on our loop.
      
   2. We will start the for loop
      
      If nums[i] == 1
         increment currentMax
         Also check if result < currentMax, if it is, store the currentMax to result.
      
      Since our input only contains 1 or 0,
      else
         we know it's a zero, so we will stop the currentMax from increment, and change it to 0
         because it will not sequential 1 at this point.
      
      Repeat the above on the for loop
      
   3. At the end, return the result.
   
   ------
   
   Time-Complexity: O(N), where N is the number of elements in the array
   Space-Complexity: O(1), no additional space is used on the solution.                              

*/

class MaxConsecutiveOnes
{
   public static void main(String[] args)
   {
      System.out.println(findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
   }
   
   public static int findMaxConsecutiveOnes(int[] nums)
   {
      int currentMax = 0, result = 0;
      
      for(int i=0; i<nums.length; i++)
      {
         if(nums[i] == 1)
         {
            currentMax++;
            
            if(result < currentMax)
            {
               result = currentMax;
            }                      
         }
         else
         {
            currentMax = 0;
         }
      }
      
      return result;
   }
   
   /*
   public static int findMaxConsecutiveOnes(int[] nums)
   {
      int currentMax = 0, result = 0;
      
      for(int i=0; i<nums.length; i++)
      {
         if(nums[i] == 1)
         {
            currentMax++;
         }
         
         if(nums[i] == 0)
         {
            currentMax = 0;
         }
         
         if(result < currentMax)
         {
            result = currentMax;
         }
      }
      
      return result;
   }
   */  
}