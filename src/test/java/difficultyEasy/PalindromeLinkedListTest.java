package difficultyEasy;

import helperClass.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {

    private PalindromeLinkedList solution;
    private ListNode head;

    @Before
    public void setUp() throws Exception {
        solution = new PalindromeLinkedList();
    }

    @Test
    public void isPalindrome() {
        head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        assertTrue(solution.isPalindrome(head));

        head = new ListNode(1, new ListNode(2, null));
        assertFalse(solution.isPalindrome(head));
    }
}