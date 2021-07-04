/*
   Intersection of Two Arrays
   
   Given two arrays, write a function to computer their intersection.
   
   Example 1:
   Input: nums1 = [1, 2, 2, 1];
          nums2 = [2, 2]
   
   Output: [2]
   --------------
   
   Algorithm:
   
   1. So we create set1 first, and add all the elements from nums1 to set1.
      
      set1 will not have duplicates, [1, 2]
   
   2. Then we make an ArrayList, list
      
      loop through nums2, if set1 contains nums2 element,
      add it to the list, and remove it from set1.
      
      This is because:
      
      set1 has [1, 2]
      
      nums has [2, 2]
      
      it will check if first 2 is in set1, once, then adds to the list.
      it will check if second 2 is in the set1, it is. So it will add to the list again.
      
      To remove duplicates, we will have to first remove that 2 from set1.
      
   3. Then make a result array, loop through list, and add the elements from the list to result array.
   
   4. return result array.
   
   ---------
   
   Time-Complexity: O(M + N), where M and N are the lengths of the nums1 and nums2 arrays respectively.
   Space-Complexity: O(M + N), in the worst case, where all elements in the nums1 and nums2 arrays are different.                   
*/


import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class IntersectionTwoArrays
{
   public static void main(String[] args)
   {
      int[] testArray1 = {1, 2, 2, 1};
      int[] testArray2 = {2, 2};
      
      System.out.println(Arrays.toString(intersection(testArray1, testArray2)));
   }
     
   public static int[] intersection(int[] nums1, int[] nums2)
   {
      Set<Integer> set1 = new HashSet<>();
      
      for(int num : nums1)
      {
         set1.add(num);
      }
      
      List<Integer> list = new ArrayList<>();
      
      for(int num : nums2)
      {
         if(set1.contains(num))
         {
            list.add(num);
            set1.remove(num);
         }
      }
      
      int[] result = new int[list.size()];
      
      for(int i=0; i<list.size(); i++)
      {
         result[i] = list.get(i);
      }
      
      return result;
      
   }
}