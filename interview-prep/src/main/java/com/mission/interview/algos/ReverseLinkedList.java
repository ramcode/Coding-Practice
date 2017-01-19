package com.mission.interview.algos;

public class ReverseLinkedList {
public static void main(String arg[]){
	LinearLinkedList<Integer> head = new LinearLinkedList<Integer>(10);
	head.insertNode(11);
	head.insertNode(12);
	head.insertNode(13);
	head.insertNode(14);
	head.insertNode(15);
	head.insertNode(16);
	head.printList(head.getHead());
}
}
