package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * Suite of JUnits created by ChatGPT for a stack following my interface.
 */
public class stackJUnits {

    private StackInterface<Integer> stack;

    // Assuming MyStack is your implementation of StackInterface
    @BeforeEach
    public void setUp() {
        stack = new LLStack<>();
    }

    @Test
    public void testIsEmptyOnNewStack() {
        assertTrue(stack.isEmpty(), "A new stack should be empty");
        assertEquals(0, stack.size(), "A new stack should have size 0");
    }

    @Test
    public void testPushAndSize() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.size(), "Stack size should be 1 after one push");

        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size(), "Stack size should be 3 after three pushes");
    }

    @Test
    public void testPushNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> stack.push(null),
                "Pushing null should throw IllegalArgumentException");
    }

    @Test
    public void testPeek() {
        stack.push(100);
        stack.push(200);
        int top = stack.peek();
        assertEquals(200, top, "Peek should return the last pushed element");
        assertEquals(2, stack.size(), "Peek should not remove the element from the stack");
    }

    @Test
    public void testPeekOnEmptyStackThrowsException() {
        assertThrows(NoSuchElementException.class, () -> stack.peek(),
                "Peeking on an empty stack should throw NoSuchElementException");
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Since stack is LIFO, elements should come off in reverse order.
        int firstPop = stack.pop();
        assertEquals(3, firstPop, "Pop should return the last pushed element");

        int secondPop = stack.pop();
        assertEquals(2, secondPop, "Pop should return elements in LIFO order");

        // Size should update accordingly.
        assertEquals(1, stack.size(), "Stack size should be reduced after pop");
    }

    @Test
    public void testPopOnEmptyStackThrowsException() {
        assertThrows(NoSuchElementException.class, () -> stack.pop(),
                "Popping from an empty stack should throw NoSuchElementException");
    }

    @Test
    public void testMultipleOperations() {
        // Push several elements
        stack.push(5);
        stack.push(15);
        stack.push(25);
        assertEquals(3, stack.size(), "Stack should have 3 elements after pushes");

        // Peek the top element
        assertEquals(25, stack.peek(), "Peek should return 25 as the top element");

        // Pop one element
        assertEquals(25, stack.pop(), "Pop should remove and return 25");
        assertEquals(2, stack.size(), "Size should be 2 after one pop");

        // Continue with more operations
        stack.push(35);
        assertEquals(35, stack.peek(), "Peek should return 35 as the new top element");
        assertEquals(3, stack.size(), "Size should be 3 after push");

        // Remove remaining elements
        assertEquals(35, stack.pop());
        assertEquals(15, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty(), "Stack should be empty after removing all elements");
    }
}

