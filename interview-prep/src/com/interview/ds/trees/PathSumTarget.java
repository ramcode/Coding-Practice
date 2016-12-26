package com.interview.ds.trees;

public class PathSumTarget {
	
	public static boolean hasPathSum(TreeNode root, int target) {
        int sum = 0;
        return hasPathSum(root,target,sum);
    }
    
    public static boolean hasPathSum(TreeNode root, int target, int sum){
        if(root==null) return false;
        sum +=root.val;
        if(root.left==null && root.right==null && sum == target) return true;
        return hasPathSum(root.left, target, sum) ||  hasPathSum(root.right, target, sum);
    }
    
    public static void main(String[] args){
    	BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(1);
		tree.insert(6);
		tree.insert(0);
		tree.insert(-2);
		tree.insert(10);
		tree.insert(8);
    	System.out.println(hasPathSum(tree.root, 4));
    }

}
