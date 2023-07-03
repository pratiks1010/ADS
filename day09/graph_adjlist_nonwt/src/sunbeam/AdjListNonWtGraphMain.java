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
import java.util.Stack;

class AdjListNonWeightedGraph {
	private int vertCount, edgeCount;
	private LinkedList<Integer> []adjlist;
	
	public AdjListNonWeightedGraph(int vertexCount) {
		vertCount = vertexCount;
		edgeCount = 0;
		adjlist = new LinkedList[vertCount];
		for (int i = 0; i < vertCount; i++)
			adjlist[i] = new LinkedList<Integer>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjlist[src].add(dest);
			adjlist[dest].add(src); // for directed graph delete this line.
		}
	}
	
	public void display() {
		System.out.println("\nAdj List: \n");
		for (int v = 0; v < vertCount; v++) {
			System.out.print("vert " + v + " : ");
			for (int dest : adjlist[v])
				System.out.print(dest + " -> ");
			System.out.println();
		}
	}
	
	public void dfsTraversal(int start) {
		System.out.print("DFS : ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		marked[start] = true;
		while(!s.isEmpty()) {
			int trav = s.pop();
			System.out.print(trav + ", ");
			for(int dest: adjlist[trav]) {
				if(!marked[dest]) {
					s.push(dest);
					marked[dest] = true;
				}
			}
		}
		System.out.println();
	}

}

public class AdjListNonWtGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vertCount = sc.nextInt();
		AdjListNonWeightedGraph g = new AdjListNonWeightedGraph(vertCount);
		g.accept(sc);
		g.display();
		g.dfsTraversal(0);
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

