/*
   Merge Sorted Array
   
   Given two sorted integer arrays nums1 and nums2,
   merge nums2 into nums1 as one sorted array.
   
   Note:
   
   - The number of elements initialized in nums1 and nums2
     are m and n respectively.
   - You may assume that nums1 has enough space (size that is
     equal to m + n) to hold additional elements from nums2.
   
   Example:
   
   Input:
   nums1 = [1, 2, 3, 0, 0, 0], m = 3
   nums2 = [2, 5, 6],          n = 3
   
   Output: [1, 2, 2, 3, 5, 6]    
   
   Constraints:
   
   nums1.length == m + n
   nums2.length == n
   
   
   ---
   https://leetcode.com/problems/merge-sorted-array/discuss/29704/My-clean-java-solution
   https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
   https://github.com/safaladhikari1/Java-Concepts/blob/master/Classes/SearchingAndSorting/MergeSort.java
   
   --
   Video Explanation: https://youtu.be/YXOBpf75R0Y 
   
   Algorithm:
   
   1. two Arrays:
      
      nums1 = [1, 2, 3, 0, 0, 0]
      
      nums2 = [2, 5, 6]
      
      m and n = no of elements initalized in nums1 and nums2 respectively
      
      So,
      
      int first = m - 1; it is pointing at 3
      int second = n - 1; it is pointing at 6
   
  2. We loop from the back of nums1.length - 1
  
     We wanted to compare nums1[first] and nums2[second]
     
     if(nums1[first] > nums2[second])
     {
        nums1[i] = nums1[first];
        first--;
     }
     else
     {
         nums1[i] = nums2[second];
         second--;
     }
     
     But we need to check edge cases such as:
     
     merge([0], 0, [1], 1)
     
     So we check,
     
     if(second < 0)
     {
         return;
     }
     
     if(first >= 0 first then && nums1[first] > nums2[second])
     
  ----
  
  TimeComplexity: O(N), where N is the number of elements in the nums2 array.
  SpaceComplexity : O(1)          
   
*/

class MergeSortedArray
{
   public static void main(String[] args)
   {
      int[] testArray1 = {0};
      int[] testArray2 = {1};
      int[] testArray3 = {1};
            
      merge(testArray1, 0, testArray2, 1);
   }
   
   public static void merge(int[] nums1, int m, int[] nums2, int n)
   {
      int first = m - 1;
      int second = n - 1;
      
      for(int i = nums1.length - 1; i >=0; i--)
      {
         if(second < 0)
         {
            return;
         }
         
         if(first >= 0 && nums1[first] > nums2[second])
         {
            nums1[i] = nums1[first];
            first--;
         }
         else
         {
            nums1[i] = nums2[second];
            second--;
         }
      }
   }   
}