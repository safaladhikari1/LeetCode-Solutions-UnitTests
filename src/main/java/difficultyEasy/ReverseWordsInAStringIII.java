package difficultyEasy;

/**
 * Reverse Words in a String III
 *
 * Problem Source: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Algorithm:
 *
 * 1. Convert the String to charArray, Loop through the characters in the Array
 *
 * 2. Make a two pointers, left and right
 *
 * 3. In for loop
 *      When you encounter a space in for loop
 *
 *          This means we found our word
 *          Reverse the letters on that word using two pointers
 *      When the loop is at the end of the String
 *
 *          This means we need to reverse the letter of the last word using two pointers.
 *
 * 4. At the end, return the new String created from the char Array.
 *
 * Time-Complexity: O(N), where N is the length of the characters in the string
 * Space-Complexity: O(N) for our new output String.
 *
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        ReverseWordsInAStringIII solution = new ReverseWordsInAStringIII();
        System.out.println(solution.reverseWords("God Ding"));
    }

    public String reverseWords(String s){
        char[] sArray = s.toCharArray();

        int left = 0, right = 0;
        for(int i=0; i < sArray.length; i++) {
            if(sArray[i] == ' '){
                right = i - 1;
                while(left < right) {
                    char temp = sArray[right];
                    sArray[right] = sArray[left];
                    sArray[left] = temp;
                    left++;
                    right--;
                }
                left = i + 1;
            }
            else if(i == sArray.length - 1){
                right = i;
                while(left < right) {
                    char temp = sArray[right];
                    sArray[right] = sArray[left];
                    sArray[left] = temp;
                    left++;
                    right--;
                }
            }
        }

        return new String(sArray);
    }

}
