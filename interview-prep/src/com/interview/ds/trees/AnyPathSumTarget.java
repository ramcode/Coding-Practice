package com.interview.ds.trees;

public class AnyPathSumTarget {
	
	public static boolean hasAnyPathSum(TreeNode root, int sum){
		if(root==null) return false;
		sum-=root.val;
		if(sum==0) return true;
		return hasAnyPathSum(root.left, sum) || hasAnyPathSum(root.right, sum);
		
	}
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree(new TreeNode(4));
		tree.insertNode(3).insertNode(1).insertNode(5).insertNode(7).insertNode(8);
		System.out.println(hasAnyPathSum(tree.root, 13));

		
	}

}
