package com.interview.ds.trees;

public class LowestCommomAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String arg[]) {
		LowestCommomAncestor lcs = new LowestCommomAncestor();
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		
		System.out.println(lcs.lowestCommonAncestor(node, new TreeNode(5), new TreeNode(4)));
	}
}
