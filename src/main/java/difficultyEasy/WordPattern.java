/*
   Word Pattern
   
   Given a pattern and a string s, find if s follows the same pattern.

   Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
   
   Example:
   
   Input: pattern = "abba", s = "dog cat cat dog"
   Output: true
   
   Problem Source: https://leetcode.com/problems/word-pattern/
   
   ---------
   
   Approach 1 (Below using a HashMap<String, Character>)
   
   Algorithm:
   
   1. For inputs: String pattern "abba" , String s "dog cat cat dog"
   
      Split the s into String[]
      
      if the splitArray length's is not equal to pattern's length
         return false
         
   2. Otherwise Create a HashMap<String, Character>
   
      In pattern: "abba"
      
      If the map does not contain the letter of the pattern
      
      Store the Map with the corresponding string such as:
      
      dog - a
      cat - b
      
   3. Then loop through the String s "dog cat cat dog"
   
      if our patternMap contains "dog"
         if(patternMap.get("dog") != patter.charAt('a'))
            return false
            
            // In this case, it doesn't enter this if condition, because on our map, dog is a, and pattern is also a
            
      Otherwise, patternMap does not contain that word
      
      It happens with example:
      pattern = "abba", s = "dog cat cat fish" where we don't store fish on our map
      
         return false
         
   4. If it passes all the above, return true.      
   
   Time-Complexity: O(M + N), M is the length of pattern string, and N is the length of s string array
   Space-Complexity: O(M), where we store the pattern string's characters with corresponding s strings in our hash map.   
   
   
   -------
   
   Approach 2: Single Index Hash Map
   
   https://leetcode.com/problems/word-pattern/solution/       
*/


import java.util.Map;
import java.util.HashMap;

class WordPattern
{
   public static void main(String[] args)
   {
      System.out.println(wordPattern("abba", "dog cat cat fish"));
   }
   
   public static boolean wordPattern(String pattern, String s)
   {
      String[] splitArray = s.split(" ");
      
      if(splitArray.length != pattern.length())
      {
         return false;
      }
      
      Map<String, Character> patternMap = new HashMap<>();
      
      for(int i=0; i < pattern.length(); i++)
      {
         if (!(patternMap.containsValue(pattern.charAt(i))))
         {
            patternMap.put(splitArray[i], pattern.charAt(i));
         }
      }
      
      for(int i=0; i < splitArray.length; i++)
      {
         if(patternMap.containsKey(splitArray[i]))
         {
            if(patternMap.get(splitArray[i]) != pattern.charAt(i))
            {
               return false;
            }
         }
         else
         {
            return false;
         }
      }
      
      return true;
   }
}