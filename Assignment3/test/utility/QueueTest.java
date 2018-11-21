package utility;

import exceptions.EmptyQueueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class QueueTest {

    private Queue<Integer> queue;
    private Queue<Integer> testQueue;
    private Integer integer1 = 1;
    private Integer integer2 = 2;
    private Integer integer3 = 3;

    @BeforeEach
    void setUp() {
        queue = new Queue<Integer>();
        testQueue = new Queue<Integer>();
    }

    @Test
    void enqueueEmpty() {
        queue.enqueue(integer1);
        assertEquals(1, queue.size());
        try {
            assertEquals(integer1, queue.peek());
        } catch (EmptyQueueException e) {
            fail("EmptyQueueException was thrown when peeking in queue with items");
        }
    }

    @Test
    void enqueueNotEmpty() {
        queue.enqueue(integer2);
        queue.enqueue(integer1);
        assertEquals(2, queue.size());
        try {
            assertEquals(integer2, queue.peek());
        } catch (EmptyQueueException e) {
            fail("EmptyQueueException was thrown when peeking in queue with items");
        }
    }

    @Test
    void enqueueNullPointerException() {
        try
        {
            queue.enqueue(null);
            fail("NullPointerException was not caught for adding a null to queue");
        }
        catch (NullPointerException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void dequeueNotEmpty() {
        queue.enqueue(integer1);
        try {
            assertEquals(integer1, queue.dequeue());
            assertEquals(0, queue.size());
        } catch (EmptyQueueException e) {
            fail("EmptyQueueException was thrown for some reason");
        }
    }

    @Test
    void dequeueEmptyQueueException() {
        try
        {
            queue.dequeue();
            fail("Dequeueing from empty queue failed");
        }
        catch (EmptyQueueException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void peekEmptyQueueException() {
        try
        {
            queue.peek();
            fail("Peeking on empty queue failed");
        }
        catch (EmptyQueueException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void peekNotEmpty() {
        queue.enqueue(integer1);
        try {
            assertEquals(integer1, queue.peek());
        } catch (EmptyQueueException e) {
            fail("Peeking non empty queue failed");
        }
    }

    @Test
    void dequeueAll() {
        queue.enqueue(integer1);
        queue.enqueue(integer2);
        assertEquals(2, queue.size());
        queue.dequeueAll();
        assertEquals(0,queue.size());
    }

    @Test
    void isEmptyNotEmpty() {
        queue.enqueue(integer2);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void isEmptyEmpty() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void equals() {
        queue.enqueue(integer1);
        testQueue.enqueue(integer1);
        if(queue.equals(testQueue))
        {
            assertTrue(true);
        }
    }

    @Test
    void isFull() {
        assertEquals(false, queue.isFull());
    }

    @Test
    void sizeEmpty() {
        assertEquals(0, queue.size());
    }

    @Test
    void sizeNotEmpty() {
        queue.enqueue(integer1);
        assertEquals(1, queue.size());
    }
}