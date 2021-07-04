import java.util.Stack;

/**
 * Remove All Adjacent Duplicates in String
 *
 * Problem Source: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Algorithm:
 *
 * 1. Make a Stack of Characters
 *
 * 2. Loop through every characters in the String
 *
 * 3. If the Stack is not empty and stack.peek() is equal to the current character in the loop
 *      pop that character in that Stack
 *    Otherwise
 *      push the character in the stack
 *
 * 4. Now to avoid reversing in the String builder
 *    Loop over every character in the stack using for each
 *      append the character to String builder
 *
 * 5. Convert the String builder to String
 *
 * Time-Complexity: O(N), N is the number of characters in the string
 * Space-Complexity: O(N), N space for the stack.
 *
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> tempStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0; i < s.length(); i++) {
            if(!tempStack.isEmpty() && tempStack.peek() == s.charAt(i)) {
                tempStack.pop();
            }
            else {
                tempStack.push(s.charAt(i));
            }
        }

        for(Character ch : tempStack) {
            result.append(ch);
        }

        return result.toString();
    }
}
