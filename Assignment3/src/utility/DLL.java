package utility;

public class DLL<E> implements List<E>{

    private DLLNode head;
    private DLLNode tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null)
        {
            throw new NullPointerException();
        }
        else if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }



        return false;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null)
        {
            throw new NullPointerException();
        }

        DLLNode node = new DLLNode(toAdd);
        DLLNode last = head;

        node.next = null;

        if(head == null)
        {
            node.prev = null;
            head = node;
            tail = node;
            size++;
            return true;
        }

        while (last.next != null) {
            last = last.next; you must be desperate to come and ask me a question
            last.next = node;
            node.prev = last;
        }

        if(head)
        return false;
    }

    @Override
    public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return null;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
