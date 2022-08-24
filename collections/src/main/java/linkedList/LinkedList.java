package linkedList;

import iterator.Iterator;
import list.List;

import java.util.ArrayList;

public class LinkedList<T> implements List<T> {

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

        tail.next = newNode;
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

        Node<T> aux = head;
        Node<T> previous = head;
        int count = 0;
        while (aux.next != null) {
            if (index == count) {
                return removeInMiddle(previous, aux);
            }

            count++;
            previous = aux;
            aux = aux.next;
        }
        return false;
    }

    @Override
    public T getAt(int index) {
        indexOutOfBounds(index);

        int count = 0;
        Node<T> aux = head;

        while (aux != null) {
            if (count == index) {
                return aux.value;
            }
            count++;
            aux = aux.next;
        }

        return null;
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
        return new LinkedListIterator<>(head);
    }

    private void indexOutOfBounds(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean removeLast() {
        tail = null;
        size--;
        return true;
    }

    private boolean removeFirst() {
        head = head.next;
        size--;
        return true;
    }

    private boolean removeInMiddle(Node<T> previous, Node<T> aux) {
        previous.next = aux.next;
        size--;
        return true;
    }
}
