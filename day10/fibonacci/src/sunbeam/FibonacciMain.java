/*******************************************************************
* Java Code: FibonacciMain.java
* Date: 12-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

public class FibonacciMain {
	private static int count;
	
	public static int recFibo(int n) {
		count++;
		if(n == 1 || n == 2)
			return 1;
		return recFibo(n-1) + recFibo(n-2);
	}
	
	public static int memFibo(int n, int[] terms) {
		count++;
		if(terms[n] != 0)
			return terms[n];
		if(n == 1 || n == 2)
			return (terms[n] = 1);
		terms[n] = memFibo(n-1, terms) + memFibo(n-2, terms);
		return terms[n];
	}
	
	public static int memFibo(int n) {
		int[] terms = new int[n+1];
		return memFibo(n, terms);
	}
	
	public static int dpFibo(int n) {
		count++;
		int[] terms = new int[n+1];
		terms[1] = terms[2] = 1;
		for(int i=3; i<=n; i++) 
			terms[i] = terms[i-1] + terms[i-2];
		return terms[n];
	}
	
	public static void main(String[] args) {
		int res;
		
		count = 0;
		res = recFibo(30);
		System.out.println("Fibo = " + res + " with " + count + " function calls.");

		count = 0;
		res = memFibo(30);
		System.out.println("Fibo = " + res + " with " + count + " function calls.");

		count = 0;
		res = dpFibo(30);
		System.out.println("Fibo = " + res + " with " + count + " function calls.");
	}
}
