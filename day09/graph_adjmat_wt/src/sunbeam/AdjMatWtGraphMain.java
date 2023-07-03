package sunbeam;
/*******************************************************************
* Java Code: AdjMatWtGraphMain.java
* Date: 11-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/


import java.util.Scanner;

class AdjMatrixWeightedGraph {
	public static final int INF = 999; //Integer.MAX_VALUE;
	private int vertCount;
	private int edgeCount;
	private int [][] adjmat;
	
	public AdjMatrixWeightedGraph(int vertexCount) {
		edgeCount = 0;
		vertCount = vertexCount;
		adjmat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				adjmat[i][j] = INF;
		}
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest weight): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			adjmat[dest][src] = wt; // delete this line for directed graph.
		}
	}
	
	public void display() {
		System.out.println("\nAdjancecy Matrix: \n");
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++) {
				if(adjmat[i][j] == INF)
					System.out.print("X\t");
				else
					System.out.print(adjmat[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

public class AdjMatWtGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixWeightedGraph g = new AdjMatrixWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		sc.close();
	}
}


/*
6
7
0 1 7
0 2 4
0 3 8
1 2 9
1 4 5
3 4 6
3 5 2
*/


