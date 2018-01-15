/*
 * Given a list of numbers, return all possible permutations.
 * 
 *  Example

For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 * Lintcode: http://lintcode.com/en/problem/permutations/
 */
import java.util.*;

public class Permutations {
	
	public void helper(int[] nums, boolean[] used, Stack<Integer> current, List<List<Integer>> result)
	{
		if (current.size() == nums.length)
		{
			result.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = 0 ; i < nums.length ; i++)
		{
			if (used[i])
			{
				continue;
			}
			used[i] = true;
			current.push(nums[i]);
			helper(nums,used,current,result);
			current.pop();
			used[i] = false;
		}
	}
    public List<List<Integer>> permute(int[] nums) {
    	boolean[] taken = new boolean[nums.length];
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Stack<Integer> current  = new Stack<Integer>();
    	
    	helper(nums, taken, current, res);
    	return res;
    }
    
    
    
	public static void main(String[] args) {
		Permutations sol = new Permutations();
		int[] arr = new int[] {1,2,3};
		List<List<Integer>> res = sol.permute(arr);
		System.out.println(res);
	}

}

