/*
   https://leetcode.com/problems/count-primes/submissions/
   
   ------
   
   Algorithm:
   
   Approach 1: Bruteforce Solution
   
   1. We are creating a isPrime method, that returns whether a number is a prime or not
      
      Prime number is a number that is only divisible by itself or 1.
      
      2, 3, 5, 7
      
      If we ask is 33 a prime number or not,
      
      33 is divisible by 11, so it is not a prime number
      
      But it also is divisible by 3
      
      So we don't have to go until 11 to find out if 33 is a prime number, because 3 will already find out whether it is a prime number or not

      It turns out if we loop until square root n, i.e. square root of 33 = 5.74

      When i = 3, it will catch whether 33 is a prime number or not.
      
   2. We look at every number,
   
      If it is less than 2, it's not a prime number
      
      If it is more than 2, check the number using the loop below

      i * i <= n is equivalent to i <= root of n

      for(int i=2; i * i <= n; i++)
      {
         if(n % i == 0)
         {
            return false;
         }
      }
      
      Since we are doing this for every number up to N, this algorithm is slow.
      
  ---------
  
  Approach 2: 
  
  Using https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
  
  Explanation: https://youtu.be/PypkiVlTRa4
  
  1. Create a boolean array of size N
  
  2. Let's say our N is 10
  
     F, F, F, F, F, F, F, F, F, F
     
     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     
     Create a for loop, start at 2
     
      Create a inner for loop that checks the multiple of 2(i) * j up to < N
      
      For example:
      
      2 x 2 = 4
      2 x 3 = 6
      2 x 4 = 8 (stops here)
      2 x 5 = 10
      
      Same with 3
      
      3 x 2 = 6
      3 x 3 = 9 (stops here)
      
  3. In the same loop, we are also checking how many false are there from 2
  
     F, F, F, T, F, T, F, T, T, F
     
     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     
     From 2 to 10(exclusive)
     
     we have 4 false
     
     2, 3, 5, 7
     
     returns 4
     
     
     ----
     
     Time-Complexity: https://leetcode.com/problems/count-primes/discuss/473021/Time-Complexity-O(log(log(n)
     
*/


class CountPrimes
{
   public static void main(String[] args)
   {
      //System.out.println(isPrime(4));
      
      System.out.println(countPrimes(10));
      
   }
   
   public static int countPrimes(int n)
   {     
      boolean[] isNotPrime = new boolean[n];
      
      int primeCount = 0;
      
      for(int i=2; i < n; i++)
      {
         if(isNotPrime[i] == false)
         {
            primeCount++;
            for(int j = 2; j * i < n; j++)
            {
               isNotPrime[j * i] = true;
            }
         }
      }
      
      /*
      for(int i=2; i < isNotPrime.length; i++)
      {
         if(isNotPrime[i] == true)
         {
            primeCount++;
         }
      }
      */
      
      return primeCount;
   }
   
   // Bruteforce Solution
   /*
   public static int countPrimes(int n)
   {
      int count = 0;
      
      for(int i=2; i < n; i++)
      {
         if(isPrime(i))
         {
            count++;
         }
      }
      
      return count;
   }
   
   public static boolean isPrime(int n)
   {
      if(n <= 1)
      {
         return false;
      }
      
      for(int i=2; i * i <= n; i++)
      {
         if(n % i == 0)
         {
            return false;
         }
      }
      
      return true;     
   }
   */
}