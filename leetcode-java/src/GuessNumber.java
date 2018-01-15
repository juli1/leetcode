/*
 * Guess Number Game
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * Lintcode: http://lintcode.com/en/problem/guess-number-game/
 */

/* remove the GuessGame class to run in leetcode/lintcode environment */

class GuessGame {
	public int guess (int n)
	{
		return 0;
	}
}

public class GuessNumber {
	public class Solution extends GuessGame {
	    /**
	     * @param n an integer
	     * @return the number you guess
	     */
	    public int guessNumber(int n) {
	        return helper(1, n);
	    }
	    
	    public int helper(int start, int end)
	    {

	        int mid = start + ((end - start) / 2);
	        int ret = guess (mid);
	        if (ret == 0)
	        {
	            return (mid);
	        }
	        
	        if (ret == -1)
	        {
	            return helper(start, mid - 1);
	        }
	        return helper(mid+1, end);
	        
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
