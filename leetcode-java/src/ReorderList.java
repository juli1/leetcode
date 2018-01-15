/*
 *  99. Reorder List
 *
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 *
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * 
 * Lintcode: http://lintcode.com/en/problem/reorder-list/
 */

import java.util.*;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null)
        {
        	return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        
        int size = 0;
        ListNode tail = head;
        while (tail.next != null)
        {
        	tail = tail.next;
        	size++;
        }
        size++;
        
        if (size <= 2)
        {
        	return;
        }
        System.out.println("size=" + size);
        
        tail = head;
        for (int i = 0 ; i < size / 2 ; i++)
        {
        	tail = tail.next;
        }
        while (tail!=null)
        {
        	stack.push(tail);
        	tail = tail.next;
        }
        
        while(!stack.isEmpty())
        {
        	ListNode t = stack.pop();
        	ListNode n = head.next;
        	t.next = n;
        	head.next = t;
        	head = n;
        }
        head.next = null;
        
    }
    
    
	public static void main(String[] args) {
		ReorderList sol = new ReorderList();
		ListNode head = new ListNode(0);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = null;
		Utils.printList(head);
		sol.reorderList(head);
		Utils.printList(head);
		
		head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = null;
		Utils.printList(head);
		sol.reorderList(head);
		Utils.printList(head);

	}

}
