package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 758243
 *
 */
@SuppressWarnings("JavaDoc")
class TestList
{
	private List<Integer> list;
	private List<Integer> testList;
	private Integer integer1 = 1;
	private Integer integer2 = 2;
	private Integer integer3 = 3;
	
	/**
	 */
	@BeforeEach
	void setUp() {
		list = new MyArrayList<>();
		testList = new MyArrayList<>();
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
	void testClearEmptyList()
	{
		list.clear();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#clear()} when the list is not empty.
	 */
	@Test
	void testClearNotEmptyList()
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
	void testAddIntNotEmptyMiddle()
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
	 * Test method for {@link utility.MyArrayList#add(int, java.lang.Object)} for NullPointerException.
	 */
	@Test
	void testAddIntNullPointerException()
	{
		try
		{
			list.add(0, null);
			fail("NullPointerException was not thrown");
		}
		catch(NullPointerException e)
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
	 * Test method for {@link utility.MyArrayList#add(java.lang.Object)} for a NullPointerException.
	 */
	@Test
	void testAddNullPointerException() {
		try
		{
			list.add(null);
			fail("NullPointerException was not thrown");
		}
		catch(NullPointerException e)
		{
			assertTrue(true);
		}
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
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. when the list is empty and added list is not empty
	 */
	@Test
	void testAddAllEmptyNotEmpty() {
		testList.add(integer1);
		assertEquals(1,testList.size());
		assertTrue(list.addAll(testList));
		assertEquals(integer1,list.get(0));
		assertEquals(1,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. when the list is empty and added list is empty
	 */
	@Test
	void testAddAllEmptyEmpty() {
		assertTrue(list.addAll(testList));
		assertEquals(0,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. when the list is not empty and added list is empty
	 */
	@Test
	void testAddAllNotEmptyEmpty() {
		list.add(integer2);
		assertEquals(1,list.size());
		assertTrue(list.addAll(testList));
		assertEquals(integer2,list.get(0));
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. when the list is not empty and added list is not empty
	 */
	@Test
	void testAddAllNotEmptyNotEmpty() {
		list.add(integer1);
		testList.add(integer2);
		testList.add(integer3);
		assertEquals(1,list.size());
		assertEquals(1,testList.size());
		assertTrue(list.addAll(testList));
		assertEquals(integer3,list.get(2));
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. for NullPointerException when list is empty
	 */
	@Test
	void testAddAllNullPointerExceptionEmpty() {
		try
		{
			list.addAll(null);
			fail("NullPointerException was not caught for addAll method");
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#addAll(utility.List)}. for NullPointerException when list is not empty
	 */
	@Test
	void testAddAllNullPointerExceptionNotEmpty() {
		list.add(integer3);
		try
		{
			assertTrue(list.addAll(null));
			fail("NullPointerException was not caught for addAll method when main list is not empty");
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is empty
	 */
	@Test
	void testGetEmpty() {
		//test for getting value of an empty list
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get first
	 */
	@Test
	void testGetNotEmptyFirst() {
		//Test when getting value of a non empty list in the beginning
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get middle
	 */
	@Test
	void testGetNotEmptyMiddle() {
		//Test when getting value of a non empty list in the middle
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get last
	 */
	@Test
	void testGetNotEmptyEnd() {
		//Test when getting value of a non empty list at the end
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when the index is <0 or greater than or equal to size
	 */
	@Test
	void testGetIndexOutOfBoundsException() {
		//test to see when the list is null and throws a IndexOutOfBoundsException
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIntEmpty() {

	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIntNotEmptyFirst() {

	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIntNotEmptyMiddle() {

	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIntNotEmptyEnd() {

	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveIntIndexOutOfBoundsException() {

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
