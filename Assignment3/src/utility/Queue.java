package utility;

import exceptions.EmptyQueueException;

public class Queue<E> implements QueueADT<E> {

    DLL<E> queue;

    public Queue()
    {
        queue = new DLL<>();
    }

    /**
     * Enqueue will place the added item at the last position in the
     * queue.  This method will not allow <code>null</code> values
     * to be added to the Queue.
     *
     * @param toAdd the item to be added to the Queue.
     * @throws NullPointerException raised when a <code>null</code> object
     *                              is placed in the Queue.
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if(toAdd == null)
        {
            throw new NullPointerException();
        }
        queue.add(toAdd);
    }

    /**
     * Dequeue will remove the first item that was placed in the Queue.
     *
     * @return the first item in the Queue.
     * @throws EmptyQueueException raised when the queue's length is zero (0).
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if(queue.size() == 0)
        {
            throw new EmptyQueueException();
        }
        return queue.remove(0);
    }

    /**
     * Peek provides a reference to the first item in the queue without
     * removing from the queue.
     *
     * @return the first item in the queue.
     * @throws EmptyQueueException raised when the queue's length is zero (0).
     */
    @Override
    public E peek() throws EmptyQueueException {
        if(queue.size() == 0)
        {
            throw new EmptyQueueException();
        }
        return queue.get(0);
    }

    /**
     * dequeueAll removes all items in the queue.
     */
    @Override
    public void dequeueAll() {
        queue.clear();
    }

    /**
     * Returns <code>true</code> when the queue contains no items.
     *
     * @return <code>true</code> when queue length is zero (0).
     */
    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     *
     * @return an iterator over the elements in this queue in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    /**
     * Used to compare two Queue ADT's. To be equal two queues must contain
     * equal items appearing in the same order.
     *
     * @param that the Queue ADT to be compared to this queue.
     * @return <code>true</code> if the queues are equal.
     */
    @Override
    public boolean equals(QueueADT<E> that) {
        for(int i=0;i<queue.size();i++)
        {
            try {
                if(!(queue.get(0).equals(that.dequeue())))
                {
                    return false;
                }
            } catch (EmptyQueueException e) {
                return false;
            }
        }
        return true;
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
        return queue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array. Obeys the general contract of the Collection.toArray(Object[])
     * method.
     *
     * @param holder the array into which the elements of this queue are to be
     *               stored, if it is big enough; otherwise, a new array of the
     *               same runtime type is allocated for this purpose.
     * @return an array containing the elements of this queue.
     * @throws NullPointerException if the specified array is null.
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if(holder == null)
        {
            throw new NullPointerException();
        }
        for(int i=0;i<queue.size();i++)
        {
            if(queue.get(i) == null)
            {
                throw new NullPointerException();
            }
        }
        return queue.toArray(holder);
    }

    /**
     * (Optional Method) Returns true if the number of items in the queue
     * equals the length.  This operation is only implement when a fixed length
     * queue is required.
     *
     * @return <code>true</code> if queue is at capacity.
     */
    @Override
    public boolean isFull() {
        //Optional
        return false;
    }

    /**
     * Returns the length of the current queue as an integer value.
     *
     * @return the current size to the queue as an integer.
     */
    @Override
    public int size() {
        return queue.size();
    }
}
