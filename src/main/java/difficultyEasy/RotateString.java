/*
   Rotate String
   
   We are given two strings, A and B.

   A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
   
   Example 1:
   Input: A = 'abcde', B = 'cdeab'
   Output: true

   Example 2:
   Input: A = 'abcde', B = 'abced'
   Output: false
   
   Problem Source: https://leetcode.com/problems/rotate-string/
   
   -----
   
   Algorithm:
   
   1. If A's length and B's length are not equal
         return false
         
      If A is equal to B
         return true
         
   2. After that,
   
      Let's say our string A is "a b c d e" and B is "c d e a b"
      
      We can keep shifting the leftmost character of the string to the rightmost position
      
      And check if A can become B after some number of shifts on A
      
      The following coding is doing this shifting:
      
      for(int i=0; i <= length; i++)
      {
         char temp = aCharArray[0];
         
         for(int j=0; j < length; j++)
         {
            aCharArray[j] = aCharArray[j+1];
         }

         aCharArray[length] = temp;
      
      a b c d e
      b c d e a
      c d e a b
      
      Since our string is now "c d e a b", which is equals to original A "a b c d e"
         returns true
  
   3. Otherwise, return false
   
   ------
   
   Time-Complexity: O(N2), on worst case, we have to shift all the elements to the left for every element on the string
   Space-Complexity: O(N), space occupied by our charArray
   
   ------
   
   Approach 2:
   
   Using KMP (Knuth-Morris-Pratt) algorithm as explained in
   
   Approach 4 section of https://leetcode.com/problems/rotate-string/solution/
   
   https://youtu.be/iZ93Unvxwtw
   
   https://youtu.be/GTJr8OvyEVQ
   
   https://youtu.be/KG44VoDtsAA         

*/


class RotateString
{
   public static void main(String[] args)
   {
      System.out.println(rotateString("abcde", "cdeab"));
   }
   
   public static boolean rotateString(String A, String B)
   {
      if(A.length() != B.length())
      {
         return false;
      }
      else if(A.equals(B))
      {
         return true;
      }
      
      char[] aCharArray = A.toCharArray();
      int length = aCharArray.length - 1;
      
      for(int i=0; i <= length; i++)
      {
         char temp = aCharArray[0];
         
         for(int j=0; j < length; j++)
         {
            aCharArray[j] = aCharArray[j+1];
         }

         aCharArray[length] = temp;
         
         if(String.valueOf(aCharArray).equals(B))
         {
            return true;
         }        
      }
          
      return false;
   }
}