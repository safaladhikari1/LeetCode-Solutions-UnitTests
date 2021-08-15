package difficultyMedium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfAPhoneNumberTest {

    private LetterCombinationsOfAPhoneNumber solution;

    @BeforeEach
    void setUp() {
        solution = new LetterCombinationsOfAPhoneNumber();
    }

    @Test
    void letterCombinations() {
        List<String> resultList = solution.letterCombinations("23");
        assertThat("All possible letter combinations of the input digits is not correct.",
                resultList, contains("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));

        resultList = solution.letterCombinations("2");
        assertThat("All possible letter combinations of the input digits is not correct.",
                resultList, contains("a", "b", "c"));
    }
}