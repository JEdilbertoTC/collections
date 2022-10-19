package set.hashset;

import iterator.Iterator;
import list.linkedlist.LinkedList;
import set.Set;

public class HashSet<T> implements Set<T> {
    private static final int MAXIMUM_LENGTH_PER_BUCKET = 5;
    private LinkedList<T>[] buckets;
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
        LinkedList<T> chosenBucket = chooseBucket(element);

        if (chosenBucket.size() >= MAXIMUM_LENGTH_PER_BUCKET) {
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
            buckets[i].clear();
        }

        numberOfBuckets = 3;
        buckets = generateBuckets();

        size = 0;
    }

    private LinkedList<T>[] generateBuckets() {
        @SuppressWarnings("unchecked")
        LinkedList<T>[] buckets = new LinkedList<>[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        return buckets;
    }

    private LinkedList<T> chooseBucket(T element) {
        int hashCode = element.hashCode();
        int chosenBucket = Math.floorMod(hashCode, buckets.length);
        return buckets[chosenBucket];
    }

    private LinkedList<T> chooseBucket(T element, LinkedList<T>[] buckets) {
        int hashCode = element.hashCode();
        int chosenBucket = Math.floorMod(hashCode, buckets.length);
        return buckets[chosenBucket];
    }

    private void distributeInBuckets() {
        numberOfBuckets *= 2;
        LinkedList<T>[] newBuckets = generateBuckets();

        for (LinkedList<T> bucket : buckets) {
            Iterator<T> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
                LinkedList<T> chosenBucket = chooseBucket(element, newBuckets);
                chosenBucket.add(element);
            }
        }
        buckets = newBuckets;
    }
}