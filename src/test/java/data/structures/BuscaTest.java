package data.structures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.Vector;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BuscaTest {

    @ParameterizedTest
    @MethodSource("sequentialSearchArguments")
    void sequentialSearch(Integer[] elements, int numberToBeFind, int expectedToBeFound) {

        Busca<Integer> busca = new BuscaImpl<>();
        assertThat(busca.buscaSequencial(elements, numberToBeFind)).isEqualTo(expectedToBeFound);

    }
    static Stream<Arguments> sequentialSearchArguments() {

        return Stream.of(
                arguments( new Integer[] {1,9,11,3,12,19,10,2,4,5,2,1}, 5, 9),
                arguments( new Integer[] {1,9,11,3,12,19,10,2,4,5,2,1}, 8, -1),
                arguments( new Integer[] {5,19,2,1,5,94,1,6}, 0, -1),
                arguments( new Integer[] {5,19,2,1,5,94,1,6}, 6, 7),
                arguments( new Integer[] {2}, 1, -1),
                arguments( new Integer[] {2,6,8}, 2, 0),
                arguments( new Integer[] {2,6,8}, 8, 2),
                arguments( new Integer[] {2,6,8}, 4, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("binarySearchArguments")
    void binarySearch(Integer[] elements, int numberToBeFind, int expectedToBeFound) {

        Busca<Integer> busca = new BuscaImpl<>();
        assertThat(busca.buscaSequencial(elements, numberToBeFind)).isEqualTo(expectedToBeFound);

    }
    static Stream<Arguments> binarySearchArguments() {

        return Stream.of(
                arguments( new Integer[] {1,3,5,6,8,10,11,12,13,16,19,20}, 5, 2),
                arguments( new Integer[] {1,3,5,6,8,10,11,12,13,16,19,20}, 19, 10),
                arguments( new Integer[] {1,3,5,6,8,10,11,12,13,16,19,20}, 4, -1),
                arguments( new Integer[] {5,6,8,11,15,16,18,19,20}, 0, -1),
                arguments( new Integer[] {5,6,8,11,15,16,18,19,20}, 19, 7),
                arguments( new Integer[] {5,6,8,11,15,16,18,19,20}, 8, 2),
                arguments( new Integer[] {2}, 1, -1),
                arguments( new Integer[] {2}, 2, 0),
                arguments( new Integer[] {2,6,8}, 2, 0),
                arguments( new Integer[] {2,6,8}, 8, 2),
                arguments( new Integer[] {2,6,8}, 4, -1)
        );
    }

    private static int random() {
        return new Random().nextInt();
    }

    private static int random(int limit) {
        var number = 0;
        while (number == 0) {
            number = new Random().nextInt(limit+1);
        }
        return number;
    }
}
