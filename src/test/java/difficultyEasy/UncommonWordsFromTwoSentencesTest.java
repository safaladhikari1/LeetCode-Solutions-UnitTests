package difficultyEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UncommonWordsFromTwoSentencesTest {

    private UncommonWordsFromTwoSentences solution;

    @BeforeEach
    void setUp() {
        solution = new UncommonWordsFromTwoSentences();
    }

    @Test
    void uncommonFromSentences() {
        String[] resultList = {"sweet", "sour"};
        assertArrayEquals(resultList, solution.uncommonFromSentences("this apple is sweet", "this apple is sour"),
                "The list does not have all the uncommon words");

        resultList = new String[] {"banana"};
        assertArrayEquals(resultList, solution.uncommonFromSentences("apple apple", "banana"),
                "The list does not have all the uncommon words");
    }
}