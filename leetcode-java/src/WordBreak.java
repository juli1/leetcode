/*
 *  107. Word Break
 *
 * Given a string s and a dictionary of words dict,
 * determine if s can be break into a space-separated 
 * sequence of one or more dictionary words.
 * 
 * Lintcode: http://lintcode.com/en/problem/word-break/
 */

import java.util.*;

public class WordBreak {
	public boolean helper(String s, int start, Set<String> dict)
	{
		int len = s.length() - start;
		for (String word : dict){

			int wordLen = word.length();
			
			if (len >= wordLen) {
				String substr = s.substring(start, start + wordLen);
				if (substr.equals(word))
				{
					if (wordLen == len)
					{
						return true;
					}

					if(helper(s,start + wordLen, dict))
					{
						return true;
					}
						
				}
			}
		}
		return false;
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
    	if (s.length() == 0)
    	{
    		return true;
    	}
    	if(dict.size() == 0)
    	{
    		return false;
    	}
    	return helper(s, 0, dict);
    }
    
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("lint");
		dictionary.add("code");
		WordBreak sol = new WordBreak();
				
		System.out.println("result="+ sol.wordBreak("lintcode", dictionary));
	}

}
