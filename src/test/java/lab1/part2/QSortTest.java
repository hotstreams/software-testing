package lab1.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QSortTest {
    private QSort sorter;

    @Test
    public void testSortIterations() {
        final int[] array = new int[] {3, 7, 8, 5, 2, 1, 9, 5, 4};
        sorter = new QSort(array);

        sorter.nextSortStep();
        assertArrayEquals(array, new int[] {1, 2, 8, 5, 7, 3, 9, 5, 4});

        sorter.nextSortStep();
        assertArrayEquals(array, new int[] {1, 2, 3, 5, 7, 8, 9, 5, 4});

        sorter.nextSortStep();
        assertArrayEquals(array, new int[] {1, 2, 3, 5, 7, 4, 5, 9, 8});

        sorter.nextSortStep();
        assertArrayEquals(array, new int[] {1, 2, 3, 5, 5, 4, 7, 8, 9});

        sorter.nextSortStep();
        assertArrayEquals(array, new int[] {1, 2, 3, 4, 5, 5, 7, 8, 9});
    }

    @Test
    public void testSorted() {
        int[] expected = new int[] {4, 8, 15, 16, 23, 42};
        int[] actual = new int[] {4, 8, 15, 16, 23, 42};
        sorter = new QSort(expected);

        sorter.nextSortStep();
        assertArrayEquals(expected, actual);

        sorter.nextSortStep();
        assertArrayEquals(expected, actual);

        sorter.sort();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBackwards() {
        int[] expected = new int[] {42, 23, 16, 15, 8, 4};
        int[] actual = new int[] {4, 8, 15, 16, 23, 42};
        sorter = new QSort(expected);

        sorter.nextSortStep();
        assertArrayEquals(expected, actual);
    }
}
