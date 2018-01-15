/* Pow(x,n)
 * Implement pow(x, n).
 * 
 * Lintcode: http://lintcode.com/en/problem/powx-n/#
 * Leetcode: https://leetcode.com/problems/powx-n/discuss/19546/
 * https://leetcode.com/problems/powx-n/description/
 */
public class Pow {
	public class Solution {
	    /*
	     * @param x: the base number
	     * @param n: the power number
	     * @return: the result
	     */
	    public double myPow(double x, int n) {
	        if(n == 0)
	        {
	            return 1;
	        }
	        if (n < 0)
	        {
	            x = 1/x;
	            n = -1 * n;
	        }
	        return (n%2 == 0) ? myPow(x*x, n/2) : x* myPow(x*x, n/2);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
