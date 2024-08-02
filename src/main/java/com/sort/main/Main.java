package com.sort.main;

public class Main {
    private static int data[] = {64, 34, 25, 12, 22, 11, 90, 15, 12, 18, 88, 77, 7, 1, 3, 2, 0, 5, 4, 6, 1,231,23,323,42,3423,4 ,234 ,2342, 34,34 ,234,43,53,44,34,5}; 

    public static void main(String[] args) {
		SortingAlgorithms sort = new SortingAlgorithms();
		System.out.println("original array: ");
		print();
		System.out.println("----------------------------");

		long startTimeBubble = System.nanoTime();
		System.out.println("Bubble Sort: ");
		sort.bubbleSort(data);
		long endTimeBubble = System.nanoTime(); 
		long durationBubble = endTimeBubble - startTimeBubble;
		System.out.println("time took to sort: " + (durationBubble / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print();
		System.out.println("----------------------------");

		long startTimeRadix = System.nanoTime();
		System.out.println("Radix Sort: ");
		sort.RadixSort(data);
		long endTimeRadix = System.nanoTime(); 
		long durationRadix = endTimeRadix - startTimeRadix;
		System.out.println("time took to sort: " + (durationRadix / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print();
		System.out.println("----------------------------");

		long startTimeCount = System.nanoTime();
		System.out.println("Count Sort: ");
		sort.CountingSort(data);
		long endTimeCount = System.nanoTime(); 
		long durationCount = endTimeCount - startTimeCount;
		System.out.println("time took to sort: " + (durationCount / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print();
		System.out.println("----------------------------");

		long startTimeSelection = System.nanoTime();
		System.out.println("Selection Sort: ");
		sort.SelectionSort(data);
		long endTimeSelection = System.nanoTime(); 
		long durationSelection = endTimeSelection - startTimeSelection;
		System.out.println("time took to sort: " + (durationSelection / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print();
		System.out.println("----------------------------");

		long startTimeInsertion = System.nanoTime();
		System.out.println("Insertion Sort: ");
		sort.InsertionSort(data);
		long endTimeInsertion = System.nanoTime(); 
		long durationInsertion = endTimeInsertion - startTimeInsertion;
		System.out.println("time took to sort: " + (durationInsertion / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print();
		System.out.println("----------------------------");

    }

    public static void print() {
        for (int i = 0; i < data.length; i++) 
            System.out.print(data[i] + " ");
        
        System.out.println(); 
    }

}
