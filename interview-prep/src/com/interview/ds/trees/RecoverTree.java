package com.interview.ds.trees;

public class RecoverTree {

	static TreeNode prev = null;
	static TreeNode first = null;
	static TreeNode second = null;

	public static void recoverTree(TreeNode root) {
		morrisInOrderTraversal(root);

	}

	public static void morrisInOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		TreeNode current = root;
		TreeNode pred = null;
		while (current != null) {
			if (prev != null && prev.val >= current.val) {
				if (first == null)
					first = prev;
				second = current;
			} else {

			}
			if (current.left == null) {
				prev = current;
				System.out.println(current.val);
				current = current.right;
			} else {
				pred = current.left;
				while (pred.right != null && pred.right != current) {
					pred = pred.right;
				}
				if (pred.right == null) {
					pred.right = current;
					current = current.left;
				} else {
					pred.right = null;
					prev = current;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(new TreeNode(10));
		TreeNode root = tree.root;
		TreeNode node5 = tree.root.insertLeftAndReturn(5);
		node5.insertLeftAndReturn(-2).insertRightAndReturn(2).insertLeft(-1);
		node5.insertRightAndReturn(6).insertRightAndReturn(8);
		root.insertRightAndReturn(30).insertRightAndReturn(40);

		morrisInOrderTraversal(root);

	}

}
