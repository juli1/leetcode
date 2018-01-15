/*
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 * 
 * In other words, given two integer arrays val[0..n-1] 
 * and wt[0..n-1] which represent values and weights 
 * associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] such that sum of 
 * the weights of this subset is smaller than or equal to W. 
 * 
 * You cannot break an item, either pick the complete item, 
 * or don’t pick it (0-1 property).
 * 
 * Geek for geeks: https://www.geeksforgeeks.org/knapsack-problem/
 */
public class Knapsack {
 
	int knapsack(int[] values, int[] weight, int capacity)
	{
		int K[][] = new int[weight.length+1][capacity+1];
		
		for (int i = 0 ; i <= weight.length ; i++)
		{
			for (int j = 0 ; j <= capacity ; j++)
			{
				if ((i == 0) || (j == 0))
				{
					K[i][j] = 0;
					continue;
				}
				
				if(weight[i-1] <= j)
				{
					K[i][j] = Math.max(values[i-1] + K[i-1][j-weight[i-1]], K[i-1][j]);
				}
				else
				{
					K[i][j] = K[i-1][j];
				}
			}
		}
		
		return K[weight.length][capacity];
	}
	
	
	public static void main(String[] args) {
		Knapsack sol = new Knapsack();
				
		int[] values = new int[] {60,100,120};
		int[] weight = new int[] {10,20,30};
		int capacity = 50;
		int solution = sol.knapsack(values, weight, capacity);
		System.out.println(solution);
	}

}
