/*
   Leetcode Problem: https://leetcode.com/problems/next-greater-element-i/
   
   You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

   Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
   
   The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
   
   
   Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
   Output: [-1,3,-1]  
   
   --------
   
   Algorithm:
   
   1. The problem description is confusing, it is basically asking:
      
      nums1 is a subset of nums2, i.e. nums2 has all elements of nums1
      
      Is there a number greater than nums1[i], to the right of nums2[i], where nums1[i] is found.
      If there is, add the number to the array. If not, add -1
      
   2. Create a HashMap
      to store the nums2[i] and an nums2[i] element greater than nums2[i] in nums2, if looped from the left
        
      For example:
      
      For 1 in nums 2, the next greatest is 3, immediately after 1
      So, we can put (1 as key, 3 as value)
      
      Similarly, (3 as key, 4 as value)
      
   3. Create a stack of integer, to store the monotonic stack
   
      In this problem we will have a stack of decreasing sub-sequence. For example:
      
      For nums2 [1, 3, 4, 2]
      
      We loop through the elements of nums2
         We will push 1 to stack
         Since 3 is greater than 1, we pop 1, and push 3 to stack
         Since 4 is greater than 3, we pop 3, and push 4 to stack
         
         So our stack will have [4, 2] decreasing subsequence.
         
   4. After the while loop, our map will have
      
      (1, 3)
      (3, 4)
      
   5. Then we loop through nums1
      
      If nums1 exists in the map, we will assign the value to our nums1 array
      For example:
      
      4 doesn't exist in the map, so we will assign first element of our result array to -1
      1 exists in the map, and the map value is 3, which is the next highest for 1, so second element of our result array is 3
      2 doesn't exist in the map, so we will assign -1 to result array
      
   6. Return result array
   
   --------
   
   Time-Complexity: O(nums1.length + nums2.length), we visit all the elements in both nums1 and nums2 array once.
   Space-Complexity: O(nums2.length) for our monoStack.
      
*/


import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;

class NextGreaterElementI
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(nextGreaterElement(new int[] {1, 3, 5, 2, 4}, new int[] {6, 5, 4, 3, 2, 1, 7})));
   }
   
   // Monotonic Stack Solution
   public static int[] nextGreaterElement(int[] nums1, int[] nums2)
   {
      Map<Integer, Integer> nums2Map = new HashMap<>();
      Stack<Integer> monoStack = new Stack<>();
      
      for(int num : nums2)
      {
         while(!monoStack.isEmpty() && monoStack.peek() < num)
         {
            nums2Map.put(monoStack.pop(), num);
         }
         
         monoStack.push(num);
      }
      
      for(int i=0; i < nums1.length; i++)
      {
         nums1[i] = nums2Map.getOrDefault(nums1[i], -1);
      }
      
      return nums1;
   }
   
   // Brute force solution. It doesn't work.
   /*
   public static int[] nextGreaterElement(int[] nums1, int[] nums2)
   {
      Map<Integer, Integer> nums2Map = new HashMap<>();
      int[] result = new int[nums1.length];
      
      for(int i=0; i < nums2.length; i++)
      {
         nums2Map.put(nums2[i], i);
      }
      
      for(int i=0; i < nums1.length; i++)
      {
         int rightIndex = nums2Map.get(nums1[i]) + 1;
         
         while(rightIndex < nums2.length)
         {
            if(nums2[rightIndex] > nums1[i])
            {
               result[i] = nums2[rightIndex];
               break;
            }
            else
            {
               result[i] = -1;
            }
            
            rightIndex++;       
         }
      }
      
      return result;     
   }
   */
}