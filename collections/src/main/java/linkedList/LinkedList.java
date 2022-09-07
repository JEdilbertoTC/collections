package linkedList;

import iterator.Iterator;
import list.List;

public class LinkedList<T> implements List<T> {

    private static class ReverseIterator<H> implements Iterator<H> {
        private Node<H> currentNode;

        ReverseIterator(Node<H> tail) {
            currentNode = tail;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public H next() {
            H currentValue = currentNode.value;
            currentNode = currentNode.previous;
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

        if (insertFirst(newNode)) return true;

        if (removeInMiddle(newNode)) return true;

        return insertLast(newNode);
    }
    @Override
    public boolean remove(int index) {
        checkIndexOutOfBounds(index);

        if (removeLast(index)) return true;

        if (removeFirst(index)) return true;

        return removeInMiddle(index);
    }

    @Override
    public T getAt(int index) {
        checkIndexOutOfBounds(index);

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
    public void setAt(int index, T element) {
        checkIndexOutOfBounds(index);

        int count = 0;
        Node<T> aux = head;

        while (aux != null) {
            if (count == index) {
                aux.value = element;
                break;
            }
            count++;
            aux = aux.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new ReverseIterator<>(tail);
    }

    private boolean removeInMiddle(Node<T> newNode) {
        if (head.next == null) {
            head.next = newNode;
            newNode.previous = head;
            tail = newNode;
            size++;
            return true;
        }
        return false;
    }

    private boolean insertLast(Node<T> newNode) {
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

    private boolean insertFirst(Node<T> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        return false;
    }

    private boolean removeFirst(int index) {
        if (index == 0) {
            head = head.next;
            head.previous = null;
            size--;
            return true;
        }
        return false;
    }

    private boolean removeLast(int index) {
        if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return true;
        }
        return false;
    }

    private boolean removeInMiddle(int index) {
        Node<T> current = head;
        int count = 0;
        boolean inserted = false;
        while (current.next != null) {
            if (index == count) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
                inserted = true;
                break;
            }

            count++;
            current = current.next;
        }
        return inserted;
    }

    private void checkIndexOutOfBounds(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds", index));
        }
    }
}
