/*
   Jewels and Stones
   
   You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
   Each character in stones is a type of stone you have.
   You want to know how many of the stones you have are also jewels.
   Letters are case sensitive, so "a" is considered a different type of stone from "A".
   
   Example 1:
   
   Input: jewels = "aA", stones = "aAAbbbb"
   Output: 3
   
   --------
   
   Algorithms:
   
   Approach 1 (Using counter table for 128 ASCII characters)
   
   1. Since our constraint is, all the characters of jewels and stones are English letters.
      
      We can create a charTable, based on their charValues.
      
      Per: https://www.utf8-chartable.de/unicode-utf8-table.pl?utf8=dec&addlinks=1&unicodeinhtml=dec&htmlent=1
      122 (char value of letter 'z') - 64 (char value of @) = 58
      
      So all the english letters, uppercase and lowercase can fall under our 
      int[] charTable array of size 58.
      
   2. Now we loop through our jewels first,
      
      increment the index value in our chartable for the respective characters by 1
      charTable[jewels.charAt(i) - 'A']++;
   
   3. We also have our count initialized to 0
   
   4. Now we loop through our stones,
      
      The character index value for all our characters that were in the jewels have been incremented by 1 on our previous loop
      Now if we go and visit them again, we can add all those ones, and that will be our total count.
      
      count += charTable[stones.charAt(i) - 'A'];
      
   5. Return the count.
   
   Time-Complexity: O(M + N), where M is the length of jewels and N is the length of stones.
   Space-Complexity: O(1), because our charTable is fixed size array and it doesn't change regardless of the input strings.
   
   --------
   
   Approach 2:
   
   1. Basically we do the same as above, but instead of storing the characters of jewels in a fixed size charTable
      we store in our hash set.
      
   2. Then we loop through the characters in stones
         Check if our hashset of jewels contains the character of stones
         If it does, we will increment our count.
         
   3. Return the total count.
   
   Time-Complexity: O(M + N), where M is the length of jewels and N is the length of stones.                 
   Space-Complexity: O(M), where M is the length of jewels. We use this space on our HashSet.

*/

import java.util.Set;
import java.util.HashSet;

class JewelsAndStones
{
   public static void main(String[] args)
   {
      System.out.println(numJewelsInStones("aA", "aAAbbbb"));
      System.out.println(numJewelsInStones("z", "ZZ"));
      
   }
   
   // Approach 2 (Using counter table for 128 ASCII characters)   
   public static int numJewelsInStones(String jewels, String stones)
   {
      int[] charTable = new int[58];
      int count = 0;
      
      for(int i=0; i < jewels.length(); i++)
      {         
         charTable[jewels.charAt(i) - 'A']++;
      }
      
      for(int i=0; i < stones.length(); i++)
      {         
         count += charTable[stones.charAt(i) - 'A'];
      }   
      
      return count;      
   }
  
   // Approach 1 (Using HashSet)
   /*
   public static int numJewelsInStones(String jewels, String stones)
   {
      Set<Character> jewelSet = new HashSet<>();
      int count = 0;
      
      for(int i=0; i < jewels.length(); i++)
      {
         jewelSet.add(jewels.charAt(i));
      }
      
      for(int i=0; i < stones.length(); i++)
      {
         if(jewelSet.contains(stones.charAt(i)))
         {
            count++;
         }
      }

      return count;
   }
   */
}