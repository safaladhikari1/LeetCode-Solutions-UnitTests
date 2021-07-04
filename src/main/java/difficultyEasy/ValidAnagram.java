/*
   Valid Anagram
   
   Given two strings s and t, write a function to determine if t is an anagram
   of s.
   
   Example 1:
   Input: s = "anagram", t = "nagaram"
   Output: true
   
   ------
   
   Algorithm:
   
   1. Anagram is a word formed by rearranging the letters of another word.
   
      On this problem, we can assume the input strings only contains lowercase alphabets
      This means we can create a Hash Table with int size 26 for 26 alphabets.
      
      For two words to be Anagram, their size has to be equal. If they are unequal return false.
      
      Then, create a counter int array, with size 26, initialize all of them to 0.
      
   2. We loop through first string, and increment the respective index value of HashTable by 1.
      
      On the example below, we have values[s.charAt(i) - 'a']
      
      char decimal value of 'a' is 97, per: https://www.utf8-chartable.de/unicode-utf8-table.pl?utf8=dec&addlinks=1&unicodeinhtml=dec&htmlent=1
      
      char decimal value of 'z' is 122. 122 - 96 is 26. That's why we have 26 size.
      
  3. Then we loop through second string, and decrement the respective index value of HashTable by 1.
     
     On the same loop, we check if any of the index values in the HashTable is less than 0, if it is, return false.
     If it is negative, it means that char letter in the index values, did not exist in the first string. So it's not Anagram.
  
  4. If it passes all the above, return true, because it is Anagram.
  
  ----
  
  Time-Complexity: O(N), where N is the number of elements in our hash table.
  Space-Complexity: O(1), although we do use extra space in HashTable, the space compexity is O(1) because the table's size stays constant no matter how large n is.
  
  -----
  
  We are using fixed size int[] array as our counter. If the input string contained unicode characters, we will use Hash Table.     
          
*/

class ValidAnagram
{
   public static void main(String[] args)
   {
      String testWord1 = "anagram";
      String testWord2 = "nagarab";
      
      System.out.println(isAnagram(testWord1, testWord2));
   }
   
   public static boolean isAnagram(String s, String t)
   {      
      int[] values = new int[26];
      
      if(s.length() != t.length())
      {
         return false;
      }
      
      else
      {
         for(int i=0; i < s.length(); i++)
         {
            values[s.charAt(i) - 'a']++;
         }
         
         for(int i=0; i < t.length(); i++)
         {
            values[t.charAt(i) - 'a']--;
            
            if(values[t.charAt(i) - 'a'] < 0)
            {
               return false;
            }
         }
         
         return true;
      }
   }
}