/*
   My Calendar I Problem: https://leetcode.com/problems/my-calendar-i/
   
   ----
   Algorithm:
   
   1. Let's say we have two events with start and end
      
      Event 1: (10, 20)
               (s1, e1)
      
      Event 2: (20, 30)
               (s2, e2)
               
      Event 1 and Event 2 will not conflict if and only if one of them starts after the other one ends.
      
      i.e.
      
      e1 <= s2  (20 <= 20)
      e2 <= s1  (30 <= 10)
      
      This means the opposite logic of the above conditions, means the events conflict
      
      i.e
      
      e1 > s2
      e2 > s1
      
      Source: https://leetcode.com/problems/my-calendar-i/solution/
      
      
   2. Therefore for our Algorithm:
   
      We store our events in int[] array of size 2, start and end
      
      List<int[]> eventList;
      
      public MyCalendar()
      {
         this.eventList = new ArrayList<>();
      }
      
      Constructor will instantiate the arraylist
      
   3. public boolean book(int start, int end)
      {
         for(int[] event : eventList)
         {
            if(event[1] > start && end > event[0])
            {
               return false;
            }             
         }
         
         eventList.add(new int[] {start, end});
         
         return true;  
      }  
      
      Inside the for loop, it's using our same logic from 1.
      
      e1 > s2
      e2 > s1
      
      returns false
      
      We are checking for every int[] event array inside the ArrayList
      
   4. If it passes that condition for all the int[] event array, then we return true at the end.
   
   ----
   
   Time-Complexity: book() method, since we are comparing the start, end for every int[] cal array
                    inside of our ArrayList
                    
                    O(N^2), where N is the number of events booked.
                    For each new event, we check all the previous events to decide whether the new event can be booked.
                    
   Space-Complexity: O(N), the size of the eventList arraylist.                 
   
*/

/*
class MyCalendarI
{
   public static void main(String[] args)
   {
      // non static class MyCalendar cannot be called on main method.
      
      // We can't make MyCalendar static because we will have to instantiate objects out of it like:  
      // MyCalendar obj = new Calendar();
      // obj.book(10, 20) // returns true
      // obj.book(15, 25) // returns false
      
      // We cannot create object out of static class.   
   }
   
   public class MyCalendar
   {
      List<int[]> eventList;
      
      public MyCalendar()
      {
         this.eventList = new ArrayList<>();
      }
      
      public boolean book(int start, int end)
      {
         for(int[] event : eventList)
         {
            if(event[1] > start && end > event[0])
            {
               return false;
            }             
         }
         
         eventList.add(new int[] {start, end});
         
         return true;  
      }       
   }
}

 */