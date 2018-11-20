package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static junit.framework.Assert.*;


class StackTest {

    private Stack<Integer> stack;
    private Stack<Integer> testStack;
    private Integer integer1 = 1;
    private Integer integer2 = 2;
    private Integer integer3 = 3;

    @BeforeEach
    void setUp() {
        stack = new Stack<Integer>();
        testStack = new Stack<Integer>();
    }

    @Test
    void peekNotEmpty() {
        stack.push(integer1);
        assertEquals(integer1, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void peekEmptyStackException() {
        try{
            stack.peek();
            fail("Peeking on empty stack exception was not thrown");
        }
        catch (EmptyStackException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void popNotEmpty() {
        stack.push(integer1);
        stack.push(integer2);
        assertEquals(2, stack.size());
        assertEquals(integer2, stack.pop());
    }

    @Test
    void popEmptyStackException() {
        try{
            stack.pop();
            fail("Popping on empty stack exception was not thrown");
        }
        catch (EmptyStackException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void pushEmpty() {
        assertEquals(0, stack.size());
        stack.push(integer1);
        assertEquals(integer1, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void pushNotEmpty() {
        stack.push(integer2);
        stack.push(integer3);
        assertEquals(2, stack.size());
        stack.push(integer1);
        assertEquals(integer1, stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void pushNullPointerException() {
        try{
            stack.push(null);
            fail("Pushing null value didnt throw NullPointerException");
        }
        catch (NullPointerException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void isEmptyEmpty() {
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void isEmptyNotEmpty() {
        stack.push(integer1);
        assertEquals(1, stack.size());
        assertEquals(false, stack.isEmpty());
    }

    @Test
    void clearEmpty() {
        stack.clear();
        try{
            stack.peek();
            fail("Clearing from empty stack failed");
        }
        catch (EmptyStackException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void clearNotEmpty() {
        stack.push(integer2);
        assertEquals(1, stack.size());
        stack.clear();
        try{
            stack.peek();
            fail("Clearing a non empty stack failed");
        }
        catch (EmptyStackException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void toArray() {
        stack.push(integer1);
        Object[] array = stack.toArray();
        assertEquals(integer1, array[0]);
    }

    @Test
    void containsEmptyNotContains() {
        assertEquals(false, stack.contains(integer1));
    }

    @Test
    void containsNotEmptyContains() {
        stack.push(integer1);
        stack.push(integer2);
        assertEquals(true, stack.contains(integer1));
        assertEquals(2, stack.size());
    }

    @Test
    void containsNullPointerException() {
        try
        {
            stack.contains(null);
            fail("Checking if stack contains null did not throw NullPointerException");
        }
        catch (NullPointerException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void searchNotEmptyNotContains() {
        stack.push(integer1);
        assertEquals(false, stack.contains(integer2));
    }

    @Test
    void searchEmpty() {
        assertEquals(-1, stack.search(integer1));
    }

    @Test
    void searchNotEmptyContains() {
        stack.push(integer1);
        stack.push(integer2);
        assertEquals(0, stack.search(integer1));
    }

    @Test
    void equals() {
        testStack.push(integer1);
        stack.push(integer1);
        assertEquals(true, stack.equals(testStack));
    }

    @Test
    void sizeEmpty() {
        assertEquals(0, stack.size());
    }

    @Test
    void sizeNotEmpty() {
        stack.push(integer1);
        assertEquals(1, stack.size());
    }
}