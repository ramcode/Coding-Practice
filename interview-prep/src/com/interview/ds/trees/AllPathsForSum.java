package com.interview.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsForSum {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        pathSum(root, sum,0, list, new LinkedList<Integer>());
        return list;
        
    }
    
    public void pathSum(TreeNode root,int target, int sum, List<List<Integer>> list, List<Integer> iList){
        if(root==null) return;
        sum+=root.val;
        if(root.left==null && root.right==null && sum==target){
            iList.add(root.val);
            list.add(new LinkedList<Integer>(iList));
            iList.remove(iList.size()-1);
            return;
        }
        iList.add(root.val);
        pathSum(root.left,target,sum, list, iList);
        pathSum(root.right,target, sum, list, iList);
        iList.remove(iList.size()-1);
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
		AllPathsForSum all = new AllPathsForSum();
		System.out.println(all.pathSum(tree.root, 4));
	}
}
