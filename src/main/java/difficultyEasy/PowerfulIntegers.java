/*
   Powerful Integers
   
   Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
   
   Return a list of all powerful integers that have value less than or equal to bound.
   
   You may return the answer in any order.  In your answer, each value should occur at most once.
   
   Example 1:
   
   Input: x = 2, y = 3, bound = 10
   Output: [2,3,4,5,7,9,10]
   
   Explanation: 
   2 = 2^0 + 3^0
   3 = 2^1 + 3^0
   4 = 2^0 + 3^1
   5 = 2^1 + 3^1
   7 = 2^2 + 3^1
   9 = 2^3 + 3^0
   10 = 2^0 + 3^2  
   
   ----------------
   
   Algorithm:
   
   1. So we have:
   
      x^i + y^j <= bound
      
      There will be many sum for x^i + y^j
      We will have to add those sum to our ArrayList.
      Return the ArrayList.
      
   2. One assumption is, 
      
      if x^i is already greater than bound, then we don't need to check for y^j
      
      But how far does i or j can increment?
      
      Per the question, 0 <= bound <= 10^6
      
      So, if we say one of the x^i or y^j is 1, Then
      
      x^i + 1 (anything power to 0 is 1, the lowest i or j) <= bound
      x^i + 1 <= 1000,000 (1 million)
      
      So, we can't check for the lowest x, which is 1, because 1^1 ,will be 1. So we can check for, when x = 2
      
      2^i + 1 <= 1000,000
      
      2^20 is 1048, 576 this is high
      2^19 is 524288
      
      2^19 + 1 is 524,289 which is <= 1000,000
      
      So we only have to check by incrementing i or j up to 19
      
      Therefore:
      
      for(int i=0; i < 20 && Math.pow(x, i) < bound; i++)
      {
         for(int j=0; j < 20 && Math.pow(y, j) < bound; j++)
         {
         
   3. Then inside the inner for loop, we get the sum of 
      (int) (Math.pow(x, i) + Math.pow(y, j)) as int
      If it is less than or equal to bound
      
      add it to out HashSet.
      
   4. At the end, the constructor of our ArrayList allows any Collection data type to be passed in,
      and return as ArrayList.
      
      https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
      
      Since HashSet is a collection, we can easily convert that to ArrayList and return it.
            
   -----------              
   
   Time Complexity: O(log^2 bound)
   Space Complexity: O(log^2 bound)  
       
*/

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class PowerfulIntegers
{
   public static void main(String[] args)
   {
      System.out.println(powerfulIntegers(2, 3, 100));
   }
   
   public static List<Integer> powerfulIntegers(int x, int y, int bound)
   {
      Set<Integer> seenSet = new HashSet<>();
      
      for(int i=0; i < 20 && Math.pow(x, i) < bound; i++)
      {
         for(int j=0; j < 20 && Math.pow(y, j) < bound; j++)
         {
            int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
            
            if(sum <= bound)
            {
               seenSet.add(sum);
            }
         }
      }
      
      return new ArrayList<>(seenSet);
   }
}