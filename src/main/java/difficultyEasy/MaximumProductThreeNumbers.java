/*
   Maximum Product of Three Numbers
   
   Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
   
   Examples:
   
   Input: nums = [1,2,3]
   Output: 6
   
   Input: nums = [-1,-2,-3]
   Output: -6
   
   --------
   
   Algorithm:
   
   1. The goal is to find the: 
      
      three largest values (max1, max2, max3)
      two smallest values (min1, min2)
      
      by iterating over the elements in the nums array
      
   2. The largest of (max1 * max2 * max3) and (max1 * min1 * min2) is the required maximum product.
   
   3. We set the max1, max2, max3 to Integer.MIN_VALUE, this will set them to minimum value an integer can have,  - 2 ^ 31 - 1
      
      We set the min1, min2 to Integer.MAX_VALUE, this will set them to maximum value an integer can have, 2^31 + 1  
      
      We iterate through the elements in the array
         
         if(nums[i] >= max1),  nums[i] is greater than or equal to max1, max2 and max3. It is the greatest.
         {
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
         }
         else if(nums[i] >= max2), nums[i] is not greater than max1, but lies between max1 and max2.
         {
            max3 = max2;
            max2 = nums[i];
         }
         else if(nums[i] >= max3), nums[i] is not greater than max2, but lies between max2 and max3.
         {
            max3 = nums[i];
         }
         
         if(nums[i] <= min1), nums[i] is the smallest so far.
         {
            min2 = min1;
            min1 = nums[i];
         }
         else if(nums[i] <= min2), nums[i] is not smaller than min1, but lies between min1 and min2.
         {
            min2 = nums[i];
         } 
         
    4. At the end, return the Math.max((max1 * max2 * max3), (max1 * min1 * min2)) 
    
    --------
    
    Time-Complexity: O(N), where N is the number of elements in the nums array
    Space-Complexity: O(1)      
*/

class MaximumProductThreeNumbers
{
   public static void main(String[] args)
   {
      System.out.println(maximumProduct(new int[] {1, 2, 3, 4}));
      
      System.out.println(maximumProduct(new int[] {-1, -2, -3}));
   }
   
   public static int maximumProduct(int[] nums)
   {
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      int max3 = Integer.MIN_VALUE;
      
      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
      
      for(int i = 0; i < nums.length; i++)
      {
         if(nums[i] >= max1)
         {
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
         }
         else if(nums[i] >= max2)
         {
            max3 = max2;
            max2 = nums[i];
         }
         else if(nums[i] >= max3)
         {
            max3 = nums[i];
         }
         
         if(nums[i] <= min1)
         {
            min2 = min1;
            min1 = nums[i];
         }
         else if(nums[i] <= min2)
         {
            min2 = nums[i];
         }        
      }
      
      return Math.max((max1 * max2 * max3), (max1 * min1 * min2));
      
   }
   
   // Bruteforce Solution, tried using sliding window (does not work)
   /*
   public static int maximumProduct(int[] nums)
   {
      //int windowStart = 0;
      int maxProduct = Integer.MIN_VALUE;
      int currentProduct = nums[0];
      
      for(int windowEnd = 1; windowEnd < nums.length; windowEnd++)
      {
         currentProduct *= nums[windowEnd];
         
         if(windowEnd >= 2)
         {
            maxProduct = Math.max(currentProduct, maxProduct);
            
            currentProduct /= nums[windowEnd - 2];
            
            //currentProduct /= nums[windowStart];
            //windowStart++;
         }
      }
      
      return maxProduct;    
   }
   */
}