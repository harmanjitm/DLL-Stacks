package utility;

import java.io.Serializable;

public interface StackADT<E> extends Serializable
{
    public E peek();

    public E pop();

    public E push(E toPush);

    public boolean isEmpty();

    public int find(E toFind);
}
