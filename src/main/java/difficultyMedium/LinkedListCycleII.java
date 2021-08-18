package difficultyMedium;

import helperClass.ListNode;

/**
 * LinkedList Cycle II
 *
 * Problem Source: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Algorithm:
 *
 * 1. Make 2 pointers ListNode slow and fast
 *    At first, they both point to head.
 *
 * 2. If we move fast's speed twice as slow
 *    At some point, if there was a LinkedList cycle, fast and slow will meet
 *
 *    Explanation: https://youtu.be/sMqEwkpvJvQ
 *
 * 3. Wherever they meet, after they have meet we confirmed there is a LinkedList cycle
 *    Now we need to find the node where the cycle starts in that linked list
 *
 *    We introduce ListNode slow2
 *
 *    Per mathematical proof: https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
 *
 *    it is guaranteed that slow and slow2 will be exactly
 *    k steps away from where the cycle starts in that linked list
 *
 *    That means we move slow and slow2 at the same speed, until they have met each other.
 *    Wherever they meet, is where the LinkedList cycle starts.
 *    We return that node.
 *
 *    Explanation: https://youtu.be/Qq-vnKmzJR0
 *    More info on the math:
 *
 *    https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
 *    https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C%2B%2B-with-Detailed-Alogrithm-Description
 *
 *
 * 4. Otherwise return null.
 *
 * Time-Complexity: O(N), where N is the number of nodes in the linked list
 * Space-Complexity: O(1)
 *
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                ListNode slow2 = head;

                while(slow != slow2) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}
