/*******************************************************************
* Java Code: AdjMatNonWtGraphMain.java
* Date: 11-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.Scanner;
import java.util.Stack;

class AdjMatrixNonWeightedGraph {
	private int vertCount;
	private int edgeCount;
	private int [][] adjmat;
	
	public AdjMatrixNonWeightedGraph(int vertexCount) {
		edgeCount = 0;
		vertCount = vertexCount;
		adjmat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				adjmat[i][j] = 0;
		}
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjmat[src][dest] = 1;
			adjmat[dest][src] = 1; // delete this line for directed graph.
		}
	}
	
	public void display() {
		System.out.println("\nAdjancecy Matrix: \n");
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				System.out.print(adjmat[i][j] + "\t");
			System.out.println();
		}
	}
	
}

public class AdjMatNonWtGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixNonWeightedGraph g = new AdjMatrixNonWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		sc.close();
	}
}


/*
6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5
*/


