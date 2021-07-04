/*
   Given two integer arrays A and B, return the maximum length of an subarray that appears
   in both arrays.
   
   Example 1:
   
   Input: [1, 2, 3, 2, 1]
   Output: [3, 2, 1, 4, 7]
   
   Output: 3
   
   The repeated subarray with maximum length is [3, 2, 1]
   
   -----
   
   Algorithm:
   
   1. This problem is solved using dynamic programming, especially with the
      dynamic programming table explained in the video below:
      
      Tushar's youtube:
      
      https://youtu.be/BysNXJHzCEs
      
      https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestCommonSubstring.java
      
      Another useful video from BacktoSWE: https://youtu.be/ASoaQq66foQ
      
   2. Once you have finished the video, our dynamic table will look like:
   
             1  2  3  2  1
         0   0  0  0  0  0      
      3  0   0  0  1  0  0
      2  0   0  1  0  2  0
      1  0   1  0  0  0  3
      4  0   0  0  0  0  0
      7  0   0  0  0  0  0
      
   3. If we look at the code:
   
      We first instantiate result = 0
      
      then create our 2d array table that looks like above, with all 0 at first.
      
      Then we compare elements
         If you noticed on the table, whereever the elements are equal
         it is adding 1 + dpTable[i-1][j-1] (the diagonal)
         
         The result is keeping track of the highest dpTable[i][j]
         
   4. At the end, return the result. Tushar's video above is really helpful to understand
      what's going in the table above.
   
   ---------
   
   Time-Complexity: O(M * N), where M, N are the lengths of numsA and numsB array.
   Space-Complexity: O(M * N), the space used by dynamic programming.
   
   Reference: Dynamic Programming section of the article: https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/ 
   
*/


class MaximumLengthOfRepeatedSubarray
{
   public static void main(String[] args)
   {
      //System.out.println(findLength(new int[] {1, 2, 3, 2, 1}, new int[] {3, 2, 1, 4, 7}));
      
      System.out.println(findLength(new int[] {3, 2, 1, 4, 7}, new int[] {1, 2, 3, 2, 1}));    
   }
   
   public static int findLength(int[] numsA, int[] numsB)
   {
      int result = 0;
      
      int[][] dpTable = new int[numsA.length + 1][numsB.length + 1];
      
      for(int i=1; i <= numsA.length; i++)
      {
         for(int j=1; j <= numsB.length; j++)
         {
            if(numsA[i-1] == numsB[j-1])
            {
               dpTable[i][j] = dpTable[i-1][j-1] + 1;
               
               if(result < dpTable[i][j])
               {
                  result = dpTable[i][j];
               }   
            }
         }
      }
          
      return result;
      
   }
}