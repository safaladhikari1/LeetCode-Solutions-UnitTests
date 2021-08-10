package difficultyEasy;

/**
 * Add Strings
 *
 * Problem Source: https://leetcode.com/problems/add-strings/
 *
 * Algorithm:
 *
 * 1. Using manual calculation technique on pen and paper with code
 * 2. Look at the last digit of both strings
 * 3. Convert it to int value
 * 4. add the values as result
 * 5. Since we only append the last digit of the result,
 *    append result % 10
 *    carry result / 10
 * 6. At the end, check if carry is not 0 to handle the case,
 *     solution.addStrings("1", "9")
 * 7. Reverse the string builder and convert to string.
 *
 * Time-Complexity: O(N), where N is the largest length between num1 and num2.
 * Space-Complexity: O(1)
 *
 */
public class AddStrings {

    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
        System.out.println(solution.addStrings("11", "123"));

        System.out.println(solution.addStrings("456", "77"));

        System.out.println(solution.addStrings("1", "9"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;

        while(index1 >= 0 || index2 >= 0) {

            int num1Val = 0;
            int num2Val = 0;

            if(index1 >= 0) {
                num1Val = num1.charAt(index1) - '0';
            }

            if(index2 >= 0) {
                num2Val = num2.charAt(index2) - '0';
            }

            int resultVal = num1Val + num2Val + carry;

            carry = resultVal / 10;

            result.append(resultVal % 10);
            index1--;
            index2--;
        }

        if(carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
