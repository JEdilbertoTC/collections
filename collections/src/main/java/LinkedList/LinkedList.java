package LinkedList;

import List.List;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean add(T element) {

        if (tail == null) {
            Node<T> newNode = new Node<>(element);
            tail = newNode;
            head = newNode;
            size++;

            return true;
        }

        Node<T> newNode = new Node<>(element);
        head.setNext(newNode);
        head = newNode;
        size++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            tail = tail.getNext();
            size--;
            return true;
        }

        if (index == size - 1) {
            Node<T> aux = tail;

            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            head = aux;
            head.setNext(null);
            size--;
            return true;
        }

        Node<T> aux = tail;
        Node<T> prev = tail;
        int count = 0;

        while (aux.getNext().getNext() != null) {
            if(count == index) {
                 break;
            }
            count++;
            prev = aux;
            aux = aux.getNext();
        }

        prev.setNext(aux.getNext());
        size--;

        return true;
    }

    @Override
    public T getAt(int index) {
        int count = 0;
        Node<T> aux = tail;

        while (aux != null) {
            if (count == index) {
                return aux.getValue();
            }
            count++;
            aux = aux.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void setAt(int index, T element) {
        int count = 0;
        Node<T> aux = tail;

        while (aux != null) {
            if (count == index) {
                aux.setValue(element);
                return;
            }
            count++;
            aux = aux.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean contains(T element) {
        Node<T> aux = tail;

        while (aux != null) {
            if (aux.getValue().equals(element)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        Node<T> aux = tail;

        ArrayList<T> arrayList = new ArrayList<>();

        while (aux != null) {
            arrayList.add(aux.getValue());

            aux = aux.getNext();
        }
        return arrayList.iterator();
    }
}
