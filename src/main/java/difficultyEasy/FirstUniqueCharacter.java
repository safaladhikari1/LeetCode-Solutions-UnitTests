/*
   First Unique Character in a String
   
   Given a string, find the first non-repeating character in it and return its index.
   If it doesn't exist, return -1.
   
   Examples:
   
   s = "leetcode"
   return 0.
   
   s = "loveleetcode"
   return 2.
   
   -----------
   Algorithm:
   
   1. Let's use a fixed size array called: countTable =  new int[26], for 26 lowercase alphabets in the array
   2. Loop through the string, countTable[s.charAt(i) - 'a']++;
      increment the index in that array for any letters of that string.
   3. Loop through the string again, if any of the index is 1, return the i, in that loop. That i is the index of the letter in the string.   
   4. Otherwise, return -1.
   
   ------------
   Time-Complexity: O(N), where N is the number of elements in the string, because we visit every element in the string at least once in the first for loop.
   Space-Complexity: O(1), we are using fixed size array with size = 26.

*/


import java.util.HashMap;

class FirstUniqueCharacter
{
   public static void main(String[] args)
   {
      String testString = "loveleetcode";
      String testString2 = "z";
      
      System.out.println(firstUniqChar(testString2));
      
   }
   
   // Using fixed array approach
   public static int firstUniqChar(String s)
   {
      int[] countTable = new int[26]; // for 26 lowercase alphabets.
      
      int stringLength = s.length(); // for single character string "z", LeetCode wants the output 0. So it is s.length(), instead of s.length() - 1
      
      for(int i=0; i<stringLength; i++)
      {
         countTable[s.charAt(i) - 'a']++;
      }
      
      for(int i=0; i<stringLength; i++)
      {
         if(countTable[s.charAt(i) - 'a'] == 1)
         {
            return i;
         }
      }
      
      return -1;
   }
   
   // Using HashMap Approach
   /*
   public static int firstUniqChar(String s)
   {
      HashMap<Character, Integer> myMap = new HashMap<>();
      
      char[] sChars = s.toCharArray();
      
      for(char letter : sChars)
      {
         if(myMap.containsKey(letter))
         {
            myMap.put(letter, myMap.get(letter) + 1);
         }
         else
         {
            myMap.put(letter, 1);
         }
      }
      
      for(int i=0; i < sChars.length; i++)
      {
         if(myMap.get(sChars[i]) == 1)
         {
            return i;
         }
      }
          
      return -1;
   }
   */
}