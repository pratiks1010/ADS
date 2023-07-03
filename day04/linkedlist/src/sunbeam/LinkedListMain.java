/*******************************************************************
* Java Code: LinkedListMain.java
* Date: 04-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

class SinglyList {
	static class Node {
		private int data;
		private Node next;
		public Node() {
			this.data = 0;
			this.next = null;
		}
		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}
	
	private Node head;
	public SinglyList() {
		head = null;
	}
	public void addLast(int val) {
		Node newNode = new Node(val);
		if(head == null)
			head = newNode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}
	public void display() {
		System.out.print("List: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + " -> ");
			trav = trav.next;
		}
		System.out.println("");
	}
	public void reverse() {
		// consider current list as old and new list as empty.
		Node oldhead = head;
		head = null;
		while(oldhead != null) {
			// delete first (temp) from old list
			Node temp = oldhead;
			oldhead = oldhead.next;
			// add first (temp) to new list
			temp.next = head;
			head = temp;
		} // repeat until old list is finished
	}
	
	private Node recReverse(Node h) {
		if(h.next == null) {
			head = h;
			return h;
		}
		Node t = recReverse(h.next);
		t.next = h;
		h.next = null;
		return h;
	}
	public void recReverse() {
		if(head != null)
			recReverse(head);
	}
	
	private void revDisplay(Node h) {
		if(h == null)
			return;
		revDisplay(h.next);
		System.out.print(h.data + " -> ");
	}
	public void revDisplay() {
		System.out.print("List: ");
		revDisplay(head);
		System.out.println("");
	}
	
	public int findMid() {
		Node fast = head, slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
}

public class LinkedListMain {
	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.display();
		
//		list.reverse();
//		list.display();

//		list.recReverse();
//		list.display();

//		list.revDisplay();
//		list.display();

		System.out.println("Middle: " + list.findMid());
	}
}
