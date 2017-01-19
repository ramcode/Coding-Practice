package com.interview.ds.linkedlist;

public class CheckPalindromeLL {
	
	public static boolean isPalindrome(Node head) {
        if(head==null) return true;
        Node slowPrev = null;
        Node slow = head;
        Node fast = head;
        Node mid = null;
         while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        if(fast!=null){
            mid = slow;
            
        }
        else {
            mid = slowPrev;
        }
        Node rev  = reverseLL(mid.next);
        if(slowPrev!=null){
            slowPrev.next = null;
        }
        boolean isP = checkPalindrome(head, rev);
        Node org = reverseLL(rev);
        if(slowPrev!=null){
        slowPrev.next = org;
        }
        if(isP) return true;
        else return false;
    }
    public static Node reverseLL(Node head){
        Node prev = null;
        while(head!=null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static Node findMid(Node head){
        if (head==null) return head;
        Node slowPrev = null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            slowPrev = slow;
        }
        if(fast!=null) return slow;
        else return slowPrev;
    }
    
    public static boolean checkPalindrome(Node l1, Node l2){
        
        while(l1!=null && l2 !=null){
            if(l1.val!=l2.val){
             return false;
            }
        l1 = l1.next;
        l2 = l2.next;
        }
        return true;
        
    }
    
    public static void main(String[] args){
    	LinkedList l1 = new LinkedList();
		l1.insert(5);
		l1.insert(2);
    	System.out.println(isPalindrome(l1.head));
    }

}
