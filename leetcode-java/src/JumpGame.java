import java.util.Arrays;

/*
 *  116. Jump Game
 *
 * Given an array of non-negative integers, you are 
 * initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum 
 * jump length at that position.
 * Determine if you are able to reach the last index. 
 * 
 * Lintcode: http://lintcode.com/en/problem/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] A) {
    	boolean possible[] = new boolean[A.length];
    	Arrays.fill(possible, false);
    	possible[0] = true;
    	for (int i = 0 ; i < A.length ; i++)
    	{
    		if (possible[i])
    		{
    			int nextStep = A[i] + i;
    			if (nextStep >= A.length)
				{
					return true;
				}
    			for (int j = i ; j <= i + A[i] ; j++)
    			{
    				possible[j] = true;
    			}
    		}
    	}
    	return possible[A.length - 1];
    }
    
	public static void main(String[] args) {
		JumpGame sol = new JumpGame();
		
		int[] nums;
		nums = new int[] {2,3,1,1,4};
		System.out.println(sol.canJump(nums));
		
		nums = new int[] {3,2,1,0,4};
		System.out.println(sol.canJump(nums));
	}

}
