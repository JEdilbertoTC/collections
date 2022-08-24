package ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class ArrayListTest {

    @Test
    public void givenAnEmptyList_whenSize_thenZeroIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        int size = arrayList.size();

        // Then:
        Assertions.assertThat(size).isEqualTo(0);

    }

    @Test
    public void givenAListWithTwoElements_whenSize_thenTwoIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        // Then:
        Assertions.assertThat(arrayList.add("element")).isTrue();

    }

    @Test
    public void givenALength_whenAdd_thenIncreasedAutomaticallyLength() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.setLength(1);

        // When:

        arrayList.add("1");
        arrayList.add("2");

        // Then:
        Assertions.assertThat(arrayList.getLength()).isEqualTo(11);
    }

    @Test
    public void givenAWrongIndex_whenRemove_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.remove(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenRemove_thenItemIsRemoved() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("1");

        // When:
        boolean isRemoved = arrayList.remove(0);
        // Then:
        Assertions.assertThat(isRemoved).isTrue();
    }

    @Test
    public void givenAWrongIndex_whenGetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.getAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenGetAt_thenItemIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("1");

        // When:
        String item = arrayList.getAt(0);

        // Then:
        Assertions.assertThat(item).isEqualTo("1");
    }

    @Test
    public void givenAWrongIndex_whenSetAt_thenIndexOutOfBoundsExceptionIsThrown() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        // Then:
        Assertions.assertThatThrownBy(() -> arrayList.setAt(-1, "1"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void givenACorrectIndex_whenSetAt_thenItemIsUpdated() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("1");

        // When:
        arrayList.setAt(0, "one");

        // Then:
        Assertions.assertThat(arrayList.getAt(0)).isEqualTo("one");
    }

    @Test
    public void givenAnElementThatIsNotInTheList_whenContains_thenFalseIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        boolean isContained = arrayList.contains("one");

        // Then:
        Assertions.assertThat(isContained).isFalse();
    }

    @Test
    public void givenAnElementThatIsInTheList_whenContains_thenTrueIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("one");

        // When:
        boolean isContained = arrayList.contains("one");

        // Then:
        Assertions.assertThat(isContained).isTrue();
    }

    @Test
    public void whenIterator_thenIteratorIsReturned() {
        // Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        // When:
        Iterator<String> iterator = arrayList.iterator();

        // Then:
        Assertions.assertThat(iterator).isNotNull();
        Assertions.assertThat(iterator.next()).isNull();
    }

}
