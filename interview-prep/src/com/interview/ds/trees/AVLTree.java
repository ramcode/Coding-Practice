package com.interview.ds.trees;

public class AVLTree {

	public Node root = null;

	public AVLTree(Node node) {
		this.root = node;
	}

	public Node insert(int data) {
		if (root == null)
			return new Node(data);
		return insertNode(this.root, data);
	}

	public Node insertNode(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (root.getData().compareTo(data) > 0) {
			root.setLeftNode(insertNode(root.getLeftNode(), data));
		} else {
			root.setRightNode(insertNode(root.getRightNode(), data));
		}
		int balance = height(root.getLeftNode()) - height(root.getRightNode());
		if (balance < -1) {
			if (height(root.getRightNode().getRightNode()) > height(root.getRightNode().getLeftNode())) {
				return leftRotate(root);
			} else {
				root.setRightNode(rightRotate(root.getRightNode()));
				return leftRotate(root);

			}
		} else if (balance > 1) {
			if (height(root.getLeftNode().getLeftNode()) > height(root.getLeftNode().getRightNode()))
				return rightRotate(root);
			else {
				root.setLeftNode(leftRotate(root.getLeftNode()));
				return rightRotate(root);
			}
		}
		return root;
	}

	public Node leftRotate(Node parent) {
		Node right = parent.getRightNode();
		parent.setRightNode(right.getLeftNode());
		right.setLeftNode(parent);
		return right;
	}

	public Node rightRotate(Node parent) {
		Node left = parent.getLeftNode();
		parent.setLeftNode(left.getRightNode());
		left.setRightNode(parent);
		return left;
	}

	public int height(Node node) {
		if (node == null)
			return 0;
		return Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1;
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(new Node(5));
		Node newRoot = null;
		newRoot = tree.insertNode(newRoot,4);
		newRoot = tree.insertNode(newRoot,3);
		newRoot = tree.insertNode(newRoot,2);
		newRoot = tree.insertNode(newRoot,1);
		newRoot = tree.insertNode(newRoot,-5);
		System.out.println(newRoot);
	}
}
