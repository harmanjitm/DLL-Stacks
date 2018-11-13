package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Harmanjit Mohaar
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
		assertTrue(list.add(integer1));
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
		assertEquals(2,testList.size());
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
		assertEquals(0,list.size());
		assertEquals(null,list.get(0));
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get first
	 */
	@Test
	void testGetNotEmptyFirst() {
		list.add(integer1);
		list.add(integer2);
		assertEquals(integer1,list.get(0));
		assertEquals(2,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get middle
	 */
	@Test
	void testGetNotEmptyMiddle() {
		list.add(integer1);
		list.add(integer2);
		list.add(integer3);
		assertEquals(3,list.size());
		assertEquals(integer2,list.get(1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when list is not empty get last
	 */
	@Test
	void testGetNotEmptyEnd() {
		list.add(integer1);
		list.add(integer2);
		list.add(integer3);
		assertEquals(3,list.size());
		assertEquals(integer3,list.get(2));
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when the index is less than 0
	 */
	@Test
	void testGetIndexOutOfBoundsExceptionLow() {
		list.add(integer3);
		try
		{
			list.get(-1);
			fail("IndexOutOfBoundsException was not caught for getting low index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when the index is equal to the size
	 */
	@Test
	void testGetIndexOutOfBoundsExceptionEqual() {
		list.add(integer3);
		try
		{
			list.get(1);
			fail("IndexOutOfBoundsException was not caught for getting equal index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#get(int)}. when the index is greater than size
	 */
	@Test
	void testGetIndexOutOfBoundsExceptionHigh() {
		list.add(integer3);
		try
		{
			list.get(1);
			fail("IndexOutOfBoundsException was not caught for getting high index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when removing index from empty list
	 */
	@Test
	void testRemoveIntEmpty() {
		assertEquals(0,list.size());
		try{
			list.remove(0);
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when removing first item from non empty list
	 */
	@Test
	void testRemoveIntNotEmptyFirst() {
		list.add(integer3);
		list.add(integer2);
		assertEquals(integer3,list.remove(0));
		assertEquals(1,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when removing middle item from non empty list
	 */
	@Test
	void testRemoveIntNotEmptyMiddle() {
		list.add(integer1);
		list.add(integer2);
		list.add(integer3);
		assertEquals(3,list.size());
		assertEquals(integer2,list.remove(1));
		assertEquals(2,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when removing last item from non empty list
	 */
	@Test
	void testRemoveIntNotEmptyEnd() {
		list.add(integer1);
		list.add(integer2);
		list.add(integer3);
		assertEquals(3,list.size());
		assertEquals(integer3,list.remove(2));
		assertEquals(2,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when  removing item that is less than 0
	 */
	@Test
	void testRemoveIntIndexOutOfBoundsExceptionLow() {
		list.add(integer1);
		try
		{
			list.remove(-1);
			fail("IndexOutOfBoundsException was not thrown for removing less than a 0 index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when  removing item that is equal to size
	 */
	@Test
	void testRemoveIntIndexOutOfBoundsExceptionEqual() {
		try
		{
			list.remove(0);
			fail("IndexOutOfBoundsException was not thrown for removing index that is equal to size");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(int)}. when  removing item that is greater than size
	 */
	@Test
	void testRemoveIntIndexOutOfBoundsExceptionHigh() {
		try
		{
			list.remove(1);
			fail("IndexOutOfBoundsException was not thrown for removing an index greater than size");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is empty
	 */
	@Test
	void testRemoveEmpty() {
		assertEquals(null,list.remove(integer1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is not empty but doesn't contain item
	 */
	@Test
	void testRemoveNotEmpty() {
		list.add(integer3);
		assertEquals(null,list.remove(integer1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#remove(java.lang.Object)}. when list is not empty but contains item being removed
	 */
	@Test
	void testRemoveNotEmptyInList() {
		list.add(integer1);//size becomes 1
		assertEquals(integer1,list.remove(integer1));//size decreases
		assertEquals(0,list.size());//size becomes 0
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
		list.add(integer3);
		assertEquals(integer3, list.set(0, integer1));
		assertEquals(integer1, list.get(0));
		assertEquals(1, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the middle index
	 */
	@Test
	void testSetMiddle() {
		list.add(integer3);
		list.add(integer2);
		list.add(integer1);
		assertEquals(integer2, list.set(1, integer1));
		assertEquals(integer1, list.get(1));
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the last value
	 */
	@Test
	void testSetLast() {
		list.add(integer3);
		list.add(integer2);
		list.add(integer1);
		assertEquals(integer1, list.set(2, integer3));
		assertEquals(integer3, list.get(2));
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. set the value when list is empty
	 */
	@Test
	void testSetEmpty() {
		assertEquals(0,list.size());
		try{
			list.set(0,integer1);
			fail("IndexOutOfBoundsException not caught when setting index of 0 in empty list.");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}.when setting a value to null
	 */
	@Test
	void testSetValueNullPointerException() {
		list.add(integer1);
		try
		{
			list.set(0,null);
			fail("NullPointerException was not caught when setting a null value");
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is less than 0
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionLow() {
		list.add(integer1);
		try
		{
			list.set(-1,integer1);
			fail("IndexOutOfBoundsException was not caught for a low value setting an index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is greater than size
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionHigh() {
		list.add(integer1);
		try
		{
			list.set(2,integer1);
			fail("IndexOutOfBoundsException was not caught for a high value setting an index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#set(int, java.lang.Object)}. when index is equal to size
	 */
	@Test
	void testSetIndexOutOfBoundsExceptionEqual() {
		list.add(integer1);
		try
		{
			list.set(1,integer1);
			fail("IndexOutOfBoundsException was not caught for a equal value setting an index");
		}
		catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#isEmpty()}. when the list is empty
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#isEmpty()}. when the list is not empty
	 */
	@Test
	void testIsEmptyNotEmpty() {
		list.add(integer1);
		assertEquals(false,list.isEmpty());
		assertEquals(1,list.size());
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking an empty list
	 */
	@Test
	void testContainsEmpty() {
		assertEquals(0,list.size());
		assertEquals(false,list.contains(integer1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking a non empty list but value is there
	 */
	@Test
	void testContainsNotEmptyExists() {
		list.add(integer1);
		assertEquals(1,list.size());
		assertEquals(true,list.contains(integer1));
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking for a null value
	 */
	@Test
	void testContainsNullPointerException() {
		list.add(integer1);
		try
		{
			list.contains(null);
			fail("NullPointerException not caught for checking if list contains null value");
		}
		catch (NullPointerException e)
		{
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utility.MyArrayList#contains(java.lang.Object)}. when checking a non empty list but value isn't there
	 */
	@Test
	void testContainsNotEmptyNotExists() {
		list.add(integer1);
		assertEquals(1,list.size());
		assertEquals(false,list.contains(integer2));
	}
}
