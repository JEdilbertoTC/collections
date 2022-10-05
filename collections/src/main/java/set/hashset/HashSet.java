package set.hashset;

import iterator.Iterator;
import list.arraylist.ArrayList;
import list.linkedlist.LinkedList;
import set.Set;

public class HashSet<T> implements Set<T> {
    private ArrayList<LinkedList<T>> buckets;
    private int size;
    private int numberOfBuckets;

    public HashSet() {
        numberOfBuckets = 3;
        size = 0;
        this.buckets = generateBuckets();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T element) {
        LinkedList<T> chosenBucket = chooseBucket(element);

        return chosenBucket.contains(element);
    }

    @Override
    public boolean add(T element) {
        int MAXIMUM_LENGTH = 5;
        LinkedList<T> chosenBucket = chooseBucket(element);

        if (chosenBucket.size() >= MAXIMUM_LENGTH) {
            distributeInBuckets();
        }

        if (chosenBucket.contains(element)) {
            return false;
        }

        chosenBucket.add(element);
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        LinkedList<T> chosenBucket = chooseBucket(element);

        if (!chosenBucket.contains(element)) {
            return false;
        }

        chosenBucket.remove(element);
        size--;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.getAt(i).clear();
        }

        numberOfBuckets = 3;
        buckets = generateBuckets();

        size = 0;
    }

    private ArrayList<LinkedList<T>> generateBuckets() {
        ArrayList<LinkedList<T>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new LinkedList<>());
        }
        return buckets;
    }

    private LinkedList<T> chooseBucket(T element) {
        int hashCode = element.hashCode();
        int chosenBucket = Math.floorMod(hashCode, buckets.size());
        return buckets.getAt(chosenBucket);
    }

    private LinkedList<T> chooseBucket(T element, ArrayList<LinkedList<T>> buckets) {
        int hashCode = element.hashCode();
        int chosenBucket = Math.floorMod(hashCode, buckets.size());
        return buckets.getAt(chosenBucket);
    }

    private void distributeInBuckets() {
        numberOfBuckets += 3;
        ArrayList<LinkedList<T>> newBuckets = generateBuckets();

        for (int i = 0; i < buckets.size(); i++) {
            Iterator<T> iterator = buckets.getAt(i).iterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
                LinkedList<T> chosenBucket = chooseBucket(element, newBuckets);
                chosenBucket.add(element);
            }
        }
        buckets = newBuckets;
    }
}
