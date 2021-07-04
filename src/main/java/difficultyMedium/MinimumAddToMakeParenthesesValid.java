import java.util.Stack;

class MinimumAddToMakeParenthesesValid
{
   public static void main(String[] args)
   {
      System.out.println(minAddToMakeValid("()))(("));
   }
   
   public static int minAddToMakeValid(String s)
   {      
      if(s.length() < 1)
      {
         return 0;
      }
      
      Stack<Character> characterStack = new Stack<>();
      int count = 0;
      
      for(int i=0; i < s.length(); i++)
      {
         if(s.charAt(i) == ')' && !characterStack.isEmpty())
         {
            while(!characterStack.isEmpty())
            {
               if(characterStack.peek() == '(')
               {
                  characterStack.pop();
               }
            }
         }
         else
         {
            characterStack.push(s.charAt(i));
         }
      }
      
      while(!characterStack.isEmpty())
      {
         count++;
         characterStack.pop();
      }     
      
      return count;
      
   }
}