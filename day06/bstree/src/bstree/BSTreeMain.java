/*******************************************************************
* Java Code: BSTreeMain.java
* Date: 06-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package bstree;

class BinarySearchTree {
	static class Node {
		// Node fields
		private int data;
		private Node left, right;
		// Node methods
		public Node() {
			data = 0;
			left = null;
			right = null;
		}
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}
	
	// Tree fields
	private Node root;
	
	// Tree methods
	public BinarySearchTree() {
		root = null;
	}
	
	public void add(int val) {
		Node newNode = new Node(val);
		if(root == null)
			root = newNode;
		else {
			Node trav = root;
			while(true) {
				if(val < trav.data) {
					if(trav.left != null)
						trav = trav.left;
					else { // no child in left
						trav.left = newNode;
						break;
					}
				}
				else { // if(val >= trav.data) 
					if(trav.right != null)
						trav = trav.right;
					else { // no child in right
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}
	
	public void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + ", ");
		preorder(trav.left);
		preorder(trav.right);
	}
	public void preorder() {
		System.out.print("PRE : ");
		preorder(root);
		System.out.println();
	}
	
	public void inorder(Node trav) {
		if(trav == null)
			return;
		inorder(trav.left);
		System.out.print(trav.data + ", ");
		inorder(trav.right);
	}
	public void inorder() {
		System.out.print("IN  : ");
		inorder(root);
		System.out.println();
	}
	
	public void postorder(Node trav) {
		if(trav == null)
			return;
		postorder(trav.left);
		postorder(trav.right);
		System.out.print(trav.data + ", ");
	}
	public void postorder() {
		System.out.print("POST: ");
		postorder(root);
		System.out.println();
	}
}

public class BSTreeMain {
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.add(50);
		t.add(30);
		t.add(10);
		t.add(90);
		t.add(100);
		t.add(40);
		t.add(70);
		t.add(80);
		t.add(60);
		t.add(20);
		t.preorder();
		t.inorder();
		t.postorder();
	}
}
