/*package com.interview.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryNodes<T extends Comparable<T>> {
	
	public List<Node<T>> getBoundaryNodes(Node<T> root){
		
	}
	
	public List<Node<T>> getLeftBoundaryNodes(Node<T> root){
		List<Node<T>> nodeList = new ArrayList<Node<T>>();
		while(root.getLeftNode()!=null || root.getRightNode()!=null){
			nodeList.add(root);
			if(root.getLeftNode()!=null)
			root = root.getLeftNode();
			else if (root.getRightNode()!=null)
				root = root.getRightNode();
		}
		return nodeList;
	}

	public List<Node<T>> getRightBoundaryNodes(Node<T> root){
		
	}
}
*/