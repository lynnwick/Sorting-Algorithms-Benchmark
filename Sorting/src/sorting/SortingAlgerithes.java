package sorting;

import java.util.List;
import java.util.ArrayList;

/*Bubble Sort Algorithm
/ Source: Mosh Hamedani - http://codewithmosh.com
/ integer array called array
/ for loop, to iterate over many times, each iteration the largest values/items to move into 
/ correct position until all are in ascending order of integers array*/

/* Insertion Sort
 * Source: Mosh Hamedani - http://codewithmosh.com
 * Insertion Sort instead of swapping values
 * in an array, it compares the values are inserted in the 
 * right position using current variable to 
 * make room and comparing the value left if it is greater than, if the
 * right value is a larger value, then its stored and moved one position to the right */

/* Merge Sort
 * Author: John Kwisses https://gist.github.com/Kwistech
 * recursion, dividing the problems into sub-arrays starting with the middle
 * position of the array of integers. */

/*Selection sort 
 *Source: https://www.programiz.com
 * Two nested for loops one in the function,
 * and second to call another function index max/min. 
 * with RT - O(n) which is linear algorithm */

/*Quick Sort
 * Source code: GeeksforGeeks.org*/

public class SortingAlgerithes {

	// ------------------------- Utilities

	//
	public static int[] randomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = (int) ((Math.random() - 0.5) * 1000) % 100;
		return arr;
	}

	// Print
	public static void print(int[] array) {
		System.out.print("[ ");
		for (int a : array)
			System.out.print(a + ", ");
		System.out.println("]");
	}

	// Swapping two elements
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	// =========Sorting algorithms=========
	
	//Insertion Sort
	//Source: Mosh Hamedani - http://codewithmosh.com
	// --------Insertion sort--------
	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					for (int k = i; k > j; k--) {
						swap(array, k, k - 1);
					}
					break;
				}
			}
		}
		return array;
	}
	
	
	//Selection sort
	//Source: https://www.programiz.com
	// --------Selection sort--------
	public static int[] selectionSort(int[] array) {
		int min; // Variables for the Loops
		for (int i = 0; i < array.length; i++) { // Looping over the array
			min = i;
			for (int j = i; j < array.length; j++) { // Loop over the array from the next element
				if (array[min] > array[j])
					min = j;
			}
			swap(array, i, min);// selected the minimum value, swap it with the next position on the left
		}
		return array;
	}

	// --------Bubble Sort--------
	public static int[] bubbleSort(int[] array) {
		for (var i = 0; i < array.length; i++) // O(n)for loop executing for 6 iteration,
			for (var n = 1; n < array.length; n++)// O(n)
				if (array[n] < array[n - 1])
					swap(array, n, n - 1); // then swap
		return array;
	}

	private void swap1(int[] array, int index1, int index2) { // temp
		var temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

	}

	//Merge: 
	// Source code: gist.github.com/Kwistech
	
	// --------Merge sort--------
	public static int[] mergeSort(int[] array) { //Sorting the sub-arrays and merge
		int[][] s = split(array);
		array = merge(s[0], s[1]);
		return array;
	}

	private static int[][] split(int[] a) { //Get the length of the two sub-arrays to sort/merge Split(2)
		int size = a.length / 2; 
		int[][] s = new int[2][];
		s[0] = new int[size];
		s[1] = new int[a.length - size];
		System.arraycopy(a, 0, s[0], 0, size);
		System.arraycopy(a, size, s[1], 0, a.length - size);
		return s;
	}

	private static int[] merge(int[] a, int[] b) {
		if (a.length > 1) {
			int[][] s = split(a);
			a = merge(s[0], s[1]);
		}
		if (b.length > 1) {
			int[][] s = split(b);
			b = merge(s[0], s[1]);
		}
		//Compare, assign and move index (of array to sort)
		int ai = 0, bi = 0;
		int[] m = new int[a.length + b.length];
		for (int i = 0; i < m.length; i++) {
			if (ai < a.length && bi < b.length) {
				if (a[ai] > b[bi])
					m[i] = b[bi++];
				else
					m[i] = a[ai++];
			} else if (ai < a.length) {
				m[i] = a[ai++];
			} else if (bi < b.length) {
				m[i] = b[bi++];
			}
		}
		return m;
	}

	// --------Quick sort--------
	public static int[] quickSort(int[] array) {
		return quickSort(array, 0, array.length - 1);
	}

	private static int[] quickSort(int[] array, int start, int end) {
		if (end - start <= 1) {
			if ((end - start == 1) && array[start] > array[end]) {
				swap(array, start, end);
			}
			return array;
		}

		int pivot = pivot(array, start);
		int med = partition(array, start, end, pivot);
		quickSort(array, start, med - 1);
		quickSort(array, med + 1, end);
		return array;
	}

	private static int pivot(int[] array, int start) {
		return start;
	}

	private static int partition(int[] array, int start, int end, int pivot) {
		swap(array, end, pivot);
		int place = end;

		for (int i = start; i < end; i++) {
			if (array[i] > array[end]) {
				boolean ordered = true;
				for (int j = i + 1; j < end; j++) {
					if (array[j] <= array[end]) {
						ordered = false;
						swap(array, j, i);
						break;
					}
				}
				if (ordered) {
					place = i;
					break;
				}
			}
		}
		swap(array, place, end);
		return place;
	}

	// --------Runner/Driver--------

	public static void main(String[] args) {
		int input_size = 9;
		int[] array_input = randomArray(input_size);
		int[] array = new int[input_size];

		System.out.println(
				"Size:           100    250    500   1000   1250   2500   3750   5000   6250   7500   8750  10000");
		benchmarking();
	}

	public static void benchmarking() {
		int[] loads = { 100, 250, 1000, 1250, 500, 2500, 3750, 5000, 6250, 8750, 7500, 10000 };
		String[] algorithmName = { "Insertion", "Selection", "Bubble", "Merge", "Quick" };
		long[][] results = new long[algorithmName.length][loads.length];
		for (int i = 0; i < loads.length; i++) {
			long time;
			int[] array_input = randomArray(loads[i]);
			int[] array = new int[loads[i]];
			
			// outputting to console results in TimeMilli seconds
			System.arraycopy(array_input, 0, array, 0, loads[i]);
			time = System.currentTimeMillis();
			insertionSort(array);
			results[0][i] = System.currentTimeMillis() - time;

			System.arraycopy(array_input, 0, array, 0, loads[i]);
			time = System.currentTimeMillis();
			selectionSort(array);
			results[1][i] = System.currentTimeMillis() - time;

			System.arraycopy(array_input, 0, array, 0, loads[i]);
			time = System.currentTimeMillis();
			bubbleSort(array);
			results[2][i] = System.currentTimeMillis() - time;

			System.arraycopy(array_input, 0, array, 0, loads[i]);
			time = System.currentTimeMillis();
			mergeSort(array);
			results[3][i] = System.currentTimeMillis() - time;

			System.arraycopy(array_input, 0, array, 0, loads[i]);
			time = System.currentTimeMillis();
			quickSort(array);
			results[4][i] = System.currentTimeMillis() - time;

		}

		for (int n = 0; n < algorithmName.length; n++) {
			System.out.printf("%-10s: ", algorithmName[n]); // display text left align
			for (int i = 0; i < loads.length; i++)
				System.out.printf(" %03.3fs", results[n][i] / 1000.0);
			System.out.println();
		}
	}
}
