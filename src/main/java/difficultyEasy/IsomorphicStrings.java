/*
   Isomorphic Strings
   
   Given two strings s and t, determine if they are isomorphic.

   Two strings s and t are isomorphic if the characters in s can be replaced to get t.

   Problem Source: https://leetcode.com/problems/isomorphic-strings/
   
   Example 1:
   
   Input: s = "egg", t = "add"
   
   Output: true
   
   Explanation:
   
   e is mapped to a
   g is mapped to d
   
   When g appears again on String s, d appears on String t
   
   That's why they are isomorphic.
   
   Example 2:
   
   Input: s = "foo", t = "bar"
   Output: false
   
   f is mapped to b
   o is mapped to a
   
   When o appears again on String s, r appears on String t instead of a
   
   That's why they are not isomorphic.
      
   -----
   
   Algorithm 
   
   Approach 1:  Using HashTable
   
   1. Since the constraint is, we have ascii characters
   
      Set up two int[] tables of 128 for String s and String t
      
      total ascii characters: 128
      
   2. Since the length of both strings are equal
      
      We can loop through s's length
      
         And increment sTable[s.charAt(i)] = i + 1;
                       tTable[s.charAt(i)] = i + 1;
                       
         And any time, if the sTable[s.charAt(i)] != tTable[t.charAt(i)]
            Then we know the same letters of String s, is not mapped to the same letter at String t
            
   3. The reason we don't do:
   
       sTable[s.charAt(i)]++;
       tTable[s.charAt(i)]++;
       
                And increment sTable[s.charAt(i)] = i + 1;
                       tTable[s.charAt(i)] = i + 1;
       
       on our for loop is because   
       
       let's say we have strings:
       
       s = "bbbaaaba"
       
       t = "aaabbbba"      
       
       The above have equal number of letter b and letter a on both strings
       
       So, if we just map their count on our hash table, it won't work because even though they are different letters, the count will be the same on our hash table
       
       So, we have increment the count with the indices
       
       For example:
       
       When we are in the loop of index: 6 of String s, that is it will be pointing at second last b
       
       s will have 
       
       b: 3
       a: 6
       
       t will have
       
       a: 3
       b: 6
       
       So when it enters the loop, it checks if b in String s, has the same number as b in string t
       Since b in String s has 3, and b in String t has 6, it returns false.

   
   Time-Complexity: O(N), N is the length of the s string.
   Space-Complexity: O(1) 
   
   -------------
   
   Approach 2: Using HashMap
   
   1. It stores the character map for each letter in both strings
   2. Checks the key-value pairs, 
      
      At any point, if the key value pairs is not equal
         returns false.
         
   3. Otherwise returns true
   
   
   Time-Complexity: O(N), where N is the length of the s string
   Space-Complexity: O(N), where N is the number of characters in the map.         
       
*/


import java.util.Map;
import java.util.HashMap;

class IsomorphicStrings
{
   public static void main(String[] args)
   {
      System.out.println(isIsomorphic("egg", "add"));
      
      System.out.println(isIsomorphic("foo", "bar"));
      
      System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
   }
   
   // Approach 1: HashTable
   public static boolean isIsomorphic(String s, String t)
   {
      int[] sTable = new int[128];
      int[] tTable = new int[128];
      
      for(int i=0; i < s.length(); i++)
      {
         
         if(sTable[s.charAt(i)] != tTable[t.charAt(i)])
         {
            return false;
         }
         
         sTable[s.charAt(i)] = i + 1;
         tTable[t.charAt(i)] = i + 1;
      }
      
      return true;      
   }
   
   // Approach 2: HashMap
   /*
   public static boolean isIsomorphic(String s, String t)
   {
      if(s.length() != t.length())
      {
         return false;
      }
      
      Map<Character, Character> charMap = new HashMap<>();
      
      for(int i=0; i < s.length(); i++)
      {
         if(charMap.containsKey(s.charAt(i)))
         {
            if(t.charAt(i) != charMap.get(s.charAt(i)))
            {
               return false;
            }          
         }
         
         if(charMap.containsValue(t.charAt(i)))
         {
            if(!charMap.containsKey(s.charAt(i)))
            {
               return false;
            }
         }
         
         charMap.put(s.charAt(i), t.charAt(i));
      }
      
      return true;     
   }
   */     
}