package difficultyEasy;

import helperClass.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertBinaryNumberInALinkedListToIntegerTest {

    private ConvertBinaryNumberInALinkedListToInteger solution;

    @BeforeEach
    void setUp() {
        solution = new ConvertBinaryNumberInALinkedListToInteger();
    }

    @Test
    void getDecimalValue() {
        assertEquals(5, solution.getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1)))),
                "The decimal value of the number in the linked list is not correct.");

        assertEquals(1, solution.getDecimalValue(new ListNode(1)),
                "The decimal value of the number in the linked list is not correct.");
    }
}