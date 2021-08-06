package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectCapitalTest {

    private DetectCapital solution;

    @BeforeEach
    void setUp() {
        solution = new DetectCapital();
    }

    @Test
    void detectCapitalUse() {
        assertTrue(solution.detectCapitalUse("USA"), "The usage of capitals does not hold all 3 cases, " +
                "per problem description");
        assertFalse(solution.detectCapitalUse("FlaG"), "The usage of capitals does not hold all 3 cases, " +
                "per problem description");
    }
}