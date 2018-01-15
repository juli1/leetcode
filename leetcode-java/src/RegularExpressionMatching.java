/*
 * Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true

	Leetcode: https://leetcode.com/problems/regular-expression-matching/description/
	Lintcode: 
 */
public class RegularExpressionMatching {
	boolean isMatch(String s, String p)
	{
		return helper(s,0,p,0);
	}
	
	boolean helper(String s, int poss, String p, int posp)
	{
		if (posp >= p.length())
		{
			return poss >= s.length();
		}
		
		if(poss >= s.length())
		{
			return false;
		}
		
		boolean has_star = posp < p.length() - 1 ? p.charAt(posp+1) == '*' : false;
		if (!has_star)
		{
			
			if(p.charAt(posp) != '.' && s.charAt(poss) != p.charAt(posp))
			{
				return false;
			}
			return helper(s, poss+1, p, posp+1);
		}
		else
		{
			char c = p.charAt(posp);
			
			while (poss < s.length() && ((s.charAt(poss) == c) || (c == '.')))
			{
				if(helper(s, poss, p, posp +2))
				{
					return true;
				}
					
				poss++;
			}
			return helper(s,poss, p, posp + 2);
		}
	}
	
	
	public static void main(String[] args) {
		String s     = "aaaaabcgdhdhjajajajawababaw";
		String match = ".*w";
		RegularExpressionMatching sol = new RegularExpressionMatching();
		System.out.println(sol.isMatch(s, match));
	}
}
