package utility;

import java.io.Serializable;

/**
 * This interface is designed to be used to implement a Stack
 * using this ADT. Implementation of this will require all the methods
 * below to be implemented with correct functionality.
 *
 * The Stack works on a FILO (First In, Last Out) basis.
 * Whatever elements are added first are removed last from the queue.
 *
 * @author Harmanjit M.
 * @version 1.0
 *
 * @param <E> The type of elements this Stack holds.
 */
public interface MyStackADT<E> extends Serializable
{
    /**
     * Method to check which element is on top of the Stack, without removing,
     * or making any changes to it.
     *
     * Pre-Conditions: The Stack must have at least one element in order to be returned.
     * Post-Conditions: The returned value must be the very first element in the Stack,
     * and cannot be a NULL value.
     *
     * @return Return the first value on the Queue.
     * @throws NullPointerException When the first element on the Stack is NULL
     * or when the Stack is empty with no elements.
     */
    public E peek() throws NullPointerException;

    /**
     * Method to remove and return the element from the very top of the Stack.
     *
     * Pre-Conditions: The Stack cannot be empty, and must contain at least one element.
     * Post-Conditions: The Stack must not return a NULL value.
     *
     * @return Return the element at the top of the Stack.
     * @throws NullPointerException When the element on the top of the Stack is NULL.
     */
    public E pop() throws NullPointerException;

    /**
     * Method to add an element to the top of the Stack.
     *
     * Pre-Conditions: The element to be pushed cannot be NULL.
     * Post-Conditions: The returned value must be true to ensure the element
     * was added properly.
     *
     * @param toPush The element to add to the top of the Stack.
     * @return Return true if the element was added to the Stack, and if the very first element
     * on the Stack is equal to the one added to the Stack.
     * @throws NullPointerException When the element specified was NULL, or if the Stack is not
     * initialized properly.
     */
    public boolean push(E toPush) throws NullPointerException;

    /**
     * Method to check if the Stack is empty or not and return a value.
     *
     * Pre-Conditions: The Stack can be either empty, or non-empty.
     * Post-Conditions: The value returned must be based on checking the
     * peek of the Stack.
     *
     * @return Return true or false based on if the Stack is empty or not.
     * If peeking on the Stack returns a null value, then the list is empty.
     */
    public boolean isEmpty();

    /**
     * Method to find the specified element in the Stack to check if it exists.
     *
     * Pre-Conditions: The specified element must not be NULL.
     * Post-Conditions: The index being returned cannot be a negative Integer and
     * must be less than the total size of the Stack.
     *
     * @param toFind The element to search for in the Stack.
     * @return Returns the index of the item found in the Stack, and the position
     * of the element in the Stack.
     * @throws NullPointerException When the item found is NULL.
     */
    public int find(E toFind) throws NullPointerException;
}
