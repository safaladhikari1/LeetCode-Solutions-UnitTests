/*
   Decode String
   
   Given an encoded string, return its decoded string.
   
   The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
   
   You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
   
   Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
   
   Examples:
   
   Input: s = "3[a]2[bc]"
   Output: "aaabcbc"
   
   Input: s = "3[a2[c]]"
   Output: "accaccacc"
   
   ----------
   
   Algorithm:
   
   1. This is best explained from videos:
      
      https://youtu.be/CW3ZYAN5Huo
      
      https://youtu.be/P7iR5iweg1M
      
      We make use of two Stacks to store the Integer, String to solve this problem.
      
   2. Let's start with example string:
   
      "3[a]2[bc]"
      
      Instead of concatenating Strings in the problem, we will only use String Builder, so we will use pointers of String Builder, watch out.
      
      We have two Stacks, 1 String Builder in the beginning
      
      The first char is '3',
         
         We will convert it to int using (int num = c - '0') and push to intStack
         
         If it was two digits number, for example 34, then we would have converted the characters to two digits using:
         while(i+1 < s.length() && Character.isDigit(s.charAt(i+1)))
         {
            num = num * 10 + s.charAt(i+1) - '0';
            i++;
         }
    
    3. The second character is '['
      
         At this time, we have an empty string builder, sb so we will push that instead to our strStack
         
         And we will start a fresh new string builder.
         
    
    4. The third character is 'a'
         We will append this character to our fresh new string builder from step 3.
         
                            
    5. The fourth character is ']'
       
       Here we will do our operation
       
       We will pop the number 3 from the intstack
       We will create a temporary string builder with already the contents of the specified string from the strStack.
       
       Then, we will create a for loop up to the number 3, that was popped out
         
         append stringbuilder from step 4, 3 times on for loop to our temp string builder on step 5
         "aaa"
         
       point the string builder to temp, we are doing this because the next time we see opening bracket, we will have push this string we made ready to our strStack.
       
    
    6. Now the fifth character is 2, we will push it to our empty intStack. Remember we popped 3 already on step 5
    
    7. The sixth character is '['
         
         We will push the "aaa" from step 5 to our strStack
         point the sb to a new String Builder.
         
    8. The seventh and eigth characters are b and c
       
       We will append them to the fresh sb string builder, from step 7.
       
    9. The ninth character is ']'
       
       We will pop the repeats from intStack.pop, which is 2
       
       We will create a temp string builder with already the contents from the strStack.pop()
       "aaa" on temp string builder so far
       
       Then we will do our for loop, to append sb from step 8, 2 times on the temp string builder.          
       
         temp will append, sb
         "aaa""bc""bc"
         
       We will point the sb to temp.
       
    10. The loop ends, and we will convert the sb to toString() and return.
    
    -------------------
    
    
    Time-Complexity: O(N), where N is the number of characters in our string array. We visit every characters in the String once.
    Space-Complexity: O(N), because we temporarily store the characters from our string array to intStack and strStack as we build our result String.     
       
*/


import java.util.Stack;

class DecodeString
{

   public static void main(String[] args)
   {
      System.out.println(decodeString("3[a]2[bc]"));
   }
   
   public static String decodeString(String s)
   {
      Stack<Integer> intStack = new Stack<>();
      Stack<String> strStack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         
         if(Character.isDigit(c))
         {
            int num = c - '0';
            
            while(i+1 < s.length() && Character.isDigit(s.charAt(i+1)))
            {
               num = num * 10 + s.charAt(i+1) - '0';
               i++;
            }
            
            intStack.push(num);
         }
         else if(c == '[')
         {
            strStack.push(sb.toString());
            sb = new StringBuilder();
         }
         else if(c == ']')
         {
            int repeats = intStack.pop();
            StringBuilder temp = new StringBuilder(strStack.pop());
            
            for(int j=0; j < repeats; j++)
            {
               temp.append(sb);
            }            
            sb = temp;            
         }
         else
         {
            sb.append(c);
         }   
      }
      
      return sb.toString();
      
   }
}

