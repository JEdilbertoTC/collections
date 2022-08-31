package linkedList;

import iterator.Iterator;
import list.List;

public class LinkedList<T> implements List<T> {

    private class ReverseIterator implements Iterator<T> {

        private Node<T> currentNode;

        private int currentIndex = size - 1;

        ReverseIterator(Node<T> tail) {
            currentNode = tail;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            T currentValue = currentNode.value;
            currentNode = currentNode.previous;
            currentIndex--;
            return currentValue;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        size = 0;
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }

        if (head.next == null) {
            head.next = newNode;
            newNode.previous = head;
            tail = newNode;
            size++;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.previous = current;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        indexOutOfBounds(index);

        if (index == size - 1) {
            return removeLast();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<T> current = head;
        int count = 0;
        boolean inserted = false;
        while (current.next != null) {
            if (index == count) {
                inserted = removeInMiddle(current);
                break;
            }

            count++;
            current = current.next;
        }
        return inserted;
    }

    @Override
    public T getAt(int index) {
        indexOutOfBounds(index);

        int count = 0;
        Node<T> aux = head;
        T value = null;

        while (aux != null) {
            if (count == index) {
                value = aux.value;
                break;
            }
            count++;
            aux = aux.next;
        }
        return value;

    }

    @Override
    public void setAt(int index, T element) {
        indexOutOfBounds(index);

        int count = 0;
        Node<T> aux = head;

        while (aux != null) {
            if (count == index) {
                aux.value = element;
                return;
            }
            count++;
            aux = aux.next;
        }
    }

    @Override
    public boolean contains(T element) {
        Node<T> aux = head;

        while (aux != null) {
            if (aux.value.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head, this);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new ReverseIterator(tail);
    }

    private void indexOutOfBounds(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean removeLast() {
        tail = tail.previous;
        tail.next = null;
        size--;
        return true;
    }

    private boolean removeFirst() {
        head = head.next;
        head.previous = null;
        size--;
        return true;
    }

    private boolean removeInMiddle(Node<T> current) {
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return true;
    }
}
