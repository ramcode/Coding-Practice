package com.interview.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
	
	public static boolean detectCycle(Node head){
		Map<Node, Integer> map = new HashMap<Node ,Integer>();
		while(head!=null){
			if(map.containsKey(head)) return true;
			map.put(head, 1);
			head = head.next;
		}
		return false;
	}
	
	public static boolean detectCyclePointers(Node head){
		Node slow = head;
		Node fast = head;
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) return true;
		}
		return false;
	}

	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.insert(5);
		Node start = l1.insertNode(2);
		l1.insert(3);
		l1.insert(-3);
		Node end= l1.insertNode(6);
		//end.next = start;
		
		System.out.println(detectCyclePointers(l1.head));
		
	
	}
}
