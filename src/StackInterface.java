package src;

/**
 * Custom stack interface
 *
 * @author Noah Stewart
 * @version 1.0.0
 * @param <T> The type of data stored in the stack
 */

public interface StackInterface<T> {
    /**
     * Adds data to the top of the stack
     * O(1)
     *
     * @throws java.lang.IllegalArgumentException if data is null
     * @param data The data to be pushed to the top of the stack
     */
    public void push(T data);

    /**
     * Takes data off the top of the stack, removes, and returns it
     * O(1)
     *
     * @throws java.util.NoSuchElementException if the stack is empty
     * @return The data at the top of the stack
     */
    public T pop();

    /**
     * Returns data from the top of the stack, but does not remove it
     *
     * @throws java.util.NoSuchElementException if the stack is empty
     * @return The data at the top of the stack
     */
    public T peek();

    /**
     * Checks if the stack is empty or not
     *
     * @return True for en empty stack, else false
     */
    public boolean isEmpty();

    /**
     * Returns the size of the stack
     *
     * @return The size of the stack
     */
    public int size();
}
