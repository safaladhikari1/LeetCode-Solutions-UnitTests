/*
   Add Digits
   
   Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
   
   Input: 199
   Output: 1
   
   Because: 199 -> 1+ 9 + 9 -> 19
            19 -> 1 + 9 -> 10
            10 -> 1 + 0 -> 1
            
            Answer is 1
            
  ----------  
  
  Algorithm, https://youtu.be/ZG88Ghhltgg
  
  1. With above, we tried to do it by hand.
  
     But we translate that to code:
     
     we want to create some sort of loop, where it stops if num > 9, because anything greater than 9 is 2 digits.
     
     Inside the while(num > 9)
      
         newNum = 0
         
         while(num > 0)
            we get the onesPlace of the number = num % 10
            we add it to the newNum, newNum += onesPlace
            we take off the onesPlace number, num /= 10
            
         At the end of the loop, num = newNum
         
     If you do the above by hand, on first iteration of the ending of while(num > 0), we get num = 19
     Then repeat again, until we get num = 1
     At that point, loop stops, and we retrn num
  
  ------
     
  Interesting Mathematical Approach on the above problem: https://leetcode.com/problems/add-digits/solution/
     
  --------
  
  Time-Complexity: O(1)
  Space-Complexity: O(1)

*/


class AddDigits
{
   public static void main(String[] args)
   {
      System.out.println(addDigits(199));
   }
   
   // Iterative Solution1
   public static int addDigits(int num)
   {
      while(num > 9)
      {
         int newNum = 0;
         
         while(num > 0)
         {
            int onesPlace = num % 10;
            newNum += onesPlace;
            num /= 10;
         }
         
         num = newNum;
      }
      
      return num;
   }
   
   // Iterative Solution 2
   /*
   public static int addDigits(int num)
   {
      int newNum = 0;
      
      while(num > 0)
      {
         newNum += num % 10;
         num /= 10;
         
         if(num == 0 && newNum > 9)
         {
            num = newNum;
            newNum = 0;
         }                
      }
       
      return newNum;
   }
   */
   
   //Recursive Solution
   /*
   public static int addDigits(int num)
   {
      if(num <= 9)
      {
         return num;
      }
      
      int newNum = 0;         
         
      while(num > 0)
      {
         int onesPlace = num % 10;
         newNum += onesPlace;
         num /= 10;
      }
          
      return addDigits(newNum);        
   }
   */ 
}