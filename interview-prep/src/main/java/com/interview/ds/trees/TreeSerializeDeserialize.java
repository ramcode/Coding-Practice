/*package com.interview.ds.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeSerializeDeserialize {

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root == null)
			return sb.toString();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		String s = serialize(queue, sb);
		// System.out.println(s);
		return s;

	}

	public static String serialize(Queue<TreeNode> queue, StringBuffer sb) {
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			sb.append(node.val + "->" + "[" + (node.left != null ? node.left.val : "null") + ","
					+ (node.right != null ? node.right.val : "null") + "]#");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return sb.substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0)
			return null;
		Map<String, TreeNode> map = new HashMap<String, TreeNode>();
		String[] nodes = data.split("#");
		for (int i = nodes.length - 1; i >= 0; i--) {
			convertToNode(map, nodes[i]);
		}

	}

	public static TreeNode convertToNode(Map<String, TreeNode> map, String s) {
		String[] nodes = s.split("->");
		String root = nodes[0];
		if (!map.containsKey(root)) {
			String[] children = nodes[1].split(",");
			String left = children[0].replaceAll("[", "");
			String right = children[0].replaceAll("]", "");
			if (!left.equals("null")) {
				
				root.left = new TreeNode(Integer.parseInt(left));
			}
		}

		if (!right.equals("null")) {
			root.left = new TreeNode(Integer.parseInt(right));
		}
	}return root;

	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new TreeNode(1)).insertNode(2).insertNode(3).insertNode(7).insertNode(4)
				.insertNode(5).insertNode(6).insertNode(8);
		System.out.println(serialize(bt.root));
	}
}*/