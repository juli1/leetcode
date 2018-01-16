

import java.util.*;

public class GeneratePowerSet {

	public void helperset(int[] array, int pos, Stack<Integer> stack, List<List<Integer>> result)
	{
		result.add(new ArrayList<Integer>(stack));
		for (int i = pos ; i < array.length ; i++)
		{
			stack.push(array[i]);
			helperset(array, i + 1, stack, result);
			stack.pop();
			//helper(array, pos + 1, stack, result);
		}
	}
	public void dfs(int[] s, int index, Stack<Integer> path, List<List<Integer>> result){
	    result.add(new ArrayList<Integer>(path));
	    
	    for(int i = index; i < s.length; i++){
	        path.push(s[i]);
	        dfs(s, i+1, path, result);
	        path.pop();
	    }
	}
	 
	public List<List<Integer>> generatePowerSet(int[] array)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		helperset(array, 0, new Stack<Integer>(), result);
		
		return result;
	}
	public List<List<Integer>> subsets(int[] S) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
	    if(S.length == 0){
	        return result;
	    }
	    
	    Arrays.sort(S);
	    dfs(S, 0, new Stack<Integer>(), result);
	    return result;
	}


	
	public static void main(String[] args) {
		GeneratePowerSet sol = new GeneratePowerSet();
		int[] array = new int[] {2,3,4};
		System.out.println(sol.generatePowerSet(array));
		System.out.println(sol.subsets(array));
	}

}
