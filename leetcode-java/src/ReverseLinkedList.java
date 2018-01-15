/*
 *  35. Reverse Linked List
 *
 * Reverse a linked list.
 * 
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 *
 * Lintcode: http://lintcode.com/en/problem/reverse-linked-list/
 */


public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode tmp = new ListNode(0);
        tmp.next = null;
        while (head != null)
        {
            ListNode t = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = t;
        }
        return tmp.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
