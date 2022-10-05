package list.linkedlist;

class Node<T> {
    T value;
    Node<T> next;

    Node<T> previous;

    Node(T value) {
        this.value = value;
        next = null;
    }
}
