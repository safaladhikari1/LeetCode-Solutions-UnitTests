/*
   Roman to Integer
   
   Roman numerals are represented by seven different symbols
   
   Symbol Value
   I        1
   V        5
   X        10
   L        50
   C        100
   D        500
   M        1000
   
   Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range
   from 1 to 3999.
   
   Example 1:
   Input: "III"
   Output: 3
   
   Example 2:
   Input: "IV"
   Output: 4
   
   Example 3:
   Input: "IX"
   Output: 9
   
   Example 4:
   Input: "LVIII"
   Output: 58
   
   ----
   
   Time Complexity: O(N), where N is the number of elements in char[] sArray.

*/

class RomanToInteger
{
   public static void main(String[] args)
   {
      System.out.println(romanToInt("III"));
   }
   
   public static int romanToInt(String s)
   {
      char[] sArray = s.toCharArray();
      
      int result = 0;
      
      for(int i=0; i<sArray.length; i++)
      {
         if(sArray[i] == 'I')
         {
            // If 'I' comes before V or X, subtract 1, example: IV = 4, IX = 9
            if(i + 1 < sArray.length)
            {
               if(sArray[i+1] == 'V' || sArray[i+1] == 'X')
               {
                  result -= 1;
               }
               
               else
               {
                  result += 1;
               } 
            }
            
            else
            {
               result += 1;
            }          
         }
         
         else if(sArray[i] == 'V')
         {
            result += 5;
         }
         
         else if(sArray[i] == 'X')
         {
            // If 'X' comes before L or C, subtract 10, example: XL = 40, XC = 90
            if(i + 1 < sArray.length)
            {
               if(sArray[i+1] == 'L' || sArray[i+1] == 'C')
               {
                  result -= 10;
               }
               
               else
               {
                  result += 10;
               }
            }
            
            else
            {
               result += 10;
            }             
         }
         
         else if(sArray[i] == 'L')
         {
            result += 50;
         }
         
         else if(sArray[i] == 'C')
         {
            // If 'C' comes before D or M, subtract 100, example: CD = 400, CM = 900
            if(i + 1 < sArray.length)
            {
               if(sArray[i+1] == 'D' || sArray[i+1] == 'M')
               {
                  result -= 100;
               }
               
               else
               {
                  result += 100;
               }
            }
            
            else
            {
               result += 100;
            }
         }
         
         else if(sArray[i] == 'D')
         {
            result += 500;
         }
         
         else if(sArray[i] == 'M')
         {
            result += 1000;
         }        
      }
      
      return result;     
   }
}