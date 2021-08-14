package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLuckyIntegerInAnArrayTest {

    private FindLuckyIntegerInAnArray solution;

    @BeforeEach
    void setUp() {
        solution = new FindLuckyIntegerInAnArray();
    }

    @Test
    void findLucky() {
        assertEquals(2, solution.findLucky(new int[] {2, 2, 3, 4}),
                "The largest lucky integer is not correct.");

        assertEquals(3, solution.findLucky(new int[] {1, 2, 2, 3, 3, 3}),
                "The largest lucky integer is not correct.");
    }
}