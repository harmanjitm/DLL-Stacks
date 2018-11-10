package utility;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements List<E>{

	private E[] array;
	private int size;
	private static final long serialVersionUID = -742628661200714845L;

	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		array = (E[]) new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i=0;i<size;i++)
		{
			array[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		array = (E[]) new Object[size+1];
		E[] newArray = (E[]) new Object[size+1];
		if(toAdd == null){
			throw new NullPointerException();
		}
		else if(index < 0 || index >=size)
		{
			throw new IndexOutOfBoundsException();
		}
		else {
			//if(index == 0)
			//{
			//	array[index] = toAdd;
			//	return true;
			//}

			for (int i = size; i >= 0; i--) {
				if (i == index) {
					newArray[i] = toAdd;
				} else {
					newArray[i] = array[i];
				}
				System.out.println(newArray[i]);
			}

			for (int i = 0; i < size + 1; i++) {
				array[i] = newArray[i];
			}
			size++;
			return true;
		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		array = (E[]) new Object[size+1];
		if(toAdd == null) {
			throw new NullPointerException();
		}
		else {
			array[size] = toAdd;
			size++;
		}
		return false;
	}

	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	private class ArrayBasedIterator implements Iterator<E>
	{
		private int pos;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			try
			{
				E toReturn = array[pos];
				pos++;
				return toReturn;
			}
			catch(IndexOutOfBoundsException e)
			{
				throw new NoSuchElementException();
			}
		}

	}
}
