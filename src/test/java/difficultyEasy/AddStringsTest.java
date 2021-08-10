package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {

    private AddStrings solution;

    @BeforeEach
    void setUp() {
        solution = new AddStrings();
    }

    @Test
    void addStrings() {
        assertEquals("134", solution.addStrings("11", "123"),
                "The output string sum of num1 and num2 string is not correct.");

        assertEquals("533", solution.addStrings("456", "77"),
                "The output string sum of num1 and num2 string is not correct.");
    }
}