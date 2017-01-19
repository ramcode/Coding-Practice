package com.interview.ds.trees;

public class MorrisInOrderTraversal {

	public static void morrisInOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		TreeNode current = root;
		TreeNode pred = null;
		while (current != null) {
			if (current.left == null) {
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
