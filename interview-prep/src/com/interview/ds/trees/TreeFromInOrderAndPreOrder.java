package com.interview.ds.trees;

import java.util.Collections;

public class TreeFromInOrderAndPreOrder {

	static int currIndex;

	public static TreeNode buildTree(int[] inOrder, int[] preOrder, int start, int end) {
		if(currIndex==preOrder.length) return null;
		TreeNode root = new TreeNode(preOrder[currIndex++]);
		if (start > end)
			return null;
		if (start == end)
			return root;
		int index = searchKey(inOrder, root.val);
		if (index != -1) {
			root.left = buildTree(inOrder, preOrder, start, index - 1);
			root.right = buildTree(inOrder, preOrder, index + 1, end);
		}
		return root;
	}

	public static int searchKey(int[] array, int key) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		TreeNode builtTree = buildTree(new int[] { 4, 2, 5, 1, 6, 3 }, new int[] { 1, 2, 4, 5, 3, 6 }, 0, 5);
	}

}
