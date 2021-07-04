/*
   Reverse Vowels of a String
   
   Write a function that takes a string as input and reverse only the vowels of a string.
   
   Example 1:
   Input: "hello"
   Output: "holle"
   
   Example 2:
   Input: "leetcode"
   Output: "leotcede"
   
   -----
   
   Algorithm:
   
   Two Pointers Approach, Start and End.
   
   1. Check first if the s is null or empty
         If it is, return the same string.
   2. Convert the string to char array
   3. make two pointer: start at 0, end at end of the string.
   4. Create mySet HashSet, add: a, e, i, o, u, A, E, I, O, U
      
      Remember Search using contains in HashSet is O(1), very efficient.
   5. while(start < end)
   
      For example: "hello"
      
      if mySet does not contain(sArray[start]): h
         start++;
         
         now start is pointing at e.
      
      Next loop
      
      if mySet does not contain(sArray[start]): e, which is false
      
      else if, mySet does not contain(sArray[end]): o, which is false
      
      else
         it swaps the e and o,
         increments start and decrement end.
         
   6. After the while loop is over, it returns the String value of char array.
   
   ------
   
   Time-Complexity: O(N), where N is the number of elements in the input string or the chary array of that string
   Space-Complexity: O(1), mySet HashSet is constant, and to search over the mySet using contains is O(1).         

*/

import java.util.Set;
import java.util.HashSet;

class ReverseVowelsString
{
   public static void main(String[] args)
   {
      String testArray = "hello";
      
      System.out.println(reverseVowels(testArray));
   }
   
   public static String reverseVowels(String s)
   {
      if(s == null || s.length() == 0)
      {
         return s;
      }
      
      char[] sArray = s.toCharArray();
      int start = 0;
      int end = s.length() - 1;
      
      Set<Character> mySet = new HashSet<>();
      mySet.add('a');
      mySet.add('e');
      mySet.add('i');
      mySet.add('o');
      mySet.add('u');
      mySet.add('A');
      mySet.add('E');
      mySet.add('I');
      mySet.add('O');
      mySet.add('U');
      
      while(start < end)
      {
         if(!mySet.contains(sArray[start]))
         {
            start++;
         }
         
         else if(!mySet.contains(sArray[end]))
         {
            end--;
         }
         
         else
         {
            char temp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = temp;
            
            start++;
            end--;
         }           
      }
       
      return String.valueOf(sArray);
      
   }
}