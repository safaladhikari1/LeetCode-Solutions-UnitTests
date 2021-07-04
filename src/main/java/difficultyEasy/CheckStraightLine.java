/*
   Check If It is a Straight Line
   
   Problem Source: https://leetcode.com/problems/check-if-it-is-a-straight-line/
   
   Algorithm:
   
   1. In order for all the points to be in a straight line, the slope between any of those two points has to be equal
   
   2. So, We get the (x,y) points for the first point and second point
      
      int[] firstPoint = coordinates[0];
      int[] secondPoint = coordinates[1];
       
      int x1 = firstPoint[0];
      int y1 = firstPoint[1];
      
      int x2 = secondPoint[0];
      int y2 = secondPoint[1]; 
      
   3. In a for loop, we can get the nextPoint's x and y
   
      int[] nextPoint = coordinates[i];
      
      int nextPointX = nextPoint[0];
      int nextPointY = nextPoint[1]; 
      
   4. This means the slope:
      
      Slope of first two points = Slope of the next two points in the for loop
      (y2 - y1)/(x2 - x1) = (nextPointY - y2)/(nextPointX - x2)
      
      There is a change, we have divide a point by 0, So we do cross product
      
      if ( (y2 - y1) * (nextPointX - x2) != (nextPointY - y2) * (x2 - x1) )
         return false
         
   5. Otherwise return true
   
   ------
   
   Time-Complexity: O(N), where N is the number of points in the coordinates array
   Space-Complexity: O(1)      
      
*/



class CheckStraightLine
{
   public static void main(String[] args)
   {
      System.out.println(checkStraightLine(new int[][] {{1, 2}, {2, 3}, {3 ,4}, {4, 5}, {5, 6}, {6, 7}}));
      
      System.out.println(checkStraightLine(new int[][] {{1, 1}, {2, 2}, {3 ,4}, {4, 5}, {5, 6}, {7, 7}}));
   }
   
   public static boolean checkStraightLine(int[][] coordinates)
   {
      int[] firstPoint = coordinates[0];
      int[] secondPoint = coordinates[1];
       
      int x1 = firstPoint[0];
      int y1 = firstPoint[1];
      
      int x2 = secondPoint[0];
      int y2 = secondPoint[1];
      
      for(int i = 2; i < coordinates.length; i++)
      {
         int[] nextPoint = coordinates[i];
         
         int nextPointX = nextPoint[0];
         int nextPointY = nextPoint[1];
             
         if((y2 - y1) * (nextPointX - x2) != (nextPointY - y2) * (x2 - x1))
         {
             return false;
         }

      }
      
      return true;     
   }
    
   /*
   public static boolean checkStraightLine(int[][] coordinates)
   {
      int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

      int slope1 = (coordinates[x1 + 1][y1 + 1] - coordinates[x1][y1 + 1]) / 
                  (coordinates[x1 + 1][y1] - coordinates[x1][y1]);
                  
      int slope2 = 0;            
                  
      for(int i = 0; i < coordinates.length; i++)
      {
         for(int j = 0; j < coordinates[i].length; j++)
         {
            slope2 = (
            
            (coordinates[i + 1][j + 1] - coordinates[i][j + 1]) / 
                  (coordinates[i + 1][j] - coordinates[i][j])
            
            );
            
            if(slope1 != slope2)
            {
               return false;
            }
         }
      }
      
      return true;            

   }
   */
} 