package arrayList;

import iterator.Iterator;

class ArrayListIterator<T> implements Iterator<T> {

    private final T[] array;
    private int current;

    ArrayListIterator(T[] array) {
        current = 0;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array[current + 1] != null;
    }

    @Override
    public Object next() {
        return array[current++];
    }
}
