/*
   Search in Rotated Sorted Array
   
   Problem Source: https://leetcode.com/problems/search-in-rotated-sorted-array/
   
   ----
   
   Approach 1 is self explanatory, O(N) run time
   
   ----
   
   Approach 2
   
   Best explained on: https://youtu.be/oTfPJKGEHcc
   
   1. There are few observations we can make:
   
      Since there is only 1 pivot point (Pivot element is the one, where the element is greater than the left side and the element is greater than the right side):
      
      a. The array has right side with more increasing order elements [6, 7, 8, 0, 1, 2, 3, 4, 5]
      
         The array has left side with more increasing order elements [2, 3, 4, 5, 6, 7, 8, 0, 1]
         
         The array has about equal, increasing order elements on both sides. [4, 5, 6, 7, 8, 0, 1, 2, 3]
         
      b. Regardless of which ever side, the elements are in sorted order.
         So we can do Binary Search, which can give us O(LogN) time.
         
   2. The question is:
   
      We have to find out in which side our target element falls under
         Then do binary search only on that side.
         
   3. On our example array:
   
      [4, 5, 6, 7, 0, 1, 2]
      
      Let's find the mid element first
      
      int mid = low + (high - low)/2; will give us our mid index.
      
      If the mid element is already our target
         just return the mid index.
         
    4. Otherwise,
       
       Check if the left half of the array is in increasing order? (we know one of the half have more increasing order)
       else if(nums[low] <= nums[mid])
         
         if it is, check if the target falls between the low and high bound of left half of the array
         if(nums[low] <= target && target <= nums[mid])
            
            If it is, then we only need to check on left half
            high = mid - 1
            
            Otherwise,
            The element must be on the other side of the array, regardless of the increasing order or not
            low = mid + 1;
                              
      If the left half is not on increasing order, the other half must be. We will do the similar check as above on our other half
         
         If the target falls between the mid and high bound of right half
         if(nums[mid] <= target && target <= nums[high])
            
            If it is, low = mid + 1
            
         Otherwise
         The element must be on the left half
            high = mid - 1;
            
     5. On our example:
     
        [4, 5, 6, 7, 0, 1, 2]
        
        low will be 0
        high will be 6
        
        mid will be 3
        
        Then, low will be 4, high will be 6, mid will be 5
        Then,  low will be 4, high will be 4, mid will be 4
        
        Then it finds the 0, and returns the index 4
        
     --------
     
     Time-Complexity: O(Log N), using Binary Search Algorithm
     Space-Complexity: O(1)            
*/

class SearchRotatedSortedArray
{
   public static void main(String[] args)
   {
      System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
      
      System.out.println(search(new int[] {1}, 0));
   }
   
   // Approach 2
   public static int search(int[] nums, int target)
   {
      int low = 0;
      int high = nums.length - 1;
      
      while(low <= high)
      {
         int mid = low + (high - low)/2;
         
         if(nums[mid] == target)
         {
            return mid;
         }
         else if(nums[low] <= nums[mid])
         {
            if(nums[low] <= target && target <= nums[mid])
            {
               high = mid - 1;
            }
            else
            {
               low = mid + 1;
            }
         }
         else
         {
            if(nums[mid] <= target && target <= nums[high])
            {
               low = mid + 1;
            }
            else
            {
               high = mid - 1;
            }
         }
      }
      
      return -1;
   }
   
   // Approach 1 (Bruteforce Solution)
   /*
   public static int search(int[] nums, int target)
   {
      for(int i=0; i < nums.length; i++)
      {
         if(nums[i] == target)
         {
            return i;
         }
      }
      
      return -1;
   }
   */
}