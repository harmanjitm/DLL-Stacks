package utility;

import java.io.Serializable;

/**
 * This interface is designed to be used to implement a Queue
 * using this ADT. Implementation of this will require all the methods
 * below to be implemented with correct functionality.
 *
 * The Queue works on a FIFO (First In First Out) basis.
 * Whatever element added first will be removed first.
 *
 * @author Harmanjit M.
 * @version 1.0
 *
 * @param <E> The type of elements this Queue holds.
 */
public interface QueueADT<E> extends Serializable
{
    /**
     * Method to check the total number of elements in the Queue
     * and return them as an Integer.
     *
     * Pre-Conditions: The list cannot have any null values.
     * Post-Conditions: The size returned cannot be a negative value.
     *
     * @return The total number of elements in the Queue
     */
    public int size();

    /**
     * Method to return the element on top of the Queue.
     * The value being returned is the one which was added first.
     *
     * Pre-Conditions: The queue must have at least one element to return.
     * Post-Conditions: The value returned must be the very first value in the Queue.
     *
     * @return The value from the top of the Queue.
     * @throws NullPointerException When the value being returned is NULL
     */
    public E deQueue() throws NullPointerException;

    /**
     * Method to add an element to the end of the Queue.
     * The value being added will be added to the very end,
     * and will be removed last.
     *
     * Pre-Conditions: The value being entered cannot be null, however
     * the implementation must catch it. The element being added can be of any type.
     * Post-Conditions: The value being returned must be true to ensure
     * that the element was added successfully to the Queue, and it
     * should be the last element in the Queue.
     *
     * @param toQueue The element to add to the Queue
     * @return Return true or false, depending on if the element was
     * added successfully to the Queue.
     * @throws NullPointerException When the value being added is being entered as NULL
     */
    public boolean enQueue(E toQueue) throws NullPointerException;

    /**
     * Method to check which element is on top of the Queue, without removing,
     * or making any changes to it.
     *
     * Pre-Conditions: The Queue must have at least one element in order to be returned.
     * Post-Conditions: The returned value must be the very first element in the Queue,
     * and cannot be a NULL value.
     *
     * @return Return the first value on the Queue.
     * @throws NullPointerException When the first element on the Queue is NULL
     * or when the Queue is empty with no elements.
     */
    public E peek() throws NullPointerException;

    /**
     * Method to check if the Queue is empty or not and return a value.
     *
     * Pre-Conditions: The Queue can be either empty, or non-empty.
     * Post-Conditions: The value returned must be based on checking the
     * size of the Queue.
     *
     * @return Return true or false based on if the Queue is empty or not.
     * If the size == 0 then return true, else return false.
     */
    public boolean isEmpty();

}
