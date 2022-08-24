package arrayList;

import iterator.Iterator;
import list.List;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        size = 0;
        capacity = 20;
        array = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean add(T element) {
        if (capacity == size) {
            capacity += 10;
            array = Arrays.copyOf(array, capacity);
        }

        array[size++] = element;
        return true;
    }

    public boolean remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);

        return true;
    }

    public T getAt(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public void setAt(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = element;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator<>(array);
    }

}
