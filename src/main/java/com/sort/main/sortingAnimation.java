package com.sort.main;

import java.util.ArrayList;
import java.util.List;

public class sortingAnimation {

    private List<int[]> stepsList = new ArrayList<>();

    public int[][] bubbleSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    stepsList.add(arr.clone());
                }
            }
        }
        return stepsList.toArray(new int[0][]);
    }

    public int[][] radixSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());

        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
            stepsList.add(arr.clone());
        }
        return stepsList.toArray(new int[0][]);
    }

    private void countingSort(int[] data, int exp) {
        int[] output = new int[data.length];
        int[] count = new int[10];

        for (int i = 0; i < 10; i++) count[i] = 0;
        for (int i = 0; i < data.length; i++) {
            int digit = (data[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = data.length - 1; i >= 0; i--) {
            int digit = (data[i] / exp) % 10;
            output[count[digit] - 1] = data[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, data, 0, data.length);
    }

    public int[][] selectionSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());
        
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) 
                if (arr[j] < arr[minIndex]) 
                    minIndex = j;
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                stepsList.add(arr.clone());
            }
        }
        return stepsList.toArray(new int[0][]);
    }

    public int[][] countingSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());

        int max = getMax(arr);
        int[] output = new int[arr.length];
        int[] count = new int[max + 1];

        for (int i = 0; i < count.length; i++) count[i] = 0;
        for (int i = 0; i < arr.length; i++) count[arr[i]]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num] - 1] = num;
            count[num]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
        stepsList.add(arr.clone());
        return stepsList.toArray(new int[0][]);
    }

    public int[][] insertionSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());

        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            stepsList.add(arr.clone());
        }
        return stepsList.toArray(new int[0][]);
    }

    public int[][] quickSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        stepsList.add(arr.clone());

        quickSort(arr, 0, arr.length - 1);
        return stepsList.toArray(new int[0][]);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
            stepsList.add(array.clone());
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public int[][] MergeSort(int[] data) {
        stepsList.clear();
        int[] arr = data.clone();
        mergeSort(arr);
        return stepsList.toArray(new int[0][]);
    }

    private void mergeSort(int[] data) {
        if (data.length <= 1) return;

        int mid = data.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[data.length - mid];

        System.arraycopy(data, 0, leftHalf, 0, mid);
        System.arraycopy(data, mid, rightHalf, 0, data.length - mid);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(data, leftHalf, rightHalf);
        stepsList.add(data.clone());
    }

    private void merge(int[] data, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            data[k++] = left[i++];
        }
        while (j < rightSize) {
            data[k++] = right[j++];
        }
    }

	private int getMax(int[] data) {
        int max = data[0];
        for (int num : data) {
            if (num > max) max = num;
        }
        return max;
    }
}
