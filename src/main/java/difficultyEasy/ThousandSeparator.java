/*
   Thousand Separator
   
   Problem Source: https://leetcode.com/problems/thousand-separator/
   
   -----
   
   Algorithm:
   
   1. Convert the int to String first
   2. Create a String Builder for our result String
   3. Scan from the back of the String
   4. Keep a counter, if the count is 3, append '.' to the string builder
      reset the counter to 0
   5. At the end, reverse the string and return it.
   
   Time-Complexity: O(N), where N is the number of characters in the string (int)
   Space-Complexity: O(1)   

*/

class ThousandSeparator
{
   public static void main(String[] args)
   {
      System.out.println(thousandSeparator(123456789));
   }
   
   public static String thousandSeparator(int n)
   {
      String nString = String.valueOf(n);
      
      StringBuilder sb = new StringBuilder();
      
      int count = 0;
      
      for(int i = nString.length() - 1; i >= 0; i--)
      {
         if(count == 3)
         {
            sb.append('.');
            count = 0;
         }
         
         sb.append(nString.charAt(i));
         count++;
      }
      
      return sb.reverse().toString(); 
   }
}