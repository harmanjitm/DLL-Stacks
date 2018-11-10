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

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		E[] newArray = (E[]) new Object[size+1];
		if(toAdd == null){
			throw new NullPointerException();
		}
		else if(index == 0)
		{
			add(toAdd);
			return true;
		}
		else if(index < 0 || index >=size)
		{
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i = 0; i < index; i++) {
				newArray[i] = array[i];
			}

			newArray[index] = toAdd;

			for (int i = index+1; i < size+1; i++) {
				newArray[i] = array[i-1];
			}
			array = newArray;
			size++;
			return true;
		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		E[] newArray = (E[]) new Object[size+1];
		newArray = array;
		if(toAdd == null) {
			throw new NullPointerException();
		}
		else {
			newArray[size] = toAdd;
			size++;
			array = newArray;
			return true;
		}
	}

	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
		E[] newArray = (E[]) new Object[toAdd.size()+array.length];

		if(toAdd == null)
		{
			throw new NullPointerException();
		}

		for(int i=0;i<toAdd.size();i++)
		{
			if(toAdd.get(i) == null)
			{
				throw new NullPointerException();
			}
		}

		for(int i=0;i<size;i++)
		{
			newArray[i] = array[i];
		}

		for(int i=0;i<toAdd.size();i++)
		{
			newArray[size+i] = toAdd.get(i);
			size++;
		}

		array = newArray;
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index == 0)
		{
			return array[0];
		}
		else if(index < 0 || index >=size)
		{
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		E toReturn;
		if(index < 0 || index >=size)
		{
			throw new IndexOutOfBoundsException();
		}
//		E[] newArray = (E[]) new Object[size];
//		toReturn = array[index];
//		array[index] = null;
//
//		for(int i=0;i<size;i++)
//		{
//			if(array[i] != null)
//			{
//				newArray[i] = array[i];
//			}
//		}
//		array = newArray;

		for(int i=0;i<size;i++)
		{
			if(i == index)
			{
				toReturn = array[i];
				for(int j=i;j<size-1;j++)
				{
					array[j] = array[j+1];
				}
				size--;
				return toReturn;
			}
		}
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null)
		{
			throw new NullPointerException();
		}

		E toReturn;

		for(int i=0;i<size;i++) {
			if (array[i] == toRemove) {
				toReturn = array[i];
				for (int j=i;j<size-1;j++)
				{
					array[j] = array[j+1];
				}
				size--;
				return toReturn;
			}
		}
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
		if(toFind == null) {
			throw new NullPointerException();
		}

		for(int i=0;i<size;i++)
		{
			if(array[i] == toFind)
			{
				return true;
			}
		}
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
