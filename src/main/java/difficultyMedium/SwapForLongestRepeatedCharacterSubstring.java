class SwapForLongestRepeatedCharacterSubstring
{
   public static void main(String[] args)
   {
      System.out.println(maxRepOpt1("ababa"));   
      
      System.out.println(maxRepOpt1("aaabaaa"));
   }
   
   // Bruteforce solution that doesn't quite work yet
   public static int maxRepOpt1(String text)
   {
      int[] charTable = new int[26];
      
      char[] textArray = text.toCharArray();
      
      charTable[textArray[0] - 'a']++;
      
      for(int i=1; i < textArray.length; i++)
      {
         if(textArray[i] != textArray[i-1])
         {
            swap(textArray, textArray[i], i);
         }
         
         charTable[textArray[i] - 'a']++;
      }
      
      int max = 0;
      
      for(int i = 0; i < charTable.length; i++)
      {
         if(charTable[i] > max)
         {
            max = charTable[i];
         }
      }
      
      return max;
   }
   
   public static void swap(char[] charTable, char letter, int index)
   {
      for(int i=charTable.length - 1; i >=0; i--)
      {
         char temp = charTable[index];
         charTable[index] = charTable[i];
         charTable[i] = temp;
         
         return;
      }
   }  
}