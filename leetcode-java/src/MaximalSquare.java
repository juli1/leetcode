/*
 * Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing all 1's and return its area.
 * 
 * Lintcode: http://lintcode.com/en/problem/maximal-square/
 */

public class MaximalSquare {
	public int findSquare(int[][] matrix, int x, int y)
	{
		
		int pos = 1;
		while ((x + pos < matrix.length) && (y+pos < matrix[0].length))
		{
			
			for (int k = y; k <= y + pos ; k++)
			{
				if (matrix[x+pos][k] == 0)
				{
					return pos;
				}
			}
			for (int k = x; k <= x + pos ; k++)
			{
				if (matrix[k][y+pos] == 0)
				{
					return pos;
				}
			}
			
			pos++;
		}
		
		return pos;
	}
	
	
	
    public int maxSquare(int[][] matrix) {
    	int max = 0;
        for (int i = 0 ; i < matrix.length ; i++)
        {
        	for (int j = 0 ; j < matrix[0].length ; j++)
        	{
        		if (matrix[i][j] == 1)
        		{
        			int v = findSquare(matrix, i, j);
        			System.out.println("i=" + i + "j=" + j + "v=" + v);
            		max = Math.max(max, v);	
        		}
        		
        	}
        }
        return max * max;
    }
    
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		//int[][] matrix = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		MaximalSquare sol = new MaximalSquare();
		
		System.out.println(sol.maxSquare(matrix));
	}

}
