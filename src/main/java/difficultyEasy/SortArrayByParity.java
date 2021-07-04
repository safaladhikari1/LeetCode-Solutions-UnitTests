/*
   Sort Array By Parity
   
   Problem Source: https://leetcode.com/problems/sort-array-by-parity/
   
   ------
   
   Algorithm:
   
   Source: https://leetcode.com/problems/sort-array-by-parity/discuss/1132918/Two-Pointer-or-Java-or-Simple-or-Easy-To-Understand
   
   1. We are separating even elements on left side, odd elements on right side using two pointers
   
   2. Setup left and right pointers
   
      left = 0
      right = A.length - 1
   
   3. Inside while loop, it breaks up when left is greater than right
      
         Another while loop to check if the left element is even
         while(left < right && A[left] % 2 == 0)
            increment the left pointer
         
         Another while loop to check if the right element is odd
         while(left < right && A[right] % 2 == 1)  
            decrement the right pointer
            
         If that's not the case, then we need to swap
         For example: [3, 1, 2, 4] , we need to swap 3 and 4
         
   4. After swapping, increment left, and decrement right to find another pair to swap on next iteration
   
   ----
   
   Time-Complexity: O(N), where N is the number of elements in the array, we visit every elements at least once.
   Space-Complexity: O(1)                
*/

import java.util.Arrays;

class SortArrayByParity
{
   public static void main(String[] args)
   {
      System.out.println(Arrays.toString(sortArrayByParity(new int[] {3, 1, 2, 4})));
      
      System.out.println(Arrays.toString(sortArrayByParity(new int[] {0, 1, 2})));   
   }
   
   public static int[] sortArrayByParity(int[] A)
   {
      int left = 0;
      int right = A.length - 1;
      
      while(left < right)
      {
         while(left < right && A[left] % 2 == 0)
         {
            left++;
         }
         
         while(left < right && A[right] % 2 == 1)
         {
            right--;
         }
         
         int temp = A[left];
         A[left] = A[right];
         A[right] = temp;
         
         left++;
         right--;
      }
      
      return A;
   }
   
   
   
   // Brute Force Solution, doesn't pass all the test cases
   /*
   public static int[] sortArrayByParity(int[] A)
   {
      int left = 0;
      int right = A.length - 1;
      
      while(left < right)
      {
         if(A[left] % 2 == 0)
         {
            left++;
         }
         else
         {
            int temp = A[left];
            
            if(A[right] % 2 == 0)
            {
               swap(A, left, right);
            }
            else
            {
               while(A[right] % 2 == 0)
               {
                  right--;
               }
               
               swap(A, left, right);
            }
         }
         
         left++;
         right--;
      }
      
      return A;
   }
   
   public static void swap(int[] A, int l, int r)
   {
      int temp = A[l];
      A[l] = A[r];
      A[r] = temp;
   }
   */
}