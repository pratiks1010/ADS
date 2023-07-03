/*******************************************************************
* Java Code: AdjMatNonWtGraphMain.java
* Date: 11-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.LinkedList;
import java.util.Queue;
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
	
	public void bfsTraversal(int start) {
		System.out.print("BFS: ");
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		marked[start] = true;
		while(!q.isEmpty()) {
			int trav = q.poll();
			System.out.print(trav + ", ");
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
				}
			}
		}
		System.out.println();
	}
	
	public void dfsTraversal(int start) {
		System.out.print("DFS: ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		marked[start] = true;
		while(!s.isEmpty()) {
			int trav = s.pop();
			System.out.print(trav + ", ");
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
				}
			}
		}
		System.out.println();
	}

	public boolean isConnected() {
		int start = 0, count = 0;
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		marked[start] = true;
		count++;
		while(!s.isEmpty()) {
			int trav = s.pop();
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
					count++;
					if(count == vertCount)
						return true;
				}
			}
		}
		return false;
	}

	public void dfsSpanningTree(int root) {
		System.out.print("DFS Spanning Tree:\n");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(root);
		marked[root] = true;
		while(!s.isEmpty()) {
			int trav = s.pop();
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
					System.out.println(trav + " -> " + dest);
				}
			}
		}
		System.out.println();
	}

	public void bfsSpanningTree(int root) {
		System.out.print("BFS Spanning Tree:\n");
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(root);
		marked[root] = true;
		while(!q.isEmpty()) {
			int trav = q.poll();
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
					System.out.println(trav + " -> " + dest);
				}
			}
		}
	}

	public int[] singleSourceShortestPath(int start) {
		int[] dist = new int[vertCount];
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		marked[start] = true;
		dist[start] = 0;
		while(!q.isEmpty()) {
			int trav = q.poll();
			for (int dest = 0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
					dist[dest] = dist[trav] + 1;
				}
			}
		}
		return dist;
	}
	
	public boolean isBipartite() {
		final int RED = -1, GREEN = 1, NOCOLOR = 0;
		int start = 0;
		int []color = new int[vertCount]; // all color=0 (NOCOLOR)
		Queue<Integer> q = new LinkedList<Integer>();
		color[start] = RED;
		q.offer(start);
		while(!q.isEmpty()) {
			int trav = q.poll();
			for(int dest=0; dest < vertCount; dest++) {
				if(adjmat[trav][dest] != 0) {
					if(color[dest] == NOCOLOR) {
						color[dest] = -1 * color[trav];
						q.offer(dest);
					}
					else if(color[dest] == color[trav])
						return false;
				}
			}
		}
		return true;
	}

}

public class GraphBfsDfsMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjMatrixNonWeightedGraph g = new AdjMatrixNonWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		g.bfsTraversal(0);
		g.dfsTraversal(0);
		System.out.println("Is Connected: " + g.isConnected());
		g.dfsSpanningTree(0);
		g.bfsSpanningTree(0);
		System.out.println("Is Bipartite: " + g.isBipartite());
		int start = 0;
		int[] dist = g.singleSourceShortestPath(start);
		for (int i = 0; i < vertCount; i++)
			System.out.println("Distance of vertex " + i + " from vertex " + start + " = " + dist[i]);
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


