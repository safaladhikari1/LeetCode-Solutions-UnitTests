/*
   Problem Source: https://leetcode.com/problems/partition-equal-subset-sum/
   
   Approach 3 (Using dynamic programming table):
   
   https://youtu.be/34l1kTIQCIA
   
   Table, first column is 0 because we can always make up a sum of 0, with empty array.
   
   if(my column number “sum” is less than element value)
   {
   	look at the value on the top
   }
   Else
   {
   	get the top value || from the top value, move the corresponding number of steps back and return the value	
   }
   
   I can form sum 1 with one element 1. So true
   
   For 5, since we already have prior element 1, that can make up the sum of 1. So it gets the value from the top, so true.
   
   Can we make sum of 2, with elements 1, 5. No, it gets the value from the top. Since 5 is still bigger, it looks at the top.
   
   Since 5 and 5 are equal, we go up, move 5 steps back, and it’s true. 
   
   For 6, we go up, move 5 steps back. It is true.
   
   Trying to make sum 7, with two elements 1 and 5.
   
   For 11, go up move 11 elements back. You can make sum 11, with elements 1, 5, 11
   
   Time-Complexity: O(Number of elements “rows” * Sum “columns”)
   
   ----
   
   Approach 2 (Using Recursion)
   
   Time-Complexity: O(2^N)
   
*/


import java.util.Map;
import java.util.HashMap;

class PartitionEqualSubsetSum
{
     
   public static void main(String[] args)
   {
      System.out.println(canPartition(new int[] {1, 5, 11, 5}));
   }
   
   // Approach 3
   
    public static boolean canPartition(int[] nums) 
    {
        int n = nums.length;
        int sum = 0;
        
        for(int i : nums)
        {
            sum += i;
        }
                   
        if(sum % 2 != 0)
        {
            return false;
        }
        
        sum = sum / 2;
        
        boolean subset[][] = new boolean[n+1][sum + 1];
        
        for(int i = 0; i <= n; i++)
        {
            subset[i][0] = true; 
        } 
            
        for(int i = 1; i <= n; i++) 
        {
            for(int j = 1; j <= sum; j++) 
            {
                if(j < nums[i - 1]) 
                {
                    subset[i][j] = subset[i - 1][j];
                }                 
                else 
                {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return subset[n][sum];
    }   
   
   // Approach 2
   /* 
   public static boolean canPartition(int[] nums)
   {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        
        int sum = 0;
        
        for(int num: nums)
        {
            sum += num;   
        }
        
        if(sum % 2 != 0)
        {
            return false;
        }
        
        sum /= 2;
        
        return helper(nums, nums.length, sum);       
    }
    
    private static boolean helper(int[] nums, int n, int target)
    {
      if(target == 0)
      {
         return true;
      }
      
      if(n == 0 && target != 0)
      {
         return false;
      }
      
      // if last element is greater than sum, ignore it
      if(nums[n-1] > target)
      {
         return helper(nums, n-1, target);
      }
      
      // check if sum can be obtained by
      // including the last element
      // excluding the last element  
      return helper(nums, n-1, target) || helper(nums, n-1, target - nums[n-1]);     
    }
    */
    
   
   // Approach 1 
   /*
    
   private static Map<Integer, Boolean> map;
    
   public static boolean canPartition(int[] nums)
   {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        
        int sum = 0;
        
        map = new HashMap<>();
        
        for(int num: nums)
        {
            sum += num;   
        }
        
        if(sum % 2 != 0)
        {
            return false;
        }
        
        sum /= 2;       
        
        return helper(nums, 0, sum/2);
    }
    
    private static boolean helper(int[] nums, int index, int target)
    {
        if(index == nums.length)
        {
            return target == 0;
        }
        
        if(target < 0)
        {
            return false;
        }
        
        if(map.containsKey(target))
        {
            return map.get(target);
        }
        
        boolean result = helper(nums, index + 1, target - nums[index]) || helper(nums, index+1, target);
        
        map.put(target, result);
        
        return result;
   }
   */   
}