
public class Utils {
	public static void printList(ListNode node)
	{
		StringBuilder sb = new StringBuilder();
		while(node != null)
		{
			sb.append(node.val + " ");
			node = node.next;
		}
		System.out.println( sb.toString());
	}
}
