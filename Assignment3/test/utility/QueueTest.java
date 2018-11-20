package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }

    @Test
    void enqueueNotEmpty() {
    }

    @Test
    void enqueueNullPointerException() {
    }

    @Test
    void dequeueNotEmpty() {
    }

    @Test
    void dequeueEmptyQueueException() {
    }

    @Test
    void peekEmptyQueueException() {
    }

    @Test
    void peekNotEmpty() {
    }

    @Test
    void dequeueAll() {
    }

    @Test
    void isEmptyNotEmpty() {
    }

    @Test
    void isEmptyEmpty() {
    }

    @Test
    void equals() {
    }

    @Test
    void isFull() {
        assertEquals(false, queue.isFull());
    }

    @Test
    void sizeEmpty() {
    }

    @Test
    void sizeNotEmpty() {
    }
}