/**
 * 
 */
package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 758243
 *
 */
class TestList 
{
	List<Integer> list;
	Integer integer1 = 1;
	Integer integer2 = 2;
	Integer integer3 = 3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception 
	{
		list = new MyArrayList<>();
	}

	/**
	 * Test method for {@link utility.MyArrayList#size()} when the list is empty.
	 */
	@Test
	void testSizeEmpty() 
	{
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#size()} when the list is not empty.
	 */
	@Test
	void testSizeNotEmpty() 
	{
		list.add(integer1);
		assertEquals(1, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#clear()} when the list is empty.
	 */
	@Test
	void testClearEmpty() 
	{
		list.clear();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#clear()} when the list is not empty.
	 */
	@Test
	void testClearNotEmpty() 
	{
		list.add(integer1);
		list.clear();
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} when the list is empty.
	 */
	@Test
	void testAddIntEmpty() 
	{
		assertTrue(list.add(0, integer1));
		assertEquals(1, list.size());
		assertEquals(integer1, list.get(0));
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} when the list not is empty.
	 */
	@Test
	void testAddIntNotEmptyBeginning() 
	{
		list.add(integer2);
		assertTrue(list.add(0, integer1));
		assertEquals(2, list.size());
		assertEquals(integer1, list.get(0));
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} when the list not is empty.
	 */
	@Test
	void testAddIntNotEmptyMidle() 
	{
		list.add(integer1);
		list.add(integer3);
		assertTrue(list.add(1, integer2));
		assertEquals(3, list.size());
		assertEquals(integer2, list.get(1));
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} when the list not is empty.
	 */
	@Test
	void testAddIntNotEmptyEnd() 
	{
		list.add(integer1);
		list.add(integer2);
		assertTrue(list.add(2, integer3));
		assertEquals(3, list.size());
		assertEquals(integer3, list.get(2));
	}

	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} for IndexOutOfBoundsException.
	 */
	@Test
	void testAddIntIndexOutOfBoundsLow() 
	{
		try
		{
			list.add(-1, integer1);
			fail("IndexOutOfBoundsException was not thrown");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} for IndexOutOfBoundsException.
	 */
	@Test
	void testAddIntIndexOutOfBoundsHigh() 
	{
		try
		{
			list.add(1, integer1);
			fail("IndexOutOfBoundsException was not thrown");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(java.lang.Object)} when list is empty.
	 */
	@Test
	void testAddEmpty() {
		assertTrue(list.add(integer1));
		assertEquals(1, list.size());
		assertEquals(integer1, list.get(0));
	}
	
	/**
	 * Test method for {@link utility.MyArrayList#add(java.lang.Object)} when list is not empty.
	 */
	@Test
	void testAddNotEmpty() {
		list.add(integer1);
		assertTrue(list.add(integer2));
		assertEquals(2, list.size());
		assertEquals(integer2, list.get(1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}.
	 */
	@Test
	void testAddAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for ToArray.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

}
