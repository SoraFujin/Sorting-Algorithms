Sorting Algorithms
Welcome to the Sorting Algorithms repository! This repository contains a collection of various sorting algorithms implemented in Java. Each sorting algorithm is designed to demonstrate different approaches to sorting data, showcasing their functionalities and performance characteristics.

### Table of Contents
#### [Overview](#overview)
#### [Algorithms](#algorithms)
#### [Usage](#usage)
### [Features](#features)
#### [Contributing](#contributing)

## Overview
This repository provides Java implementations for a variety of sorting algorithms. The purpose of this project is to demonstrate the different sorting techniques and their efficiencies. The algorithms included in this repository are:

1. **Bubble Sort**
2. **Radix Sort**
3. **Selection Sort**
4. **Counting Sort**
5. **Insertion Sort**
6. **Quick Sort**

## Algorithms:

1. **Bubble Sort**
Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.

2. **Radix Sort**
Radix Sort is a non-comparative sorting algorithm. It sorts numbers by processing individual digits. The algorithm processes each digit of the numbers, starting from the least significant digit to the most significant digit.

3. **Selection Sort**
Selection Sort is a comparison-based sorting algorithm. It works by repeatedly finding the minimum element (or maximum, depending on sorting order) from the unsorted portion and moving it to the beginning.

4. **Counting Sort**
Counting Sort is a non-comparative sorting algorithm that counts the occurrences of each element in the input array. It then uses this count to place elements in their correct position in the sorted array.

5. **Insertion Sort**
Insertion Sort is a comparison-based sorting algorithm. It builds the final sorted array one item at a time by repeatedly picking the next item and inserting it into its correct position.

6. **Quick Sort**
Quick Sort is a divide-and-conquer sorting algorithm. It works by selecting a 'pivot' element and partitioning the array into two sub-arrays, which are then sorted recursively.

## Usage
To use any of the sorting algorithms, you can run the Main class which provides a menu to choose the sorting algorithm you want to execute. Here’s a quick guide on how to run the program:

# Sorting Algorithms Visualizer

Welcome to the Sorting Algorithms Visualizer! This project is a graphical user interface (GUI) tool that visualizes various sorting algorithms. It provides an interactive way to see how different sorting algorithms work by animating the sorting process.

## Features

- Visualize sorting algorithms: Bubble Sort, Radix Sort, Selection Sort, Counting Sort, Insertion Sort, Quick Sort, Merge Sort
- Dynamic array generation
- Step-by-step animation of sorting algorithms
- Interactive GUI with options to generate new arrays and clear the current visualization

## Installation

To run this project on your local machine, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SoraFujin/Sorting-Algorithms.git


## 2. Compile the Java files:
Using the Makefile.sh it will automatically compile the files and add them to a dir called out <br>

## 3. Run the Main class:
make run CLASS=com.sort.main.Main <br>
to run the GUI: **make run CLASS=com.sort.main.SortingGUI

## Contributing
Contributions are welcome! If you have any suggestions or improvements, please open an issue or submit a pull request.

## Fork the repository.
Create a new branch (git checkout -b feature-branch).
Commit your changes (git commit -am 'Add new feature').
Push to the branch (git push origin feature-branch).
Open a pull request.
