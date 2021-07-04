/*
   Split a String in Balanced Strings
   
   Balanced strings are those who have equal quantity of 'L' and 'R' characters.
   Given a balanced string s split it in the maximum amount of balanced strings.
   Return the maximum amount of splitted balanced strings.
   
   Example 1:
   
   Input: s = "RLRRLLRLRL"
   Output: 4
   Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
   
   Example 2:
   
   Input: s = "RLLLLRRRLR"
   Output: 3
   Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
   
   ---------
   
   Algorithm (Approach 2):
   
   1. This question is basically asking as you loop through the characters in the string
      count how many times 'L' is equal to 'R'
      
      The order of 'L' and 'R' doesn't matter.
      
      Since the string only contains 'L' or 'R'
      
   2. We can initialize our
      
      result count = 0
      L count = 0
      R count = 0
      
      we will loop through every characters in the string
         
         If we find 'L'
            increment the L count
         else
            It must be 'R', since the string only has either L or R
            increment the R count
            
         check if L count is equal to R count
            increment our result count 
   
   3. At the end return the result count.
   
   Time-Complexity: O(N), where N is the number of characters in the string
   Space-Complexity: O(1)
   
  -------
  
  Algorithm (Approach 1)
  
  1. We are doing the same thing as above, but we first created a charTable of size 2
  
  2. Then loop through the string
     
     If the character is L, char Value is 76
      incrment the charTable[0]
      
     Otherwise, it's R, charavalue is 82
      increment the charTable[1]
      
     If the charTable[0] is equal charTable[1]
      count++
      reset the charTable to 0.
      
  3. return the count
  
  Time-Complexity: O(N), where N is the characters in the string
  Space-Complexity: O(1), the size of the charTable doesn't grow, regardless of the size of the input string.                         

*/

class SplitBalancedStrings
{
   public static void main(String[] args)
   {
      System.out.println(balancedStringSplit("RLRRLLRLRL"));
      
      System.out.println(balancedStringSplit("RLRRRLLRLL"));
   }
   
   // Approach 2
   public static int balancedStringSplit(String s)
   {
      int count = 0;
      int lcount = 0;
      int rcount = 0;
      
      for(int i=0; i < s.length(); i++)
      {
         if(s.charAt(i) == 'L')
         {
            lcount++;
         }
         else
         {
            rcount++;
         }
         
         if(lcount == rcount)
         {
            count++;
         }
      }
      
      return count;      
   }
   
   // Bruteforce Approach 1: (Using charTable)
   /*
   public static int balancedStringSplit(String s)
   {
      int count = 0;
      int[] charTable = new int[2];
      
      for(int i=0; i < s.length(); i++)
      {
         if(s.charAt(i) == 76)
         {
            charTable[0]++;
         }        
         else if(s.charAt(i) == 82)
         {
            charTable[1]++;
         }
         
         if(charTable[0] != 0 && charTable[1] != 0)
         {
            if(charTable[0] == charTable[1])
            {
               count++;
               charTable[0] = 0;
               charTable[1] = 0;
            }
         }
      }
      
      return count;
   }
   */
}