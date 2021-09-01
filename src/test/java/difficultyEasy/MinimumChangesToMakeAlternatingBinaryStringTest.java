package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumChangesToMakeAlternatingBinaryStringTest {

    private MinimumChangesToMakeAlternatingBinaryString solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumChangesToMakeAlternatingBinaryString();
    }

    @Test
    void minOperations() {
        assertEquals(1, solution.minOperations("0100"),
                "The minimum number of operations needed to make s alternating is not correct");

        assertEquals(2, solution.minOperations("1111"),
                "The minimum number of operations needed to make s alternating is not correct");
    }
}