package arrayList;

import iterator.Iterator;

class ArrayListIterator<T> implements Iterator<T> {

    private final ArrayList<T> array;
    private int current;

    ArrayListIterator(ArrayList<T> array) {
        current = 0;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return current <= array.size() - 1;
    }

    @Override
    public T next() {
        return array.getAt(current++);
    }
}
