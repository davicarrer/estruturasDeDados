package data.structures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortableTest {

    @ParameterizedTest
    @MethodSource("sortArguments")
    void sortBySelection(int[] elements, int[] expectedToBeFound) {

        Sortable<Integer> sort = new SortableImpl<>();
        assertThat(sort.selectionSort(elements)).isEqualTo(expectedToBeFound);

    }
    @ParameterizedTest
    @MethodSource("sortArguments")
    void sortByBubble(int[] elements, int[] expectedToBeFound) {

        Sortable<Integer> sort = new SortableImpl<>();
        assertThat(sort.bubbleSort(elements)).isEqualTo(expectedToBeFound);

    }
    static Stream<Arguments> sortArguments() {

        return Stream.of(
                arguments( new int[] {1,9,11,3,12,19,10,2,4,5,2,1},new int[] {1,1,2,2,3,4,5,9,10,11,12,19}),
                arguments( new int[] {5,19,2,1,5,94,1,6}, new int[] {1,1,2,5,5,6,19,94}),
                arguments( new int[] {1,2,3,4,8,20,25}, new int[] {1,2,3,4,8,20,25}),
                arguments( new int[] {2}, new int[] {2}),
                arguments( new int[] {2,6,8,1,12}, new int[]{1,2,6,8,12})
        );
    }
}
