package com.interview.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeavesPaths {

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null)
			return list;
		return binaryTreePaths(root, list, "");

	}

	public static List<String> binaryTreePaths(TreeNode root, List<String> list, String sb) {
		if (root.left == null && root.right == null) {
			sb = sb + String.valueOf(root.val);
			list.add(sb);
			sb = new String();
		}
		if (root.left != null) {
			sb = sb + root.val + "->";
			binaryTreePaths(root.left, list, sb);
		}
		if (root.right != null) {
			sb = sb + root.val + "->";
			binaryTreePaths(root.right, list, sb);
		}
		return list;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(new TreeNode(1));
		tree.insertNode(2).insertNode(3).insertNode(5);
		System.out.println(binaryTreePaths(tree.root));
	}

}
