package su.arlet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSorterTest {
    private final MergeSorter sorter = new MergeSorter();

    @Test
    void sortNullArray() {
        int[] a = null;

        int[] expectedResult = null;

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortEmptyArray() {
        int[] a = {};

        int[] expectedResult = {};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortOneElementArray() {
        int[] a = {666};

        int[] expectedResult = {666};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortEvenCountElementsArray() {
        int[] a = {5, 2, 7, 25, 1, 4};

        int[] expectedResult = {1, 2, 4, 5, 7, 25};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortOddCountElementsArray() {
        int[] a = {5, 2, 7, 1, 4};

        int[] expectedResult = {1, 2, 4, 5, 7};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortDuplicateElementsArray() {
        int[] a = {2, 2, 2};

        int[] expectedResult = {2, 2, 2};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortSomeDuplicateElementsArray() {
        int[] a = {8, 2, 6, 2, 2, 1};

        int[] expectedResult = {1, 2, 2, 2, 6, 8};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortSortedArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] expectedResult = a;

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }

    @Test
    void sortReverseSortedArray() {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8};

        sorter.sort(a);

        assertArrayEquals(a, expectedResult);
    }
}