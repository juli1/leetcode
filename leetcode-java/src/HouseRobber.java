/*
 *  392. House Robber
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Lintcode: http://lintcode.com/en/problem/house-robber/
 * 
 */
public class HouseRobber {
    public long houseRobber(int[] A) {
        if (A.length == 0)
        {
        	return 0;
        }
        if (A.length == 1)
        {
        	return A[0];
        }
        if (A.length == 2)
        {
        	return A[1];
        }
        long[] gain = new long[A.length];
        gain[0] = A[0];
        gain[1] = A[1];
        for (int i = 2 ; i < A.length ; i++)
        {
        	gain[i] = Math.max(gain[i-2] + A[i], gain[i-1]);
        }
        
        
        return gain[A.length - 1];
    }
    
	public static void main(String[] args) {
		int[] plop = {3,8,4};
		HouseRobber sol = new HouseRobber();
		
		System.out.println(sol.houseRobber(plop));

	}

}
