/*
 *  113. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Have you met this question in a real interview?
 * Example
 *
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * Lintcode: http://lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/
 */

import java.util.*;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode tmp = new ListNode(0);
        ListNode newHead = tmp;
        tmp.next = null;
        
        Set<Integer> duplicates = new HashSet<Integer>();
        while(node != null && node.next != null)
        {
            if (node.val == node.next.val)
            {
                duplicates.add(node.val);
            }
            node = node.next;
        }
        
        node = head;
        while(node != null)
        {
            if(!duplicates.contains(node.val))
            {
            	tmp.next = node;
            	tmp = tmp.next;
            	
            }
            node = node.next;
        }
        tmp.next = null;
        return newHead.next;
    }
    
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII sol = new RemoveDuplicatesFromSortedListII();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next = null;
		Utils.printList(head);
		sol.deleteDuplicates(head);
		Utils.printList(head);
	}

}
