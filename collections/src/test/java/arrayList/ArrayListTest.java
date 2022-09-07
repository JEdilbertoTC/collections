package arrayList;

import iterator.Iterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    @Test
    public void givenAnEmptyList_whenSize_thenZeroIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        int size = arrayList.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(0);

    }

    @Test
    public void givenAListWithTwoElements_whenSize_thenTwoIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");

        // When:
        int size = arrayList.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(2);

    }

    @Test
    public void givenAList_whenAdd_thenItemIsAdded() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        // Then:
        Assertions.assertThat(arrayList.add("element")).isTrue();

    }

    @Test
    public void givenAListWithTwentyElements_whenAdd_thenIncreasedAutomaticallyLength() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        for (int i = 0; i <= 20; i++) {
            arrayList.add("" + i);
        }

        // Then:
        Assertions.assertThat(arrayList.getCapacity()).isEqualTo(30);
        for (int i = 0; i < arrayList.size(); i++) {
            Assertions.assertThat(arrayList.getAt(i)).isEqualTo("" + i);
        }
    }

    @Test
    public void givenAWrongIndex_whenRemove_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.remove(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenRemove_thenItemIsRemoved() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");

        // When:
        boolean isRemoved = arrayList.remove(0);
        // Then:
        Assertions.assertThat(isRemoved).isTrue();
    }

    @Test
    public void givenAWrongIndex_whenGetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.getAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenGetAt_thenItemIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");

        // When:
        String item = arrayList.getAt(0);

        // Then:
        Assertions.assertThat(item).isEqualTo("1");
    }

    @Test
    public void givenAWrongIndex_whenSetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.setAt(-1, "1"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenSetAt_thenItemIsUpdated() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");

        // When:
        arrayList.setAt(0, "one");

        // Then:
        Assertions.assertThat(arrayList.getAt(0)).isEqualTo("one");
    }

    @Test
    public void givenAnElementThatIsNotInTheList_whenContains_thenFalseIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        boolean isContained = arrayList.contains("one");

        // Then:
        Assertions.assertThat(isContained).isFalse();
    }

    @Test
    public void givenAnElementThatIsInTheList_whenContains_thenTrueIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("one");

        // When:
        boolean isContained = arrayList.contains("one");

        // Then:
        Assertions.assertThat(isContained).isTrue();
    }

    @Test
    public void whenIterator_thenIteratorIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        Iterator<String> iterator = arrayList.iterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void whenAnArrayListWithTwoElements_thenIteratorIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");

        // When:
        Iterator<String> iterator = arrayList.iterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(arrayList.size()).isEqualTo(2);

        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("1");

        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("2");

        Assertions.assertThat(iterator.hasNext()).isFalse();
        Assertions.assertThat(arrayList.size()).isEqualTo(2);
    }

    @Test
    public void whenReverseIterator_thenReverseIteratorIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();

        // When:
        Iterator<String> iterator = arrayList.reverseIterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    public void whenAnArrayListWithTwoElements_thenReverseIteratorIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");

        // When:
        Iterator<String> iterator = arrayList.reverseIterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(arrayList.size()).isEqualTo(2);

        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("2");

        Assertions.assertThat(iterator.hasNext()).isTrue();
        Assertions.assertThat(iterator.next()).isEqualTo("1");

        Assertions.assertThat(iterator.hasNext()).isFalse();
        Assertions.assertThat(arrayList.size()).isEqualTo(2);
    }

}
