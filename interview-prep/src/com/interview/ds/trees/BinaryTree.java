package com.interview.ds.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

	private Node<T> rootNode;
	public TreeNode root;

	public BinaryTree(T rootData) {

		Node<T> rootNode = new Node<T>(rootData);
		rootNode.setInsertionSequence(0);
		rootNode.setLeftNode(null);
		rootNode.setRightNode(null);
		this.rootNode = rootNode;

	}
	
	public BinaryTree(TreeNode root){
		this.root = root;
	}

	public BinaryTree insertNode(int val) {
		if (root == null) {
			TreeNode rootNode = new TreeNode(val);
			root = rootNode;
			return this;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left == null) {
				TreeNode left = new TreeNode(val);
				node.left = left;
				break;
			} else {
				queue.offer(node.left);
			}
			if (node.right == null) {
				TreeNode right = new TreeNode(val);
				node.right = right;
				break;
			} else {
				queue.offer(node.right);
			}
		}
		return this;
	}
	
	public TreeNode insertAndReturnNode(int val) {
		if (root == null) {
			TreeNode rootNode = new TreeNode(val);
			root = rootNode;
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left == null) {
				TreeNode left = new TreeNode(val);
				node.left = left;
				return left;
			} else {
				queue.offer(node.left);
			}
			if (node.right == null) {
				TreeNode right = new TreeNode(val);
				node.right = right;
				return right;
			} else {
				queue.offer(node.right);
			}
		}
		return null;
	}

	public Node<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node<T> rootNode) {
		this.rootNode = rootNode;
	}

	public BinaryTree<T> addNode(Node<T> node) {
		Node<T> currentNode = null;
		if (rootNode == null) {
			this.rootNode = node;
			currentNode = rootNode;
			currentNode.setInsertionSequence(0);
		} else {
			currentNode = rootNode;
			while (true) {
				if (node.getData().compareTo(currentNode.getData()) < 0) {
					if (currentNode.getLeftNode() == null) {
						currentNode.setLeftNode(node);
						break;
					} else {
						currentNode = currentNode.getLeftNode();
					}
				} else if (node.getData().compareTo(currentNode.getData()) > 0) {
					if (currentNode.getRightNode() == null) {
						currentNode.setRightNode(node);
						break;
					} else {
						currentNode = currentNode.getRightNode();
					}
				}
			}
		}
		node.setInsertionSequence(currentNode.getInsertionSequence() + 1);
		node.setParentNode(currentNode);
		return this;
	}

	public String printBinaryTree(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		StringBuffer sb = new StringBuffer();
		Node<T> rootNode = node;
		if (node != null) {
			queue.add(node);
			while (!queue.isEmpty()) {
				Node<T> n = queue.peek();
				int depth = findDepth(n);
				for (int i = 0; i < depth; i++) {
					sb.append("\t");
				}
				int level = queue.size();
				while (level > 0) {
					Node<T> current = queue.remove();
					Node<T> parent = current.getParentNode();
					if (current.getParentNode() != null
							&& current.getData().compareTo(current.getParentNode().getData()) > 0) {
						sb.append("\t");
					}
					sb.append(current.getData());
					if (current.getLeftNode() != null) {
						queue.add(current.getLeftNode());
					}
					if (current.getRightNode() != null) {
						queue.add(current.getRightNode());
					}
					sb.append("\t");
					level--;
				}
				sb.append("\n");
			}
		}
		return sb.toString();

	}

	public Integer findDepth(Node<T> node) {
		if (node != null) {
			int left = findDepth(node.getLeftNode());
			int right = findDepth(node.getRightNode());
			return (left >= right) ? left + 1 : right + 1;
		} else {
			return 0;
		}
	}

	public Node<T> deleteNode(Node<T> root, T data) {
		if (root == null)
			return null;
		else {
			if (data.compareTo(root.getData()) < 0) {
				root.setLeftNode(deleteNode(root.getLeftNode(), data));
			} else if (data.compareTo(root.getData()) > 0) {
				root.setRightNode(deleteNode(root.getRightNode(), data));
			} else {
				if (root.getLeftNode() == null && root.getRightNode() == null) {
					root = null;
				} else if (root.getLeftNode() == null) {
					root = root.getRightNode();
				} else if (root.getRightNode() == null) {
					root = root.getLeftNode();
				} else {
					Node<T> temp = findMinimum(root.getRightNode());
					root.setData(temp.getData());
					root.setRightNode(deleteNode(root.getRightNode(), temp.getData()));
				}
			}
			return root;
		}
	}

	public Node<T> findMinimum(Node<T> root) {
		if (root.getLeftNode() == null)
			return root;
		else {
			return findMinimum(root.getLeftNode());
		}
	}

	public String printInorderTraversal(Node<T> root) {
		StringBuffer sb = new StringBuffer();
		if (root != null) {
			sb.append(printInorderTraversal(root.getLeftNode()));
			sb.append(root.getData().toString() + "->");
			sb.append(printInorderTraversal(root.getRightNode()));
		}
		return sb.toString();
	}

	public Node<T> findSuccesor(Node<T> root, Node<T> node) {
		if (findKey(root, node.getData())) {
			if (node.getRightNode() != null) {
				return findMinimum(root.getRightNode());
			} else {
				Node<T> successor = null;
				while (root != null) {
					if (node.getData().compareTo(root.getData()) < 0) {
						successor = root;
						root = root.getLeftNode();
					} else {
						root = root.getRightNode();
					}
				}
				return successor;
			}
		} else {
			return null;
		}
	}

	public Node<T> findMaximum(Node<T> root) {
		if (root.getRightNode() != null) {
			return findMaximum(root.getRightNode());
		} else {
			return root;
		}
	}

	public Node<T> findPredecessor(Node<T> root, Node<T> node) {
		if (findKey(root, node.getData())) {
			if (node.getLeftNode() != null) {
				return findMaximum(root.getLeftNode());
			} else {
				Node<T> predecessor = null;
				while (root != null) {
					if (node.getData().compareTo(root.getData()) > 0) {
						predecessor = root;
						root = root.getRightNode();
					} else {
						root = root.getLeftNode();
					}
				}
				return predecessor;
			}
		} else {
			return null;
		}
	}

	public boolean findKey(Node<T> root, T key) {
		if (root != null) {
			if (key.compareTo(root.getData()) < 0) {
				return findKey(root.getLeftNode(), key);
			} else if (key.compareTo(root.getData()) > 0) {
				return findKey(root.getRightNode(), key);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static void main(String arg[]) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(6);
		bt.addNode(new Node<Integer>(8)).addNode(new Node<Integer>(5)).addNode(new Node<Integer>(10))
				.addNode(new Node<Integer>(7)).addNode(new Node<Integer>(3)).addNode(new Node<Integer>(9))
				.addNode(new Node<Integer>(4)).addNode(new Node<Integer>(1)).addNode(new Node<Integer>(2));

		System.out.println(bt.printBinaryTree(bt.getRootNode()));
		System.out.println(bt.printInorderTraversal(bt.getRootNode()));
		System.out.println(bt.printBinaryTree(bt.deleteNode(bt.getRootNode(), 6)));
		System.out.println(bt.printInorderTraversal(bt.getRootNode()));
		// System.out.println(bt.findSuccesor(bt.getRootNode(), new
		// Node<Integer>(12)).getData());
		System.out.println(bt.findPredecessor(bt.getRootNode(), new Node<Integer>(5)).getData());

	}
}
