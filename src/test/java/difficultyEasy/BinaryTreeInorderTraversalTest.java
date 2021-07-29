package difficultyEasy;

import helperClass.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal solution;
    private TreeNode root;

    @Before
    public void setUp() throws Exception {
        solution = new BinaryTreeInorderTraversal();
    }

    @Test
    public void inorderTraversal() {
        // Testcase 1
        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> resultList = solution.inorderTraversal(root);
        assertThat("Inorder traversal of nodes' values are not correct",
                resultList, contains(1, 3, 2));

        // Test case2
        root = new TreeNode(1, null, new TreeNode(2));
        resultList = solution.inorderTraversal(root);
        assertThat("Inorder traversal of nodes' values are not correct",
                resultList, contains(1, 2));
    }
}