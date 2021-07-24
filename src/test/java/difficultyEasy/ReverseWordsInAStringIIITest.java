package difficultyEasy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringIIITest {

    private ReverseWordsInAStringIII solution;

    @Before
    public void setUp() throws Exception {
        solution = new ReverseWordsInAStringIII();
    }

    @Test
    public void reverseWords() {
        assertEquals("Reverse Words in Output String does not preserve whitespace and initial word order"
                ,"doG gniD", solution.reverseWords("God Ding"));

        assertEquals("Reverse Words in Output String does not preserve whitespace and initial word order"
                ,"s'teL ekat edoCteeL tsetnoc", solution.reverseWords("Let's take LeetCode contest"));
    }
}