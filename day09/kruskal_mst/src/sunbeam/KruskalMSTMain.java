package sunbeam;
/*******************************************************************
* Java Code: KruskalMSTMain.java
* Date: 11-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import sunbeam.AdjMatrixWeightedGraph.Edge;

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
			adjmat[dest][src] = wt; // delete this line for directed graph.
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
	
	private int find(int v, int[] parent) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}
	
	private void union(int sr, int dr, int[] parent) {
		parent[sr] = dr;
	}
	
	public boolean unionFind(List<Edge> edges) {
		int[] parent = new int[vertCount];
		Arrays.fill(parent, -1);
		for (Edge e : edges) {
			int sr = find(e.src, parent);
			int dr = find(e.dest, parent);
			if(sr == dr)
				return true;
			union(sr, dr, parent);
		}
		return false; // no cycle formed
	}
	
	public List<Edge> kruskalMST() {
		List<Edge> mst = new ArrayList<Edge>();
		// sort edge list in ascending order of weight
		edgeList.sort((e1,e2) -> e1.getWeight() - e2.getWeight());
		int i = 0;
		while(mst.size() != vertCount-1) {
			// pick an edge from edge list
			Edge e = edgeList.get(i);
			i++;
			// add the edge into mst
			mst.add(e);
			// if that edge is forming cycle in mst
			if(unionFind(mst)) 
				// discard the edge from mst
				mst.remove(mst.size()-1);
		}
		return mst;
	}
}

public class KruskalMSTMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixWeightedGraph g = new AdjMatrixWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		List<Edge> mst = g.kruskalMST();
		int total = 0;
		for (Edge e : mst) {
			System.out.println(e);
			total = total + e.getWeight();
		}
		System.out.println("Total Weight: " + total);
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


