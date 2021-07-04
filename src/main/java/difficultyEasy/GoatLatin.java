/*
   Goat Latin
   
   Problem Source: https://leetcode.com/problems/goat-latin/
   
   ------------
   Algorithm:
   
   1. So according to the problem description,
   
      If our 
      
      Input: "I speak Goat Latin"
      
      Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
      
   2. We first create a HashSet to store the vowel Characters both lower case and upper case: 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
   
      We create a StringBuilder sb, to make our result
      We create a StringBuilder a, which has "a", which we used to append later
      
      We create a String words array, by using s.split(" ")
      
      Then we check each word in that words array
         
         If the first letter of the word is not a vowel character
            Then we append the word, string from the second letter to sb
            Then append the first letter to our sb
         Else
            We append the word to sb.
            
         After that, we append "ma" to sb
         sb.append(a)
         a.append("a"), this increments a on each iteration on for loop.
         
         Then append extra space " " to sb.
                     
   3. We will have extra space on our sb. So delete just the last space on our sb.
   
   4. Then return the sb as String.
   
   ------  
   Time-Complexity: O(N^2)
   Space-Complexity: O(N^2)
   
   Refer here for explanation: https://leetcode.com/problems/goat-latin/solution/  

*/


import java.util.HashSet;
import java.util.Arrays;

class GoatLatin
{
   public static void main(String[] args)
   {
      System.out.println(toGoatLatin("I speak Goat Latin"));
   }
   
   public static String toGoatLatin(String s)
   {
      HashSet<Character> mySet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
      
      StringBuilder sb = new StringBuilder();
      StringBuilder a = new StringBuilder("a");
      
      String[] sArray = s.split(" ");
      
      for(String word : sArray)
      {
         if(!mySet.contains(word.charAt(0)))
         {
            sb.append(word.substring(1));
            sb.append(word.charAt(0));
         }
         else
         {
            sb.append(word);         
         }
         
         sb.append("ma");
         sb.append(a);
         a.append("a");
         
         sb.append(" ");
      }
      
      sb.deleteCharAt(sb.length() - 1);
      
      return sb.toString();
   }
}