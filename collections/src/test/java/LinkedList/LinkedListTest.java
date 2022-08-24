package LinkedList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class LinkedListTest {

    @Test
    public void givenAnEmptyList_whenSize_thenZeroIsReturned() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // When:

        int size = linkedList.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(0);
    }

    @Test
    public void givenAListWithTwoElements_whenSize_thenTwoIsReturned() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);

        // When:
        int size = linkedList.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(2);
    }

    @Test
    public void givenAWrongIndex_whenRemove_thenIndexOutOfBoundsException() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> linkedList.remove(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenAZeroIndex_whenRemove_thenFirstItemIsRemoved() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // When:
        linkedList.remove(0);

        // Then:
        Assertions.assertThat(linkedList.size()).isEqualTo(2);
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(2);
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(3);
    }

    @Test
    public void givenALastIndex_whenRemove_thenLastItemIsRemoved() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        int lastIndex = linkedList.size() - 1;

        // When:
        linkedList.remove(lastIndex);

        // Then:
        Assertions.assertThat(linkedList.size()).isEqualTo(2);
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(2);
    }

    @Test
    public void givenAMiddleIndexWithAListWithThreeElements_whenRemove_thenItemIsRemoved() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // When:
        linkedList.remove(1);

        // Then:
        Assertions.assertThat(linkedList.size()).isEqualTo(2);
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(3);
    }

    @Test
    public void givenATwoIndexWithAListWithFourElements_whenRemove_thenItemIsRemoved() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        // When:
        linkedList.remove(2);

        // Then:
        Assertions.assertThat(linkedList.size()).isEqualTo(3);
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(2);
        Assertions.assertThat(linkedList.getAt(2)).isEqualTo(4);
    }

    @Test
    public void givenIndexOneWithAListWithFourElements_whenRemove_thenItemIsRemoved() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        // When:
        linkedList.remove(1);

        // Then:
        Assertions.assertThat(linkedList.size()).isEqualTo(3);
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(3);
        Assertions.assertThat(linkedList.getAt(2)).isEqualTo(4);
    }

    @Test
    public void givenAListWithOutElements_whenGetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> linkedList.getAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenAListWithOneElement_whenGetAt_thenElementIsReturned() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);

        // When:
        Integer found = linkedList.getAt(0);

        // Then:
        Assertions.assertThat(found).isEqualTo(1);
    }

    @Test
    public void givenAListWithoutElements_whenSetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> linkedList.setAt(0, 1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenAListWithOneElement_whenSetAt_thenFindElementAndUpdate() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);

        // When:

        linkedList.setAt(0, 0);
        // Then:
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(0);
    }

    @Test
    public void givenAListWithTwoElements_whenSetAt_thenFindElementAndUpdate() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);

        // When:

        linkedList.setAt(1, 0);
        // Then:
        Assertions.assertThat(linkedList.getAt(1)).isEqualTo(0);
    }

    @Test
    public void givenAListWithTwoElements_whenContains_thenFindAndReturnTrue() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);

        // When:
        boolean isContained = linkedList.contains(1);

        // Then:
        Assertions.assertThat(isContained).isTrue();
    }

    @Test
    public void givenAListWithTwoElements_whenContains_thenFindAndReturnFalse() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);

        // When:
        boolean isContained = linkedList.contains(3);

        // Then:
        Assertions.assertThat(isContained).isFalse();
    }

    @Test
    public void whenIterator_thenIteratorIsReturned() {
        // Given:
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);

        // When:
        Iterator<Integer> iterator = linkedList.iterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
    }
}
