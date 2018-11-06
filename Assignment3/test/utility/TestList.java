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
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is empty
	 */
	@Test
	void testRemoveEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is not empty but doesn't contain item
	 */
	@Test
	void testRemoveNotEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is not empty but contains item being removed
	 */
	@Test
	void testRemoveNotEmptyInList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. for NullPointerException when list is empty
	 */
	@Test
	void testRemoveNullPointerExceptionEmpty() {
		try
		{
			list.remove(null);
			fail("NullPointerException was not caught when removing item and list is empty");
		}
		catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. for NullPointerException when list is not empty
	 */
	@Test
	void testRemoveNullPointerExceptionNotEmpty() {
		list.add(integer1);
		try
		{
			list.remove(null);
			fail("NullPointerException was not caught when removing item and list is not empty");
		}
		catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the first index
	 */
	@Test
	void testSetFirst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the middle index
	 */
	@Test
	void testSetMiddle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the last value
	 */
	@Test
	void testSetLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the value when list is empty
	 */
	@Test
	void testSetEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}.when setting a value to null
	 */
	@Test
	void testSetValueNullPointerException() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}.when setting a null index
	 */
	@Test
	void testSetIndexNullPointerException() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is less than 0
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionLow() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is greater than size
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionHigh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is equal to size
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionEqual() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#isEmpty()}. when the list is empty
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#isEmpty()}. when the list is not empty
	 */
	@Test
	void testIsEmptyNotEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking an empty list
	 */
	@Test
	void testContainsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking a non empty list but value is there
	 */
	@Test
	void testContainsNotEmptyExists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking for a null value
	 */
	@Test
	void testContainsNullPointerException() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking a non empty list but value isn't there
	 */
	@Test
	void testContainsNotEmptyNotExists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for ToArray. when the specified array is empty
	 */
	@Test
	void testToArrayArrayEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for ToArray. when specified array is not empty
	 */
	@Test
	void testToArrayArrayNotEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for ToArray. when specified array is null
	 */
	@Test
	void testToArrayArrayNullPointerException() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for ToArray. when the total size is greater than max size of initial array
	 */
	@Test
	void testToArrayArraySizeTooBig() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#toArray()}. when the list is empty
	 */
	@Test
	void testToArrayEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#toArray()}. when the list is not empty
	 */
	@Test
	void testToArrayNotEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#iterator()}. when list is empty
	 */
	@Test
	void testIteratorEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utility.MyArrayList#iterator()}. when list is not empty
	 */
	@Test
	void testIteratorNotEmpty() {
		fail("Not yet implemented");
	}

}
