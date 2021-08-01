package difficultyEasy;

import helperClass.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class AverageOfLevelsInBinaryTreeTest {

    private AverageOfLevelsInBinaryTree solution;
    private TreeNode root;

    @Before
    public void setUp() throws Exception {
        solution = new AverageOfLevelsInBinaryTree();
    }

    @Test
    public void averageOfLevels() {
        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Double> resultList = solution.averageOfLevels(root);
        assertThat("The result list does not contain the average value of the nodes on each level",
                resultList, contains(3.00, 14.50, 11.00));

        root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        resultList = solution.averageOfLevels(root);
        assertThat("The result list does not contain the average value of the nodes on each level",
                resultList, contains(3.00, 3.00, 3.00));

    }
}