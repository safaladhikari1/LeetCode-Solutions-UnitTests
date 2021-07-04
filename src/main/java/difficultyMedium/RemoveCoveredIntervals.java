/*
   Remove Covered Intervals
   
   Problem Source: https://leetcode.com/problems/remove-covered-intervals/
   
   ----
   
   Algorithm:
   
   1. Let's say our 2D array:
   
      [
         [1, 4],
         [3, 6],
         [2, 8]
      ]
      
   2. Based on the logic on the question:
        
      [a, b] is covered by [c, d]
      
      When c <= a && b <= d 
      
      Therefore, we are checking every other elements by assigning the values of our 2D arrays
      in [a, b] and [c, d]
      
         Once we find the if the interval is covered by the above logic, we decrement intervals.length
         
         At the end return the intervals.length, which is the number of remaining intervals.
         
  3. So our our double for loop
  
      for(int i=0; i < intervals.length; i++)
      {
         a = intervals[i][0];
         b = intervals[i][1];
         
         for(int j=0; j < intervals.length; j++)
         {             
            c = intervals[j][0];
            d = intervals[j][1];
               
            if(i != j && c <= a && b <= d)
            {
               result--;
               break;
            }         
         }
      }
      
      First assigns both a,b,c,d to the first array
      
      Then a,b will remain as 1,4 as first array
      
      Then it will check against 3,6 and 2,8
      
      Then a,b will be 3,6 (a, b)
      
      Then it will check against 1,4 and 3,6 and 2,8 (c, d)
         At this point, it satifies the condition if(i != j && c <= a && b <= d)
         decrements the intervals.length
          
      Then a,b will be 2,8 (a, b) and so on.
      
  -----
  
  Time-Complexity: O(N * M), where N is the length of outer intervals array, M is the length of inner intervals array 
  Space-Complexity: O(1)
               
*/


class RemoveCoveredIntervals
{
   public static void main(String[] args)
   {
      System.out.println(removeCoveredIntervals(new int[][] { {1,4}, {3,6}, {2,8}}));
      
      System.out.println(removeCoveredIntervals(new int[][] { {1,4}, {2, 3} }));
   }
   
   public static int removeCoveredIntervals(int[][] intervals)
   {
      int result = intervals.length;
      int a=0, b=0, c=0, d=0;
      
      for(int i=0; i < intervals.length; i++)
      {
         a = intervals[i][0];
         b = intervals[i][1];
         
         for(int j=0; j < intervals.length; j++)
         {             
            c = intervals[j][0];
            d = intervals[j][1];
               
            if(i != j && c <= a && b <= d)
            {
               result--;
               break;
            }         
         }

      }
      
      return result;
   }   
}