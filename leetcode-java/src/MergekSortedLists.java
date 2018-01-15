/*
 *  104. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * Lintcode: http://lintcode.com/en/problem/merge-k-sorted-lists/
 * 
 */

import java.util.*;

public class MergekSortedLists {
	/**
	 * Definition for ListNode.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int val) {
	 *         this.val = val;
	 *         this.next = null;
	 *     }
	 * }
	 */ 

	    public ListNode getMinimumNode(List<ListNode> lists)
	    {
	        ListNode res = null;
	        int listIndex = 0;
	        for (int i = 0 ; i < lists.size() ; i++)
	        {
	            if (lists.get(i) != null && res == null)
	            {
	                res = lists.get(i);
	            }
	            if (lists.get(i) == null)
	            {
	                continue;
	            }
	            if (lists.get(i).val <= res.val)
	            {
	                res = lists.get(i);
	                listIndex = i;
	            }
	        }
	        if (res != null)
	        {
	            lists.set(listIndex, res.next);
	        }
	        return res;
	    }
	    
	    /**
	     * @param lists: a list of ListNode
	     * @return: The head of one sorted list.
	     */
	    public ListNode mergeKLists(List<ListNode> lists) {  
	        ListNode front = new ListNode(0);
	        ListNode current;
	        ListNode newNode;
	        current = front;
	        while ( (newNode = getMinimumNode(lists)) != null)
	        {
	            current.next = newNode;
	            current = current.next;
	            current.next = null;
	        }
	        
	        return front.next;
	    }
	

	public static void main(String[] args) {
		MergekSortedLists sol = new MergekSortedLists();
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode n = new ListNode(34);
		lists.add(n);
		System.out.println(sol.getMinimumNode(lists));
	}

}
