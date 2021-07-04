/*
   Reverse String
   
   Write a function that reverses a string. The input string is given as an array of characters char[].
   
   Do not allocate extra space for another array, you must do this by modifying the input array in-place
   with O(1) extra memory
   
   You may assume all the characters consists of printable ASCII characters
   
   Example 1:
   
   Input: ["h","e","l","l","o"]
   Output: ["o","l","l","e","h"]
   
   Example 2: 
   
   Input: ["H","a","n","n","a","h"]
   Output: ["h","a","n","n","a","H"]
   
   ------
   
   Algorithm:
   
   1. we are using two pointers approach:
      
      start is at 0
      end is at lastIndex of the char array
      
      Then while(start < end)
      
      store the s[start] char temp
      
      swap the s[start] and s[end]
      
      store the char temp in s[end]
      
      increment the start
      increment the end
      
      When the meet in the middle, start = end, the loop ends.
      
      The above algorithm is explained in: https://leetcode.com/problems/reverse-string/solution/
   
   -----
   
   Time Complexity: O(N), where N is the number of elements in the char array, to swap N/2 elements.
   
   Space Complexity: O(1), it's a constant space solution, no memory is used anywhere. 
                     Variable memory does not count in in-place algorithm: https://en.wikipedia.org/wiki/In-place_algorithm
     
*/

import java.util.Arrays;

class ReverseString
{
   public static void main(String[] args)
   {
      char[] testArray = {'h', 'e', 'l', 'l', 'o'};
      
      reverseString(testArray);
      
      System.out.println(Arrays.toString(testArray));
   }
   
   public static void reverseString(char[] s)
   {
      int start = 0;
      int end = s.length - 1;
      
      while(start < end)
      {
         char temp = s[start];
         
         s[start] = s[end];
         
         s[end] = temp;
                 
         start++;
         end--;
      }
   }
}