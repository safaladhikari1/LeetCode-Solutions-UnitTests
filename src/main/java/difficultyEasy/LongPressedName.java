/*
   Long Pressed Name
   
   Problem Source: https://leetcode.com/problems/long-pressed-name/
   
   -----
   
   Algorithm:
   
   Based on the solution mentioned on https://leetcode.com/problems/long-pressed-name/discuss/238723/Java-2-pointers-natural-general-easiest-to-understand-code
   
   1. We have two pointers
      
      i is the pointer for name
      j is the pointer for typed
      
      On outer while loop
         both pointers are pointing at unique letter at the same time
      
      On inner loop, we are counting the number of same letters in both name and typed
      
      Typed should always have more than or equal same letters count than name because of long pressed, user will type more, character appears more
      
      At any point, if the letter count in name is higher
         return false   
         
   2. For example:
      
      name = "alex"
      typed = "aaleex"
      
      We will keep track of how many 'a' are in name
      We will keep track of how many 'a' are in typed
      
      typed has 2 'a', name has 1 'a'
      
      We will move on, and check l, e and x.
      
   3. Also at the end, we need to check if our i and j equals to name string length and typed string length.
         If it's not then, it's not possible that user got long pressed.
         
         For example on this edge case:
         
            
         name = "alex", 
         typed = "aaleexa"
         
         There is extra 'a' at the end of typed.
         
   --------
   
   Time-Complexity: O(N + T), where N is the length of name array, T is the length of typed array
   Space-Commplexity: O(1)      
*/

class LongPressedName
{
   public static void main(String[] args)
   {
      //System.out.println(isLongPressedName("alex", "aaleex"));
      
      //System.out.println(isLongPressedName("saeed", "ssaaedd"));
      
      //System.out.println(isLongPressedName("rick", "kric"));
      
      //System.out.println(isLongPressedName("laiden", "laiden"));
      
      //System.out.println(isLongPressedName("leelee", "lleeelee"));
      
      System.out.println(isLongPressedName("alex", "aaleexa"));
   }
   
   public static boolean isLongPressedName(String name, String typed)
   {
      int i = 0;
      int j = 0;
      
      int nSize = name.length();
      int tSize = typed.length();
      
      while(i < nSize && j < tSize)
      {
         char nameLetter = name.charAt(i);
         char typedLetter = typed.charAt(j);
         
         // if the letters that i and j are pointing do not match, return false
         if(nameLetter != typedLetter)
         {
            return false;
         }
         
         int countLName = 0;
         
         while(i < nSize && name.charAt(i) == typedLetter)
         {
            countLName++;
            i++;
         }
         
         int countTName = 0;
         
         while(j < tSize && typed.charAt(j) == nameLetter)
         {
            countTName++;
            j++;
         }
         
         if(!(countTName >= countLName))
         {
            return false;
         }               
      }
      
      // both i and j are at the end, i.e. i should equal nSize and t should equal tSize
      return i == nSize && j == tSize;     
   }
}