package src;

import java.util.LinkedList;
import java.util.NoSuchElementException;


public class LLStack<T> implements StackInterface<T> {
    private int size = 0;
    private final LinkedList<T> backingLL = new LinkedList<>();

    /**
     * Adds data to the top of the stack
     * O(1)
     *
     * @param data The data to be pushed to the top of the stack
     * @throws IllegalArgumentException if data is null
     */
    @Override
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data you passed into push is null," +
                    "please push non-null data");
        }
        backingLL.addFirst(data);
        size++;
    }

    /**
     * Takes data off the top of the stack, removes, and returns it
     * O(1)
     *
     * @return The data at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() {
        if (backingLL.isEmpty()) {
            throw new NoSuchElementException("You tried to pop from an empty stack, " +
                    "please make the stack non-empty before you pop");
        }
        T removedData = backingLL.removeFirst();
        size--;
        return removedData;
    }

    /**
     * Returns data from the top of the stack, but does not remove it
     *
     * @return The data at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public T peek() {
        if (backingLL.isEmpty()) {
            throw new NoSuchElementException("You tried to peek from an empty stack, " +
                    "please make the stack non-empty before you pop");
        }
        T topData = backingLL.peekFirst();
        return topData;
    }

    /**
     * Checks if the stack is empty or not
     *
     * @return True for en empty stack, else false
     */
    @Override
    public boolean isEmpty() {
        return backingLL.isEmpty();
    }

    /**
     * Returns the size of the stack
     *
     * @return The size of the stack
     */
    @Override
    public int size() {
        return size;
    }
}
