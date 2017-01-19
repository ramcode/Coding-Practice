package com.interview.ds.trees;

public class TreeMirror {
	
	public static TreeNode treeMirror(TreeNode root){
		if(root==null) return null;
		treeMirror(root.left);
		treeMirror(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
	
	public static void treeMirror(TreeNode left, TreeNode right){
		if(left!=null) treeMirror(left.left, left.right);
		if(right!=null) treeMirror(right.left, right.right);
		if(left!=null || right!=null){
			TreeNode temp = left;
			left = right;
			right = temp;
		}
	}
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree(new TreeNode(4));
		tree.insertNode(1).insertNode(3).insertNode(3).insertNode(5).insertNode(9).insertNode(6).insertNode(8);
		treeMirror(tree.root);
		TreeNode mirror = tree.root;
	}

}
