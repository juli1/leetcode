

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    		if (strs.length == 0)
    		{
    			return "";
    		}
		StringBuilder sb = new StringBuilder();
		int[] pos = new int[strs.length];
		Arrays.fill(pos, 0);
		int smallestLen = Integer.MAX_VALUE;
		for (String s : strs)
		{
			smallestLen = Math.min(smallestLen, s.length());
		}
		
		int current = 0;
		while (current < smallestLen)
		{
			char c = strs[0].charAt(current);
			for (int i = 0 ; i < strs.length ; i++)
			{
				if (strs[i].charAt(current) != c)
				{
					return sb.toString();
				}
			}
			sb.append(c);
			current++;
		}
		return sb.toString();
		
    }
	public static void main(String[] args) {
		String[] strings = new String[] {"ABCDEFG","ABCEFG","ABCEFA"};
		LongestCommonPrefix sol = new LongestCommonPrefix();
		System.out.println(sol.longestCommonPrefix(strings));
		
	}

}
