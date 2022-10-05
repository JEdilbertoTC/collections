package list.linkedlist;

import iterator.Iterator;


class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> currentNode;

    LinkedListIterator(Node<T> head) {
        currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T currentValue = currentNode.value;
        currentNode = currentNode.next;
        return currentValue;
    }
}
