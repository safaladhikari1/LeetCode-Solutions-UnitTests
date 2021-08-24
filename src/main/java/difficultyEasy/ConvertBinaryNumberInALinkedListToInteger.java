package difficultyEasy;

import helperClass.ListNode;

/**
 * Convert Binary Number in a LinkedList to Integer
 *
 * Problem Source: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Algorithm:
 *
 * Best explained on: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/629087/Detailed-explanation-Java-%3A-faster-than-100.00
 *
 * Time-Complexity: O(N), where N is the number of nodes in the list
 * Space-Complexity: O(1)
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ConvertBinaryNumberInALinkedListToInteger solution = new ConvertBinaryNumberInALinkedListToInteger();
        System.out.println(solution.getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1)))));
    }

    public int getDecimalValue(ListNode head) {
        int resultVal = 0;

        while(head != null) {
            resultVal = resultVal * 2 + head.val;
            head = head.next;
        }

        return resultVal;
    }
}
