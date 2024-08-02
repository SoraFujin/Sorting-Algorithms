package com.sort.main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	private static int data[] = {64, 34, 25, 12, 22, 11, 90, 15, 12, 18, 88, 77, 7, 1, 3, 2, 0, 5, 4, 6, 1,231,23,323,42,3423,4 ,234 ,2342, 34,34 ,234,43,53,44,34,5}; 
	private static SortingAlgorithms sort = new SortingAlgorithms();

	public static void main(String[] args) {
		userInput();
		// testing();
	}

	public static void unsort(int[] data) {
		Random random = new Random();
		for (int i = data.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}

	public static void testing() {
		System.out.println("original array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeBubble = System.nanoTime();
		System.out.println("Bubble Sort: ");
		sort.bubbleSort(data);
		long endTimeBubble = System.nanoTime(); 
		long durationBubble = endTimeBubble - startTimeBubble;
		System.out.println("time took to sort: " + (durationBubble / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeRadix = System.nanoTime();
		System.out.println("Radix Sort: ");
		sort.RadixSort(data);
		long endTimeRadix = System.nanoTime(); 
		long durationRadix = endTimeRadix - startTimeRadix;
		System.out.println("time took to sort: " + (durationRadix / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeCount = System.nanoTime();
		System.out.println("Count Sort: ");
		sort.CountingSort(data);
		long endTimeCount = System.nanoTime(); 
		long durationCount = endTimeCount - startTimeCount;
		System.out.println("time took to sort: " + (durationCount / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeSelection = System.nanoTime();
		System.out.println("Selection Sort: ");
		sort.SelectionSort(data);
		long endTimeSelection = System.nanoTime(); 
		long durationSelection = endTimeSelection - startTimeSelection;
		System.out.println("time took to sort: " + (durationSelection / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeInsertion = System.nanoTime();
		System.out.println("Insertion Sort: ");
		sort.InsertionSort(data);
		long endTimeInsertion = System.nanoTime(); 
		long durationInsertion = endTimeInsertion - startTimeInsertion;
		System.out.println("time took to sort: " + (durationInsertion / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
		unsort(data);

		long startTimeQuick = System.nanoTime();
		System.out.println("Quick Sort: ");
		sort.QuickSort(data, 0, data.length - 1);
		long endTimeQuick = System.nanoTime(); 
		long durationQuick = endTimeQuick - startTimeQuick;
		System.out.println("time took to sort: " + (durationQuick / 1000) + " micro seconds");
		System.out.print("Sorted array: ");
		print(data);
		System.out.println("----------------------------");
	}

	public static void userInput() {
		Scanner scanner = new Scanner(System.in);
		int size = 0;

		System.out.println("Enter the size of the new array: ");
		try {
			size = scanner.nextInt();
			if (size <= 0) {
				System.out.println("Array size must be a positive integer.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid integer for the array size.");
			scanner.next(); 
		}

		int[] arr = new int[size];

		System.out.println("Enter the elements:");
		try {
			for (int i = 0; i < size; i++) {
				System.out.print("Element " + (i + 1) + ": ");
				arr[i] = scanner.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter integers only!");
			scanner.next(); 
		}

		int option = 0;
		do {
			try {
				System.out.println("Choose one of the following options:");
				System.out.println("1. Bubble Sort");
				System.out.println("2. Radix Sort");
				System.out.println("3. Selection Sort");
				System.out.println("4. Count Sort");
				System.out.println("5. Insertion Sort");
				System.out.println("6. Quick Sort");
				System.out.println("7. Merge Sort");
				System.out.println("8. Exit");
				option = scanner.nextInt();

				switch (option) {
					case 1:
						long startTimeBubble = System.nanoTime();
						System.out.println("Bubble Sort: ");
						sort.bubbleSort(arr);
						long endTimeBubble = System.nanoTime();
						long durationBubble = (endTimeBubble - startTimeBubble) / 1_000; 
						System.out.println("Time taken to sort: " + durationBubble + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 2:
						long startTimeRadix = System.nanoTime();
						System.out.println("Radix Sort: ");
						sort.RadixSort(arr);
						long endTimeRadix = System.nanoTime();
						long durationRadix = (endTimeRadix - startTimeRadix) / 1_000; 
						System.out.println("Time taken to sort: " + durationRadix + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 3:
						long startTimeSelection = System.nanoTime();
						System.out.println("Selection Sort: ");
						sort.SelectionSort(arr);
						long endTimeSelection = System.nanoTime();
						long durationSelection = (endTimeSelection - startTimeSelection) / 1_000;
						System.out.println("Time taken to sort: " + durationSelection + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 4:
						long startTimeCount = System.nanoTime();
						System.out.println("Count Sort: ");
						sort.CountingSort(arr);
						long endTimeCount = System.nanoTime();
						long durationCount = (endTimeCount - startTimeCount) / 1_000; 
						System.out.println("Time taken to sort: " + durationCount + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 5:
						long startTimeInsertion = System.nanoTime();
						System.out.println("Insertion Sort: ");
						sort.InsertionSort(arr);
						long endTimeInsertion = System.nanoTime();
						long durationInsertion = (endTimeInsertion - startTimeInsertion) / 1_000;
						System.out.println("Time taken to sort: " + durationInsertion + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 6:
						long startTimeQuick = System.nanoTime();
						System.out.println("Quick Sort: ");
						sort.QuickSort(arr, 0, arr.length - 1);
						long endTimeQuick = System.nanoTime();
						long durationQuick = (endTimeQuick - startTimeQuick) / 1_000; 
						System.out.println("Time taken to sort: " + durationQuick + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 7:
						long startTimeMerge = System.nanoTime();
						System.out.println("Merge Sort: ");
						sort.MergeSort(arr);
						long endTimeMerge = System.nanoTime();
						long durationMerge = (endTimeMerge - startTimeMerge) / 1_000; 
						System.out.println("Time taken to sort: " + durationMerge + " milliseconds");
						print(arr);
						System.out.println("----------------------------");
						unsort(arr);
						break;
					case 8:
						System.out.println("Exiting...");
						break;
					default:
						System.out.println("Invalid option. Please choose a valid option.");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.");
				scanner.next(); 
			}
		} while (option != 7);

		scanner.close();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " ");
		System.out.println(); 
	}

}
