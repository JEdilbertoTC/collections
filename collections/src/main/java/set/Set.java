package set;

public interface Set<T> {
    int size();

    boolean isEmpty();

    boolean contains(T o);

    boolean add(T o);

    boolean remove(T o);

    void clear();
}