package leetcode;

public class ReverseLinkedListII {
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode foo = new ListNode(0);
        foo.next = head;
        ListNode left = foo;
        ListNode right = foo;
        for(int i = 0 ; i < m - 1 ; i++)
        {
        		left = left.next;
        }
        
        ListNode toswap = left.next;
        
        for (int i = 0 ; i < n - m ; i++)
        {
        		ListNode oldnext = left.next;
        		ListNode newnext = toswap.next;
        		toswap.next = toswap.next.next;
        		left.next = newnext;
        		left.next.next = oldnext;
        }
        return foo.next;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		ReverseLinkedListII sol = new ReverseLinkedListII();
		sol.reverseBetween(head, 2, 4);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}

}

