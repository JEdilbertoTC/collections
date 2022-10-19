package set.linkedhashset;

import iterator.Iterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedHashSetTest {

    @Test
    public void givenAnEmptyLinkedHashSet_whenSize_thenZeroIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        int size = linkedHashSet.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(0);
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElement_whenSize_thenTwoIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        boolean element1WasAdded = linkedHashSet.add("element1");
        boolean element2WasAdded = linkedHashSet.add("element2");

        // When:
        int size = linkedHashSet.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(2);
        Assertions.assertThat(element1WasAdded).isTrue();
        Assertions.assertThat(element2WasAdded).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element1")).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element2")).isTrue();
    }

    @Test
    public void givenAnEmptyLinkedHashSet_whenIsEmpty_thenTrueIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        boolean isEmpty = linkedHashSet.isEmpty();

        // Then:
        Assertions.assertThat(isEmpty).isTrue();
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElements_whenIsEmpty_thenFalseIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        boolean isEmpty = linkedHashSet.isEmpty();

        // Then:
        Assertions.assertThat(isEmpty).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElementsDuplicate_whenAdd_thenJustAddOneElement() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        boolean element1WasAdded = linkedHashSet.add("element1");
        boolean element2WasAdded = linkedHashSet.add("element1");

        // Then:
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(element1WasAdded).isTrue();
        Assertions.assertThat(element2WasAdded).isFalse();
        Assertions.assertThat(linkedHashSet.contains("element1")).isTrue();
    }

    @Test
    public void givenAnEmptyLinkedHashSet_whenContains_thenFalseIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        boolean contains = linkedHashSet.contains("element1");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(0);
        Assertions.assertThat(contains).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithOneCoincidence_whenContains_thenTrueIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        boolean contains = linkedHashSet.contains("element1");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(2);
        Assertions.assertThat(contains).isTrue();
    }

    @Test
    public void givenAnEmptyLinkedHashSet_whenClear_thenSizeIsZero() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        linkedHashSet.clear();

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(0);
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElements_whenClear_thenSizeIsZero() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        linkedHashSet.clear();

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(0);
        Assertions.assertThat(linkedHashSet.contains("element1")).isFalse();
        Assertions.assertThat(linkedHashSet.contains("element2")).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElements_whenRemoveLastElement_thenRemoveAndReturnTrueElement() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        boolean wasRemoved = linkedHashSet.remove("element2");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(wasRemoved).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element1")).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element2")).isFalse();
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElements_whenRemoveFirstElement_thenRemoveAndReturnTrueElement() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        boolean wasRemoved = linkedHashSet.remove("element1");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(wasRemoved).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element1")).isFalse();
        Assertions.assertThat(linkedHashSet.contains("element2")).isTrue();
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithTwoElements_whenRemove_thenRemoveAndReturnFalseElement() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");
        linkedHashSet.add("element2");

        // When:
        boolean wasRemoved = linkedHashSet.remove("element3");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(2);
        Assertions.assertThat(wasRemoved).isFalse();
        Assertions.assertThat(linkedHashSet.contains("element1")).isTrue();
        Assertions.assertThat(linkedHashSet.contains("element2")).isTrue();
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithManyElements_whenAdd_thenDistributeElementsIntoBuckets() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // When:
        for (int i = 0; i < 100; i++) {
            linkedHashSet.add("element" + i);
        }

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(100);
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
        for (int i = 0; i < 100; i++) {
            linkedHashSet.contains("element" + i);
        }
    }

    @Test
    public void givenAnLinkedHashSetWithOneElementAfterClear_whenAddAndClear_thenCheckBuckets() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            linkedHashSet.add("element" + i);
        }

        // When:
        linkedHashSet.clear();
        linkedHashSet.add("element1");

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
    }

    @Test
    public void givenAnLinkedHashSetWithOne_whenIterator_thenIteratorIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("element1");

        // When:
        Iterator<String> iterator = linkedHashSet.iterator();

        // Then:
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(1);
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("element1");
    }

    @Test
    public void givenAnLinkedHashSetWithOneHundredElements_whenIterator_thenIteratorIsReturned() {
        // Given:
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            linkedHashSet.add("element" + i);
        }

        // When:
        Iterator<String> iterator = linkedHashSet.iterator();

        // Then:
        Assertions.assertThat(linkedHashSet.isEmpty()).isFalse();
        Assertions.assertThat(linkedHashSet.size()).isEqualTo(100);
        Assertions.assertThat(iterator).isNotNull();
        int index = 0;
        while (iterator.hasNext()) {
            String s = "element" + index++;
            Assertions.assertThat(iterator.next()).isEqualTo(s);
        }
    }
}
