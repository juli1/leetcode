package leetcode;
import java.util.*;
import java.util.HashMap;

public class InterleaveString {
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if (s3.length() != s1.length() + s2.length())
        {
        		return false;
        }
		return isInterleave(s1, 0, s2, 0, s3, 0);
		
	}
    public boolean isInterleave(String s1, int pos1, String s2, int pos2, String s3, int pos3) {
    		if (pos1 == s1.length() && pos2 == s2.length())
    		{
    			return true;
    		}
    		if (pos1 < s1.length())
    		{
    			if(s1.charAt(pos1) == s3.charAt(pos3))
    			{
    				if (isInterleave(s1, pos1+1, s2, pos2, s3, pos3 + 1))
    				{
    					return true;
    				}
    			}
    		}
    		if (pos2 < s2.length())
    		{
    			if(s2.charAt(pos2) == s3.charAt(pos3))
    			{
    				if (isInterleave(s1, pos1, s2, pos2 + 1, s3, pos3 + 1))
    				{
    					return true;
    				}
    			}
    		}
    		
        return false;
    }
    
    
	public static void main(String[] args) {
		InterleaveString sol = new InterleaveString();
		System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
