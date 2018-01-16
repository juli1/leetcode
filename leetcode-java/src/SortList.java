package leetcode;

public class SortList {
	public String printLinkedList(ListNode head)
	{
		StringBuilder sb = new StringBuilder();
		while(head != null)
		{
			sb.append(" " + head.val);
			head = head.next;
		}
		return sb.toString();
	}
	
	public ListNode mergeNodes(ListNode left, ListNode right)
	{
		ListNode head = new ListNode(0);
		ListNode t = head;
		while (left != null && right != null)
		{
			if (left.val < right.val)
			{
				head.next = left;
				left = left.next;
			}
			else
			{
				head.next = right;
				right = right.next;
			}
		}
		while (left != null)
		{
			head.next = left;
			left = left.next;
		}
		while (right != null)
		{
			head.next = right;
			right = right.next;
		}
		head.next = null;
		return t.next;
	}
	
    public ListNode sortList(ListNode head) {
    		if (head == null || head.next == null)
    			return head;
    		
        int size = 0;
        ListNode t = head;
        while (t != null)
        {
        		size++;
        		t = t.next;
        }
        ListNode left = head;
        t = head;
        ListNode right = head.next;
        
        for (int i = 1 ; i < size / 2 ; i++)
        {
        		t = t.next;
        		right = right.next;
        		
        }
        
        t.next = null;
        right.next = null;
        sortList(left);
        sortList(right);
        
        return mergeNodes(left, right);
        	
    }
    
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next = new ListNode(4);
		SortList sol = new SortList();
		ListNode bla = sol.sortList(head);
		System.out.println("solution"+sol.printLinkedList(bla));

	}
}
