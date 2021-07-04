/*
   Given a binary array, find the maximum number of consecutive 1s in this array if you can flip
   at most one 0.
   
   Example:
   
   Input: nums = [1, 0, 1, 1, 0]
   Output: 4
   
   Locked question from Leetcode.
   
   LintCode has this problem on: https://www.lintcode.com/problem/max-consecutive-ones-ii/description
   
   ----
   
   Approach 1 and Approach 2 pass test cases.

*/


class MaxConsecutiveOnesII
{
   public static void main(String[] args)
   {
      System.out.println(findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0}));
   }
   
   // Approach 1
   /*
   public static int findMaxConsecutiveOnes(int[] nums)
   {
      int ans = 0, left = -1, zeroCount = 0, right = 0;
      
      while(right < nums.length)
      {
         if(nums[right] == 0)
         {
            zeroCount++;
         }
         
         while(zeroCount > 1)
         {
            left++;
            if(nums[left] == 0)
            {
               zeroCount--;
            }
         }
         
         ans = Math.max(ans, right-left);
         right++;
      }
      
      return ans;
   }
   */
   
   // Approach 2
   public static int findMaxConsecutiveOnes(int[] nums) 
   {
        int res = 0, cur = 0, cnt = 0;
        for (int i = 0; i < nums.length; i ++) 
        {
            cnt++;
            if (nums[i] == 0) 
            {
                cur = cnt;
                cnt = 0;
            } 
            res = Math.max(res, cnt + cur);
        }
        
        return res;
    }
    
    
   // Bruteforce approach, doesn't pass test cases
   /*
   public static int findMaxConsecutiveOnes(int[] nums)
   {
      int currentCounter = 0, result = 0;
      boolean flag = false;
      
      for(int i=0; i < nums.length; i++)
      {
         if(nums[i] == 1)
         {
            currentCounter++;
            
            if(result < currentCounter)
            {
               result = currentCounter;
            }            
         }
         else
         {
            if(flag == true && nums[i] == 0)
            {
               currentCounter = 0;
            }            
            else
            {
               flag = true;
               currentCounter++;
            }             
         }
      }
      
      return result;
      
   }
   */
}