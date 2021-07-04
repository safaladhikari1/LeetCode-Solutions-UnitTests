/*
   Defanging an IP Address
   
   Given a valid (IPv4) IP address, return a defanged version of that IP address.
   
   A defanged IP address replaces every period "." with "[.]".
   
   Example:
   
   Input: address = "1.1.1.1"
   Output: "1[.]1[.]1[.]1"
   
   Problem Source: https://leetcode.com/problems/defanging-an-ip-address/
   
   --------
   
   Algorithm:
   
   1. Create two String Builders, sb and result
      
      sb has "[.]"
      
      result is a empty string builder
      
   2. Then loop through the characters in the string
      
      If it does not sees '.', append the character to result
      Otherwise, append sb
      
   3. The reason we use sb, because String in Java is immutable, and we don't want to make multiple copies of the string while doing string concatination
   
   4. Return the String version of the result.
   
   Time-Complexity: O(N), where N is the number of the characters in the array
   Space-Complexity: O(1)       

*/

class DefangingIPAddress
{
   public static void main(String[] args)
   {
      System.out.println(defangIPaddr("1.1.1.1"));
   }
   
   public static String defangIPaddr(String address)
   {
      StringBuilder sb = new StringBuilder("[.]");
      
      StringBuilder result = new StringBuilder();
            
      for(int i=0; i < address.length(); i++)
      {
         if(address.charAt(i) != '.')
         {
            result.append(address.charAt(i));
         }
         else
         {
            result.append(sb);
         }
      }
      
      return result.toString();
            
   }
}