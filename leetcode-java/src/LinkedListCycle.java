
import java.util.*;
/*
 *  103. Linked List Cycle II

    Description
    Notes
    Testcase
    Judge

Given a linked list, return the node where the cycle begins.

If there is no cycle, return null.

Lintcode: http://lintcode.com/en/problem/linked-list-cycle-ii/
 */
public class LinkedListCycle {
	
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null)
        {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast != null && fast.next != null && slow != null && slow != fast)
        {
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (slow == null || fast ==null)
        {
        	return null;
        }
        slow = head;
        
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
	public static void main(String[] args) {
		LinkedListCycle sol = new LinkedListCycle();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head.next;
		
		ListNode found = sol.detectCycle(head);
		System.out.println(found != null ? found.val : "not found");
	}

}
