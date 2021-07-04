/*
   Minimum Time Visiting All Points
   
   On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
   
   Example 1:
   
   Input: points = [[1,1],[3,4],[-1,0]]
   Output: 7
   
   Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
   Time from [1,1] to [3,4] = 3 seconds 
   Time from [3,4] to [-1,0] = 4 seconds
   Total time = 7 seconds
   
   Problem Source: https://leetcode.com/problems/minimum-time-visiting-all-points/
   
   ----
   
   Algorithm:
   
   1. From stack overflow post: https://stackoverflow.com/questions/59077134/minimum-time-visiting-all-points-understanding
   2. If we plot the points out on the paper, and manually count the different ways to move between the points.
      
      The shortest distance is the longest of the X-axis or Y-axis side, because moving diagonally is counted as 1, i.e. the same as an X or Y movement.
      
   3. Therefore, on our input array we have points = [[1,1],[3,4],[-1,0]]
      
      It is a two dimensional arrays, So we can calculate the x-axis distance and y-axis distance between two points
      Then, get the maximum of those distances, and only add the max distance to our time, as we loop through those points in our array.
      
   4. Return the time.
   
   --------
   
   Time-Complexity: O(1)
   Space-Complexity: O(1)
   
   Constant time/space solution overall.   
         
*/

class MinimumTimeVisitingAllPoints
{
   public static void main(String[] args)
   {
      System.out.println(minTimeToVisitAllPoints(new int[][] {{1,1}, {3, 4}, {-1, 0}}));
   }
   
   public static int minTimeToVisitAllPoints(int[][] points)
   {
      int time = 0;
      
      for(int i=0; i < points.length - 1; i++)
      {
         int x1 = points[i][0];
         int y1 = points[i][1];
         int x2 = points[i+1][0];
         int y2 = points[i+1][1];
         
         time += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));         
      }
      
      return time;
   }
}