package com.interview.ds.trees;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalsIterative {

	public static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			System.out.println(root.val);
			root = root.right;
		}
	}

	public static void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (true) {
			while (root != null) {
				System.out.println(root.val);
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.right;
		}
	}

	public static Deque<Integer> reversePreOrder(TreeNode root) {
		Deque<Integer> rev = new ArrayDeque<Integer>();
		if (root == null)
			return rev;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (true) {
			while (root != null) {
				System.out.println(root.val);
				rev.push(root.val);
				stack.push(root);
				root = root.right;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.left;
		}
		return rev;
	}

	public static void postOrderTraversalUsingPreOrder(TreeNode root) {
		if (root == null)
			return;
		Deque<Integer> stack = reversePreOrder(root);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void postOrderUsingFlag(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.visited || (node.left == null && node.right == null)) {
				System.out.println(stack.pop().val);
			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
				node.visited = true;
			}

		}
	}

	public static void postOrderWithOutFlag(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == root || node.right == root || node.left == null && node.right == null) {
				System.out.println(stack.pop().val);
				root = node;
			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);

			}
		}
	}

	public static void levelOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

	}
	
	public static int heightTreeIterative(TreeNode root){
		int height =-1;
		if(root==null) return height;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node==null) height++;
			else{
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
				if(queue.peek()==null) queue.offer(null);
			}
		}
		return height-1;
	}
	

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new TreeNode(1)).insertNode(2).insertNode(3).insertNode(7).insertNode(4)
				.insertNode(5).insertNode(6).insertNode(8);
		//postOrderWithOutFlag(bt.root);
		System.out.println(
				heightTreeIterative(bt.root));

	}

}
