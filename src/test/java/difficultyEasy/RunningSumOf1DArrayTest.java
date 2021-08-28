package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunningSumOf1DArrayTest {

    private RunningSumOf1DArray solution;

    @BeforeEach
    void setUp() {
        solution = new RunningSumOf1DArray();
    }

    @Test
    void runningSum() {
        assertArrayEquals(new int[] {1, 3, 6, 10}, solution.runningSum(new int[] {1, 2, 3, 4}),
                "The running sum of nums array is not correct");

        assertArrayEquals(new int[] {3, 4, 6, 16, 17}, solution.runningSum(new int[] {3, 1, 2, 10, 1}),
                "The running sum of nums array is not correct");
    }
}