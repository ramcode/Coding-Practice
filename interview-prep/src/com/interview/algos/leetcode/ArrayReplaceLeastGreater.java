package com.interview.algos.leetcode;

public class ArrayReplaceLeastGreater {

	public static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node root;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
			if (root == null)
				this.root = this;
		}

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public static Node addNode(Node root, int data) {
		Node succ = null;
		while (true) {
			if (data < root.data) {
				if (root.left == null) {
					root.left = new Node(data);
					succ = root;
					break;
				}
				root = root.left;

			} else {
				if (root.right == null) {
					root.right = new Node(data);
					break;
				}
				root = root.right;
			}
		}
		return succ;
	}

	public static int[] replaceArrayWithSuccessor(int[] input) {
		ArrayReplaceLeastGreater.Node root = new ArrayReplaceLeastGreater.Node(input[input.length - 1]);
		input[input.length - 1] = -1;
		for (int i = input.length - 2; i > -1; i--) {
			Node succ = addNode(root, input[i]);
			if (succ != null)
				input[i] = succ.data;
			else {
				input[i] = -1;
			}
		}
		return input;
	}

	public static void main(String[] args) {
		for (int a : replaceArrayWithSuccessor(new int[] { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 })) {
			System.out.print(a + " ");
		}
	}

}
