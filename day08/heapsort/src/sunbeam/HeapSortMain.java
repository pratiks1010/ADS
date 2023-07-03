/*******************************************************************
* Java Code: HeapSortMain.java
* Date: 08-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.Arrays;

class MaxHeap {
	private int[] arr;
	private int size;
	public MaxHeap(int[] a) {
		arr = a;
		size = a.length - 1;
	}
	public void makeHeap() {
		// heap size is number of elements in heap (1 to length)
		size = arr.length - 1;
		// from middle node to first node check if it is greater than each child node
		for(int i = size/2; i >= 1; i--) {
			// take ith element into temp variable & also take child index of ith node
			int temp = arr[i], ci = i * 2;
			// find appropriate location for temp variable.
			while(ci <= size) {
				// check if right child is available & is greater than left child
				if((ci+1) <= size && arr[ci+1] > arr[ci])
					ci = ci + 1;
				// if temp is greater than max child (ci)
				if(temp > arr[ci])
					break;
				// if child is greater than temp, promote child to its parent location
				arr[ci/2] = arr[ci];
				// check if its child is valid location for temp?
				ci = ci * 2;
			}
			// insert temp as parent of ci
			arr[ci / 2] = temp;
		}
	}
	
	public int delMax() {
		// max node is always arr[1]
		int max = arr[1];
		// take last node into temp variable
		int temp = arr[size];
		// decrement size of heap by 1
		size = size - 1;
		// find approrpiate position for temp.
		int ci = 2; // child of arr[1]
		while(ci <= size) {
			// check if right child is available & is greater than left child
			if((ci+1) <= size && arr[ci+1] > arr[ci])
				ci = ci + 1;
			// if temp is greater than max child (ci)
			if(temp > arr[ci])
				break;
			// if child is greater than temp, promote child to its parent location
			arr[ci/2] = arr[ci];
			// check if its child is valid location for temp?
			ci = ci * 2;
		}
		// insert temp as parent of ci
		arr[ci / 2] = temp;
		// return deleted node
		return max;
	}
	public void print() {
		System.out.print("Heap: ");
		for (int i = 1; i <= size; i++)
			System.out.print(arr[i]+ ", ");
		System.out.println();
	}
}

public class HeapSortMain {	
	public static void heapSort(int[] arr) {
		MaxHeap h = new MaxHeap(arr);
		h.makeHeap(); // O(n log n)
		for(int i=1; i<arr.length; i++) { // O(n log n)
			int max = h.delMax(); // O(log n)
			arr[arr.length-i] = max;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}







