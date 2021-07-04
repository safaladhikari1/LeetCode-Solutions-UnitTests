/*
   Problem Source: https://leetcode.com/problems/guess-number-higher-or-lower/
      
   We are playing the Guess Game. The game is as follows:

   I pick a number from 1 to n. You have to guess which number I picked.

   Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
   
   You call a pre-defined API int guess(int num), which returns 3 possible results:
   
   -1: The number I picked is lower than your guess (i.e. pick < num).
   1: The number I picked is higher than your guess (i.e. pick > num).
   0: The number I picked is equal to your guess (i.e. pick == num).
   
   Return the number that I picked.  
   
   Example:
   
   Input: n = 10, pick = 6
   Output: 6
   
   -------------------
   
   Algorithm:
   
   1. We have a pre-defined API, with int guess(int num) method, which returns:
      
         -1, if the number picked is lower than the guess number
         1, if the number picked is higher than the guess number
         0, if the number picked is equal to the guess number.
   
   2. For example, if we pass in 'n' as 10
      
      Guess number is between:
      
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10
      
      Let's say the guess number was 6
      
      Since the elements are sorted, we can use binary search to predict the guess number.
      
  3. while(left <= right)
     We do less than equals, because if there is one element, 1 and the guess is 1, we want the operation be done inside the while loop
     
     We get the mid, which 1 + (10 - 1) / 2 = 5
     
     Since the guess is 6, guess(mid) will return 1 because:
     
     -1 : guess number is lower
      1 : guess number is higher
      0 : Congrats! You got it!
      
      guess number is higher, which is 6.
      
     That's why move our left to mid + 1  
        
      else if(guess(mid) == 1)
      {
         left = mid + 1;
      }
         
     so we can completely eliminate the left half (anything less than or equal to 5)
     since the guess is on the right side.
     
     Simlarly, if the guess was 3, then we had to eliminate the right side using the following code:
     
      if(guess(mid) == -1)
      {
         right = mid - 1;
      }
      
     Otherwise, guess(mid) returns 0, so our mid is the guess number.
     We return mid.     
  
   --------------- 
   
   Time complexity: O(log N), binary search
   Space complexity: O(1)  
                
*/

/*
class GuessNumberHigherorLower
{
   public int guessNumber(int n)
   {
      int left = 1;
      int right = n;
      
      while(left <= right)
      {
         int mid = left + (right - left)/2;
         
         if(guess(mid) == -1)
         {
            right = mid - 1;
         }
         else if(guess(mid) == 1)
         {
            left = mid + 1;
         }
         else
         {
            return mid;            
         }         
      }
      
      return -1;
   }  
}
 */