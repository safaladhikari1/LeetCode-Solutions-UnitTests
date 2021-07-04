/*
   Implement strStr()
   
   Return the index of the first occurrence of needle in haystack, or -1 if needle is not
   part of hayStack.
   
   Example 1:
   
   Input: haystack = "hello", needle = "ll"
   Output: 2
   
   Example 2:
   
   Input haystack = "aaaaa", needle = "bba"
   Output: -1
   
   if needle is empty, return 0.
   
   ---
   
   Source: https://www.techiedelight.com/implement-strstr-function-java/
   
   Similar to inner implementation of java's String class: indexOf(String str) method (https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#indexOf-java.lang.String-)
   
   Time Complexity:
   
   O(i * j), where i is the length of haystack, j is the length of the needle.

*/

class ImplementstrStr
{
   public static void main(String[] args)
   {
      String testhaystack = "hello";
      String testneedle = "ll";
      
      System.out.println(strStr("mississippi", "issiq"));
   }
   
   public static int strStr(String haystack, String needle)
   {
      // if haystack is shorter than needle, return -1
      if(haystack.length() < needle.length())
      {
         return -1;
      }
      
      // if needle is empty, return 0
      if(needle.length() == 0)
      {
         return 0;
      }
      
      // Get the difference of the longer haystack and shorter needle
      int difference = haystack.length() - needle.length();
      
      /*
         Loop <= difference
         declare int j for counting
         if needle.charAt(j) == haystack.charAt(i+j)
            increment the j. But j is always less than needle.length
         
         if j's count is equal to needle.length()
            it means, that the needle string is inside the haystack string
         
         i is keeping track of where the needle string started
         
         returning i, will return the first occurrence of needle in haystack     
      */
      for(int i=0; i<=difference; i++)
      {
         int j;
         
         for(j = 0; j<needle.length(); j++)
         {
            if(needle.charAt(j) != haystack.charAt(i+j))
            {
               break;
            }
         }
         
         if(j == needle.length())
         {
            return i;
         }         
      }
      
      return -1;
   }   
}