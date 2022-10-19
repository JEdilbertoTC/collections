package set.hashset;

import iterator.Iterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashSetTest {

    @Test
    public void givenAnEmptyHashSet_whenSize_thenZeroIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        int size = hashSet.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(0);
    }

    @Test
    public void givenAnHashSetWithTwoElement_whenSize_thenTwoIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        boolean element1WasAdded = hashSet.add("element1");
        boolean element2WasAdded = hashSet.add("element2");

        // When:
        int size = hashSet.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(2);
        Assertions.assertThat(element1WasAdded).isTrue();
        Assertions.assertThat(element2WasAdded).isTrue();
        Assertions.assertThat(hashSet.contains("element1")).isTrue();
        Assertions.assertThat(hashSet.contains("element2")).isTrue();
    }

    @Test
    public void givenAnEmptyHashSet_whenIsEmpty_thenTrueIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        boolean isEmpty = hashSet.isEmpty();

        // Then:
        Assertions.assertThat(isEmpty).isTrue();
    }

    @Test
    public void givenAnHashSetWithTwoElements_whenIsEmpty_thenFalseIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        boolean isEmpty = hashSet.isEmpty();

        // Then:
        Assertions.assertThat(isEmpty).isFalse();
    }

    @Test
    public void givenAnHashSetWithTwoElementsDuplicate_whenAdd_thenJustAddOneElement() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        boolean element1WasAdded = hashSet.add("element1");
        boolean element2WasAdded = hashSet.add("element1");

        // Then:
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(element1WasAdded).isTrue();
        Assertions.assertThat(element2WasAdded).isFalse();
        Assertions.assertThat(hashSet.contains("element1")).isTrue();
    }

    @Test
    public void givenAnEmptyHashSet_whenContains_thenFalseIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        boolean contains = hashSet.contains("element1");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(0);
        Assertions.assertThat(contains).isFalse();
    }

    @Test
    public void givenAnHashSetWithOneCoincidence_whenContains_thenTrueIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        boolean contains = hashSet.contains("element1");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(2);
        Assertions.assertThat(contains).isTrue();
    }

    @Test
    public void givenAnEmptyHashSet_whenClear_thenSizeIsZero() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        hashSet.clear();

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(0);
    }

    @Test
    public void givenAnHashSetWithTwoElements_whenClear_thenSizeIsZero() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        hashSet.clear();

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(0);
        Assertions.assertThat(hashSet.contains("element1")).isFalse();
        Assertions.assertThat(hashSet.contains("element2")).isFalse();
    }

    @Test
    public void givenAnHashSetWithTwoElements_whenRemoveLastElement_thenRemoveAndReturnTrueElement() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        boolean wasRemoved = hashSet.remove("element2");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(wasRemoved).isTrue();
        Assertions.assertThat(hashSet.contains("element1")).isTrue();
        Assertions.assertThat(hashSet.contains("element2")).isFalse();
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnHashSetWithTwoElements_whenRemoveFirstElement_thenRemoveAndReturnTrueElement() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        boolean wasRemoved = hashSet.remove("element1");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(wasRemoved).isTrue();
        Assertions.assertThat(hashSet.contains("element1")).isFalse();
        Assertions.assertThat(hashSet.contains("element2")).isTrue();
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnHashSetWithTwoElements_whenRemove_thenRemoveAndReturnFalseElement() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");
        hashSet.add("element2");

        // When:
        boolean wasRemoved = hashSet.remove("element3");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(2);
        Assertions.assertThat(wasRemoved).isFalse();
        Assertions.assertThat(hashSet.contains("element1")).isTrue();
        Assertions.assertThat(hashSet.contains("element2")).isTrue();
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnHashSetWithManyElements_whenAdd_thenDistributeElementsIntoBuckets() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        for (int i = 0; i < 100; i++) {
            hashSet.add("element" + i);
        }

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(100);
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
        for (int i = 0; i < 100; i++) {
            hashSet.contains("element" + i);
        }
    }

    @Test
    public void givenAnHashSetWithOneElementAfterClear_whenAddAndClear_thenCheckBuckets() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            hashSet.add("element" + i);
        }

        // When:
        hashSet.clear();
        hashSet.add("element1");

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnHashSetWithOne_whenIterator_thenIteratorIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("element1");

        // When:
        Iterator<String> iterator = hashSet.iterator();

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(1);
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("element1");
    }

    @Test
    public void givenAnHashSetWithOneHundredElements_whenIterator_thenIteratorIsReturned() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            hashSet.add("element" + i);
        }

        // When:
        Iterator<String> iterator = hashSet.iterator();

        // Then:
        Assertions.assertThat(hashSet.size()).isEqualTo(100);
        Assertions.assertThat(hashSet.isEmpty()).isFalse();
        Assertions.assertThat(iterator).isNotNull();
        int count = 0;
        int index = 0;
        while (iterator.hasNext()) {
            String s = "element" + index;
            if (iterator.next().equals(s)) {
                count++;
            }
            index++;
        }
        Assertions.assertThat(count).isNotEqualTo(hashSet.size());
    }
}
