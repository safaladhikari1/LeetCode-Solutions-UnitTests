/*
   First Bad Version:
   
   You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
   
   Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
   
   You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
   
   Example 1:

   Input: n = 5, bad = 4
   Output: 4
   Explanation:
   call isBadVersion(3) -> false
   call isBadVersion(5) -> true
   call isBadVersion(4) -> true
   Then 4 is the first bad version.
   
   --------
   
   Approach 1: Binary Search
   
   Algorithm:
   
   1. Use the algorithm from the Binary Search, dividing the elements into half, then left half, right half and so on..
   
   2. Eventually, left and right meets and it must be the first bad version.
   
      The algorithm is explained in: https://youtu.be/P1j1eKrBx4E
                                     https://leetcode.com/problems/first-bad-version/solution/
   3. So basically if we have
   
      firstBadVersion(7), bad version is 5.
      
      1, 2, 3, 4, 5, 6, 7
      
      On the first loop, it has left = 1, right = 7. It gets the mid as 4
      
      Since 4 is left of 5, isBadVersion(5) returns false.
      
      On the second loop, it has left = 5, right = 7. It gets the mid as 6
      
      Since 6 is right of 5,isBadVersion(6) returns true.
      
      On the third loop, it has left = 5, right = 6. It gets the mid as 5.
      
      Since isBadVersion(5) returns true. Right is 5.
      
      At that point, left = 5, right = 5, loop stops.
      
      We know that left is the firstBadVersion.
      
   
   Time-Complexity: O(log n). The search space is halved each time, so the complexity is O(log n).
   
   Space-Complexity: O(1)
   
   -------
   
   Approach 2: Linear Scan, loop every elements from the start.
   
   Algorithm:
   
   1. loop through all the elements from 1 to N. If isBadVersion(i) is true, return the i, which is our first bad version.
   
   Time-Complexity: O(N), It takes at most N-1 checks, so overall time-complexity is O(N)
   Space-Complexity: O(1)
   
*/



class FirstBadVersion
{
   
   // Optimized Solution
   /*
   public static int firstBadVersion(int n)
   {
      int left = 1;
      int right = n;
      
      while(left < right)
      {
         int mid = left + (right - left) / 2;
         
         if(!isBadVersion(mid))
         {
            left = mid + 1;
         }
         else
         {
            right = mid;
         }
      }
      
      return left;
      
   }
   */
   
   // Bruteforce Solution
   /*
   public int firstBadVersion(int n)
   {
      for(int i=1; i < n; i++)
      {
         if(isBadVersion(i))
         {
            return i;
         }
      }
      
      return n;
   }
   */
}