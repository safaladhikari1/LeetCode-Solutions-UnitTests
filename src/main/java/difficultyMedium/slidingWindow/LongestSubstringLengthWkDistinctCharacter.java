/*
   Leetcode premium problem: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
   
   Same problem on LintCode: https://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters  
   
   Given a string S, find the length of the longest substring T that contains at most k distinct characters.
   
   Example 1:
   
   Input: S = "eceba" and k = 3
   Output: 4
   Explanation: T = "eceb"
   
   Example 2:
   
   Input: S = "aaahhibc" and k = 2
   Output: 5
   
   ----
   
   Algorithm:
   
   1. Instantiate the windowStart to 0, maxLength = 0
   
   2. Create a HashMap <Character, Integer>
      Loop through the characters from the left
      
   3. If the HashMap doesn't have the character yet, default is 0, key + 1
   
   4. while HashMap.size() > k
      
         decrement the (key, value) from windowStart by 1
         put the new value to the character key
         
         If the (key,value) pair's value is 0, remove the key
         
   5. Outside the while loop, keep track of the maxLength of the HashMap.size
   
   6. Return the maxLength
   
   It is also explained on: https://youtu.be/MK-NZ4hN7rs?t=2001
   
   Time-Complexity: O(N), where N is the length of the string
   Space-Complexity: O(N), for our HashMap.       
*/

import java.util.Map;
import java.util.HashMap;

class LongestSubstringLengthWkDistinctCharacter
{
   public static void main(String[] args)
   {
      System.out.println(findLength("aaahhibc", 2));
      
      System.out.println(findLength("eceba", 3));
   }
   
   public static int findLength(String s, int k)
   {
      int windowStart = 0;
      Map<Character, Integer> chMap = new HashMap<>();
      int maxLength = 0;
      
      for(int windowEnd = 0; windowEnd < s.length(); windowEnd++)
      {
         char wEndKey = s.charAt(windowEnd);
         chMap.put(wEndKey, chMap.getOrDefault(wEndKey, 0) + 1);
         
         while(chMap.size() > k)
         {
            char wStartKey = s.charAt(windowStart);
            chMap.put(wStartKey, chMap.get(wStartKey) - 1);
            
            if(chMap.get(wEndKey) == 0)
            {
               chMap.remove(wEndKey);
            }
            
            windowStart++;
         }
         
         maxLength = Math.max(maxLength, windowEnd - windowStart + 1);   
      }
      
      return maxLength;
           
   }
}