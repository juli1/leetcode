import java.util.Arrays;

/*
 *  92. Backpack
 *
 * Given n items with size Ai, an integer m denotes 
 * the size of a backpack. How full you can fill this backpack?
 *
 * You can not divide any item into small pieces.
 *
 * Example
 *
 * If we have 4 items with size [2, 3, 5, 7], 
 * the backpack size is 11, we can select [2, 3, 5], 
 * so that the max size we can fill this backpack is 10. 
 * If the backpack size is 12. we can select [2, 3, 7]
 * so that we can fulfill the backpack.
 *
 * You function should return the max size we can fill in the given backpack.
 *
 * Lintcode: http://lintcode.com/en/problem/backpack/
 */

public class Bagpack {
    
    public int backPack(int m, int[] A) {
    	int[][] dp = new int[m+1][A.length + 1];

    	for (int distance = 1 ; distance <= m ; distance++)
    	{
    		for (int item = 1 ; item <= A.length ; item++)
    		{
    			if (distance - A[item - 1] >= 0)
    			{
    				dp[distance][item] = Math.max(dp[distance][item - 1], A[item-1] + dp[distance-A[item-1]][item-1]);
    			}
    			else
    			{
    				dp[distance][item] = dp[distance][item -1];
    			}
    		}
    	}
    	return dp[m][A.length];
    }
    
	public static void main(String[] args) {
		Bagpack sol = new Bagpack();
		
		int[] nums = new int[] {2,3,5,7};
		System.out.println(sol.backPack(11, nums));
		
		nums = new int[] {12,3,7,4,5,13,2,8,4,7,6,5,7};
		System.out.println(sol.backPack(90, nums));
		nums = new int[] {828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
		System.out.println(sol.backPack(5000, nums));

	}

}
