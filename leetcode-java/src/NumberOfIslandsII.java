/*
 * 
 * A 2d grid map of m rows and n columns is initially 
 * filled with water. We may perform an addLand operation 
 * which turns the water at position (row, col) into a land.
 * 
 * Given a list of positions to operate, count the number of 
 * islands after each addLand operation. An island is surrounded 
 * by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 * 
 * Programcreek: https://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/
 * 
 */

import java.util.*;

public class NumberOfIslandsII {
	int[][] surroundings = new int[][] {{0,-1},{0,1},{1,0},{-1,0}}; 
	public List<Integer> numIslands2(int m, int n, int[][] positions)
	{
		int[] rootArray = new int [m * n];
		List<Integer> counts = new ArrayList<Integer>();
		Arrays.fill(rootArray, -1);
		int countIslands = 0;
		
		for (int i = 0 ; i < positions.length ; i++)
		{
			int positionIndex = positions[i][0] *  m + positions[i][1];
			rootArray[positionIndex] = positionIndex;
			countIslands++;
			for (int[] surrounding : surroundings)
			{
				int surroundingX = positions[i][0] + surrounding[0];
				int surroundingY = positions[i][1] + surrounding[1];
				int surroundingIndex = surroundingX * m + surroundingY;
				
				if (surroundingX > 0 && surroundingY > 0 && rootArray[surroundingIndex] != -1)
				{
					int otherRoot = getRoot(rootArray, surroundingIndex);
					if (otherRoot != rootArray[positionIndex])
					{
						rootArray[otherRoot] = positionIndex;
						countIslands--;
					}
					
				}
			}
			
			counts.add(countIslands);
		}
		
		
		
		return counts;
	}
	
	public int getRoot(int[] rootArray, int index)
	{
		while (rootArray[index] != index)
		{
			return(getRoot(rootArray, rootArray[index])); 
		}
		return 0;
	}
	
	
	
	public void printArray(int[] rootArray, int m, int n)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; i < m ; i++)
		{
			for (int j = 0 ; j < n ; j++)
			{
				sb.append(""+rootArray[i * m + j ] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public List<Integer> numIslands2bis(int m, int n, int[][] positions) {
	    int[] rootArray = new int[m*n];
	    Arrays.fill(rootArray,-1);
	 
	    ArrayList<Integer> result = new ArrayList<Integer>();
	 
	    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
	    int count=0;
	 
	    for(int k=0; k<positions.length; k++){
	        count++;
	 
	        int[] p = positions[k];
	        int index = p[0]*n+p[1];
	        rootArray[index]=index;//set root to be itself for each node
	 
	        for(int r=0;r<4;r++){
	            int i=p[0]+directions[r][0];
	            int j=p[1]+directions[r][1];
	 
	            if(i>=0&&j>=0&&i<m&&j<n&&rootArray[i*n+j]!=-1){
	                //get neighbor's root
	                int thisRoot = getRootbis(rootArray, i*n+j);
	                if(thisRoot!=index){
	                    rootArray[thisRoot]=index;//set previous root's root
	                    count--;
	                }
	            }
	        }
	        printArray(rootArray, m,n);
	        result.add(count);
	    }
	 
	    return result;
	}
	 
	public int getRootbis(int[] arr, int i){
	    while(i!=arr[i]){
	        i=arr[i];
	    }
	    return i;
	}
	
	public static void main(String[] args) {
		int[][] positions = new int[][]
				{
			{1,1}, {1,3}, {1,2},{2,0},{3,1},{2,1}, {2,2}
				};
		NumberOfIslandsII sol = new NumberOfIslandsII();
		List<Integer> res = sol.numIslands2(10, 10, positions);
		System.out.println(res);
		res = sol.numIslands2bis(10, 10, positions);
		System.out.println(res);

	}

}
