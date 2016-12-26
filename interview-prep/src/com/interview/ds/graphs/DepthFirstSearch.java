package com.interview.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

	public static void depthFirstSearch(Node root, Node target) {
		if (root == null)
			return;
		if (!root.visited) {
			root.visited = true;
			if (root.id == target.id) {
				System.out.println("Found target");
				return;
			}

			for (Node node : root.neighBours) {
				//if (!node.visited)
					depthFirstSearch(node, target);
			}

		}

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		List<Node> n6 = new ArrayList<Node>();
		n6.add(node9);
		List<Node> n8 = new ArrayList<Node>();
		n8.add(node10);
		n8.add(node2);
		List<Node> n7 = new ArrayList<Node>();
		n7.add(node8);
		n7.add(node10);
		n7.add(node6);
		n7.add(node9);
		List<Node> n4 = new ArrayList<Node>();
		n4.add(node8);
		List<Node> n3 = new ArrayList<Node>();
		n3.add(node4);
		n3.add(node8);
		List<Node> n5 = new ArrayList<Node>();
		n5.add(node3);
		n5.add(node6);
		n5.add(node10);
		List<Node> n1 = new ArrayList<Node>();
		n1.add(node3);
		n1.add(node4);

		node6.neighBours = n6;
		node8.neighBours = n8;
		node7.neighBours = n7;
		node4.neighBours = n4;
		node3.neighBours = n3;
		node5.neighBours = n5;

		root.neighBours = n1;
		depthFirstSearch(root, node9);
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		list.add(node6);
		list.add(node7);
		list.add(node8);
		list.add(node9);
		list.add(node10);

		
		  System.out.println(root.id+"->"+root.neighBours);
		  System.out.println(node2.id+"->"+node2.neighBours);
		  System.out.println(node3.id+"->"+node3.neighBours);
		  System.out.println(node4.id+"->"+node4.neighBours);
		  System.out.println(node5.id+"->"+node5.neighBours);
		  System.out.println(node6.id+"->"+node6.neighBours);
		  System.out.println(node7.id+"->"+node7.neighBours);
		  System.out.println(node8.id+"->"+node8.neighBours);
		  System.out.println(node9.id+"->"+node9.neighBours);
		  System.out.println(node10.id+"->"+node10.neighBours);
		 

	}

}
