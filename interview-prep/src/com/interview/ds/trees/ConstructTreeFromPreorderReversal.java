package com.interview.ds.trees;

import java.util.Arrays;

public class ConstructTreeFromPreorderReversal {
	
	public static TreeNode constructTree(String[] preOrder){
		if(preOrder== null || preOrder.length==0) return null;
		TreeNode root = new TreeNode(Integer.valueOf(preOrder[0]));
		int indexToSplit = 0;
		int firstMax = Integer.valueOf(preOrder[0]);
		for(int i=1; i<preOrder.length; i++){
			int val = Integer.valueOf(preOrder[i]);
			if(val>firstMax){
				indexToSplit = i;
				break;
			}
		}
		String[] left = null, right = null;
		if(preOrder.length>1 && indexToSplit>0 && indexToSplit<=preOrder.length-1){
			left = Arrays.copyOfRange(preOrder, 1, indexToSplit);
			right = Arrays.copyOfRange(preOrder, indexToSplit, preOrder.length);
		}
		else if(indexToSplit==0){
			left = Arrays.copyOfRange(preOrder, 1, preOrder.length);
		}
		root.left = constructTree(left);
		root.right = constructTree(right);
		return root;
	}
	
	public static TreeNode constructTreeUsingMinMax(int[] preorder){
		if(preorder==null || preorder.length==0) return null;
		return preOrderHelper(preorder, 0, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static TreeNode preOrderHelper(int[] preorder, int pos, int min, int max){
		if(pos>=preorder.length) return null;
		if(preorder[pos]<min || preorder[pos]>max) return null;
		TreeNode root = new TreeNode(preorder[pos]);
		root.left = preOrderHelper(preorder, pos+1, min, preorder[pos]);
		root.right = preOrderHelper(preorder, pos+1, preorder[pos], max);
		return root;
	}
	
	public static void main(String[] args){
		TreeNode tree = constructTreeUsingMinMax(new int[]{10, 5, 1, 7, 40, 50});
		System.out.println(tree);
	}

}
