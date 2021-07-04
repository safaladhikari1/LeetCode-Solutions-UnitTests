/*
   3 Sum
   
   Given an array nums of n integers, are there elements
   a, b, c in nums such that a + b + c = 0? Find all unique
   triplets in the array which gives the sum of zero.
   
   Notice that the solution set must not contain duplicate triplets.
   
   Example 1:
   
   nums = [-1, 0, 1, 2, -1, -4]
   Output = [[-1, -1, 2], [-1, 0, 1]]
   
   --------
   Algorithm:
   
   1. This algorithm is best explained on https://youtu.be/-AMHUdZc9ss
   
   2. The idea is we have an input array:
   
      [-1, 0, 1, 2, -1, -4]
      
      We have return all possible three elements a,b,c such that a+b+c = 0
      a+b+c pairs have to be unique.
      
   3. We first create an empty result ArrayList
      
      We add our three elements pair, by converting it to a List, and add to ArrayList
      
   4. We will first sort the input array
   
      [-4, -1, -1, 0, 1, 2]
      
      We only loop through the array until nums.length - 3
      because we have three pointers
      
      At first
      
      i is pointing at -4
      start is pointing at -1
      end is pointing at 2
      
      while(start < end)
      
         we check if nums[i] + nums[start] + nums[end] == 0
            If it is, we will convert them to List and add to our result ArrayList
         
         If the sum is less than 0
            we will increment the start, making sure that it is skipping the duplicates
                          
         Otherwise, the sum is greater than 0
            So we decrement the end, skipping the duplicates.
            
   5. At the end return the result. The above approach is best explained on the video above.
   
   ---------
   Time-Complexity: O(N^2), where N is the number of elements in the array
                    On outer for loop, we loop once, then we have inner while loop, where at most we will have to loop for every outer for loop.
   Space-Complexity: O(1), the space occupied by our result List does not count, because we have to return the result as our List<List<Integer>>                 

*/




import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class ThreeSum
{
   public static void main(String[] args)
   {
      System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
   }
   
   public static List<List<Integer>> threeSum(int[] nums)
   {
      List<List<Integer>> result = new ArrayList<>();
      
      Arrays.sort(nums);
      
      for(int i=0; i<=nums.length - 3; i++)
      {
         if(i == 0 || nums[i] > nums[i-1])
         {
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end)
            {
               if(nums[i] + nums[start] + nums[end] == 0)
               {
                  result.add(Arrays.asList(nums[i], nums[start], nums[end]));
               }
               
               if(nums[i] + nums[start] + nums[end] < 0)
               {
                  int currentStart = start;
                  
                  while(nums[start] == nums[currentStart] && start < end)
                  {
                     start++;
                  }
               }
               else // this means "nums[i] + nums[start] + nums[end] > 0"
               {
                  int currentEnd = end;
                  
                  while(nums[end] == nums[currentEnd] && start < end)
                  {
                     end--;
                  }
               }
            }
         }
      }
           
      return result;
   } 
}