/*
   Group Anagrams
   
   Problem Source: https://leetcode.com/problems/group-anagrams/
   
   -----
   
   Algorithm:
   
   Approach 1 Categorize by Sorted String: https://leetcode.com/problems/group-anagrams/solution/
   
   Two strings are anagram, if their sorted strings are equal.
   
   1. If the input string's length is 0
         return new empty array list
         
   2. Create a map of String and int
   
   3. Create a for - each loop to get each string from strings[] array
         Convert string to char array
         Sort the char array
         Convert sorted array to String key
         
         If the map doesn't contain the string
            add the string key and empty array list
         
         get the respective arraylist using the string key, and add the original string to it.
   
   4. At the end create a new Arraylist using the values of the map(which will just contain the arraylist of anagram strings) 
   
   Time and Space Complexity, explained on the above article on Leetcode.                
*/


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class GroupAnagrams
{
   public static void main(String[] args)
   {
      //System.out.println(isAnagram("anagram", "nagaram"));
      
      System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
   }
   
   public static List<List<String>> groupAnagrams(String[] strs)
   {
      if(strs.length == 0)
      {
         return new ArrayList();
      }
      
      Map<String, List> wordMap = new HashMap<>();
      
      for(String s : strs)
      {
         char[] sArray = s.toCharArray();
         Arrays.sort(sArray);
         
         String key = String.valueOf(sArray);
         
         if(!wordMap.containsKey(key))
         {
            wordMap.put(key, new ArrayList());
         }

         wordMap.get(key).add(s);      
      }
      
      return new ArrayList(wordMap.values());
   }
   
   
   
   
   // Bruteforce solution, doesn't work
   /*
   public static List<List<String>> groupAnagrams(String[] strs)
   {
      List<List<String>> outerList = new ArrayList<>();
      Set<String> innerSet = new HashSet<>(); 
      
      for(int i=0; i < strs.length; i++)
      {
         for(int j=1; j < strs.length; j++)
         {
            if(isAnagram(strs[i], strs[j]))
            {
               innerSet.add(strs[i]);
               innerSet.add(strs[j]);
               
               List<String> innerList = new ArrayList<>(innerSet);
               outerList.add(innerList);
               innerSet.clear();
            }
         }
      }
      
      
      return outerList;
   }
   
   public static boolean isAnagram(String s, String t)
   {
      int[] letterMap = new int[26];
      
      if(s.length() != t.length())
      {
         return false;
      }
      else
      {
         for(int i=0; i < s.length(); i++)
         {
            letterMap[s.charAt(i) - 'a']++;
         }
         
         for(int i=0; i < t.length(); i++)
         {
            letterMap[t.charAt(i) - 'a']--;
            
            if(letterMap[t.charAt(i) - 'a'] < 0)
            {
               return false;
            }
         }
      }
      
      return true;
   }
   */
}