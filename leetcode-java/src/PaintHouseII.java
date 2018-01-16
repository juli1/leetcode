
/*
 *  516. Paint House II
 *
 * There are a row of n houses, each house can be painted with
 * one of the k colors. The cost of painting each house with a
 * certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is
 * represented by a n x k cost matrix. For example, costs[0][0] 
 * is the cost of painting house 0 with color 0; costs[1][2] is 
 * the cost of painting house 1 with color 2, and so on... 
 * Find the minimum cost to paint all houses.
 *
 * Lintcode: http://lintcode.com/en/problem/paint-house-ii/
 */

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        
        if (costs.length == 0)
        {
            return 0;
        }
        if (costs[0].length == 0)
        {
            return 0;
        }
        int houses = costs.length;
        int colors = costs[0].length;
        
        for (int i = 1 ; i < houses ; i++)
        {
            for (int color = 0 ; color < colors ; color++)
            {
                int min = Integer.MAX_VALUE;
                for (int other_color = 0 ; other_color < colors ; other_color++)
                {
                    if (other_color == color)
                    {
                        continue;
                    }
                    min = Math.min(min, costs[i-1][other_color+colors%colors]);
                    
                }
                costs[i][color] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int color = 0 ; color < colors ; color++)
        {
            min = Math.min(min, costs[houses -1][color]);
        }
        return min;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
