package leetcode;
import java.util.*;
public class MinimumWindowSubstring {
	public void copyHash(Map<Character, Integer> destination, Map<Character, Integer> source)
	{
		for (Character c : source.keySet())
		{
			destination.put(c, source.get(c));
		}
	}
    public String minWindow(String source , String target) {
    		String minimumString = null;
    		
    		int start = 0;
    		int end = 0;
    		int currentNbMatches = 0;
        Map<Character, Integer> targetCount = new HashMap<Character,Integer>();
        for (int i = 0 ; i < target.length() ; i++)
        {
        		char c = target.charAt(i);
        		targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> currentCount = targetCount;
        while(end < source.length())
        {
        		char c = source.charAt(end);
        		if (currentCount.containsKey(c))
        		{
        			currentCount.put(c, currentCount.get(c) - 1);
        			if (currentCount.get(c) >=0)
        			{
        				currentNbMatches++;
        			}
        			while (currentNbMatches == target.length())
        			{
        				if (currentCount.containsKey(source.charAt(start)))
        				{
        					currentCount.put(source.charAt(start), currentCount.get(source.charAt(start)) + 1);
        					if(currentCount.get(source.charAt(start)) > 0)
        					{
        						currentNbMatches--;
        					}
        				}
        				if ((minimumString == null) || (minimumString.length() > end - start))
            			{
            				minimumString = source.substring(start, end + 1);
            			}
        				start++;
        			}
        			
        			end++;
        			
        		}
        		else
        		{
        			end++;
        		}
        }
        
        return minimumString == null ? "" : minimumString;
    }
	public static void main(String[] args) {
		MinimumWindowSubstring sol = new MinimumWindowSubstring();
		System.out.println(sol.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

	}

}
