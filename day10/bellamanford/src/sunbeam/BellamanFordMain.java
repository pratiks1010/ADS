/*******************************************************************
* Java Code: BellamanFordMain.java
* Date: 12-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class AdjMatrixWeightedGraph {
	static class Edge {
		private int src;
		private int dest;
		private int weight;
		public Edge() {
		}
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return String.format("Edge [src=%s, dest=%s, weight=%s]", src, dest, getWeight());
		}
		public int getWeight() {
			return weight;
		}
	}
	
	public static final int INF = 999; //Integer.MAX_VALUE;
	private int vertCount;
	private int edgeCount;
	private int [][] adjmat;
	private List<Edge> edgeList;
	
	public AdjMatrixWeightedGraph(int vertexCount) {
		edgeCount = 0;
		edgeList = new ArrayList<Edge>();
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
			edgeList.add(new Edge(src, dest, wt));
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
	
	public void updateDistance(int[] dist) {
		for (Edge e : edgeList) {
			int u = e.src, v = e.dest, w = e.weight;
			if(dist[u] != INF && dist[u] + w < dist[v])
				dist[v] = dist[u] + w;
		}
	}
	
	public boolean isNegativeCycle(int[] dist) {
		for (Edge e : edgeList) {
			int u = e.src, v = e.dest, w = e.weight;
			if(dist[u] != INF && dist[u] + w < dist[v])
				return true;
		}
		return false;
	}	
	
	public int[] bellamanFord(int root) {
		// make dist of all vertices as INF.
		int[] dist = new int[vertCount];
		Arrays.fill(dist, INF);
		// make starting vertex dist as 0
		dist[root] = 0;
		// repeat for V-1 times
		for(int i=1; i<vertCount; i++)
			updateDistance(dist);
		if(isNegativeCycle(dist))
			throw new RuntimeException("Graph has negative weight cycle.");
		return dist;
	}
}

public class BellamanFordMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixWeightedGraph g = new AdjMatrixWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		int[] dist = g.bellamanFord(0);
		for (int i = 0; i < vertCount; i++)
			System.out.println("Distance of vertex " + i + " from vertex 0 = " + dist[i]);
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
