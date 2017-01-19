package com.interview.ds.trees;

public class TreeSearchAlgos {

	public static int findMax(TreeNode root) {
		int max = Integer.MIN_VALUE;
		if (root == null)
			return max;
		int leftMax = findMax(root.left);
		int rightMax = findMax(root.right);
		max = Math.max(Math.max(leftMax, root.val), rightMax);
		return max;
	}
	
	public static boolean searchElement(TreeNode root, int data){
		if(root==null) return false;
		if(root.val == data) return true;
		boolean found = searchElement(root.left, data);
		if(!found) found = searchElement(root.right, data);
		return found;
	}
	
	public static int findSize(TreeNode root){
		int size = 0;
		return findSize(root, size);
		
	}

	private static int findSize(TreeNode root, int size) {
		if(root==null) return 0;
		return findSize(root.left, size)+findSize(root.right, size)+1;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(new TreeNode(-1));
		tree.insertNode(-10).insertNode(-1).insertNode(-9).insertNode(-11).insertNode(-13).insertNode(-10).insertNode(-12);
		System.out.println(findSize(tree.root));
	}

}
