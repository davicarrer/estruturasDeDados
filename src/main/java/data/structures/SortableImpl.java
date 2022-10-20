package data.structures;

public class SortableImpl<T extends Comparable<T>> implements Sortable<T>{

    @Override
    public int[] selectionSort(int[] elements) {
        int size = elements.length;
        for (int i = 0; i < size-1; i++) {
            int min = i;
            for (int j = i+1; j < size ; j++){
                if(elements[j] < elements[min])
                    min = j;
            }
            int aux = elements[min];
            elements[min] = elements[i];
            elements[i] = aux;
        }
        return elements;
    }

    @Override
    public int[] bubbleSort(int[] elements) {
        int size = elements.length;
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size-i-1); j++) {
                if(elements[j] > elements[j+1]){
                    int aux = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = aux;
                }
            }
        }
        return elements;
    }

    @Override
    public int[] mergeSort(int[] elements) {
        return new int[0];
    }

    @Override
    public int[] radixSort(int[] elements) {
        return new int[0];
    }

    @Override
    public int[] insertionSort(int[] elements) {
        return new int[0];
    }


}
