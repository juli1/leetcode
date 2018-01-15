/*
 *  98. Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Lintcode: http://lintcode.com/en/problem/sort-list/
 * 
 */
public class SortList {
	public int listSize(ListNode head)
	{
		int res = 0;
		while (head != null)
		{
			res++;
			head = head.next;
		}
		return res;
	}
	
	public ListNode mergeList(ListNode left, ListNode right)
	{
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		while(left != null && right != null)
		{
			if (left.val < right.val)
			{
				current.next = left;
				left = left.next;
			}
			else
			{
				current.next = right;
				right = right.next;
			}
			current = current.next;
		}
		
		while (left!=null)
		{
			current.next = left;
			current = current.next;
			left = left.next;
		}
		while (right!=null)
		{
			current.next = right;
			current = current.next;
			right = right.next;
		}
		current.next = null;
		
		
		return  head.next;
	}
	
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        {
        	return head;
        }
        
        int size = listSize(head);
        int med = size / 2;
        ListNode left = head;
        ListNode right = head;
        ListNode t = left;
        
        
        while (med >1)
        {
        	t = t.next;
        	right = right.next;
        	med--;
        }
        
        right = right.next;
        t.next = null;
        
        left = sortList(left);
        right = sortList(right);
        
        return mergeList(left, right);
        
        
        
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(6);
		SortList sol = new SortList();
		ListNode sorted = sol.sortList(head);
		Utils.printList(sorted);
	}

}
