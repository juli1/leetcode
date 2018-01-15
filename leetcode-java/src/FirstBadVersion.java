/*
 * The code base version is an integer start from 1 to n. 
 * One day, someone committed a bad version in the code case, 
 * so it caused this version and the following versions are all 
 * failed in the unit tests. Find the first bad version.
 * You can call isBadVersion to help you determine which 
 * version is the first bad one. 
 * The details interface can be found in the code's annotation part.
 */
public class FirstBadVersion {
	static class SVNRepo {
		static boolean isBadVersion(int m)
		{
			return false;
		}
	}
	/**
	 * public class SVNRepo {
	 *     public static boolean isBadVersion(int k);
	 * }
	 * you can use SVNRepo.isBadVersion(k) to judge whether 
	 * the kth code version is bad or not.
	*/

	public class Solution {
	    /*
	     * @param n: An integer
	     * @return: An integer which is the first bad version.
	     */
	    public int findFirstBadVersion(int n) {
	        return helper(0, n);
	    }
	    
	    public int helper(int start, int end)
	    {
	        System.out.println("start=" + start + "end="  + end);
	        if (start == end)
	        {
	            return start;
	        }
	        
	        if (end - start == 1)
	        {
	            if(SVNRepo.isBadVersion(start))
	            {
	                return start;
	            }
	            return end;
	        }
	        
	        int m = start +( (end - start) / 2);
	        if (SVNRepo.isBadVersion(m))
	        {
	            return helper(start, m);
	        }
	        return helper(m+1, end);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
