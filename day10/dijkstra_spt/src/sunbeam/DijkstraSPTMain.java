package sunbeam;
/*******************************************************************
* Java Code: PrimsMST.java
* Date: 12-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/


import java.util.Arrays;
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
	
	public int getMin(int[] dist, boolean[] spt) {
		int minKey = INF, minVert = -1;
		for (int v = 0; v < vertCount; v++) {
			if(!spt[v] && dist[v] < minKey) {
				minKey = dist[v];
				minVert = v;
			}
		}
		return minVert;
	}
	
	public int[] dijkstraSPT(int root) {
		int count = 0;
		// dists of all vertices should be initialized to INF 
		int []dist = new int[vertCount];
		Arrays.fill(dist, INF);
		// make parent of all vertices to -1
		int []parent = new int[vertCount];
		Arrays.fill(parent, -1);
		// initially no vertex is added into spt
		boolean []spt = new boolean[vertCount];
		Arrays.fill(spt, false);
		// make starting vertex dist as 0
		dist[root] = 0;
		while(count != vertCount) { // -- O(V) 
			// pick vertex with min dist
			int u = getMin(dist, spt); // -- O(V) -- minheap/priorityqueue: O(log V) -- for each outer loop iteration
													// overall -- O(V log V)
			// add it into spt
			spt[u] = true;
			count++;
			// update dists of its neighbors
			for (int v = 0; v < vertCount; v++) { // O(V) -- adjlist: overall O(E)
				if(adjmat[u][v] != INF && !spt[v] && dist[u] + adjmat[u][v] < dist[v]) {
					dist[v] = dist[u] + adjmat[u][v];
					parent[v] = u;
				}
			}
		} // repeat until all vertices are added into spt
		// improved version (priority queue + adjacency list)  = O(E + V log V)
		for (int v = 0; v < vertCount; v++)
			System.out.println("Distance of vertex " + v + " from vertex " + root + " = " + dist[v]);
		return parent;
	}
	
	public int getWeight(int src, int dest) {
		if(src == -1 || dest == -1)
			return 0;
		return adjmat[src][dest];
	}
}

public class DijkstraSPTMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixWeightedGraph g = new AdjMatrixWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		int total = 0;
		// for(int root=0; root < vertCount; root++)
		// 		g.dijkstraSPT(root);
		int[] parent = g.dijkstraSPT(0);
		System.out.print("Enter destination vertex: ");
		int v, dest = sc.nextInt();
		v = dest;
		while(v != 0){
			System.out.println(parent[v] + " -> " + v);
			total = total + g.getWeight(parent[v], v);
			v = parent[v];
		}
		System.out.println("Shotest Distance: " + total);
		sc.close();
	}
}


/*
9
14
7 6 1
8 2 2
6 5 2
0 1 4
2 5 4
8 6 6
2 3 7
7 8 7
0 7 8
1 2 8
3 4 9
5 4 10
1 7 11
3 5 14
*/


