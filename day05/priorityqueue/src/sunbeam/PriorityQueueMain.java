/*******************************************************************
* Java Code: PriorityQueueMain.java
* Date: 05-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.PriorityQueue;

public class PriorityQueueMain {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.offer(5);
		q.offer(9);
		q.offer(6);
		q.offer(2);
		while(!q.isEmpty())
			System.out.println(q.poll());
	}
}
