package com.sort.main;

public class SortingAlgorithms {

    private static int data[] = {64, 34, 25, 12, 22, 11, 90, 15, 12, 18, 88, 77, 7, 1, 3, 2, 0, 5, 4, 6}; 

    public static void main(String[] args) {
		System.out.println("original array: ");
		print();
		System.out.println("----------------------------");
    }

    public void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
					data[j] = data[j] ^ data[j + 1];
					data[j + 1] = data[j] ^ data[j + 1];
					data[j] = data[j] ^ data[j + 1];
                }
            }
        }
    }

	public void RadixSort(int[] data) {
		int max = getMax(data);
		for (int exp = 1; max / exp > 0; exp *= 10) 
			countingSort(data, exp);
	}


	private void countingSort(int[] data, int exp) {
		int[] output = new int[data.length];
		int[] count = new int[10]; 

		for (int i = 0; i < 10; i++) 
			count[i] = 0;

		for (int i = 0; i < data.length; i++) {
			int digit = (data[i] / exp) % 10;
			count[digit]++;
		}

		for (int i = 1; i < 10; i++) 
			count[i] += count[i - 1];

		for (int i = data.length - 1; i >= 0; i--) {
			int digit = (data[i] / exp) % 10;
			output[count[digit] - 1] = data[i];
			count[digit]--;
		}
		System.arraycopy(output, 0, data, 0, data.length);
	}

	public void CountingSort(int[] data) {
		int max = getMax(data);
		int[] output = new int[data.length];
		int[] count = new int[max + 1];

		for(int i = 0; i < count.length; i++) 
				count[i] = 0;

		for (int i = 0; i < data.length; i++) 
			count[data[i]]++;

		for (int i = 1; i < count.length; i++) 
			count[i] += count[i - 1];

		for (int i = data.length - 1; i >= 0; i--) {
			int num = data[i];
			output[count[num] - 1] = num;
			count[num]--;
		}
		System.arraycopy(output, 0, data, 0, data.length);

	}

	public void SelectionSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < data.length; j++) 
				if (data[j] < data[minIndex]) 
					minIndex = j;
			if (minIndex != i) {
				data[i] = data[i] ^ data[minIndex];
				data[minIndex] = data[i] ^ data[minIndex];
				data[i] = data[i] ^ data[minIndex];
			}
		}
	}

	public void InsertionSort(int[] data) {
			for (int i = 1; i < data.length; ++i) {
				int key = data[i];
					int j = i - 1;
					while (j >= 0 && data[j] > key) {
						data[j + 1] = data[j];
							j = j - 1;
					}
				data[j + 1] = key;
			}
	}

	private int getMax(int data[]) {
		int max = data[0]; 
		for (int num : data) {
			if (num > max) 
				max = num;
		}
		return max;
	}

	public void QuickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
				QuickSort(array, low, pivotIndex - 1);
				QuickSort(array, pivotIndex + 1, high);
		}
	}
	
		public int partition(int[] array, int low, int high) {
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

	public static void print() {
		for (int i = 0; i < data.length; i++) 
			System.out.print(data[i] + " ");

		System.out.println(); 
	}

}
