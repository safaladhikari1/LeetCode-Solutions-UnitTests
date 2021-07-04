/*
   Subtract the Product and Sum of Digits of an Integer
   
   Problem Source: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
   
   Approach 1, Using Math
   
   1. Using modulus operator % to compute the last digit. 
      int lastDigit = n % 10;
      
   2. Store the product, Store the Sum, and keep on getting the remaining last digit using while loop
      
      n /= 10;
      
      we are dividing the number by 10 until it's 0
      
   3. Return product - sum
   
   Time-Complexity: O(log N), the N is the size of the digit, Log is base 10.
   
   Explanation: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/discuss/446372/JavaC++Python-Straight-Forward-Solution/875186      
   
   Space-Complexity: O(1)
   
   ------
   
   Approach 2, Converting Int to String
   
   1. Convert int to string
      
      loop through every char in the string
      convert every char to int value
      store the product and sum
      
   2. Return product - sum
   
   Time-Complexity: O(N), where N is the number of digits in N
   Space-Complexity: O(1)
      
*/

class SubtractProductSumDigitsInteger
{
   public static void main(String[] args)
   {
      System.out.println(subtractProductAndSum(4421));   
   }
   
   // Approach 1
   public static int subtractProductAndSum(int n)
   {
      int product = 1;
      int sum = 0;
      
      while(n > 0)
      {
         int lastDigit = n % 10;
         
         product *= lastDigit;
         sum += lastDigit;
         
         n /= 10;
      }
      
      return product - sum;     
   }
   
   // Approach 2
   /*
   public static int subtractProductAndSum(int n)
   {
      int product = 1;
      int sum = 0;
      
      String nString = String.valueOf(n);
      
      for(int i=0; i < nString.length(); i++)
      {
         int value = Character.getNumericValue(nString.charAt(i));
         product *= value;
         sum += value;         
      }
      
      return product - sum;
   }
   */
  
}