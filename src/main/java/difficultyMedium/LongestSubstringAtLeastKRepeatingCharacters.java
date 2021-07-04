/*
   Longest Substring with At Least K Repeating Characters
   
   Problem Source: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
   
   ------
   
   Review: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/1014507/Clean-Java

*/


import java.util.Map;
import java.util.HashMap;

class LongestSubstringAtLeastKRepeatingCharacters
{
   public static void main(String[] args)
   {
      System.out.println(longestSubstring("ababbc", 2));   
   }
   
   public static int longestSubstring(String s, int k)
   {
      int windowStart = 0;
      int result = 0;
      Map<Character, Integer> letterMap = new HashMap<>();
      
      for(int windowEnd = 0; windowEnd < s.length(); windowEnd++)
      {
         letterMap.put(s.charAt(windowEnd), letterMap.getOrDefault(s.charAt(windowEnd), 0) + 1);
         
         while(letterMap.get(s.charAt(windowEnd)) >= k)
         {
            char windowStartLetter = s.charAt(windowStart);
            
            letterMap.put(windowStartLetter, letterMap.get(windowStartLetter) - 1);
            
            windowStart++;          
         }
         
         result = Math.max(result, windowEnd - windowStart + 1);
      }
      
      return result;
   }
}