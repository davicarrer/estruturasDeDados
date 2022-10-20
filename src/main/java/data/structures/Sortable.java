package data.structures;

public interface Sortable<T extends Comparable<T>> {

    int[] selectionSort(int[] elements);
    int[] bubbleSort(int[] elements);
    int[] mergeSort(int[] elements);
    int[] radixSort(int[] elements);
    int[] insertionSort(int[] elements);
}
