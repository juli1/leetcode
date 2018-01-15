/*
 * We consider an undirected tree with N nodes, numbered from 1 to N,
 * Additionally, each node also has a label attached to it and the label
 * is an integer value. Note that different nodes can have identical labels. 
 * You need to write a function , that , given a zero-indexed array A of 
 * length N, where A[J] is the label value of the (J + 1)-th node in the tree, 
 * and a zero-indexed array E of length K = (N - 1) * 2 in which the edges of 
 * the tree are described (for every 0 <= j <= N -2 values E[2 * J] 
 * and E[2 * J + 1] represents and edge connecting node E[2 * J] with 
 * node E[2 * J + 1])， returns the length of the longest path such that all 
 * the nodes on that path have the same label. Then length of a path if defined 
 * as the number of edges in that path.
 * 
 * Lintcode: http://lintcode.com/en/problem/tree-longest-path-with-same-value/
 */

import java.util.*;

public class LongestPathWithSameValue {
    public int LongestPathWithSameValue(int[] A, int[] E) {
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int maxValue = 0;
        boolean[] visited = new boolean[A.length];
        Arrays.fill(visited, false);
        
        // build map
        for (int pos = 0 ; pos < A.length ; pos++)
        {
        	List<Integer> list = map.getOrDefault(A[pos], new ArrayList());
        	list.add(pos);
        	if (!map.containsKey(A[pos]))
        	{
        		map.put(A[pos], list);
        	}
        }
        
        for (int key : map.keySet())
        {
        	System.out.println("key" + key);
        	for (int position : map.get(key))
        	{
        		
        		int v = visit(position, position, visited, E, map.get(key));
        		
        		maxValue = Math.max(maxValue, v);
        	}
        	
        }
        
        
        return maxValue;
    }
    
    public int visit(int position, int initialnode, boolean[] visited, int[] edges, List<Integer> positions)
    {
    	if (visited[position])
    	{
    		return 0;
    	}
    	System.out.println("visit" + position);
    	visited[position] = true;
    	int res = 0;
    	for (int position2 : positions)
    	{
    		for (int eid = 0 ; eid < edges.length ; eid = eid + 2)
    		{
    			//System.out.println("test from" + edges[eid] + "to" + edges[eid+1]);
    			if ( (edges[eid] == position + 1) && (edges[eid+1] == position2 + 1))
        		{
    				//System.out.println("from" + (position +1) + "to" + (position2 + 1));
    				if (position == initialnode)
    				{
    					res += 1+ visit(position2, initialnode, visited, edges, positions);
    				}
    				else
    				{
    					res = Math.max(res,1+visit(position2, initialnode, visited, edges, positions));
    				}
        		}	
    		}
    		
    	}
    	visited[position] = false;
    	return res;
    }
    
    
    
	public static void main(String[] args) {
		LongestPathWithSameValue s = new LongestPathWithSameValue();
		//int[] a = {1, 1, 1 ,2, 2};
		int[] a = {1, 1, 1 ,1, 1};
		//int[] e = {1, 2, 1, 3, 2, 4, 2, 5};
		int[] e = {1,2,1,3,2,4,2,5};
		System.out.println(s.LongestPathWithSameValue(a, e));
	}

}
