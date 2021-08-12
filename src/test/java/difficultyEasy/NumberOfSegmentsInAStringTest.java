package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfSegmentsInAStringTest {

    private NumberOfSegmentsInAString solution;

    @BeforeEach
    void setUp() {
        solution = new NumberOfSegmentsInAString();
    }

    @Test
    void countSegments() {
        assertEquals(5, solution.countSegments("Hello, my name is John"),
                "The number of segments in the string is not correct");
        assertEquals(4, solution.countSegments("love live! mu'sic forever"),
                "The number of segments in the string is not correct");
    }
}