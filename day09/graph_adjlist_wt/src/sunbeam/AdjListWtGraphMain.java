/*******************************************************************
* Java Code: AdjListNonWtGraphMain.java
* Date: 11-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.LinkedList;
import java.util.Scanner;


class AdjListWeightedGraph {
	static class Edge {
		private int src;
		private int dest;
		private int wt;
		public Edge() {
		}
		public Edge(int src, int dest, int wt) {
			super();
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return String.format("[%s->%s (%s)]", src, dest, wt);
		}
	}

	private int vertCount, edgeCount;
	private LinkedList<Edge> []adjlist;
	
	public AdjListWeightedGraph(int vertexCount) {
		vertCount = vertexCount;
		edgeCount = 0;
		adjlist = new LinkedList[vertCount];
		for (int i = 0; i < vertCount; i++)
			adjlist[i] = new LinkedList<Edge>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest weight): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjlist[src].add(new Edge(src, dest, wt));
			adjlist[dest].add(new Edge(dest, src, wt)); // for directed graph delete this line.
		}
	}
	
	public void display() {
		System.out.println("\nAdj List: \n");
		for (int v = 0; v < vertCount; v++) {
			System.out.print("vert " + v + " : ");
			for (Edge e: adjlist[v])
				System.out.print(e + " -> ");
			System.out.println();
		}
	}
}

public class AdjListWtGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjListWeightedGraph g = new AdjListWeightedGraph(vertCount);
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

