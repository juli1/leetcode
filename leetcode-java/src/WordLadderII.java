import java.util.*;

public class WordLadderII {
	int min;
	
	public void helper(String end, Set<String> dict, Stack<String> current, List<List<String>> result)
	{
		if (current.size() > min)
		{
			return;
		}
		char[] array = current.peek().toCharArray();
		for (int i = 0 ; i < array.length ; i++)
		{
			char orig = array[i];
			
			for (int j = 0 ; j < 26 ; j++)
			{
				char newchar = (char)('a' + j);
				if (newchar==orig)
				{
					continue;
				}
				array[i] = newchar;
				String tosearch = new String(array);
				
				if (tosearch.equalsIgnoreCase(end))
				{
					current.push(tosearch);
					min = Math.min(min, current.size());
					result.add(new ArrayList<String>(current));
					current.pop();
				}
				else
				{
					if (dict.contains(tosearch) && ! current.contains(tosearch))
					{
						current.push(tosearch);
						helper(end, dict, current, result);
						current.pop();
					}
				}
			}
			array[i] = orig;
		}
	}
	
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<List<String>> finalresult = new ArrayList<List<String>>();
        Stack<String> current = new Stack<String>();
        current.push(start);
        min = Integer.MAX_VALUE;
        helper(end, dict, current, result);
       
  
        for (List<String> l : result)
        {
        	if (l.size() == min )
        	{
        		finalresult.add(l);
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadderII sol = new WordLadderII();
		System.out.println(sol.findLadders("hit","cog" , dict));
	}

}
