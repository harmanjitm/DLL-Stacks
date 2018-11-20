package utility;

public class Stack<E> implements MyStackADT<E> {

    int max = 1000;
    int top = 0;
    E[] array;

    public Stack() {
        array = (E[]) new Object[max];
    }

    /**
     * Method to check which element is on top of the Stack, without removing,
     * or making any changes to it.
     * <p>
     * Pre-Conditions: The Stack must have at least one element in order to be returned.
     * Post-Conditions: The returned value must be the very first element in the Stack,
     * and cannot be a NULL value.
     *
     * @return Return the first value on the Queue.
     * @throws NullPointerException When the first element on the Stack is NULL
     *                              or when the Stack is empty with no elements.
     */
    @Override
    public E peek() throws NullPointerException {
        if(top == 0)
        {
            return null;
        }
        else if(array[top] == null)
        {
            throw new NullPointerException();
        }
        else {
            return array[top];
        }
    }

    /**
     * Method to remove and return the element from the very top of the Stack.
     * <p>
     * Pre-Conditions: The Stack cannot be empty, and must contain at least one element.
     * Post-Conditions: The Stack must not return a NULL value.
     *
     * @return Return the element at the top of the Stack.
     * @throws NullPointerException When the element on the top of the Stack is NULL.
     */
    @Override
    public E pop() throws NullPointerException {
        if(array[top] == null)
        {
            throw new NullPointerException();
        }
        top--;
        return array[top];
    }

    /**
     * Method to add an element to the top of the Stack.
     * <p>
     * Pre-Conditions: The element to be pushed cannot be NULL.
     * Post-Conditions: The returned value must be true to ensure the element
     * was added properly.
     *
     * @param toPush The element to add to the top of the Stack.
     * @return Return true if the element was added to the Stack, and if the very first element
     * on the Stack is equal to the one added to the Stack.
     * @throws NullPointerException When the element specified was NULL, or if the Stack is not
     *                              initialized properly.
     */
    @Override
    public boolean push(E toPush) throws NullPointerException {
        if (toPush == null) {
            throw new NullPointerException();
        }
        top++;
        array[top] = toPush;
        return true;
    }

    /**
     * Method to check if the Stack is empty or not and return a value.
     * <p>
     * Pre-Conditions: The Stack can be either empty, or non-empty.
     * Post-Conditions: The value returned must be based on checking the
     * peek of the Stack.
     *
     * @return Return true or false based on if the Stack is empty or not.
     * If peeking on the Stack returns a null value, then the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return peek() == null;
    }

    /**
     * Method to find the specified element in the Stack to check if it exists.
     * <p>
     * Pre-Conditions: The specified element must not be NULL.
     * Post-Conditions: The index being returned cannot be a negative Integer and
     * must be less than the total size of the Stack.
     *
     * @param toFind The element to search for in the Stack.
     * @return Returns the index of the item found in the Stack, and the position
     * of the element in the Stack.
     * @throws NullPointerException When the item found is NULL.
     */
    @Override
    public int find(E toFind) throws NullPointerException {
        for(int i = top;i<=array.length;i++)
        {
            if(array[i] == toFind)
            {
                return i;
            }
            else if(toFind == null)
            {
                throw new NullPointerException();
            }
        }
        return 0;
    }
}
