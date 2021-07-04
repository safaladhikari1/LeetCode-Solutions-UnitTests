/*
      Day of the Week
      
      Given a date, return the corresponding day of the week for that date.

      The input is given as three integers representing the day, month and year respectively.

      Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
      
      Example 1:
      
      Input: day = 31, month = 8, year = 2019
      Output: "Saturday"
      
      Constraints: The given dates are valid dates between the years 1971 and 2100.
      
      ---------
      
      Calculation of Leap Year:     
      
      How to determine whether a year is a leap year:
      https://docs.microsoft.com/en-us/office/troubleshoot/excel/determine-a-leap-year
      
      Why Do We Have Leap Year?
      https://www.dictionary.com/e/leap-year/  
      
      -----------
      
      Algorithm:
      
      1. We know that 01/01/1971 is a Friday. We also know how many days are in each month, for 12 months. For Leap years, we can add 1 to the month of February.         
         We use the above two fact, to calculate the number of days that is passed, against our input date and return the day of the week.
         
      2. We create an array of daysOfMonths
         create an array of nameOfDays. We start on Friday, because 01/01/1971 is Friday, so we want to keep this order.
         
      3. Instantiate the count to 0
         
         We will first add the number of days that have passed for the years.
         
         for loop from 1971 to the input year
            if it is a leap year, add 366
            otherwise add 365 to the count.
            
      4. Now we will add the number of days that have passed for the months in the last year.
       
         Check if it is a leap year
            add 1 day to February
         
         for loop from 0 (January) to that input month - 1 (because let's say the month is March, we add january 0, Feb 1, but don't add the whole month of march) We will add days after this.
            add the days to the count.
            
      5. Now we will the add the input days. But we subtract 1. Because:
      
         1971/01/01 is Friday. 1971/01/02 is Saturday. So if we input our day as 2.
         We are not going to add 2 to our days, because 1971/01/02 is only 1 day after 1971/01/01
         So we subtract by 1.
         
      6. Now, we just check the day, by doing nameOfDays[count % 7]; this will tell us what bucket of day, it falls under and gives us the correct day.
      
      ---------
      
      Time-Complexity: O(1), although most of our loop is the year loop, we know the range of year is fixed size (1971 - 2100). Therefore O(1)
      Space-Complexity: O(1), no extra memory consumed in the solution.                         
*/


class DayOfTheWeek
{
   public static void main(String[] args)
   {
      System.out.println(dayOfTheWeek(8, 9, 1995));
   }
   
   public static String dayOfTheWeek(int day, int month, int year)
   {
      int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
      // 1971/01/01 was Friday
      String[] nameOfDays = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
      
      int days = 0;
      
      for(int i=1971; i < year; i++)
      {
         if(isLeapYear(i))
         {
            days += 366;
         }
         else
         {
            days += 365;
         }
      }
      
      if(isLeapYear(year))
      {
         daysOfMonths[1]++;
      }
      
      for(int i=0; i < month - 1; i++)
      {
         days += daysOfMonths[i];
      }
      
      days += day - 1; // 1971/01/01 is Friday. 1971/01/02 is Saturday. So if we input our day as 2.
                       // We are not going to add 2 to our days, because 1971/01/02 is only 1 day after 1971/01/01
                       // So we subtract by 1.
      
      return nameOfDays[days % 7];
   }
   
   public static boolean isLeapYear(int year)
   {
      boolean result = false;
      
      // If the year is divisible by 4
      if(year % 4 == 0)
      {
         // Check if it is a century year (divisible by 100)
         if(year % 100 == 0)
         {
            // Now check if it is divisible by 400
            if(year % 400 == 0)
            {
               result = true;
            }
            else
            {
               result = false;
            }
         }
         
         // It is a not a century year, but divisible by 4
         else
         {
            result = true;
         }        
      }
      
      return result;      
   }  
}