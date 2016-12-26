package com.mission.interview.algos;

public class LinearLinkedList<T extends Comparable<T>> {
	private LinkedNode<T> head;

	public LinearLinkedList(T data) {
		this.head = new LinkedNode<T>(data);
	}

	public LinkedNode<T> getHead() {
		return head;
	}

	public void setHead(LinkedNode<T> head) {
		this.head = head;
	}

	public LinkedNode<T> insertNode(T data) {
		LinkedNode<T> temp = this.head;
		if (temp == null) {
			head = new LinkedNode<T>(data);
		} else {
			while (temp.next != null) {
				temp = temp.getNext();
			}
			LinkedNode<T> node = new LinkedNode<T>(data);
			temp.setNext(node);
		}
		return head;
	}

	public LinkedNode<T> insertNode(LinkedNode<T> node) {
		LinkedNode<T> temp = this.head;
		if (temp == null) {
			head = new LinkedNode<T>(node.data);
		} else {
			while (temp.next != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		return head;
	}

	public void printList(LinkedNode<T> head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.print("null" + "\n");
	}

	public LinkedNode<T> reverseLinkedListItr(LinkedNode<T> head) {
		if (head == null) {
			return null;
		} else {

			LinkedNode<T> prev = null;
			LinkedNode<T> current = head;
			LinkedNode<T> next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;

		}

	}

	public LinkedNode<T> reverseLinkedListRec(LinkedNode<T> head) {

		if (head == null || head.next == null) {
			return head;
		} else {
			LinkedNode<T> temp = head.next;
			head.next = null;
			LinkedNode<T> newHead = reverseLinkedListRec(temp);
			temp.next = head;
			return newHead;
		}
	}

	public boolean detectLoop(LinkedNode<T> node) {
		if (node == null) {
			return true;
		} else {
			LinkedNode<T> head = this.getHead();
			LinkedNode<T> slow = head;
			LinkedNode<T> fast = head;
			while (slow != null && fast != null) {
				fast = fast.next;
				if (fast == null) {
					return false;
				}
				if (slow == fast) {
					return true;
				}
				fast = fast.next;
				if (fast == null) {
					return false;
				}
				if (fast == slow) {
					return true;
				}
				slow = slow.next;
			}
			return false;
		}
	}

	public static void main(String arg[]) {
		/*
		 * LinearLinkedList<Integer> head = new LinearLinkedList<Integer>(10);
		 * head.insertNode(11); head.insertNode(12); head.insertNode(13);
		 * head.insertNode(14); head.insertNode(15); head.insertNode(16);
		 * System.out.println("LinkedList->"); head.printList(head.getHead());
		 * LinkedNode<Integer> newHead =
		 * head.reverseLinkedListItr(head.getHead()); System.out.println(
		 * "Printing Reverse using Itr->"); head.printList(newHead);
		 * LinkedNode<Integer> newRecHead = head.reverseLinkedListRec(newHead);
		 * System.out.println("Printing Reverse using Rec->");
		 * head.printList(newRecHead);
		 */

		// Looped linked List

		LinearLinkedList<Integer> loopedList = new LinearLinkedList<Integer>(10);
		LinkedNode<Integer> n1 = new LinkedNode<Integer>(11);
		loopedList.insertNode(n1);
		LinkedNode<Integer> n2 = new LinkedNode<Integer>(12);
		loopedList.insertNode(n2);
		LinkedNode<Integer> n3 = new LinkedNode<Integer>(13);
		loopedList.insertNode(n3);
		LinkedNode<Integer> n4 = new LinkedNode<Integer>(14);
		loopedList.insertNode(n4);
		LinkedNode<Integer> n5 = new LinkedNode<Integer>(15);
		loopedList.insertNode(n5);
		LinkedNode<Integer> n6 = new LinkedNode<Integer>(16);
		loopedList.insertNode(n6);
		//n6.next = n3;
		System.out.println("Has Loop---->"+loopedList.detectLoop(loopedList.getHead()));

	}
}
