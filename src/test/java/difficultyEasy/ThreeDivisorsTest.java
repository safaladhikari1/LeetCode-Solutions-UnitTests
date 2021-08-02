package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeDivisorsTest {

    private ThreeDivisors solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeDivisors();
    }

    @Test
    void testIsThree() {
        assertEquals(solution.isThree(2), false,
                "Input int does not have exactly three positive divisors");

        assertEquals(solution.isThree(4), true,
                "Input int does not have exactly three positive divisors");
    }
}