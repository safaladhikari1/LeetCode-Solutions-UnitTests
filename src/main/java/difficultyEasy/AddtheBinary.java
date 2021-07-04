package difficultyEasy;/*
   
   Add Binary
   
   Given two binary strings, return their sum (also a binary string)
   
   The input strings are both non-empty and contains only characters 1 or 0.
   
   Example 1:
   Input: a = "11", b = "1"
   
   Example 2:
   Input: a = "1010", b = "1011"
   Output: "10101"
   
   ---
   
   Binary Addition:
   
   0 + 0 = 00
   0 + 1 = 01
   1 + 1 = 10 , 0 carry 1
   1 + 1 + 1 =  1, carry 1
   
   Algorithm:
   
   The idea is if we have two inputs
   a = "11"
   b = "1"
   
   We will use String Builder, so we don't keep have to adding Strings
   because Strings are immutable in Java:
      Each time we say a = "11", a += "10"
      Instead of appending to a original "11"
      It just makes a new string, because the original String cannot be changed.
      The original string will remain in the memory, and we don't want that.
      
  So we check the char of a and b from the back
  We will append to the String Builder,
  Reverse the Stringbuilder and return as String.
  
  1. i = starts at back of a
     j = starts at back of b
     
     will declare sum and carry as 0 for now.
  
  2. while(i >= 0 || j >= 0)
       
     we want to stop if i is 0 or j is 0, because we can't get a char of a and b, if they are negative
     
     sum = carry, so sum is 0
     
     if i >= 0
      sum+= a.charAt(i--) - '0';
      
      if char is 1, 1 - 0 = 1
      if char is 0, 0 - 1 = -1
     
     same logic for j
      sum+= b.charAt(i--) - '0';
     
     sb.append(sum % 2);
     
     if sum is 2, 2 % 2 = 0
     if sum is 1, 1 % 2 = 1
     if sum is 0, 0 % 2 = 0
     
     carry = sum / 2;
     
     if sum is 2, 2 / 2 = 1
     if sum is 1, 1 / 2 = 0
     if sum is 0 , 0 / 2 = 0
     
  3. After the while loop ends,
     sometimes carry is still has remaining
     
     for example: a = "11" , b = "1"
     
     if(carry != 0)
     {
      sp.append(carry);
     }
     
  4. return sb.reverse().toString();
  
  ----
  
  Time-Complexity: O(N), where N is the length of the longer String
  Space-Complexity: O(N), where N is the length of the string. The longer the string, the more ints we have store in the StringBuilder.    
       
*/

class AddtheBinary
{
   public static void main(String[] args)
   {
      String a = "11";
      String b = "1";
      
      System.out.println(addBinary(a, b));   
   }
   
   public static String addBinary(String a, String b)
   {
      StringBuilder sb = new StringBuilder();
      
      int i = a.length() - 1;
      int j = b.length() - 1;
      
      int carry = 0;
      int sum = 0;
      
      while(i >=0 || j >= 0)
      {
         sum = carry;
         
         if(i >= 0)
         {
            sum += a.charAt(i--) - '0';
         }
         
         if(j >= 0)
         {
            sum += b.charAt(j--) - '0';
         }
         
         sb.append(sum % 2);
         carry = sum/2;  
      }
      
      if(carry != 0)
      {
         sb.append(carry);
      }
      
      return sb.reverse().toString();        
   }      
}