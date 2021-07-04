/*
   Longest Common Prefix
   
   Write a function to find the longest common prefix string amongst an array of strings.
   
   If there is no common prefix, return an empty string "".
   
   Example 1:
   
   Input: ["flower", "flow", "flight"]
   Output: "fl"
   
   Example 2:
   
   Input: ["dog", "racecar", "car"]
   Output: ""
   
   ----
   
   First attempt using the concept: https://youtu.be/g5kH8EX4l-U
   
   Algorithm:
   
   String[] -> ["flower", "flow", "flight"]
   
   1. Make an empty string builder, so we don't have to keep doing string +=
   2. If the string[] is empty, return ""
   3. Store the first String[0] on comparisonWord (flower)
   4. Convert comparisonWord to comparisonWord2Char array, so we can take one char at a time 
      'f' 'l', then compare that char to the 1st index, 2nd index of String[1], String[2]..
   5. Increment the index using comparisonIndex.   
   5. We have to make sure:
      bark(comparisonWord)    bar(CurrentWord)
      if comparisonIndex doesn't get more than currentword.length()
      
      On the above example, our loop should end at bar, on comparison Word
      
   6. If the chars are equal, keep appending the comparisonLetter on String Builder, and return the string.
      If the chars are not equal, return the string immediately.
      

*/
import java.lang.String;

class LongestCommonPrefix
{
   public static void main(String[] args)
   {
      String[] testArray = {"flower", "flow", "flight"};
      String[] testArray2 = {"aa", "a"};
      
      System.out.println(longestPrefix(testArray));
   }
   
   public static String longestPrefix(String[] str)
   {
      StringBuilder result = new StringBuilder();
      result.append("");
      
      if(str.length == 0)
      {
         return result.toString();
      }
      
      String comparisonWord = str[0];
      
      char[] comparisonWord2Char = comparisonWord.toCharArray();
      
      int comparisonIndex = 0;
      
      for(char comparisonLetter: comparisonWord2Char)
      {
         for(int i=1; i<str.length; i++)
         {
            String currentWord = str[i];
            
            if(comparisonIndex >= currentWord.length())
            {
               return result.toString();
            }   
           
            char currentLetter = currentWord.charAt(comparisonIndex);
            
            if(comparisonLetter != currentLetter || comparisonIndex > currentWord.length())
            {
               return result.toString();
            }                                                                        
         }
                           
         result.append(comparisonLetter);
         comparisonIndex++; 
                      
      }
          
      return result.toString();      
   }
}