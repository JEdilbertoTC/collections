package set.linkedhashset;

import iterator.Iterator;
import list.linkedlist.LinkedList;
import set.hashset.HashSet;

public class LinkedHashSet<T> extends HashSet<T> {
    @Override
    protected void distributeInBuckets() {
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
