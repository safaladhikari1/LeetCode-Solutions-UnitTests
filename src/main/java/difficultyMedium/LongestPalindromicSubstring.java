/*
   Longest Palindromic Substring
   
   Given a string s, return the longest palindromic substring in s.
   
   Example 1:
   Input: s = "babad"
   Output: "bab" or "aba"
   
   Problem Source: https://leetcode.com/problems/longest-palindromic-substring/
   
   -------
   
   Algorithm:
   
   https://youtu.be/y2BD4MJqV20
   
   Approach4: Expand Around Center, https://leetcode.com/problems/longest-palindromic-substring/solution/

*/

class LongestPalindromicSubstring
{

   public static void main(String[] args)
   {
      String s = "babad";
      
      System.out.println(longestPalindrome(s));
   }
   
   /*
   private static int resultStart;
   private static int resultLength;
   
   public static String longestPalindrome(String s)
   {
      
      int strLength = s.length();
      
      if (strLength < 2)
      {
         return s;
      }
      
      for(int start=0; start < strLength - 1; start++)
      {
         expandRange(s, start, start);
         expandRange(s, start, start + 1); // If number of characters are even
         
         // Are the above the possible midpoint of palindrome substring?    
      }
      
      return s.substring(resultStart, resultStart + resultLength);
 
   }
   
   private static void expandRange(String str, int begin, int end)
   {
      while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end))
      {
         begin--;
         end++;
      }
      
      if(resultLength < end - begin -1)
      {
         resultStart = begin + 1;
         resultLength = end - begin - 1; // because of zero index of the array of java
      }
      
   }
   */
       
   public static String longestPalindrome(String s)
   {
      if(s == null || s.length() < 1)
      {
         return "";
      }
      
      int start = 0;
      int end = 0;
      
      for(int i=0; i < s.length(); i++)
      {
         int len1 = expandFromCenter(s, i, i);
         int len2 = expandFromCenter(s, i, i+1);
         
         int len = Math.max(len1, len2);
         
         if(len > end - start)
         {
            start = i-((len-1)/2);
            end = i + (len/2);
         }
      }
      
      return s.substring(start, end + 1);
   }
   
   private static int expandFromCenter(String s, int left, int right)
   {
      if(s == null || left > right)
      {
         return 0;
      }
      
      while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
      {
         left--;
         right++;
      }
      
      return right-left-1;
   }
}