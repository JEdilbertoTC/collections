package list;

import iterator.Iterator;

public interface List<T> {
    boolean add(T o);

    boolean remove(int index);

    boolean remove(T o);

    T getAt(int index);

    void clear();

    void setAt(int index, T o);

    boolean contains(T o);

    int size();

    Iterator<T> iterator();

    Iterator<T> reverseIterator();
}
