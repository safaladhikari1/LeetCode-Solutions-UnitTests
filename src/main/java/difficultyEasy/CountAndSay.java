/*
   Count and Say
   
   Problem Source: https://leetcode.com/problems/count-and-say/
   
   In simpler sentence, the description of the problem says:
   
   Given the first string is "1", the second string is "11", the third string is "21", What is the nth string?
   
   Example:
   
   The following is the sequence from n 1 to 6.
   
   1.    1
   2.    11 (Since there is only one 1, we said 11)
   3.    21 (There are two 1s, we said 21, count first, then number)
   4.    1211 (There is one 2, and one 1, so we said 1211)
   5.    111221 (Similarly one 1, one 2, two 1, so we said 111221)
   6.    312211
   
   ----------
   
   Algorithm:
   
   1. We will translate the above findings into code.
   2. 
      For example:
      
      When n = 1:
      
      At first our resultString is "1"
      
      This is, when n = 1
      
      our for loop (i = 1; i < n; i++)
         since n is 1, it doesn't go into this loop
         
      So our result is "1".
      
   3. When n = 2:
   
      resultString = "1"
      
      for(i=1; i < 2; i++)
         We will pass the resultString to our helper method.
         
      On helper method
         
         initial count = 1
         initialChar = s.charAt(0) = 1
         We have a stringbuilder, so we can append our result strings to it.
         
         Another for loop
         for(i = 1; i < string.length(on this case, 1); i++)
            it won't go to this loop, because our string is too small, only length 1
            
         StringBuilder will append count and initialChar
         So, sb.append(1).append(1)
         
      It returns "11"
      
   4. So we basically keep doing that, for every number, and passing to resultString
      For every n, we will have a resultString, and we will assign the resultString back to resultString
      and pass it to the helper method again.
      
      On this problem's constraint: our n is not very large, 1 <= n <= 30
      
      So to generate the nth term, we are just counting and saying the (n-1)th term.
      Which means, the produce the result for nth term, we are performing the calculation on (n-1)th term.
      
  ----------
  
  What is the time/space complexity?  
  
  Is the time-complexity O(N^2), where N is the input number, because of the two for loops.
  Space-Complexity: ?
          
   
*/


class CountAndSay
{
   public static void main(String[] args)
   {
      System.out.println(countAndSay(5));
   }
   
   public static String countAndSay(int n)
   {
      String resultString = "1";
      
      for(int i=1; i < n; i++)
      {
         resultString = helper(resultString);
      }
      
      return resultString;
   }
   
   public static String helper(String s)
   {
      int count = 1;
      char initialChar = s.charAt(0);
      StringBuilder sb = new StringBuilder();
      
      for(int i = 1; i < s.length(); i++)
      {
         if(s.charAt(i) != initialChar)
         {
            sb.append(count).append(initialChar);
            initialChar = s.charAt(i);
            count = 1;   
         }
         else
         {
            count++;
         }
      }
      
      sb.append(count).append(initialChar);
      
      return sb.toString();      
   }  
}