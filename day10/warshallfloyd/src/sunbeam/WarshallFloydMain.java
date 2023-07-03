/*******************************************************************
* Java Code: WarshallFloydMain.java
* Date: 12-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

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

	public int[][] warshallFloyd() {
		// set initial dist matrix same as adj matrix
		int [][]dist = new int[vertCount][vertCount];
		for (int s = 0; s < vertCount; s++) {
			for (int d = 0; d < vertCount; d++)
				dist[s][d] = adjmat[s][d];
			// dist of a vertex to itself is 0.
			dist[s][s] = 0;
		}
		
		// consider vertex i in between s and d and find optimal distance between s and d.
		for (int i = 0; i < vertCount; i++) {
			for (int s = 0; s < vertCount; s++) {
				for (int d = 0; d < vertCount; d++) {
					if(dist[s][i] != INF && dist[i][d] != INF && dist[s][i] + dist[i][d] < dist[s][d])
						dist[s][d] = dist[s][i] + dist[i][d];
				}
			}			
		}
		
		return dist;
	}
}

public class WarshallFloydMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixWeightedGraph g = new AdjMatrixWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		int[][] dist = g.warshallFloyd();
		System.out.println("\nAdjancecy Matrix: \n");
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++) {
				if(dist[i][j] == AdjMatrixWeightedGraph.INF)
					System.out.print("X\t");
				else
					System.out.print(dist[i][j] + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}

/*
5
7
3 4 3
2 4 3
2 3 4
2 1 -2
1 3 -1
0 2 5
0 1 6
*/








