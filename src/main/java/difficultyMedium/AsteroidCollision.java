import java.util.Arrays;
import java.util.Stack;

/**
 * Asteroid Collision
 *
 * https://leetcode.com/problems/asteroid-collision/
 *
 * Algorithm:
 *
 * 1. Make a stack of Integer
 * 2. Loop through the elements in the array
 *
 *    If they are positive, push it to stack
 *    Else
 *          while loop, check if stack is not empty, top element of stack is less than Math.abs(asteroid) and
 *          top element of Stack is positive
 *              Pop the element from stack
 *              This means,
 *              [10, 2, -5], -5 wins over 2
 *
 *          If the stack is empty or we have the negative element in the top of stack
 *              push the element (asteroid) in the stack
 *
 *          Else if, if the asteroid + top element of stack is zero
 *              That means, they collide, the pop the element
 * 3. At the end,
 *       Pop all the elements from the stack and add to the array
 *
 *       Return the array
 *
 *  Time-Complexity: O(N), where N is the length of input array or the number of asteroids
 *  Space-Complexity: O(N), worst case none of them collides, so we add them all on our stack
 *
 *  Explanation:
 *
 *  https://leetcode.com/problems/asteroid-collision/discuss/193403/Java-easy-to-understand-solution
 *  https://leetcode.com/problems/asteroid-collision/discuss/904009/Java-100-Clean-Code-or-Easy-%2B-Comments-(5-ms)
 *  https://leetcode.com/problems/asteroid-collision/solution/
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[] {5, 10, -5})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> numStack = new Stack<>();

        for(int i=0; i < asteroids.length; i++) {
            if(asteroids[i] > 0) {
                numStack.push(asteroids[i]);
            }
            else {
                while(!numStack.isEmpty() && numStack.peek() < Math.abs(asteroids[i]) && numStack.peek() > 0) {
                    numStack.pop();
                }

                if(numStack.isEmpty() || numStack.peek() < 0) {
                    numStack.push(asteroids[i]);
                }
                else if(asteroids[i] + numStack.peek() == 0) {
                    numStack.pop();
                }
            }
        }

        int[] result = new int[numStack.size()];

        int index = result.length - 1;

        while(!numStack.isEmpty()) {
            result[index] = numStack.pop();
            index--;
        }

        return result;
    }
}
