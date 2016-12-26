package com.interview.ds.trees;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public boolean visited;
	
	public TreeNode insertLeft(int val){
		TreeNode left = new TreeNode(val);
		this.left = left;
		return this;
	}
	public TreeNode insertRight(int val){
		TreeNode right = new TreeNode(val);
		this.right = right;
		return this;
	}
	
	public TreeNode insertLeftAndReturn(int val){
		TreeNode left = new TreeNode(val);
		this.left = left;
		return left;
	}
	public TreeNode insertRightAndReturn(int val){
		TreeNode right = new TreeNode(val);
		this.right = right;
		return right;
	}
	public TreeNode insertLeftRight(int lval, int rval){
		this.left = new TreeNode(lval);
		this.right = new TreeNode(rval);
		return this;
	}
	
	public TreeNode(int data){
		this.val = data;
	}
}
