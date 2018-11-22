package utility;

import java.util.EmptyStackException;

public class Stack<E> implements StackADT<E> {

    MyArrayList<E> stack;

    public Stack() {
        stack = new MyArrayList<>();
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
    public E peek() throws EmptyStackException {
        if(stack.get(0) == null || stack.size() == 0)
        {
            throw new EmptyStackException();
        }
        return stack.get(0);
    }

    /**
     * Clears all the items from this Stack. This method returns, unless there
     * is an Exception (Runtime) thrown.
     */
    @Override
    public void clear() {
        stack.clear();
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
    public E pop() throws EmptyStackException {
        if(stack.get(0) == null || stack.size() == 0)
        {
            throw new EmptyStackException();
        }
        E toReturn = stack.get(0);
        stack.remove(0);
        return toReturn;
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
    public void push(E toPush) throws NullPointerException {
        if(toPush == null)
        {
            throw new NullPointerException();
        }
        stack.add(0,toPush);
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
        return stack.size() == 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence.
     */
    @Override
    public Object[] toArray() {
        return stack.toArray();
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array. Obeys the general contract of the Collection.toArray(Object[])
     * method.
     *
     * @param holder@return an array containing the elements of this stack.
     * @throws NullPointerException if the specified array is null.
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if(holder == null)
        {
            throw new NullPointerException();
        }

        for(int i=0;i<holder.length;i++)
        {
            if(holder[i] == null)
            {
                throw new NullPointerException();
            }
        }
        return stack.toArray(holder);
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param toFind element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @throws NullPointerException if the specified element is null and this list does not
     *                              support null elements.
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind == null)
        {
            throw new NullPointerException();
        }
        return stack.contains(toFind);
    }

    /**
     * Returns the 1-based position where an object is on this stack. If the
     * object o occurs as an item in this stack, this method returns the
     * distance from the top of the stack of the occurrence nearest the top of
     * the stack; the topmost item on the stack is considered to be at distance
     * 1. The equals method is used to compare o to the items in this stack.
     *
     * @param toFind the desired object.
     * @return the 1-based position from the top of the stack where the object
     * is located; the return value -1 indicates that the object is not
     * on the stack.
     */
    @Override
    public int search(E toFind) {
        for(int i=0;i<stack.size();i++)
        {
            if(stack.get(i).equals(toFind))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence.
     *
     * @return an iterator over the elements in this stack in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }

    /**
     * Used to compare two Stack ADT's. To be equal two stacks must contain
     * equal items appearing in the same order.
     *
     * @param that the Stack ADT to be compared to this stack.
     * @return <code>true</code> if the stacks are equal.
     */
    @Override
    public boolean equals(StackADT<E> that) {
        for(int i=0;i<stack.size();i++)
        {
            if(!(stack.get(i).equals(that.pop())))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the depth of the current stack as an integer value.
     *
     * @return the current size to the stack as an integer.
     */
    @Override
    public int size() {
        return stack.size();
    }

}
