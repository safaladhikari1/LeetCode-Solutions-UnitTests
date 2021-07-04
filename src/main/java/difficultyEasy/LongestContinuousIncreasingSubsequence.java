/*
   Longest Continuous Increasing Subsequence
   
   Given an unsorted array of integers nums, return the length of the longest continuous
   increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
   
   Example 1:
   
   Input: nums = [1, 3, 5, 4, 7]
   Output: 3
   
   Example 2:
   
   Input: nums = [2, 2, 2, 2, 2]
   Output: 1
   
   -------
   Algorithm (Sliding Window Technique): 
   
   Explanation: https://youtu.be/jSvoE-_Yhs4
   
   1. Let's look at our input array
   
      [1, 3, 5, 4, 7]
      
      We want to keep track of our counter when the values on the left is less than the values on the right
      
      As soon as the values on the left is greater than the values on the right, we have to reset the counter to 1
      
      Then get the max value of the counter, and return it.
      
   2. We do that first by declaring
   
      result = 0, this is our counter
      anchor = 0, this is where we reset
      
      So we start out for loop from the beginning of the array
      
         Since we check from left against the right, to avoid going index out of bound 
         We will say
         
         if (i > 0 && nums[i - 1] >= nums[i])
            that's when we know left is greater than right, so we reset out counter to 1
            
         Otherwise,
         
         result = Math.max(previous result, i - resetcounter + 1);
          
         +1 is actually incrementing out result counter on this for loop
         
    3. At the end return the result. Try tracing this algorithm by hand, it will make more sense.
    
    --------
    
    Time-Complexity: O(N), where N is the number of elements in our input array. We do this in linear run time, i.e. 1 loop.
    Space-Complexity: O(1), no additional space is used. It's a constant space solution.
                 
*/

class LongestContinuousIncreasingSubsequence
{
   public static void main(String[] args)
   {
      System.out.println(findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
      
      System.out.println(findLengthOfLCIS(new int[] {2, 2, 2, 2, 2}));
      
      //int a = 1;
      
      //System.out.println(a++);
      //System.out.println(++a);
   }
   
   public static int findLengthOfLCIS(int[] nums)
   {
      int result = 0;
      int anchor = 0;
      
      for(int i=0; i < nums.length; i++)
      {
         if(i > 0 && nums[i - 1] >= nums[i])
         {
            anchor = i;
         }
         
         result = Math.max(result, i - anchor + 1);
      }
      
      return result;
   }
}