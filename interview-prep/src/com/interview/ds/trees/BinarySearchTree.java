package com.interview.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	public TreeNode root = null;

	public TreeNode insert(int val) {
		if (this.root == null) {
			this.root = new TreeNode(val);
			return root;
		}
		return insert(root, val);
	}

	public TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static List<Integer> getLeaves(TreeNode root) {
		List<Integer> leaves = new ArrayList<Integer>();
		return getLeaves(leaves, root);
	}

	public static List<Integer> getLeaves(List<Integer> list, TreeNode root){
		if(root!=null && root.left==null && root.right==null){
			list.add(root.val);
			return list;
		}
		else if(root==null) return list;
		getLeaves(list, root.left);
		getLeaves(list, root.right);
		return list;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(1);
		tree.insert(6);
		tree.insert(0);
		tree.insert(-2);
		tree.insert(10);
		tree.insert(8);
		System.out.println(tree.root);
		System.out.println(getLeaves(tree.root));
	}

}
