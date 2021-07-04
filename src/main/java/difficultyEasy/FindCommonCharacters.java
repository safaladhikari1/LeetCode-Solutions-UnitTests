/*
   Find Common Characters
   
   Problem Source: https://leetcode.com/problems/find-common-characters/
   
   Algorithm:
   
   1. Create int[] originalTable of size 26
   
   2. Loop through the first string of Array
         Increment the charValues of int[] table
         
   3. Create currentTable of size 26
   
   4. Loop through the second string of Array      
         Increment the charValues of currentTable
         
         Loop through the originalTable and currentTable
            Set the originalTable value as minimum
   
   5. At the end, we will have original Table with only the number of common chars.
   
         For example:
      
         Input: ["bella","label","roller"]
         
         At first on our original table, it will have
         
         After reviewing "bella"
         
         b - 1
         e - 1
         l - 2
         a - 1
         
         Then we will review "label"
         
         l - 2
         a - 1
         b - 1
         e - 1
         
         After comparing we will have
         
         l - 2
         a - 1
         b - 1
         e - 1
         
         Then, we will review "roller"
         
         r - 2
         o - 1
         l - 2
         e - 1
         
         After comparing, we will have
         
         l - 2
         e - 1
         
   6. Then we will loop through the original Table
      
      Get the char value
      Convert it to char, then String
      And add to our ArrayList.
      
   7. Return the arraylist.
      
      Output: ["e","l","l"] 
      
   --------
   
   Time-Complexity: O(N), where N is the number of characters in total of the input string array.
   Space-Complexity: O(1)   
*/

import java.util.List;
import java.util.ArrayList;

class FindCommonCharacters
{
   public static void main(String[] args)
   {
      System.out.println(commonChars(new String[] {"bella", "label", "roller"}));
   }
   
   public static List<String> commonChars(String[] A)
   {
      List<String> myList = new ArrayList<>();
      int[] originalTable = new int[26];
      
      for(int i=0; i < A[0].length(); i++)
      {
         originalTable[A[0].charAt(i) - 'a']++;
      }
      
      for(int i=1; i < A.length; i++)
      {
         int[] currentTable = new int[26];
         
         String currentString = A[i];
         
         for(int j=0; j < currentString.length(); j++)
         {
            currentTable[currentString.charAt(j) - 'a']++;
         }
         
         for(int j=0; j < 26; j++)
         {
            originalTable[j] = Math.min(currentTable[j], originalTable[j]);
         }       
      }
      
      for(int i=0; i < 26; i++)
      {
         while(originalTable[i] > 0)
         {
            char c = (char)(i + 'a');
            
            myList.add(Character.toString(c));
            originalTable[i]--;
         }
      }
           
      return myList;
   }
}