package linkedList;

import iterator.Iterator;


class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> head;

    LinkedListIterator(Node<T> head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head.next != null;
    }

    @Override
    public Object next() {
        head = head.next;
        return head;
    }
}
