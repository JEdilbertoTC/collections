package ArrayList;

import List.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements List<T> {

    private final Object[] array;
    private int size;
    private int length;

    public ArrayList() {
        size = 0;
        length = 20;
        array = new Object[length];
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean add(T element) {

        if (length == size) {
            length += 10;
        }

        array[size++] = element;
        return true;
    }

    public boolean remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);

        return true;
    }

    public T getAt(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return (T) array[index];
    }

    public void setAt(int index, T element) {
        if (index > size || index < 0) {
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
        return (Iterator<T>) Arrays.stream(array).iterator();
    }

}
