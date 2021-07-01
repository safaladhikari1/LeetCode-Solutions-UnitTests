package difficultyMedium;

import helperClass.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindBottomLeftTreeValueTest {

    private TreeNode root;
    private FindBottomLeftTreeValue solution;

    @Before
    public void setup() {
        solution = new FindBottomLeftTreeValue();
    }

    @Test
    public void test_FindBottomLeftTreeValueTest() {
        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        assertEquals("The output should be 1 after calling the findBottomLeftValue()", 1,
                solution.findBottomLeftValue(root));
    }
}