package linkedList;

import iterator.Iterator;


class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> currentNode;
    private final LinkedList<T> linkedList;
    private int count;

    LinkedListIterator(Node<T> head, LinkedList<T> linkedList) {
        currentNode = head;
        this.linkedList = linkedList;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count <= linkedList.size() - 1;
    }

    @Override
    public T next() {
        T currentValue = currentNode.value;
        currentNode = currentNode.next;
        count++;
        return currentValue;
    }
}
