package com.interview.ds.linkedlist;

public class SortLinkedList {

    public static Node sortList(Node head) {
        if(head==null || head.next==null) return head;
        Node[] splits = splitLL(head);
        Node left = sortList(splits[0]);
        Node right = sortList(splits[1]);
        return merge(left, right);
    }
    
    public static int length(Node head){
        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    
    public static Node merge(Node left, Node right){
        if(left==right) return left;
        Node dummy = new Node(-1);
        Node copy = dummy;
        Node tl = left, tr = right;
        while(tl!=null && tr!=null){
            if(tl.val==tr.val){
                dummy.next = new Node(tl.val);
                dummy.next.next = new Node(tl.val);
                dummy =  dummy.next.next;
                tl = tl.next;
                tr = tr.next;
            }
            else if(tl.val<tr.val){
                dummy.next = tl;
                dummy = tl;
                tl = tl.next;
            }
            else{
                dummy.next = tr;
                dummy = tr;
                tr = tr.next;
            }
        }
        
        if(tl==null && tr!=null) dummy.next = tr;
        if(tr ==null && tl!=null) dummy.next = tl;
        return copy.next;
    }
    
    public static Node[] splitLL(Node head){
        
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node first = head;
    Node left = first;
    while(first.next!=slow){
        first = first.next;
    }
    first.next = null;
    Node[] splits = new Node[2];
    splits[0] = left;
    splits[1] = slow;
    return splits;
    }
    
    
    public static void main(String[] args){
    	Node first = new Node(2);
    	Node second = new Node(3);
    	Node third = new Node(1);
    	first.next = second;
    	second.next = third;
    	LinkedList.iterateLL(sortList(first));
    }

	
	

}
