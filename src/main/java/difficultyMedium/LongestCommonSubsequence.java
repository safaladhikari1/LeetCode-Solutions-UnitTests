/*
   Longest Common Subsequence:
   
   Given two strings text1 and text2, return the length of their longest common subsequence.
   
   If there is no common subsequence, return 0.
   
   Example:
   
   Input: text1 = "abcde", text2 = "ace" 
   Output: 3  
   Explanation: The longest common subsequence is "ace" and its length is 3.
   
   Problem Source: https://leetcode.com/problems/longest-common-subsequence/
   
   ---------
   
   Algorithm:
   
   1. This is explained in my post: https://github.com/safaladhikari1/CodingProblems/blob/master/OtherProblems/LongestSequenceOfCharacters.java
   
   2. The DP table for this problem will look like for input: "ace", "abcde"
   
      
               0     1     2     3     4     5
               
               ""    a     b     c     d     e
               
    0    ""    0     0     0     0     0     0      
      
    1    a     0    *1     1     1     1     1
    
    2    c     0     1     1    *2     2     2
    
    3    e     0     1     1     2     2    *3
    
    -------
    
    Time-Complexity: O(M * N), where M and N are the lengths of string 1 and string 2 respectively..
    Space-Complexity: O(M * N) for our DP table.

*/


class LongestCommonSubsequence
{
   public static void main(String[] args)
   {
      System.out.println(longestCommonSubsequence("ace", "abcde"));
   }
   
   public static int longestCommonSubsequence(String text1, String text2)
   {
      char[] textChar1 = text1.toCharArray();
      char[] textChar2 = text2.toCharArray();
      
      int max = 0;
      
      int[][] dpTable = new int[textChar1.length + 1][textChar2.length + 1];
      
      for(int i=1; i < dpTable.length; i++)
      {
         for(int j=1; j < dpTable[i].length; j++)
         {
            if(textChar1[i-1] == textChar2[j-1])
            {
               dpTable[i][j] = dpTable[i-1][j-1] + 1;
            }
            else
            {
               dpTable[i][j] = Math.max(dpTable[i][j-1], dpTable[i-1][j]);
            }
            
            if(max < dpTable[i][j])
            {
               max = dpTable[i][j];
            }
         }
      }     
      
      return max;
   }
}