package lab1.part2;

import java.util.ArrayList;
import java.util.Arrays;

public class QSort {
    private final int[] array;
    private ArrayList<Integer> indices = new ArrayList<Integer>();

    QSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        this.array = array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort() {
        while (nextSortStep());
    }

    public boolean nextSortStep() {
        if (indices.isEmpty()) {
            sort(0, array.length - 1);
            return !indices.isEmpty();
        }

        ArrayList<Integer> step = (ArrayList<Integer>) indices.clone();
        indices.clear();
        for (int i1 = 0; i1 < step.size(); i1 += 4) {
            int i = step.get(i1);
            int j = step.get(i1 + 1);
            int begin = step.get(i1 + 2);
            int end = step.get(i1 + 3);

            if (begin < j) {
                sort(begin, j);
            }

            if (i < end) {
                sort(i, end);
            }
        }

        return !indices.isEmpty();
    }

    private void sort(int begin, int end) {
        int i = begin;
        int j = end;

        int pivot = array[begin + (end - begin) / 2];

        while (i <= j) {
            while (array[i] < pivot) { i++; }
            while (array[j] > pivot) { j--; }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        indices.add(i);
        indices.add(j);
        indices.add(begin);
        indices.add(end);
    }
}
